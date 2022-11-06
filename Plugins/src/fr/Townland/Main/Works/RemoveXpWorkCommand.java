package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveXpWorkCommand implements CommandExecutor {

    private final Rank rank;
    private final HashMapFarmer hashMapFarmer;

    public RemoveXpWorkCommand(HashMapFarmer hashMapFarmer, Rank rank){
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (label.equals("removexp")) {
                if (args.length == 3){
                    if (rank.hasPowerSup(player, 7)) {
                        Player player1 = Bukkit.getPlayer(args[1]);

                            if (args[0].equals("farmer")) {
                                int xp = Integer.parseInt(args[2]);
                                int xps = hashMapFarmer.getXPFarmer(player1);
                                if (xp > xps){
                                    hashMapFarmer.removeXP(xps, player1);
                                    player.sendMessage("§2" + player1.getName() + " a perdu " + xps + "xp du métier farmer");
                                    player1.sendMessage("§2" + player.getName() + " vous a retiré " + xps  + "xp du métier farmer");
                                    return true;
                                }
                                hashMapFarmer.removeXP(xp, player1);
                                player.sendMessage("§2" + player1.getName() + " a perdu " + xp + "xp du métier farmer");
                                player1.sendMessage("§2" + player.getName() + " vous a retiré " + xp + "xp du métier farmer");
                                return true;
                            }





                    } else {
                        player.sendMessage("§cvous n'avez pas la permission d'éxecuter cette commande");
                        return true;
                    }
                }else {
                    player.sendMessage("§c/removexp <métier> <joueur> <xp>");
                    return true;
                }
                } else {
                    player.sendMessage("§c/removexp <métier> <joueur> <xp>");
                    return true;
                }
        }
        return true;
    }
}
