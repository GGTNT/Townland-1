package fr.Townland.Main.Help;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("help")){
                //msg help 1
                TextComponent msgHelp1 = new TextComponent("§1Les métiers " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork"));


                player.sendMessage("§l============Help============");
                player.spigot().sendMessage(msgHelp1);
                player.sendMessage("§l============================");
            }
        }

        return true;
    }
}
