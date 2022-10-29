package fr.Townland.Main.Help.Modo;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.TabList.RankList;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpModo implements CommandExecutor {

    private Rank rank;

    public HelpModo(Rank rank){
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("helpmodo")){

                if (args.length == 0){

                    TextComponent msgHelpModo1 = new TextComponent("§2- Modération " + "§9>>");
                    msgHelpModo1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpmodo moderation"));

                    TextComponent msgHelpModo2 = new TextComponent("§e- Economie " + "§9>>");
                    msgHelpModo2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpmodo economie"));

                    TextComponent msgHelpModo3 = new TextComponent("§1- Métiers " + "§9>>");
                    msgHelpModo3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpmodo metier"));





                    if (rank.hasPower(player,4) || rank.hasPower(player, 5)){

                        player.sendMessage("§2============Modération============");
                        player.spigot().sendMessage(msgHelpModo1);
                        player.sendMessage("§2============================");
                    }
                    if (rank.hasPowerSup(player, 6)){
                        player.sendMessage("§2============Modération============");
                        player.spigot().sendMessage(msgHelpModo1);
                        player.spigot().sendMessage(msgHelpModo2);
                        player.spigot().sendMessage(msgHelpModo3);
                        player.sendMessage("§2============================");
                    }


                }else if(args.length == 1) {

                    //récupère power
                    int ranklvl = 0;
                    RankList rankList = rank.getPlayerRank(player);
                    ranklvl = rankList.getPower();

                    if (args[0].equalsIgnoreCase("moderation")) {

                        switch (ranklvl) {
                            case 4:
                                player.sendMessage("§2============HelpModoTest============");
                                player.sendMessage("/kick <joueur>");
                                player.sendMessage("/mute <joueur> perm <raison>");
                                player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                                player.sendMessage("/unmute <joueur>");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 5:
                                player.sendMessage("§2============HelpModo============");
                                player.sendMessage("/kick <joueur>");
                                player.sendMessage("/mute <joueur> perm <raison>");
                                player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                                player.sendMessage("/unmute <joueur>");
                                player.sendMessage("/cclear");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 6:
                                player.sendMessage("§2============HelpSM============");
                                player.sendMessage("/kick <joueur>");
                                player.sendMessage("/mute <joueur> perm <raison>");
                                player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                                player.sendMessage("/unmute <joueur>");
                                player.sendMessage("/cclear");
                                player.sendMessage("/clear <joueur>");
                                player.sendMessage("/tp <joueur>");
                                player.sendMessage("/tpa <joueur>");
                                player.sendMessage("/fly");
                                player.sendMessage("/freeze <joueur>");
                                player.sendMessage("/invsee <joueur>");
                                player.sendMessage("/ban <joueur> perm <raison>");
                                player.sendMessage("/tempban <joueur>:<durée> <raison>");
                                player.sendMessage("/unban <joueur>");
                                player.sendMessage("/vanish");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 7:
                                player.sendMessage("§2============HelpAdmin============");
                                player.sendMessage("/kick <joueur>");
                                player.sendMessage("/mute <joueur> perm <raison>");
                                player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                                player.sendMessage("/unmute <joueur>");
                                player.sendMessage("/cclear");
                                player.sendMessage("/clear <joueur>");
                                player.sendMessage("/tp <joueur>");
                                player.sendMessage("/tpa <joueur>");
                                player.sendMessage("/fly");
                                player.sendMessage("/freeze <joueur>");
                                player.sendMessage("/invsee <joueur>");
                                player.sendMessage("/ban <joueur> perm <raison>");
                                player.sendMessage("/tempban <joueur>:<durée> <raison>");
                                player.sendMessage("/unban <joueur>");
                                player.sendMessage("/vanish");
                                player.sendMessage("/gamemode <survie/créative/spectateur>");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 8:
                                player.sendMessage("§2============HelpFonda============");
                                player.sendMessage("/kick <joueur>");
                                player.sendMessage("/mute <joueur> perm <raison>");
                                player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                                player.sendMessage("/unmute <joueur>");
                                player.sendMessage("/cclear");
                                player.sendMessage("/clear <joueur>");
                                player.sendMessage("/tp <joueur>");
                                player.sendMessage("/tpa <joueur>");
                                player.sendMessage("/fly");
                                player.sendMessage("/freeze <joueur>");
                                player.sendMessage("/invsee <joueur>");
                                player.sendMessage("/ban <joueur> perm <raison>");
                                player.sendMessage("/tempban <joueur>:<durée> <raison>");
                                player.sendMessage("/unban <joueur>");
                                player.sendMessage("/vanish");
                                player.sendMessage("/gamemode <survie/créative/spectateur>");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("/check <joueur>");
                                player.sendMessage("§2============================");
                                break;
                        }
                    }

                    if (args[0].equalsIgnoreCase("economie")) {

                        switch (ranklvl) {
                            case 6:
                                player.sendMessage("§2============HelpSM============");
                                player.sendMessage("/coins <joueur>");
                                player.sendMessage("/coins add <nombre> <joueur>");
                                player.sendMessage("/coins remove <nombre> <joueur>");
                                player.sendMessage("/coins pay <nombre> <joueur>");
                                player.sendMessage("/coins set <nombre> <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 7:
                                player.sendMessage("§2============HelpAdmin============");
                                player.sendMessage("/coins <joueur>");
                                player.sendMessage("/coins add <nombre> <joueur>");
                                player.sendMessage("/coins remove <nombre> <joueur>");
                                player.sendMessage("/coins pay <nombre> <joueur>");
                                player.sendMessage("/coins set <nombre> <joueur>");
                                player.sendMessage("§2============================");
                                break;

                            case 8:
                                player.sendMessage("§2============HelpFonda============");
                                player.sendMessage("/coins <joueur>");
                                player.sendMessage("/coins add <nombre> <joueur>");
                                player.sendMessage("/coins remove <nombre> <joueur>");
                                player.sendMessage("/coins pay <nombre> <joueur>");
                                player.sendMessage("/coins set <nombre> <joueur>");
                                player.sendMessage("§2============================");
                                break;
                        }
                    }

                    if (args[0].equalsIgnoreCase("metier")) {

                        switch (ranklvl) {
                            case 6:
                                player.sendMessage("§2============HelpSM============");
                                player.sendMessage("/getwork <joueur>");
                                player.sendMessage("/getxp <métier> <joueur>");
                                player.sendMessage("/givexp <métier> <joueur> <nombre>");
                                player.sendMessage("/joinwork <métier> <joueur>");
                                player.sendMessage("/leavework <métier> <joueur>");
                                player.sendMessage("/removexp <métier> <joueur> <nombre>");
                                player.sendMessage("§2============================");
                                break;

                            case 7:
                                player.sendMessage("§2============HelpAdmin============");
                                player.sendMessage("/getwork <joueur>");
                                player.sendMessage("/getxp <métier> <joueur>");
                                player.sendMessage("/givexp <métier> <joueur> <nombre>");
                                player.sendMessage("/joinwork <métier> <joueur>");
                                player.sendMessage("/leavework <métier> <joueur>");
                                player.sendMessage("/removexp <métier> <joueur> <nombre>");
                                player.sendMessage("§2============================");
                                break;

                            case 8:
                                player.sendMessage("§2============HelpFonda============");
                                player.sendMessage("/getwork <joueur>");
                                player.sendMessage("/getxp <métier> <joueur>");
                                player.sendMessage("/givexp <métier> <joueur> <nombre>");
                                player.sendMessage("/joinwork <métier> <joueur>");
                                player.sendMessage("/leavework <métier> <joueur>");
                                player.sendMessage("/removexp <métier> <joueur> <nombre>");
                                player.sendMessage("§2============================");
                                break;
                        }
                    }
                }
                }

            }
        return true;
    }
}
