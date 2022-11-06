package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Pecheur.HashMapPecheur;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetWorkCommand implements CommandExecutor {

    private Rank rank;
    private HashMapFarmer hashMapFarmer;
    private HashMapPecheur hashMapPecheur;

    public GetWorkCommand(Rank rank, HashMapFarmer hashMapFarmer, HashMapPecheur hashMapPecheur) {
        this.rank = rank;
        this.hashMapFarmer = hashMapFarmer;
        this.hashMapPecheur = hashMapPecheur;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("getwork")) {
                if (rank.hasPowerSup(player, 6)) {
                    Player player1 = Bukkit.getPlayer(args[0]);
                    if (player1.isOnline()) {

                        String farmer ;
                        String lumberjack = "§c✖";
                        String minor = "§c✖";
                        String fisherman;
                        String hunter = "§c✖";
                        String breeder = "§c✖";
                        String blacksmith = "§c✖";
                        String enchanter = "§c✖";
                        String alchemist = "§c✖";

                        if (hashMapFarmer.getWorkFarmer(player1)) {
                            farmer = "§a✔";
                        }else{
                            farmer = "§c✖";
                        }
                        if (hashMapPecheur.getWorkpecheur(player1)) {
                            fisherman = "§a✔";
                        }else {
                            fisherman = "§c✖";
                        }

                        player.sendMessage("§7-----------------------------------------------------");
                        player.sendMessage("§eMétiers de " + player1.getName() + " :");
                        player.sendMessage("§2- Farmer : " + farmer);
                        player.sendMessage("§6- Lumberjack : " + lumberjack);
                        player.sendMessage("§7- Minor : " + minor);
                        player.sendMessage("§3- Fisherman : " + fisherman);
                        player.sendMessage("§4- Hunter : " + hunter);
                        player.sendMessage("§e- Breeder : " + breeder);
                        player.sendMessage("§8- Blacksmith : " + blacksmith);
                        player.sendMessage("§d- Enchanter : " + enchanter);
                        player.sendMessage("§5- Alchemist : " + alchemist);
                        player.sendMessage("§7-----------------------------------------------------");
                    }


                } else {
                    player.sendMessage("§cCe joueur n'est pas connecté");
                    return true;
                }
            } else {
                sender.sendMessage("§cVous n'avez pas la permission");
                return true;
            }


            //console
        } else {

            Player player1 = Bukkit.getPlayer(args[0]);
            if (player1.isOnline()) {

                String farmer = "§c✖";
                String lumberjack = "§c✖";
                String minor = "§c✖";
                String fisherman = "§c✖";
                String hunter = "§c✖";
                String breeder = "§c✖";
                String blacksmith = "§c✖";
                String enchanter = "§c✖";
                String alchemist = "§c✖";

                if (hashMapFarmer.getWorkFarmer(player1)) {
                    farmer = "§a✔";
                }
                if (hashMapPecheur.getWorkpecheur(player1)) {
                    fisherman = "§a✔";
                }

                sender.sendMessage("§7-----------------------------------------------------");
                sender.sendMessage("§eMétiers de " + player1.getName() + " :");
                sender.sendMessage("§2- Farmer : " + farmer);
                sender.sendMessage("§6- Lumberjack : " + lumberjack);
                sender.sendMessage("§7- Minor : " + minor);
                sender.sendMessage("§3- Fisherman : " + fisherman);
                sender.sendMessage("§4- Hunter : " + hunter);
                sender.sendMessage("§e- Breeder : " + breeder);
                sender.sendMessage("§8- Blacksmith : " + blacksmith);
                sender.sendMessage("§d- Enchanter : " + enchanter);
                sender.sendMessage("§5- Alchemist : " + alchemist);
                sender.sendMessage("§7-----------------------------------------------------");
            }
        }
        return true;
    }
}