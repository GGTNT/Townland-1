package fr.Townland.Main.Help;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.TabList.RankList;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.block.data.type.Switch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    private Rank rank;

    public HelpCommand(Rank rank){
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("help")){
                //msg help 1
                TextComponent msgHelp1 = new TextComponent("§1Les métiers " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork"));


                //msg modération
                TextComponent msgHelpModoTest = new TextComponent("§2Commandes modération " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpModo"));
                TextComponent msgHelpModo = new TextComponent("§2Commandes modération " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpModo"));
                TextComponent msgHelpSM = new TextComponent("§2Commandes modération " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpModo"));
                TextComponent msgHelpAdmin = new TextComponent("§2Commandes modération " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpModo"));
                TextComponent msgHelpFondateur = new TextComponent("§2Commandes modération " + "§9>>");
                msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpModo"));

                //récupère power
                int ranklvl = 0;
                RankList rankList = rank.getPlayerRank(player);
                ranklvl = rankList.getPower();

                switch (ranklvl) {
                    case 0:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.sendMessage("§l============================");
                        break;

                    case 1:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.sendMessage("§l============================");
                        break;

                    case 2:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.sendMessage("§l============================");
                        break;

                    case 3:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.sendMessage("§l============================");
                        break;

                    case 4:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.spigot().sendMessage(msgHelpModoTest);
                        player.sendMessage("§l============================");
                        break;

                    case 5:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.spigot().sendMessage(msgHelpModo);
                        player.sendMessage("§l============================");
                        break;

                    case 6:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.spigot().sendMessage(msgHelpSM);
                        player.sendMessage("§l============================");
                        break;

                    case 7:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.spigot().sendMessage(msgHelpAdmin);
                        player.sendMessage("§l============================");
                        break;

                    case 8:
                        player.sendMessage("§l============Help============");
                        player.spigot().sendMessage(msgHelp1);
                        player.spigot().sendMessage(msgHelpFondateur);
                        player.sendMessage("§l============================");
                        break;

                }
            }
        }

        return true;
    }
}
