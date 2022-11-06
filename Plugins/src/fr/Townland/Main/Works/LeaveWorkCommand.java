package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Farmer.RequestFarmer;
import fr.Townland.Main.Works.Pecheur.HashMapPecheur;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveWorkCommand implements CommandExecutor {

    private final RequestFarmer requestFarmer;
    private final HashMapFarmer hashMapFarmer;
    private final Rank rank;
    private final HashMapPecheur hashMapPecheur;

    public LeaveWorkCommand(RequestFarmer requestFarmer, HashMapFarmer hashMapFarmer, Rank rank, HashMapPecheur hashMapPecheur){
        this.requestFarmer = requestFarmer;
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
        this.hashMapPecheur = hashMapPecheur;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (label.equals("leavework")){

                //modo
                if (rank.hasPowerSup(player, 6)){
                    if (args.length == 2){
                        Player pl2 = Bukkit.getPlayer(args[1]);

                        if (args[0].equalsIgnoreCase("farmer")){
                            if (!hashMapFarmer.getWorkFarmer(pl2)){
                                player.sendMessage("§Ce joueur n'est déjà pas farmer");
                                return true;
                            }else {
                                hashMapFarmer.addWorkFarmer(pl2, false);
                                hashMapFarmer.removeXP(hashMapFarmer.getXPFarmer(pl2), pl2);
                                pl2.sendMessage("§2Vous n'êtes plus farmer !");
                                player.sendMessage(ChatColor.GREEN + pl2.getName() + " n'est plus farmer");
                                return true;
                            }
                        }

                        if (args[0].equalsIgnoreCase("pecheur")){
                            if (!hashMapPecheur.getWorkpecheur(pl2)){
                                player.sendMessage("§Ce joueur n'est déjà pas pêcheur");
                                return true;
                            }else {
                                hashMapPecheur.setWorkpecheur(pl2, false);
                                hashMapPecheur.setXppecheur(pl2, 0);
                                pl2.sendMessage("§2Vous n'êtes plus pêcheur !");
                                player.sendMessage(ChatColor.GREEN + pl2.getName() + " n'est plus pêcheur");
                                return true;
                            }

                        }

                    }else {
                        player.sendMessage("§c/leavework <métier> <Joueur>");
                        return true;
                    }

                    //joueur
                }else {
                    if (args.length == 1){
                        if (args[0].equalsIgnoreCase("farmer")){
                            if (!hashMapFarmer.getWorkFarmer(player)){
                                player.sendMessage("§cVous n'êtes déjà pas farmer");
                                return true;
                            }else {
                                hashMapFarmer.addWorkFarmer(player, false);
                                hashMapFarmer.removeXP(hashMapFarmer.getXPFarmer(player), player);
                                player.sendMessage("§2Vous n'êtes plus farmer !");
                                return true;
                            }

                        }

                        if (args[0].equalsIgnoreCase("pecheur")){
                            if (!hashMapPecheur.getWorkpecheur(player)){
                                player.sendMessage("§cVous n'êtes déjà pas pecheur");
                                return true;
                            }else {
                                hashMapPecheur.setWorkpecheur(player, false);
                                hashMapPecheur.setXppecheur(player, 0);
                                player.sendMessage("§2Vous n'êtes plus pêcheur !");
                                return true;
                            }


                        }
                    }else {
                        player.sendMessage("§c/leavework <métier>");
                    }
                }
            }

        }

        return true;
    }
}
