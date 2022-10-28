package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
    private final Rank rank;

    public ClearChat(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender || rank.hasPowerInf((Player) sender, 4)) {
            sender.sendMessage("§cVous n'avez pas la permission");
        }else{
            for (Player p : Bukkit.getOnlinePlayers()) {
                    for (int x = 0; x < 100; x++) {
                        p.sendMessage(" ");
                    }
                p.sendMessage("§aLe chat a été clear par §5" + sender.getName());
                    }
        }
        return false;
    }
}