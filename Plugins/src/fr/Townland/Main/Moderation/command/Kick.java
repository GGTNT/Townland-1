package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    private final Rank rank;

    public Kick(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("kick") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 3)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "[KICK] Joueur introuvable");
                        return true;
                    } else {
                        p.sendMessage("§b[KICK] §fVous avez kick §6" + args[0]);
                        po.kickPlayer("§cVous avez été kick par §6" + p.getName());
                        return true;
                    }
                }else{
                    p.sendMessage("§eHelp: /kick <joueur>");
                }

            }
        }
        return false;
    }
}
