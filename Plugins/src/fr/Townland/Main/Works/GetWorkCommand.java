package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetWorkCommand implements CommandExecutor {

    private Rank rank;
    private HashMapFarmer hashMapFarmer;

    public GetWorkCommand(Rank rank, HashMapFarmer hashMapFarmer){
        this.rank = rank;
        this.hashMapFarmer = hashMapFarmer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("getwork")) {
                if (rank.hasPowerSup(player, 6)) {
                    Player player1 = Bukkit.getPlayer(args[0]);
                    if (player1.isOnline()) {

                        if (hashMapFarmer.getWork(player1)) {
                            player.sendMessage("§2" + player1.getName() + " est pas farmer");
                        } else {
                            player.sendMessage("§2" + player1.getName() + " n'est pas farmer");
                        }


                    } else {
                        player.sendMessage("§cCe joueur n'est pas connecté");
                        return true;
                    }
                } else {
                    sender.sendMessage("§cVous n'avez pas la permission");
                    return true;
                }
            }
        } else {
            Player player1 = Bukkit.getPlayer(args[0]);
            if (player1.isOnline()) {

                if (hashMapFarmer.getWork(player1)) {
                    sender.sendMessage("§2" + player1.getName() + " est pas farmer");
                } else {
                    sender.sendMessage("§2" + player1.getName() + " n'est pas farmer");
                }
            }
        }

            return true;
        }
    }
