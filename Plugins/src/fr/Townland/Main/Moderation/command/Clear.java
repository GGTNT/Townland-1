package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {
    private final Rank rank;

    public Clear(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("clear") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 5)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "Joueur introuvable");
                        return true;
                    } else {
                        po.getInventory().clear();
                        p.sendMessage("§b[CLEAR] §fVous avez clear §6" + args[0]);
                        return true;
                    }
                } else{
                    p.sendMessage("§cVeuillez spécifié un joueur.");
                }

            }
        }
        return false;
    }
}
