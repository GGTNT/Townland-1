package fr.Townland.Main.Help.Modo;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.TabList.RankList;
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

                //récupère power
                int ranklvl = 0;
                RankList rankList = rank.getPlayerRank(player);
                ranklvl = rankList.getPower();

                switch (ranklvl) {
                    case 4:
                        player.sendMessage("§2============HelpModoTest============");
                        player.sendMessage("/kick <joueur>");
                        player.sendMessage("/mute <joueur> <raison>");
                        player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                        player.sendMessage("/unmute <joueur>");
                        player.sendMessage("/check <joueur>");
                        player.sendMessage("§2============================");
                        break;

                    case 5:
                        player.sendMessage("§2============HelpModo============");
                        player.sendMessage("/kick <joueur>");
                        player.sendMessage("/mute <joueur> <raison>");
                        player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                        player.sendMessage("/unmute <joueur>");
                        player.sendMessage("/cclear");
                        player.sendMessage("/check <joueur>");
                        player.sendMessage("§2============================");
                        break;

                    case 6:
                        player.sendMessage("§2============HelpSM============");
                        player.sendMessage("/kick <joueur>");
                        player.sendMessage("/mute <joueur> <raison>");
                        player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                        player.sendMessage("/unmute <joueur>");
                        player.sendMessage("/cclear");
                        player.sendMessage("/clear <joueur>");
                        player.sendMessage("/tp <joueur>");
                        player.sendMessage("/tpa <joueur>");
                        player.sendMessage("/fly");
                        player.sendMessage("/freeze <joueur>");
                        player.sendMessage("/invsee <joueur>");
                        player.sendMessage("/ban <joueur> <raison>");
                        player.sendMessage("/tempban <joueur>:<durée> <raison>");
                        player.sendMessage("/unban <joueur>");
                        player.sendMessage("/vanish");
                        player.sendMessage("/check <joueur>");
                        player.sendMessage("§2============================");
                        break;

                    case 7:
                        player.sendMessage("§2============HelpAdmin============");
                        player.sendMessage("/kick <joueur>");
                        player.sendMessage("/mute <joueur> <raison>");
                        player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                        player.sendMessage("/unmute <joueur>");
                        player.sendMessage("/cclear");
                        player.sendMessage("/clear <joueur>");
                        player.sendMessage("/tp <joueur>");
                        player.sendMessage("/tpa <joueur>");
                        player.sendMessage("/fly");
                        player.sendMessage("/freeze <joueur>");
                        player.sendMessage("/invsee <joueur>");
                        player.sendMessage("/ban <joueur> <raison>");
                        player.sendMessage("/tempban <joueur>:<durée> <raison>");
                        player.sendMessage("/unban <joueur>");
                        player.sendMessage("/vanish");
                        player.sendMessage("/gamemode <survie/crétif/spectateur>");
                        player.sendMessage("/check <joueur>");
                        player.sendMessage("§2============================");
                        break;

                    case 8:
                        player.sendMessage("§2============HelpFonda============");
                        player.sendMessage("/kick <joueur>");
                        player.sendMessage("/mute <joueur> <raison>");
                        player.sendMessage("/tempmute <joueur>:<durée> <raison>");
                        player.sendMessage("/unmute <joueur>");
                        player.sendMessage("/cclear");
                        player.sendMessage("/clear <joueur>");
                        player.sendMessage("/tp <joueur>");
                        player.sendMessage("/tpa <joueur>");
                        player.sendMessage("/fly");
                        player.sendMessage("/freeze <joueur>");
                        player.sendMessage("/invsee <joueur>");
                        player.sendMessage("/ban <joueur> <raison>");
                        player.sendMessage("/tempban <joueur>:<durée> <raison>");
                        player.sendMessage("/unban <joueur>");
                        player.sendMessage("/vanish");
                        player.sendMessage("/gamemode <survie/crétif/spectateur>");
                        player.sendMessage("/check <joueur>");
                        player.sendMessage("§2============================");
                        break;
                }
            }
        }
        return true;
    }
}
