package fr.Townland.Main.TabList;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import fr.Townland.Main.TabList.RankList;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Rank {

    private Scoreboard scoreboard;
    private final Plugin plugin;
    private final Map<String, RankList> playerRanks = Maps.newHashMap();
    private FileConfiguration config;
    private File file;

    public Rank(Plugin plugin){
        this.plugin = plugin;
        initConfig();
    }

    //methode pour obtenir le plugin
    public final Plugin getPlugin() {
        return plugin;
    }

    //methode pour obtenir le scoreboard
    public final Scoreboard getScoreboard() {
        return scoreboard;
    }

    //methode pour initialiser la config des ranks
    private void initConfig(){
        File f = new File("plugins/Rank");
        if (!f.exists()) f.mkdir();
        file = new File(f,"rank.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException ioe){ ioe.printStackTrace();}
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    //methode pour initialiser le scoreboard au demarage du plugin
    public  void initScoreboard(){
        if (scoreboard != null) throw new UnsupportedOperationException("Le scoreboard est deja initialisé");
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        for (RankList ranklist : RankList.values()){

            if (scoreboard.getTeam(ranklist.getName()) == null){
                Team team = scoreboard.registerNewTeam(ranklist.getName());
                team.setPrefix(ranklist.getPrefix());
            }

        }
    }

    //methode appelé quand le joueur se connecte
    public void loadPlayer(Player player){
        String uuid = player.getUniqueId().toString();
        if(playerRanks.containsKey(uuid))return;
        if (!config.contains(uuid)){
            config.set(uuid,0);
            saveConfig();
        }

        playerRanks.put(uuid,getRankById(config.getInt(uuid)));
        scoreboard.getTeam(playerRanks.get(uuid).getName()).addEntry(player.getName());
    }

    //methode appelé quand le joueur se deconnecte
    public void deletePlayer(Player player){
        if(!playerRanks.containsKey(player.getUniqueId().toString()))return;
        playerRanks.remove(player.getUniqueId().toString());
    }

    //methode pour recuperer le rank du player
    public RankList getPlayerRank(Player player){
        if(!playerRanks.containsKey(player.getUniqueId().toString())) loadPlayer(player);
        return playerRanks.get(player.getUniqueId().toString());
    }

    public RankList getRankById(int id){
        for (RankList rankList : RankList.values()){
            if (rankList.getId() == id) return rankList;
        }
        return RankList.IJOUEUR;
    }

    public void saveConfig(){
        try {
            config.save(file);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    //methode pour avoir le power
    public boolean hasPower(Player player, int power){
        return (getPlayerRank(player).getPower() == power);
    }

    public boolean hasPowerSup(Player player, int power){
        return (getPlayerRank(player).getPower() >= power);
    }

    public boolean hasPowerInf(Player player, int power){
        return (getPlayerRank(player).getPower() <= power);
    }

    public void changeRank(Player player, RankList rankList){
        config.set(player.getUniqueId().toString(), rankList.getId());
        saveConfig();
        deletePlayer(player);
        loadPlayer(player);
    }
}
