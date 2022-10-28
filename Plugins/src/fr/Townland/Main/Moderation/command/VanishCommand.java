package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor, Listener {
    ArrayList<Player> invisible_list = new ArrayList<>();
    private Main main;
    private Rank rank;
    public VanishCommand(Main main, Rank rank) {
        this.main = main;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (rank.hasPowerInf((Player) sender, 5)) {
            sender.sendMessage("§cVous n'avez pas la permission");
        } else {

            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        if (rank.hasPowerInf((Player) sender, 5)) {
                            people.showPlayer(main, player);
                        }
                    }
                    invisible_list.remove(player);
                    player.sendMessage("§cVous nêtes maintenant plus en vanish !");
                } else if (!invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(main, player);
                    }
                    invisible_list.add(player);
                    player.sendMessage("§aVous êtes maintenant en vanish !");

                }
            }
        }
        return true;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        System.out.println("Je passe ici");
        Player player = e.getPlayer();
        if (invisible_list.contains(player)) {
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.hidePlayer(main, player);
            }
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        for (Player people : Bukkit.getOnlinePlayers()) {
            people.showPlayer(main, player);
        }
        invisible_list.remove(player);
    }
}

















