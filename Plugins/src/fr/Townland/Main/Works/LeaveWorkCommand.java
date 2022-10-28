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

public class LeaveWorkCommand implements CommandExecutor {

    private final RequestFarmer requestFarmer;
    private final HashMapFarmer hashMapFarmer;
    private final Rank rank;

    public LeaveWorkCommand(RequestFarmer requestFarmer, HashMapFarmer hashMapFarmer, Rank rank){
        this.requestFarmer = requestFarmer;
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (label.equals("leavework")){
                if (rank.hasPowerSup(player, 6)){
                    if (args.length == 2){
                        if (!hashMapFarmer.getWork(player)){
                            player.sendMessage("§cVous n'êtes déjà pas farmer");
                            return true;
                        }else {
                            Player pl2 = Bukkit.getPlayer(args[1]);
                            hashMapFarmer.removeWorkFarmer(pl2);
                            requestFarmer.updateWork("farmer", false, pl2);
                            hashMapFarmer.addWorkFarmer(pl2, requestFarmer.getWork("farmer", pl2.getUniqueId()));
                            pl2.sendMessage("§2Vous n'êtes plus farmer !");
                            player.sendMessage(ChatColor.GREEN + pl2.getName() + " n'est plus farmer");
                            return true;
                        }
                    }else {
                        player.sendMessage("§c/leavework <métier> <Joueur>");
                        return true;
                    }
                }else {
                    if (args.length == 1){
                        if (args[0].equals("farmer")){
                            if (!hashMapFarmer.getWork(player)){
                                player.sendMessage("§cVous n'êtes déjà pas farmer");
                                return true;
                            }else {
                                hashMapFarmer.removeWorkFarmer(player);
                                requestFarmer.updateWork("farmer", false, player);
                                hashMapFarmer.addWorkFarmer(player, requestFarmer.getWork("farmer", player.getUniqueId()));
                                player.sendMessage("§2Vous n'êtes plus farmer !");
                                return true;
                            }

                        }else {
                            player.sendMessage("§c/leavework <métier>");
                            return true;
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
