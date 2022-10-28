package fr.Townland.Main.works;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("work")){
            sender.sendMessage("§l============Work============");
            sender.sendMessage("§2- farmer (Farmeur)");
            sender.sendMessage("§6- lumberjack (Bucheron");
            sender.sendMessage("§7- minor (Mineur)");
            sender.sendMessage("§3- fisherman (Pêcheur)");
            sender.sendMessage("§4- hunter (Chasseur)");
            sender.sendMessage("§e- breeder (Eleveur)");
            sender.sendMessage("§8- blacksmith (Forgeron)");
            sender.sendMessage("§d- enchanter (Enchanteur)");
            sender.sendMessage("§4- alchemist (Alchimiste)");
            sender.sendMessage("§l============================");
        }
        return true;
    }
}
