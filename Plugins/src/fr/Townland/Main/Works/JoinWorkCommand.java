package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Farmer.RequestFarmer;
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

    public JoinWorkCommand(RequestFarmer requestFarmer, HashMapFarmer hashMapFarmer, Rank rank){
        this.requestFarmer = requestFarmer;
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            if (label.equals("joinwork")){
                Player player = (Player) sender;

                if (rank.hasPowerSup(player, 6)){
                    if (args.length == 2){
                        if (!hashMapFarmer.getWork(player)) {
                            Player pl2 = Bukkit.getPlayer(args[1]);
                            hashMapFarmer.removeWorkFarmer(pl2);
                            requestFarmer.updateWork("farmer", true, pl2);
                            hashMapFarmer.addWorkFarmer(player, requestFarmer.getWork("farmer", pl2.getUniqueId()));
                            pl2.sendMessage("§2vous êtes devenue farmer !");
                            player.sendMessage(ChatColor.GREEN + pl2.getName() + " est devenue farmer");
                            return true;
                        }else {
                            player.sendMessage("§cLe joueur est déjà farmer");
                        }
                    }else {
                        player.sendMessage("§c/joinwork <métier> <Joueur>");
                        return true;
                    }
                }else {
                    if (args.length == 1){
                        if (args[0].equals("farmer")){
                            if (hashMapFarmer.getWork(player)){
                                player.sendMessage("§cVous êtes déjà farmer");
                                return true;
                            }else {
                                hashMapFarmer.removeWorkFarmer(player);
                                requestFarmer.updateWork("farmer", true, player);
                                hashMapFarmer.addWorkFarmer(player, requestFarmer.getWork("farmer", player.getUniqueId()));
                                player.sendMessage("§2Vous êtes devenue farmer !");
                                return true;
                            }
                        }else {
                            player.sendMessage("§c/joinwork <métier>");
                            return true;
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
