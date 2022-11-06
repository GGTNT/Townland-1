package fr.Townland.Main;

import fr.Townland.Main.Bienvenue.Bienvenue;
import fr.Townland.Main.Bienvenue.RequestBvn;
import fr.Townland.Main.Bienvenue.SetupBVNCommand;
import fr.Townland.Main.Command.TestCommand;
import fr.Townland.Main.Economie.DataEconomie.SignShopManager;
import fr.Townland.Main.Economie.commands.CoinsCommand;
import fr.Townland.Main.Economie.events.SignShop;
import fr.Townland.Main.Economie.listeners.player.PlayerJoinListener;
import fr.Townland.Main.Help.HelpCommand;
import fr.Townland.Main.Help.Work.HelpWork;
import fr.Townland.Main.Message.MessagePropa_Sensi;
import fr.Townland.Main.Moderation.command.*;
import fr.Townland.Main.Moderation.command.Bans.BanCommand;
import fr.Townland.Main.Moderation.command.Bans.BanManager;
import fr.Townland.Main.Moderation.command.Bans.PlayerInfos;
import fr.Townland.Main.Moderation.command.Mute.MuteCommand;
import fr.Townland.Main.Moderation.command.Mute.MuteManager;
import fr.Townland.Main.Moderation.command.Mute.PlayerInfosM;
import fr.Townland.Main.Moderation.command.vanish.VanishCommand;
import fr.Townland.Main.Moderation.command.vanish.events.JoinEvent;
import fr.Townland.Main.TabList.CustomTabList;
import fr.Townland.Main.TabList.PlayerListener;
import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.TabList.RankCommand;
import fr.Townland.Main.Teleportation.commands.Home;
import fr.Townland.Main.Teleportation.commands.RegionCmd;
import fr.Townland.Main.Teleportation.commands.SetSpawnCommand;
import fr.Townland.Main.Teleportation.commands.SpawnCommand;
import fr.Townland.Main.Teleportation.listeners.HomeManager;
import fr.Townland.Main.Teleportation.listeners.RegionListener;
import fr.Townland.Main.Teleportation.listeners.SpawnManager;
import fr.Townland.Main.Teleportation.managers.RegionManager;
import fr.Townland.Main.Works.Farmer.Farmer;
import fr.Townland.Main.Works.Farmer.FarmerListener;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Farmer.RequestFarmer;
import fr.Townland.Main.Works.*;
import fr.Townland.Main.mysql.DbManage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

	public static Main INSTANCE;
	private Rank rank;
	private MessagePropa_Sensi messagePropa_sensi;
	private RequestFarmer requestFarmer;
	private HashMapFarmer hashMapFarmer;
	private Farmer farmer;
	private RequestBvn requestBvn;
	private Bienvenue bienvenue;
	public DbManage database;
	public BanManager banManager = new BanManager();
	public PlayerInfos playerInfos = new PlayerInfos();
	public MuteManager muteManager = new MuteManager();
	public PlayerInfosM playerInfosM = new PlayerInfosM();
	public List<UUID> que;
	public List<Player> frozen;
	public ArrayList<Player> invisible_list = new ArrayList<>();
	public HomeManager homeManager = new HomeManager();
	public SpawnManager spawnManager = new SpawnManager();
	public SignShopManager signShopManager = new SignShopManager();
	private RegionManager regionManager = new RegionManager();
	public RegionCmd regionCmd;



	public void onEnable() {
		//Spawn
		getConfig().options().copyDefaults();
		saveDefaultConfig();



		this.que = new ArrayList<>();
		this.frozen = new ArrayList<>();
		INSTANCE = this;
		database = new DbManage("jdbc:mysql://","localhost","townlandplugin","root","");
		database.connexion();
		bienvenue = new Bienvenue();
		requestBvn = new RequestBvn(this);
		requestFarmer = new RequestFarmer(this, hashMapFarmer);
		messagePropa_sensi = new MessagePropa_Sensi();
		hashMapFarmer = new HashMapFarmer();
		farmer = new Farmer(hashMapFarmer, requestFarmer);
		regionCmd = new RegionCmd(this,rank);

		//registrer les Events
		getServer().getPluginManager().registerEvents(new Bienvenue(), this);
		getServer().getPluginManager().registerEvents(new FarmerListener(requestFarmer, rank, hashMapFarmer, farmer), this);
		getServer().getPluginManager().registerEvents(new PlayerListener(rank), this);
		getServer().getPluginManager().registerEvents(new CustomTabList(),this);
		getServer().getPluginManager().registerEvents(new SignShop(),this);
		getServer().getPluginManager().registerEvents(this, this);
		//getServer().getPluginManager().registerEvents(new VanishCommand(this,rank), this);
		getServer().getPluginManager().registerEvents(new PlayerInfos(),this);
		getServer().getPluginManager().registerEvents(new PlayerInfosM(),this);
		getServer().getPluginManager().registerEvents(new Home(rank,this),this);
		getServer().getPluginManager().registerEvents(new Freeze(rank,this),this);
		getServer().getPluginManager().registerEvents(new SignShop(),this);
		getServer().getPluginManager().registerEvents(new JoinEvent(this,rank),this);
		this.getServer().getPluginManager().registerEvents(new RegionListener(this), this);


		rank.initScoreboard();
		//les commandes
		getCommand("home").setExecutor(new Home(rank,this));
		getCommand("delhome").setExecutor(new Home(rank,this));
		getCommand("sethome").setExecutor(new Home(rank,this));
		getCommand("setbvn").setExecutor(new SetupBVNCommand(rank, requestBvn));
		getCommand("givexp").setExecutor(new GiveXpWorkCommand(rank, hashMapFarmer));
		getCommand("removexp").setExecutor(new RemoveXpWorkCommand(hashMapFarmer, rank));
		getCommand("getxp").setExecutor(new GetXpWorkCommand(rank, hashMapFarmer));
		getCommand("test").setExecutor(new TestCommand(bienvenue));
		getCommand("rank").setExecutor(new RankCommand(rank));
		getCommand("joinwork").setExecutor(new JoinWorkCommand(requestFarmer, hashMapFarmer, rank));
		getCommand("leavework").setExecutor(new LeaveWorkCommand(requestFarmer, hashMapFarmer, rank));
		getCommand("vanish").setExecutor(new VanishCommand(this,rank));
		getCommand("cclear").setExecutor(new ClearChat(rank));
		getCommand("freeze").setExecutor(new Freeze(rank,this));
		getCommand("unfreeze").setExecutor(new Freeze(rank,this));
		getCommand("ban").setExecutor(new BanCommand(rank));
		getCommand("fly").setExecutor(new Fly(rank));
		getCommand("tp").setExecutor(new Tp(rank));
		getCommand("tpa").setExecutor(new Tpa(rank));
		getCommand("kick").setExecutor(new Kick(rank));
		getCommand("clear").setExecutor(new Clear(rank));
		getCommand("invsee").setExecutor(new Invsee(rank));
		getCommand("gamemode").setExecutor(new Gm(rank));
		getCommand("gamemode").setTabCompleter( new AutoComplete());
		getCommand("coins").setTabCompleter( new CoinComplete());
		getCommand("unban").setExecutor(new BanCommand(rank));
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("unmute").setExecutor(new MuteCommand());
		getCommand("check").setExecutor(new BanCommand(rank));
		getCommand("setspawn").setExecutor(new SetSpawnCommand(this,rank));
		getCommand("spawn").setExecutor(new SpawnCommand(this,rank));

		//commande help
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("helpWork").setExecutor(new HelpWork());


		System.out.println("TownlandPlugin allume");

		//remettre les métiers et xp de farmer en cas de relancement
		farmer.setupFarmerXP();
		//récupérer les coordonnées des melons sugarcannes et pumpkins
		farmer.setupFarmerCo();

		//ajouter les bienvenues
		bienvenue.setBVN();

		//System d'éconnomie
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new fr.Townland.Main.Economie.listeners.player.PlayerJoinListener(),this);
		pm.registerEvents(new PlayerJoinListener(),this);
		this.getCommand("coins").setExecutor(new CoinsCommand(rank,this));


	}

	public void onDisable() {
		for (Player player : Bukkit.getOnlinePlayers()){
			if (hashMapFarmer.getXpfarmer().containsKey(player.getUniqueId().toString())){
				requestFarmer.changeXP("farmer", player, hashMapFarmer.getXpfarmer().get(player.getUniqueId().toString()));
				hashMapFarmer.getXpfarmer().remove(player.getUniqueId().toString());
			}else {
			}
		}

		//save l'exp des joueurs métier farmeur
		farmer.saveFarmerXP();
		//save les coordonnées des melons sugarcannes et pumpkins
		farmer.saveFarmerCo();

		//save le nombre de joueur co pour 1ere fois
		bienvenue.saveBVN();
		database.deconnexion();

	}

	@Override
	public void onLoad() {
		rank = new Rank(this);
	}
	public static Main getInstance() {
		return INSTANCE;
	}
	public void addQue(UUID id)
	{
		this.que.add(id);
	}

	public void cancelQue(UUID id)
	{
		this.que.remove(id);
	}

	public boolean isQued(UUID id)
	{
		return this.que.contains(id);
	}
	//SpawnClaim
	public RegionCmd getRegionCmd() {
		return this.regionCmd;
	}

	public RegionManager getRegionManager() {
		return this.regionManager;
	}

}
