package fr.Townland.Main.TabList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class RankCommand implements CommandExecutor {

    private final Rank rank;
    private int r;
    private String rang;

    public RankCommand(Rank rank) {
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){

            if (rank.hasPowerInf((Player) sender, 5)){
                return sendMessage(sender, "§cVous n'avez pas la permission");
            }

            if (args.length != 2){
                return sendMessage(sender, "§c/rank <Player> <Rank>");
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null){
                return sendMessage(sender,"§cLe joueur n'a pas été trouvé");
            }
            RankList rankList = null;

            //supermodo
            if (rank.hasPower((Player) sender, 6)){
                if (args[1].equalsIgnoreCase("joueur") || args[1].equalsIgnoreCase("fer") || args[1].equalsIgnoreCase("or") || args[1].equalsIgnoreCase("diamant") || args[1].equalsIgnoreCase("modotest") || args[1].equalsIgnoreCase("modo")){
                    if (args[1].equalsIgnoreCase("joueur")){
                        r = 0;
                        rang = "§7Joueur";
                    }
                    if (args[1].equalsIgnoreCase("fer")){
                        r = 1;
                        rang = "§8Fer";
                    }
                    if (args[1].equalsIgnoreCase("or")){
                        r = 2;
                        rang = "§eOr";
                    }
                    if (args[1].equalsIgnoreCase("diamant")){
                        r = 3;
                        rang = "§bDiamant";
                    }
                    if (args[1].equalsIgnoreCase("modotest")){
                        r = 4;
                        rang = "§aModoTest";
                    }
                    if (args[1].equalsIgnoreCase("modo")){
                        r = 5;
                        rang = "§aModo";
                    }

                    try {
                        rankList = rank.getRankById(r);
                    }catch (NumberFormatException nbe){
                        try {
                            //rankList = RankList.valueOf(args[1].toUpperCase());
                            rankList = RankList.valueOf(String.valueOf(r));
                        }catch (Exception e){
                            return sendMessage(sender, "§cLe rank n'a pas été trouvé (Joueur, Fer, Or, Diamant, ModoTest, Modo)");
                        }
                    }

                    rank.changeRank(target, rankList);
                    sendMessage(target, "§9Votre grade a été modifié");
                    return sendMessage(sender, "§6" + target.getName() + "§2 a bien obtenu son grade " + rang);
                }else if (args[1].equalsIgnoreCase("sm") || args[1].equalsIgnoreCase("supermodo") || args[1].equalsIgnoreCase("admin") || args[1].equalsIgnoreCase("administrateur") || args[1].equalsIgnoreCase("fondateur")){
                    return sendMessage(sender,"§cVous ne pouvez pas mettre un joueur SuperModo, Administrateur ou Fondateur");
                }else {
                    return sendMessage(sender, "§c/rank <Player> <Rank>");
                }
            }

            //administrateur
            if (rank.hasPower((Player) sender, 7)){
                if (args[1].equalsIgnoreCase("joueur") || args[1].equalsIgnoreCase("fer") || args[1].equalsIgnoreCase("or") || args[1].equalsIgnoreCase("diamant") || args[1].equalsIgnoreCase("modotest") || args[1].equalsIgnoreCase("modo") || args[1].equalsIgnoreCase("supermodo") || args[1].equalsIgnoreCase("sm")){
                    if (args[1].equalsIgnoreCase("joueur")){
                        r = 0;
                        rang = "§7Joueur";
                    }
                    if (args[1].equalsIgnoreCase("fer")){
                        r = 1;
                        rang = "§8Fer";
                    }
                    if (args[1].equalsIgnoreCase("or")){
                        r = 2;
                        rang = "§eOr";
                    }
                    if (args[1].equalsIgnoreCase("diamant")){
                        r = 3;
                        rang = "§bDiamant";
                    }
                    if (args[1].equalsIgnoreCase("modotest")){
                        r = 4;
                        rang = "§aModoTest";
                    }
                    if (args[1].equalsIgnoreCase("modo")){
                        r = 5;
                        rang = "§aModo";
                    }
                    if (args[1].equalsIgnoreCase("supermodo") || args[1].equalsIgnoreCase("sm")){
                        r = 6;
                        rang = "§2SuperModo";
                    }
                    try {
                        rankList = rank.getRankById(r);
                    }catch (NumberFormatException nbe){
                        try {
                            rankList = RankList.valueOf(String.valueOf(r));
                        }catch (Exception e){
                            return sendMessage(sender, "§cLe rank n'a pas été trouvé (Joueur, Fer, Or, Diamant, ModoTest, Modo, SuperModo ou SM)");
                        }
                    }

                    rank.changeRank(target, rankList);
                    sendMessage(target, "§9Votre grade a été modifié");
                    return sendMessage(sender, "§6" + target.getName() + "§2 a bien obtenu son grade " + rang);
                }else if (args[1].equalsIgnoreCase("admin") || args[1].equalsIgnoreCase("administrateur") || args[1].equalsIgnoreCase("fondateur")){
                    return sendMessage(sender,"§cVous ne pouvez pas mettre un joueur Administrateur ou Fondateur");
                }else {
                    return sendMessage(sender, "§c/rank <Player> <Rank>");
                }
            }

            //fondateur
            if (rank.hasPower((Player) sender, 8)){
                if (args[1].equalsIgnoreCase("joueur")){
                    r = 0;
                    rang = "§7Joueur";
                }
                if (args[1].equalsIgnoreCase("fer")){
                    r = 1;
                    rang = "§8Fer";
                }
                if (args[1].equalsIgnoreCase("or")){
                    r = 2;
                    rang = "§eOr";
                }
                if (args[1].equalsIgnoreCase("diamant")){
                    r = 3;
                    rang = "§bDiamant";
                }
                if (args[1].equalsIgnoreCase("modotest")){
                    r = 4;
                    rang = "§aModoTest";
                }
                if (args[1].equalsIgnoreCase("modo")){
                    r = 5;
                    rang = "§aModo";
                }
                if (args[1].equalsIgnoreCase("supermodo") || args[1].equalsIgnoreCase("sm")){
                    r = 6;
                    rang = "§2SuperModo";
                }
                if (args[1].equalsIgnoreCase("administrateur") || args[1].equalsIgnoreCase("admin")){
                    r = 7;
                    rang = "§4Administrateur";
                }
                if (args[1].equalsIgnoreCase("fondateur")){
                    r = 8;
                    rang = "§1Fondateur";
                }

                try {
                    rankList = rank.getRankById(r);
                }catch (NumberFormatException nbe){
                    try {
                        rankList = RankList.valueOf(String.valueOf(r));
                    }catch (Exception e){
                        return sendMessage(sender, "§cLe rank n'a pas été trouvé (Joueur, Fer, Or, Diamant, ModoTest, Modo, SuperModo ou SM, Administrateur ou Admin, Fondateur)");
                    }
                }

                rank.changeRank(target, rankList);
                sendMessage(target, "§9Votre grade a été modifié");
                return sendMessage(sender, "§6" + target.getName() + "§2 a bien obtenu son grade " + rang);
            }
        }else {

            if (args.length != 2){
                return sendMessage(sender, "§c/rank <Player> <Rank>");
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null){
                return sendMessage(sender,"§cLe joueur n'a pas été trouvé");
            }
            RankList rankList = null;

            //console
            if (args[1].equalsIgnoreCase("joueur")){
                r = 0;
                rang = "§7Joueur";
            }
            if (args[1].equalsIgnoreCase("fer")){
                r = 1;
                rang = "§8Fer";
            }
            if (args[1].equalsIgnoreCase("or")){
                r = 2;
                rang = "§eOr";
            }
            if (args[1].equalsIgnoreCase("diamant")){
                r = 3;
                rang = "§bDiamant";
            }
            if (args[1].equalsIgnoreCase("modotest")){
                r = 4;
                rang = "§aModoTest";
            }
            if (args[1].equalsIgnoreCase("modo")){
                r = 5;
                rang = "§aModo";
            }
            if (args[1].equalsIgnoreCase("supermodo") || args[1].equalsIgnoreCase("sm")){
                r = 6;
                rang = "§2SuperModo";
            }
            if (args[1].equalsIgnoreCase("administrateur") || args[1].equalsIgnoreCase("admin")){
                r = 7;
                rang = "§4Administrateur";
            }
            if (args[1].equalsIgnoreCase("fondateur")){
                r = 8;
                rang = "§1Fondateur";
            }

            try {
                rankList = rank.getRankById(r);
            }catch (NumberFormatException nbe){
                try {
                    rankList = RankList.valueOf(String.valueOf(r));
                }catch (Exception e){
                    return sendMessage(sender, "§cLe rank n'a pas été trouvé (Joueur, Fer, Or, Diamant, ModoTest, Modo, SuperModo ou SM, Administrateur ou Admin, Fondateur)");
                }
            }

            rank.changeRank(target, rankList);
            sendMessage(target, "§9Votre grade a été modifié");
            return sendMessage(sender, "§6" + target.getName() + "§2 a bien obtenu son grade " + rang);
        }

        return true;
    }

    public boolean sendMessage(CommandSender sender, String msg){
        sender.sendMessage(msg);
        return true;
    }
}
