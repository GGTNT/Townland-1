package fr.Townland.Main.Teleportation.commands;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class SpawnCommand implements CommandExecutor {

    private final Main main;
    private final Rank rank;

    public SpawnCommand(Main main,Rank rank) {
        this.main = main;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Make sure that they are a player
        if (sender instanceof Player){

            Player player = (Player) sender;
            //see if the plugin has a spawn point set in the config
            Location location = main.getConfig().getLocation("spawn");
            if (location != null){
                if (rank.hasPowerInf((Player) sender, 5)) {
                    UUID id = player.getUniqueId();
                    main.que.add(id);
                    player.sendMessage(ChatColor.GOLD + "Téléportation dans 5 secondes");
                    new BukkitRunnable() {
                        int delay = 5;

                        @Override
                        public void run() {
                            if (main.que.contains(id)) {

                                if (delay == 0) {
                                    player.sendMessage(ChatColor.GOLD + "Téléportation...");
                                    player.teleport(location);
                                    main.que.remove(id);
                                    this.cancel();
                                } else {
                                    delay--;

                                }
                            } else {
                                player.sendMessage(ChatColor.RED + "§cTéléportation annulé");
                                this.cancel();
                            }

                        }
                    }.runTaskTimer(main, 0, 20);
                }else{
                    player.sendMessage(ChatColor.GOLD + "§aVous avez été téléporté au spawn.");
                    player.teleport(location);
                }
            }else{
                player.sendMessage("§eLe spawn n'est pas défini.");
            }

        }else{
            System.out.println("Vous n'êtes pas un joueur.");
        }

        return true;
    }
}