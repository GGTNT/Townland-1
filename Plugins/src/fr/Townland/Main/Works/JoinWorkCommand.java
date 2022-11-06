package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Farmer.RequestFarmer;
import fr.Townland.Main.Works.Pecheur.HashMapPecheur;
import fr.Townland.Main.Works.Pecheur.RequestPecheur;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinWorkCommand implements CommandExecutor {

    private final RequestFarmer requestFarmer;
    private final HashMapFarmer hashMapFarmer;
    private final Rank rank;
    private final HashMapPecheur hashMapPecheur;
    private final RequestPecheur requestPecheur;

    public JoinWorkCommand(RequestFarmer requestFarmer, HashMapFarmer hashMapFarmer, Rank rank, HashMapPecheur hashMapPecheur, RequestPecheur requestPecheur){
        this.requestFarmer = requestFarmer;
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
        this.hashMapPecheur = hashMapPecheur;
        this.requestPecheur = requestPecheur;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            if (label.equals("joinwork")){
                Player player = (Player) sender;

                //modo
                if (rank.hasPowerSup(player, 6)){
                    if (args.length == 2){

                        Player pl2 = Bukkit.getPlayer(args[1]);

                        if (args[0].equalsIgnoreCase("farmer")){

                            if (!hashMapFarmer.getWorkFarmer(player)) {
                                hashMapFarmer.addWorkFarmer(player, true);
                                pl2.sendMessage("§2vous êtes devenue farmer !");
                                player.sendMessage(ChatColor.GREEN + pl2.getName() + " est devenue farmer");
                                return true;
                            }else {
                                player.sendMessage("§cLe joueur est déjà farmer");
                                return true;
                            }
                        }
                        if (args[0].equalsIgnoreCase("pecheur")){

                            if (!hashMapPecheur.getWorkpecheur(pl2)){
                                hashMapPecheur.setWorkpecheur(pl2, true);
                                pl2.sendMessage("§2vous êtes devenue pêcheur !");
                                player.sendMessage(ChatColor.GREEN + pl2.getName() + " est devenue pêcheur");
                                return true;
                            }else {
                                player.sendMessage("§cLe joueur est déjà pêcheur");
                                return true;
                            }

                        }




                    }else {
                        player.sendMessage("§c/joinwork <métier> <Joueur>");
                        return true;
                    }
                    //joueur
                }else {
                    if (args.length == 1){

                        if (args[0].equalsIgnoreCase("farmer")){
                            if (hashMapFarmer.getWorkFarmer(player)){
                                player.sendMessage("§cVous êtes déjà farmer");
                                return true;
                            }else {
                                hashMapFarmer.addWorkFarmer(player, true);
                                player.sendMessage("§2Vous êtes devenue farmer !");
                                return true;
                            }
                        }

                        if (args[0].equalsIgnoreCase("pecheur")){
                            if (hashMapPecheur.getWorkpecheur(player)){
                                player.sendMessage("§cVous êtes déjà pêcheur");
                                return true;
                            }else {
                                hashMapPecheur.setWorkpecheur(player, true);
                                player.sendMessage("§2Vous êtes devenue pêcheur !");
                                return true;
                            }
                        }

                    }else {
                        player.sendMessage("§c/joinwork <métier>");
                        return true;
                    }
                }

            }
        }
        return true;
    }
}
