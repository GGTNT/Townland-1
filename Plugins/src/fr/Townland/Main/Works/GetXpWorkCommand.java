package fr.Townland.Main.Works;

import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.Works.Pecheur.HashMapPecheur;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetXpWorkCommand implements CommandExecutor {

    private final HashMapFarmer hashMapFarmer;
    private final Rank rank;
    private final HashMapPecheur hashMapPecheur;

    public GetXpWorkCommand(Rank rank, HashMapFarmer hashMapFarmer, HashMapPecheur hashMapPecheur) {
        this.hashMapFarmer = hashMapFarmer;
        this.rank = rank;
        this.hashMapPecheur = hashMapPecheur;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equals("getxp")) {

                //modération
                if (!rank.hasPowerInf(player, 5)) {
                    if (args.length == 2) {

                        //métier farmer
                        if (args[0].equalsIgnoreCase("farmer")) {
                            Player player1 = Bukkit.getPlayer(args[1]);
                            if (player.isOnline()) {
                                if (hashMapFarmer.getWorkFarmer(player1)) {

                                    int xp = hashMapFarmer.getXPFarmer(player1);
                                    int niv = 0;
                                    int prog = 0;
                                    if (xp < 10000) {
                                        niv = 0;
                                    }
                                    if (xp >= 10000 && xp < 30000) {
                                        niv = 1;
                                    }
                                    if (xp >= 30000 && xp < 60000) {
                                        niv = 2;
                                    }
                                    if (xp >= 60000 && xp < 100000) {
                                        niv = 3;
                                    }
                                    if (xp >= 100000 && xp < 150000) {
                                        niv = 4;
                                    }
                                    if (xp >= 150000 && xp < 220000) {
                                        niv = 5;
                                    }
                                    if (xp >= 220000 && xp < 300000) {
                                        niv = 6;
                                    }
                                    if (xp >= 300000 && xp < 400000) {
                                        niv = 7;
                                    }
                                    if (xp >= 400000 && xp < 550000) {
                                        niv = 8;
                                    }
                                    if (xp >= 550000 && xp < 720000) {
                                        niv = 9;
                                    }
                                    if (xp >= 720000 && xp < 900000) {
                                        niv = 10;
                                    }
                                    if (xp >= 900000 && xp < 1100000) {
                                        niv = 11;
                                    }
                                    if (xp >= 1100000 && xp < 1350000) {
                                        niv = 12;
                                    }
                                    if (xp >= 1350000 && xp < 1600000) {
                                        niv = 13;
                                    }
                                    if (xp >= 1600000 && xp < 1850000) {
                                        niv = 14;
                                    }
                                    if (xp >= 1850000 && xp < 2100000) {
                                        niv = 15;
                                    }
                                    if (xp >= 2100000 && xp < 2400000) {
                                        niv = 16;
                                    }
                                    if (xp >= 2400000 && xp < 2700000) {
                                        niv = 17;
                                    }
                                    if (xp >= 2700000 && xp < 3000000) {
                                        niv = 18;
                                    }
                                    if (xp >= 3000000 && xp < 3500000) {
                                        niv = 19;
                                    }
                                    if (xp >= 3500000) {
                                        niv = 20;
                                    }

                                    switch (niv) {
                                        case 0:
                                            prog = 10000;
                                            break;
                                        case 1:
                                            prog = 30000;
                                            break;
                                        case 2:
                                            prog = 60000;
                                            break;
                                        case 3:
                                            prog = 100000;
                                            break;
                                        case 4:
                                            prog = 150000;
                                            break;
                                        case 5:
                                            prog = 220000;
                                            break;
                                        case 6:
                                            prog = 300000;
                                            break;
                                        case 7:
                                            prog = 400000;
                                            break;
                                        case 8:
                                            prog = 550000;
                                            break;
                                        case 9:
                                            prog = 720000;
                                            break;
                                        case 10:
                                            prog = 900000;
                                            break;
                                        case 11:
                                            prog = 1100000;
                                            break;
                                        case 12:
                                            prog = 1350000;
                                            break;
                                        case 13:
                                            prog = 1600000;
                                            break;
                                        case 14:
                                            prog = 1850000;
                                            break;
                                        case 15:
                                            prog = 2100000;
                                            break;
                                        case 16:
                                            prog = 2400000;
                                            break;
                                        case 17:
                                            prog = 2700000;
                                            break;
                                        case 18:
                                            prog = 3000000;
                                            break;
                                        case 19:
                                            prog = 3500000;
                                            break;
                                        case 20:
                                            prog = 3500000;
                                    }
                                    sender.sendMessage("§9Le joueur " + player1.getName() + " a : " + xp + "/" + prog + "xp dans le métier de farmer (niveau : " + niv + ")");
                                    return true;
                                } else {
                                    player.sendMessage("§cCe joueur n'est pas farmer");
                                    return true;
                                }

                            } else {
                                player.sendMessage("§cCe joueur n'est pas connecté");
                                return true;
                            }

                        }

                        //métier de pêcheur
                        if (args[0].equalsIgnoreCase("pecheur")) {
                            Player player1 = Bukkit.getPlayer(args[1]);
                            if (player.isOnline()) {
                                if (hashMapPecheur.getWorkpecheur(player1)) {
                                    int xp = hashMapPecheur.getXpPecheur(player1);
                                    int niv = 0;
                                    int prog = 0;
                                    if (xp < 10000) {
                                        niv = 0;
                                    }
                                    if (xp >= 10000 && xp < 30000) {
                                        niv = 1;
                                    }
                                    if (xp >= 30000 && xp < 60000) {
                                        niv = 2;
                                    }
                                    if (xp >= 60000 && xp < 100000) {
                                        niv = 3;
                                    }
                                    if (xp >= 100000 && xp < 150000) {
                                        niv = 4;
                                    }
                                    if (xp >= 150000 && xp < 220000) {
                                        niv = 5;
                                    }
                                    if (xp >= 220000 && xp < 300000) {
                                        niv = 6;
                                    }
                                    if (xp >= 300000 && xp < 400000) {
                                        niv = 7;
                                    }
                                    if (xp >= 400000 && xp < 550000) {
                                        niv = 8;
                                    }
                                    if (xp >= 550000 && xp < 720000) {
                                        niv = 9;
                                    }
                                    if (xp >= 720000 && xp < 900000) {
                                        niv = 10;
                                    }
                                    if (xp >= 900000 && xp < 1100000) {
                                        niv = 11;
                                    }
                                    if (xp >= 1100000 && xp < 1350000) {
                                        niv = 12;
                                    }
                                    if (xp >= 1350000 && xp < 1600000) {
                                        niv = 13;
                                    }
                                    if (xp >= 1600000 && xp < 1850000) {
                                        niv = 14;
                                    }
                                    if (xp >= 1850000 && xp < 2100000) {
                                        niv = 15;
                                    }
                                    if (xp >= 2100000 && xp < 2400000) {
                                        niv = 16;
                                    }
                                    if (xp >= 2400000 && xp < 2700000) {
                                        niv = 17;
                                    }
                                    if (xp >= 2700000 && xp < 3000000) {
                                        niv = 18;
                                    }
                                    if (xp >= 3000000 && xp < 3500000) {
                                        niv = 19;
                                    }
                                    if (xp >= 3500000) {
                                        niv = 20;
                                    }

                                    switch (niv) {
                                        case 0:
                                            prog = 10000;
                                            break;
                                        case 1:
                                            prog = 30000;
                                            break;
                                        case 2:
                                            prog = 60000;
                                            break;
                                        case 3:
                                            prog = 100000;
                                            break;
                                        case 4:
                                            prog = 150000;
                                            break;
                                        case 5:
                                            prog = 220000;
                                            break;
                                        case 6:
                                            prog = 300000;
                                            break;
                                        case 7:
                                            prog = 400000;
                                            break;
                                        case 8:
                                            prog = 550000;
                                            break;
                                        case 9:
                                            prog = 720000;
                                            break;
                                        case 10:
                                            prog = 900000;
                                            break;
                                        case 11:
                                            prog = 1100000;
                                            break;
                                        case 12:
                                            prog = 1350000;
                                            break;
                                        case 13:
                                            prog = 1600000;
                                            break;
                                        case 14:
                                            prog = 1850000;
                                            break;
                                        case 15:
                                            prog = 2100000;
                                            break;
                                        case 16:
                                            prog = 2400000;
                                            break;
                                        case 17:
                                            prog = 2700000;
                                            break;
                                        case 18:
                                            prog = 3000000;
                                            break;
                                        case 19:
                                            prog = 3500000;
                                            break;
                                        case 20:
                                            prog = 3500000;
                                    }
                                    sender.sendMessage("§9Le joueur " + player1.getName() + " a : " + xp + "/" + prog + "xp dans le métier de pêcheur (niveau : " + niv + ")");
                                    return true;

                                } else {
                                    player.sendMessage("§cCe joueur n'est pas farmer");
                                    return true;
                                }
                            } else {
                                player.sendMessage("§cCe joueur n'est pas connecté");
                                return true;
                            }

                        }

                    } else {
                        player.sendMessage("§c/getxp <métier> <joueur>");
                        return true;
                    }
                }

                //joueur
                if (args.length == 1) {
                    if (rank.hasPowerInf(player, 6)) {

                        //métier farmer
                        if (args[0].equals("farmer")) {
                            if (hashMapFarmer.getWorkFarmer(((Player) sender).getPlayer())) {
                                int xp = hashMapFarmer.getXPFarmer((Player) sender);
                                int niv = 0;
                                int prog = 0;
                                if (xp < 10000) {
                                    niv = 0;
                                }
                                if (xp >= 10000 && xp < 30000) {
                                    niv = 1;
                                }
                                if (xp >= 30000 && xp < 60000) {
                                    niv = 2;
                                }
                                if (xp >= 60000 && xp < 100000) {
                                    niv = 3;
                                }
                                if (xp >= 100000 && xp < 150000) {
                                    niv = 4;
                                }
                                if (xp >= 150000 && xp < 220000) {
                                    niv = 5;
                                }
                                if (xp >= 220000 && xp < 300000) {
                                    niv = 6;
                                }
                                if (xp >= 300000 && xp < 400000) {
                                    niv = 7;
                                }
                                if (xp >= 400000 && xp < 550000) {
                                    niv = 8;
                                }
                                if (xp >= 550000 && xp < 720000) {
                                    niv = 9;
                                }
                                if (xp >= 720000 && xp < 900000) {
                                    niv = 10;
                                }
                                if (xp >= 900000 && xp < 1100000) {
                                    niv = 11;
                                }
                                if (xp >= 1100000 && xp < 1350000) {
                                    niv = 12;
                                }
                                if (xp >= 1350000 && xp < 1600000) {
                                    niv = 13;
                                }
                                if (xp >= 1600000 && xp < 1850000) {
                                    niv = 14;
                                }
                                if (xp >= 1850000 && xp < 2100000) {
                                    niv = 15;
                                }
                                if (xp >= 2100000 && xp < 2400000) {
                                    niv = 16;
                                }
                                if (xp >= 2400000 && xp < 2700000) {
                                    niv = 17;
                                }
                                if (xp >= 2700000 && xp < 3000000) {
                                    niv = 18;
                                }
                                if (xp >= 3000000 && xp < 3500000) {
                                    niv = 19;
                                }
                                if (xp >= 3500000) {
                                    niv = 20;
                                }

                                switch (niv) {
                                    case 0:
                                        prog = 10000;
                                        break;
                                    case 1:
                                        prog = 30000;
                                        break;
                                    case 2:
                                        prog = 60000;
                                        break;
                                    case 3:
                                        prog = 100000;
                                        break;
                                    case 4:
                                        prog = 150000;
                                        break;
                                    case 5:
                                        prog = 220000;
                                        break;
                                    case 6:
                                        prog = 300000;
                                        break;
                                    case 7:
                                        prog = 400000;
                                        break;
                                    case 8:
                                        prog = 550000;
                                        break;
                                    case 9:
                                        prog = 720000;
                                        break;
                                    case 10:
                                        prog = 900000;
                                        break;
                                    case 11:
                                        prog = 1100000;
                                        break;
                                    case 12:
                                        prog = 1350000;
                                        break;
                                    case 13:
                                        prog = 1600000;
                                        break;
                                    case 14:
                                        prog = 1850000;
                                        break;
                                    case 15:
                                        prog = 2100000;
                                        break;
                                    case 16:
                                        prog = 2400000;
                                        break;
                                    case 17:
                                        prog = 2700000;
                                        break;
                                    case 18:
                                        prog = 3000000;
                                        break;
                                    case 19:
                                        prog = 3500000;
                                        break;
                                    case 20:
                                        prog = 3500000;
                                }
                                sender.sendMessage("§9Vous avez : " + xp + "/" + prog + "xp dans le métier de farmer (niveau : " + niv + ")");
                                return true;
                            } else {
                                sender.sendMessage("§cVous n'êtes pas farmer !");
                                return true;
                            }
                        }

                        //métier de pêcheur
                        if (args[0].equalsIgnoreCase("pecheur")) {
                            if (player.isOnline()) {
                                if (hashMapPecheur.getWorkpecheur(player)) {
                                    int xp = hashMapPecheur.getXpPecheur(player);
                                    int niv = 0;
                                    int prog = 0;
                                    if (xp < 10000) {
                                        niv = 0;
                                    }
                                    if (xp >= 10000 && xp < 30000) {
                                        niv = 1;
                                    }
                                    if (xp >= 30000 && xp < 60000) {
                                        niv = 2;
                                    }
                                    if (xp >= 60000 && xp < 100000) {
                                        niv = 3;
                                    }
                                    if (xp >= 100000 && xp < 150000) {
                                        niv = 4;
                                    }
                                    if (xp >= 150000 && xp < 220000) {
                                        niv = 5;
                                    }
                                    if (xp >= 220000 && xp < 300000) {
                                        niv = 6;
                                    }
                                    if (xp >= 300000 && xp < 400000) {
                                        niv = 7;
                                    }
                                    if (xp >= 400000 && xp < 550000) {
                                        niv = 8;
                                    }
                                    if (xp >= 550000 && xp < 720000) {
                                        niv = 9;
                                    }
                                    if (xp >= 720000 && xp < 900000) {
                                        niv = 10;
                                    }
                                    if (xp >= 900000 && xp < 1100000) {
                                        niv = 11;
                                    }
                                    if (xp >= 1100000 && xp < 1350000) {
                                        niv = 12;
                                    }
                                    if (xp >= 1350000 && xp < 1600000) {
                                        niv = 13;
                                    }
                                    if (xp >= 1600000 && xp < 1850000) {
                                        niv = 14;
                                    }
                                    if (xp >= 1850000 && xp < 2100000) {
                                        niv = 15;
                                    }
                                    if (xp >= 2100000 && xp < 2400000) {
                                        niv = 16;
                                    }
                                    if (xp >= 2400000 && xp < 2700000) {
                                        niv = 17;
                                    }
                                    if (xp >= 2700000 && xp < 3000000) {
                                        niv = 18;
                                    }
                                    if (xp >= 3000000 && xp < 3500000) {
                                        niv = 19;
                                    }
                                    if (xp >= 3500000) {
                                        niv = 20;
                                    }

                                    switch (niv) {
                                        case 0:
                                            prog = 10000;
                                            break;
                                        case 1:
                                            prog = 30000;
                                            break;
                                        case 2:
                                            prog = 60000;
                                            break;
                                        case 3:
                                            prog = 100000;
                                            break;
                                        case 4:
                                            prog = 150000;
                                            break;
                                        case 5:
                                            prog = 220000;
                                            break;
                                        case 6:
                                            prog = 300000;
                                            break;
                                        case 7:
                                            prog = 400000;
                                            break;
                                        case 8:
                                            prog = 550000;
                                            break;
                                        case 9:
                                            prog = 720000;
                                            break;
                                        case 10:
                                            prog = 900000;
                                            break;
                                        case 11:
                                            prog = 1100000;
                                            break;
                                        case 12:
                                            prog = 1350000;
                                            break;
                                        case 13:
                                            prog = 1600000;
                                            break;
                                        case 14:
                                            prog = 1850000;
                                            break;
                                        case 15:
                                            prog = 2100000;
                                            break;
                                        case 16:
                                            prog = 2400000;
                                            break;
                                        case 17:
                                            prog = 2700000;
                                            break;
                                        case 18:
                                            prog = 3000000;
                                            break;
                                        case 19:
                                            prog = 3500000;
                                            break;
                                        case 20:
                                            prog = 3500000;
                                    }
                                    sender.sendMessage("§9Le joueur " + player.getName() + " a : " + xp + "/" + prog + "xp dans le métier de pêcheur (niveau : " + niv + ")");
                                    return true;

                                } else {
                                    player.sendMessage("§cCe joueur n'est pas farmer");
                                    return true;
                                }
                            }
                        } else {
                            sender.sendMessage("§c/getxp <métier>");
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
