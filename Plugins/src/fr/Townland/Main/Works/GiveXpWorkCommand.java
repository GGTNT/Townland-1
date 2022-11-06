package fr.Townland.Main.Works;

import fr.Townland.Main.Works.Farmer.HashMapFarmer;
import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Works.Pecheur.HashMapPecheur;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveXpWorkCommand implements CommandExecutor {

    private final Rank rank;
    private final HashMapFarmer hashMapFarmer;
    private final HashMapPecheur hashMapPecheur;

    public GiveXpWorkCommand(Rank rank, HashMapFarmer hashMapFarmer, HashMapPecheur hashMapPecheur) {
        this.rank = rank;
        this.hashMapFarmer = hashMapFarmer;
        this.hashMapPecheur = hashMapPecheur;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equals("givexp")) {
                if (args.length == 3) {
                    if (rank.hasPowerSup(player, 6)) {

                        Player player1 = Bukkit.getPlayer(args[1]);

                        if (args[0].equalsIgnoreCase("farmer")) {

                            if (hashMapFarmer.getWorkFarmer(player1)) {
                                if (player1.isOnline()) {

                                    int xp = Integer.parseInt(args[2]);
                                    hashMapFarmer.addXPFarmer(player1, xp);
                                    player.sendMessage("§2" + player1.getName() + " a reçu " + xp + "xp du métier farmer");
                                    player1.sendMessage("§2" + player.getName() + " vous a donné " + xp + "xp du métier farmer");
                                    return true;


                                } else {
                                    player.sendMessage("§cJoueur introuvable ou déconnecté");
                                    return true;
                                }
                            } else {
                                player.sendMessage("§cCe Joueur n'est pas Farmer");
                                return true;
                            }
                        }

                        if (args[0].equalsIgnoreCase("pecheur")) {

                            if (hashMapPecheur.getWorkpecheur(player1)) {
                                if (player1.isOnline()) {

                                    int xp = Integer.parseInt(args[2]);
                                    hashMapPecheur.addXppecheur(player1, xp);
                                    player.sendMessage("§2" + player1.getName() + " a reçu " + xp + "xp du métier Pêcheur");
                                    player1.sendMessage("§2" + player.getName() + " vous a donné " + xp + "xp du métier Pêcheur");
                                    return true;


                                } else {
                                    player.sendMessage("§cJoueur introuvable ou déconnecté");
                                    return true;
                                }


                            } else {
                                player.sendMessage("§cCe Joueur n'est pas Pêcheur");
                                return true;
                            }


                        } else {
                            player.sendMessage("§cvous n'avez pas la permission d'éxecuter cette commande");
                            return true;
                        }
                    } else {
                        player.sendMessage("§c/givexp <métier> <joueur> <xp>");
                        return true;
                    }
                } else {
                    player.sendMessage("§c/givexp <métier> <joueur> <xp>");
                    return true;
                }
            }
        }
        return true;
    }
}