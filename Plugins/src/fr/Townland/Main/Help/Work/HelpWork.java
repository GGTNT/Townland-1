package fr.Townland.Main.Help.Work;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpWork implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (label.equalsIgnoreCase("HelpWork")){
                if (args.length == 0){
                    TextComponent msgHelpWork1 = new TextComponent("§2- Farmer " + "§9>>");
                    msgHelpWork1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Farmer"));

                    TextComponent msgHelpWork2 = new TextComponent("§6- Lumberjack (Bucheron) " + "§9>>");
                    msgHelpWork2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Bucheron"));

                    TextComponent msgHelpWork3 = new TextComponent("§7- Minor (Mineur) " + "§9>>");
                    msgHelpWork3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Mineur"));

                    TextComponent msgHelpWork4 = new TextComponent("§3- Fisherman (Pêcheur) " + "§9>>");
                    msgHelpWork4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Pecheur"));

                    TextComponent msgHelpWork5 = new TextComponent("§4- Hunter (Chasseur) " + "§9>>");
                    msgHelpWork5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Chasseur"));

                    TextComponent msgHelpWork6 = new TextComponent("§e- Breeder (Eleveur) " + "§9>>");
                    msgHelpWork6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Eleveur"));

                    TextComponent msgHelpWork7 = new TextComponent("§8- Blacksmith (Forgeron) " + "§9>>");
                    msgHelpWork7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Forgeron"));

                    TextComponent msgHelpWork8 = new TextComponent("§d- Enchanter (Enchanteur) " + "§9>>");
                    msgHelpWork8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Enchanteur"));

                    TextComponent msgHelpWork9 = new TextComponent("§5- Alchemist (Alchimiste) " + "§9>>");
                    msgHelpWork9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Alchimiste"));

                    player.sendMessage("§l============Work============");
                    player.spigot().sendMessage(msgHelpWork1);
                    player.spigot().sendMessage(msgHelpWork2);
                    player.spigot().sendMessage(msgHelpWork3);
                    player.spigot().sendMessage(msgHelpWork4);
                    player.spigot().sendMessage(msgHelpWork5);
                    player.spigot().sendMessage(msgHelpWork6);
                    player.spigot().sendMessage(msgHelpWork7);
                    player.spigot().sendMessage(msgHelpWork8);
                    player.spigot().sendMessage(msgHelpWork9);
                    player.sendMessage("§l============================");
                }

                if (args.length == 1){

                    if (args[0].equalsIgnoreCase("Farmer")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Farmer XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Farmer Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Farmer Avantages"));

                        sender.sendMessage("§2============Farmer============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§2============================");
                    }

                    if (args[0].equalsIgnoreCase("Bucheron")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Bucheron XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Bucheron Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Bucheron Avantages"));

                        sender.sendMessage("§6============Bucheron============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§6============================");
                    }

                    if (args[0].equalsIgnoreCase("Mineur")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Mineur XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Mineur Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Mineur Avantages"));

                        sender.sendMessage("§7============Mineur============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§7============================");
                    }

                    if (args[0].equalsIgnoreCase("Pecheur")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Pecheur XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Pecheur Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Pecheur Avantages"));

                        sender.sendMessage("§3============Pecheur============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§3============================");
                    }

                    if (args[0].equalsIgnoreCase("Chasseur")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Chasseur XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Chasseur Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Chasseur Avantages"));

                        sender.sendMessage("§4============Chasseur============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§4============================");
                    }

                    if (args[0].equalsIgnoreCase("Eleveur")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Eleveur XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Eleveur Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Eleveur Avantages"));

                        sender.sendMessage("§e============Eleveur============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§e============================");
                    }

                    if (args[0].equalsIgnoreCase("Forgeron")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Forgeron XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Forgeron Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Forgeron Avantages"));

                        sender.sendMessage("§8============Forgeron============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§8============================");
                    }

                    if (args[0].equalsIgnoreCase("Enchanteur")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Enchanteur XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Enchanteur Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Enchanteur Avantages"));

                        sender.sendMessage("§d============Enchanteur============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§d============================");
                    }

                    if (args[0].equalsIgnoreCase("Alchimiste")){

                        TextComponent msgHelp1 = new TextComponent("§5Comment gagner de l'xp ? " + "§9>>");
                        msgHelp1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Alchimiste XP"));

                        TextComponent msgHelp2 = new TextComponent("§1Récompenses ? " + "§9>>");
                        msgHelp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Alchimiste Recompenses"));

                        TextComponent msgHelp3 = new TextComponent("§4Avantages ? " + "§9>>");
                        msgHelp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helpWork Alchimiste Avantages"));

                        sender.sendMessage("§5============Alchimiste============");
                        sender.spigot().sendMessage(msgHelp1);
                        sender.spigot().sendMessage(msgHelp2);
                        sender.spigot().sendMessage(msgHelp3);
                        player.sendMessage("§5============================");
                    }
                }

                if (args.length == 2){

                    if (args[0].equalsIgnoreCase("Farmer")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§2============XP Farmer============");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires : 1 blé récolté = 10xp, 1 pain fabriqué = 10xp");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires : 1 blé récolté = 10xp, 1 pain fabriqué = 10xp");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires : 1 blé récolté = 10xp, 1 pain fabriqué = 10xp");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires : 1 blé récolté = 5xp, 1 pain fabriqué = 5xp, 1 carotte récolté = 10xp, 1 pomme de terre récolté = 10xp");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires : 1 blé récolté = 2xp, 1 carotte récolté = 10xp, 1 pomme de terre récolté = 10xp");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires : 1 blé récolté = 2xp, 1 carotte récolté = 10xp, 1 pomme de terre récolté = 10xp");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires : 1 blé récolté = 2xp, 1 carotte récolté = 5xp, 1 pomme de terre récolté = 5xp, 1 betterave récolté = 15xp");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires : 1 blé récolté = 2xp, 1 betterave récolté = 15xp");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires : 1 blé récolté = 2xp, 1 betterave récolté = 10xp, 1 canne à sucre récolté = 10xp");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires : 1 blé récolté = 2xp, 1 betterave récolté = 10xp, 1 canne à sucre récolté = 10xp");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires : 1 blé récolté = 2xp, 1 betterave récolté = 5xp, 1 canne à sucre récolté = 5xp, 1 citrouille récolté = 15xp");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires : 1 blé récolté = 2xp, 1 citrouille récolté = 15xp");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires : 1 blé récolté = 2xp, 1 citrouille récolté = 10xp");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires : 1 blé récolté = 2xp, 1 pastèque récolté = 15xp");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires : 1 blé récolté = 2xp, 1 pastèque récolté = 15xp");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires : 1 blé récolté = 2xp, 1 pastèque récolté = 10xp");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires : 1 blé récolté = 2xp, 1 cacao récolté = 15xp");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires : 1 blé récolté = 2xp, 1 cacao récolté = 15xp");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires : 1 blé récolté = 10xp, 1 pain fabriqué = 10xp");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires : 1 blé récolté = 10xp, 1 pain fabriqué = 10xp");
                            player.sendMessage("§2=================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§2============Récompenses Farmer============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 1 houe en diamant solidité I");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 1 houe en diamant Solidité III et Efficacité III");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 1 houe en netherite Solidité III et Efficacité IV");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 1 houe en netherite Solidité IV, Efficacité V et Raccommodage");
                            player.sendMessage("§2==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§2============Avantages Farmer============");
                            player.sendMessage("- Seuls joueurs à pouvoir bêcher la terre et planter (canne a sucre, cacao y compris)");
                            player.sendMessage("§2========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Bucheron")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§6============XP Bucheron============");
                            player.sendMessage("- 1 tronc cassé de n'importe quelle type de bois = 20xp");
                            player.sendMessage("§6============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§6===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§6============Récompenses Bucheron============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 1 hache en diamant Solidité I, Efficacité I");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 1 hache en diamant Solidité II, Efficacité III, Fortune I");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 1 hache en netherite Solidité III, Efficacité V, Fortune II");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 1 hache en netherite Solidité III, Efficacité VI, Fortune III");
                            player.sendMessage("§6==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§6============Avantages Bucheron============");
                            player.sendMessage("- Seuls joueurs à pouvoir récupérer les troncs d'arbres en le cassant");
                            player.sendMessage("§6==========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Mineur")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§7============XP Mineur============");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires : 1 pierre miné = 1xp, 1 minerai de charbon miné = 20xp");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires : 1 pierre miné = 1xp, 1 minerai de charbon miné = 20xp");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires : 1 pierre miné = 1xp, 1 minerai de charbon miné = 20xp, 1 minerai de fer miné = 30xp");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires : 1 pierre miné = 1xp, 1 minerai de fer miné = 30xp");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires : 1 pierre miné = 1xp, 1 minerai de fer miné = 20xp");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires : 1 minerai de fer miné = 20xp, 1 minerai de redstonne miné = 30xp");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires : 1 minerai de fer miné = 10xp, 1 minerai de redstonne miné = 20xp");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires : 1 minerai de fer miné = 10xp, 1 minerai de redstonne miné = 20xp, 1 minerai d'or miné = 50xp");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de redstonne miné = 10xp, 1 minerai d'or miné = 40xp, 1 minerai de pépites d'or = 40xp ");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai d'or miné = 30xp, 1 minerai de pépites d'or = 30xp, 1 minerai de quartz = 40xp");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de pépites d'or = 20xp, 1 minerai de quartz = 30xp");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de pépites d'or = 20xp, 1 minerai de quartz = 30xp");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de pépites d'or = 15xp, 1 minerai de quartz = 25xp");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de pépites d'or = 10xp, 1 minerai de quartz = 20xp, 1 pierre lumineuse miné = 60xp");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de quartz = 20xp, 1 pierre lumineuse miné = 60xp");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 pierre lumineuse miné = 50xp, 1 minerai de diamant miné = 120xp, 1 minerai de lapis-lazuli = 50xp");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de diamant miné = 110xp, 1 minerai de lapis-lazuli = 40xp, 1 minerai d'émeraude = 500xp");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de diamant miné = 100xp, 1 minerai de lapis-lazuli = 30xp, 1 minerai d'émeraude = 450xp, 1 débris antique miné = 200xp");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de diamant miné = 90xp, 1 minerai d'émeraude = 400xp, 1 débris antique miné = 190xp");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires : 1 minerai de fer miné = 5xp, 1 minerai de diamant miné = 80xp, 1 minerai d'émeraude = 350xp, 1 débris antique miné = 180xp");
                            player.sendMessage("§7=================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§7============Récompenses Mineur============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 1 pioche en diamant Solidité I et Efficacité I");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 1 pioche en diamant Solidité II, Efficacité III et Fortune I");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 1 pioche en netherite Solidité III, Efficacité IV et Fortune III");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 1 pioche en netherite Solidité III, Efficacité VI et Fortune III");
                            player.sendMessage("§7==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§7============Avantages Mineur============");
                            player.sendMessage("- Seuls joueurs à pouvoir récupérer les minerais minés");
                            player.sendMessage("§7========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Pecheur")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§3============XP Pecheur============");
                            player.sendMessage("- 1 saumon pêché = 40xp");
                            player.sendMessage("- 1 morue pêché = 40");
                            player.sendMessage("- 1 poison globe pêché = 100xp");
                            player.sendMessage("- 1 poisson tropical pêché = 100xp");
                            player.sendMessage("- 1 trésor pêché = 100xp");
                            player.sendMessage("- 1 déchet pêché = 60xp");
                            player.sendMessage("§3============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§3===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§3============Récompenses Pecheur============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 1 canne à pêche Solidité I, Appât I");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 1 canne à pêche Solidité II, Appât II, Chance de la mer I");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 1 canne à pêche Solidité III, Appât III, Chance de la mer II");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 1 canne à pêche Solidité IV, Appât IV, Chance de la mer III");
                            player.sendMessage("§3============================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§3============Avantages Pecheur============");
                            player.sendMessage("- Seuls joueurs à pouvoir pêcher");
                            player.sendMessage("§3=========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Chasseur")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§4============XP Chasseur============");
                            player.sendMessage("- Tuer un monstre = 80xp");
                            player.sendMessage("§4============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§4===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§4============Récompenses Chasseur============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, ajout  de 0,25 dégâts, 1 arc Puissance I et Solidité I");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, ajout  de 0,25 dégâts, 1 arc Puissance III, Solidité II et Flame ");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, ajout  de 0,25 dégâts, 1 arc Puissance V, Solidité III et Flame ");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus,  ajout  de 0,25 dégâts, 1 arc Puissance VI, Solidité III, Flame et Frappe II");
                            player.sendMessage("§4==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§4============Avantages Chasseur============");
                            player.sendMessage("- Seuls joueurs à avoir un bonus de dégâts. (jusqu'à 2X plus)");
                            player.sendMessage("§4==========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Eleveur")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§e============XP Eleveur============");
                            player.sendMessage("- Tuer un animal = 50xp");
                            player.sendMessage("- Nourrir un animal = 40xp");
                            player.sendMessage("- Eclore 1 œuf = 20xp");
                            player.sendMessage("§e============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§e===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§e============Récompenses Eleveur============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 2 laisses, 1 œuf de mouton, 1 œuf de vache et 1 œuf de poule");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 4 laisses, 2 œufs de mouton, 2 œufs de vache et 2 œufs de poule");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 6 laisses, 4 œufs de mouton, 4 œufs de vache et 4 œufs de poule");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 8 laisses, 8 œufs de mouton, 8 œufs de vache et 8 œufs de poule");
                            player.sendMessage("§e==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§e============Avantages Eleveur============");
                            player.sendMessage("- Seuls joueurs a pouvoir nourrir un animal");
                            player.sendMessage("§e========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Forgeron")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§8============XP Forgeron============");
                            player.sendMessage("- 4 flèches = 16xp");
                            player.sendMessage("- 1 arc = 20xp");
                            player.sendMessage("- 1 arbalète = 30xp");
                            player.sendMessage("- 1 bouclier = 15xp");
                            player.sendMessage("- 1 épée en fer = 20xp");
                            player.sendMessage("- 1 épée en or = 20xp");
                            player.sendMessage("- 1 épée en diamant = 200xp");
                            player.sendMessage("- 1 hache en fer = 30xp");
                            player.sendMessage("- 1 hache en or = 30xp");
                            player.sendMessage("- 1 hache en diamant = 300xp");
                            player.sendMessage("- 1 houe en fer = 30xp");
                            player.sendMessage("- 1 houe en or = 30xp");
                            player.sendMessage("- 1 houe en diamant = 300xp");
                            player.sendMessage("- 1 pelle en fer = 10xp");
                            player.sendMessage("- 1 hache en or = 30xp");
                            player.sendMessage("- 1 hache en diamant = 300xp");
                            player.sendMessage("- 1 pelle en fer = 10xp");
                            player.sendMessage("- 1 pelle en or = 10xp");
                            player.sendMessage("- 1 pelle en diamant = 10xp ");
                            player.sendMessage("- 1 casque en fer = 50xp");
                            player.sendMessage("- 1 casque en or = 50xp");
                            player.sendMessage("- 1 casque en diamant = 500xp ");
                            player.sendMessage("- 1 plastron en fer = 80xp");
                            player.sendMessage("- 1 plastron en or = 80xp");
                            player.sendMessage("- 1 plastron en diamant = 800xp ");
                            player.sendMessage("- 1 jambière en fer = 70xp");
                            player.sendMessage("- 1 jambière en or = 70xp");
                            player.sendMessage("- 1 jambière en diamant = 700xp ");
                            player.sendMessage("- 1 paire de botte en fer = 40xp");
                            player.sendMessage("- 1 paire de botte en or = 40xp");
                            player.sendMessage("- 1 paire de botte en diamant = 400xp");
                            player.sendMessage("- Transformation d'un outil ou armure en netherite = 600xp");
                            player.sendMessage("- 1 réparation dans l'enclume = 50xp");
                            player.sendMessage("§8============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§8===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§8============Récompenses Forgeron============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 1 débris antique et 1 enclume");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 2 débris antique et 2 enclumes");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 3 débris antique et 3 enclumes");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 4 débris antique et 4 enclumes");
                            player.sendMessage("§8==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§8============Avantages Forgeron============");
                            player.sendMessage("- Seuls joueurs a pouvoir fabriqué les outils/armures de fer à netherite et réaliser des réparations sur l'enclume");
                            player.sendMessage("§8==========================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Enchanteur")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§d========================XP Enchanteur========================");
                            player.sendMessage("- Solidité I = 80xp                - Solidité II = 160xp");
                            player.sendMessage("- Solidité III = 240xp             - Protection I = 80xp");
                            player.sendMessage("- Protection II = 160xp            - Protection III = 240xp");
                            player.sendMessage("- Protection IV = 320xp            - Puissance I = 80xp");
                            player.sendMessage("- Puissance II = 160xp             - Puissance III = 240xp");
                            player.sendMessage("- Puissance IV = 320xp             - Puissance V = 400xp");
                            player.sendMessage("- Infinité = 240xp                 - Flamme = 240xp");
                            player.sendMessage("- Frappe I = 160xp                 - Frappe II = 240xp");
                            player.sendMessage("- Perforation I = 80xp             - Perforation II = 160xp");
                            player.sendMessage("- Perforation III = 240xp          - Perforation IV = 320xp");
                            player.sendMessage("- Charge rapide I = 80xp           - Charge rapide II = 160xp");
                            player.sendMessage("- Charge rapide III = 240xp        - Tir multiple = 160xp");
                            player.sendMessage("- Protection au feu I = 80xp       - Protection au feu II = 160xp");
                            player.sendMessage("- Protection au feu III = 240xp    - Protection au feu IV = 320xp");
                            player.sendMessage("- Epine I = 80xp                   - Epine II = 160xp");
                            player.sendMessage("- Epine III = 240xp                - Protection explosions I = 80xp");
                            player.sendMessage("- Protection explosions II = 160xp - Protection explosions III = 240xp");
                            player.sendMessage("- Protection explosions IV = 320xp - Chute amortie I = 80xp");
                            player.sendMessage("- Chute amortie II = 160xp         - Chute amortie III = 240xp");
                            player.sendMessage("- Chute amortie IV = 320xp         - Agilité des âmes I = 160xp");
                            player.sendMessage("-Agilité des âmes II = 240xp       - Agilité des âmes III = 320xp");
                            player.sendMessage("- Agilité aquatique I = 80xp       - Agilité aquatique II = 160xp");
                            player.sendMessage("- Agilité aquatique III = 240xp    - Affinité aquatique I = 80xp");
                            player.sendMessage("- Affinité aquatique II = 160xp    - Affinité aquatique III = 240xp");
                            player.sendMessage("- Respiration I = 80xp             - Respiration II = 160xp");
                            player.sendMessage("- Respiration III = 240xp          - Fortune I = 160xp");
                            player.sendMessage("- Fortune II = 240xp               - Fortune III = 320xp");
                            player.sendMessage("- Touché de soie = 240xp           - Efficacité I = 80xp");
                            player.sendMessage("- Efficacité II = 160xp            - Efficacité III = 240xp");
                            player.sendMessage("- Efficacité IV = 320xp            - Efficacité V = 400xp");
                            player.sendMessage("- Tranchant I = 80xp               - Tranchant II = 160xp");
                            player.sendMessage("- Tranchant III = 240xp            - Tranchant IV = 320xp");
                            player.sendMessage("- Butin I = 160xp                  - Butin II = 240xp");
                            player.sendMessage("- Butin III = 320xp                - Aura de feu I = 160xp");
                            player.sendMessage("- Aura de feu II = 240xp           - Recul I = 160xp");
                            player.sendMessage("- Recul II = 240xp                 - Fléau des arthropodes I = 80xp");
                            player.sendMessage("- Fléau des arthropodes II = 160xp - Fléau des arthropodes III = 240xp");
                            player.sendMessage("- Fléau des arthropodes IV = 320xp - Fléau des arthropodes V = 400xp");
                            player.sendMessage("- Affilage I = 80xp                - Affilage II = 160xp");
                            player.sendMessage("- Affilage III = 240xp             - Châtiment I = 80xp");
                            player.sendMessage("- Châtiment II = 160xp             - Châtiment III = 240xp");
                            player.sendMessage("- Châtiment IV = 320xp             - Châtiment V = 400xp");
                            player.sendMessage("- Loyauté I = 80xp                 - Loyauté II = 160xp");
                            player.sendMessage("- Loyauté III = 240xp              - Empalement I = 80xp");
                            player.sendMessage("- Empalement II = 160xp            - Empalement III = 240xp");
                            player.sendMessage("- Empalement IV = 320xp            - Empalement V = 400xp");
                            player.sendMessage("- Impulsion I = 80xp               - Impulsion II = 160xp");
                            player.sendMessage("- Impulsion III = 240xp            - Canalisation = 240xp");
                            player.sendMessage("- Chance de la mer I = 160xp       - Chance de la mer II = 240xp");
                            player.sendMessage("- Chance de la mer III = 320xp     - Appât I = 160xp");
                            player.sendMessage("- Appât II = 240xp                 - Appât III = 320xp");
                            player.sendMessage("§d=================XP Nécessaire===============");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§d=============================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§d============Récompenses Enchanteur============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 128 fioles d'expériences et 8 livres");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus, 256 fioles d'expériences et 16 livres");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 512 fioles d'expériences et 32 livres");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 1024 fioles d'expériences et 64 livres");
                            player.sendMessage("§d============================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§d============Avantages Enchanteur============");
                            player.sendMessage("- Seuls joueurs a pouvoir enchanter (enclume et table d'enchantement)");
                            player.sendMessage("§d============================================");
                        }
                    }

                    if (args[0].equalsIgnoreCase("Alchimiste")){

                        if (args[1].equalsIgnoreCase("XP")){

                            player.sendMessage("§5============XP Alchimiste============");
                            player.sendMessage("- 1 potion étrange = 10xp");
                            player.sendMessage("- 1 potion jetable = 10xp");
                            player.sendMessage("- 1 potion banale = 10xp");
                            player.sendMessage("- 1 potion de faiblesse = 14xp");
                            player.sendMessage("- 1 potion de rapidité = 8xp");
                            player.sendMessage("- 1 potion de force = 10xp");
                            player.sendMessage("- 1 potion de poison = 10xp");
                            player.sendMessage("- 1 potion de soin = 12xp");
                            player.sendMessage("- 1 potion de dégâts = 14xp");
                            player.sendMessage("- 1 potion de régénération = 20xp ");
                            player.sendMessage("- 1 potion de respiration = 14xp");
                            player.sendMessage("- 1 potion de saut = 16xp");
                            player.sendMessage("- 1 potion de lenteur = 14xp");
                            player.sendMessage("- 1 potion de résistance au feu = 12xp");
                            player.sendMessage("- 1 potion de vision nocturne = 12xp");
                            player.sendMessage("- 1 potion d'invisibilité = 14xp");
                            player.sendMessage("- Amélioration en temps = 10xp (redstonne)");
                            player.sendMessage("- Amélioration de l'efficacité = 10xp (poudre lumineuse)");
                            player.sendMessage("§5============XP Nécessaire==========");
                            player.sendMessage("- Niveau 1 : 10 000xp nécessaires");
                            player.sendMessage("- Niveau 2 : 30 000xp nécessaires");
                            player.sendMessage("- Niveau 3 : 60 000xp nécessaires");
                            player.sendMessage("- Niveau 4 : 100 000xp nécessaires");
                            player.sendMessage("- Niveau 5 : 150 000xp nécessaires");
                            player.sendMessage("- Niveau 6 : 220 000xp nécessaires");
                            player.sendMessage("- Niveau 7 : 300 000xp nécessaires");
                            player.sendMessage("- Niveau 8 : 400 000xp nécessaires");
                            player.sendMessage("- Niveau 9 : 550 000xp nécessaires");
                            player.sendMessage("- Niveau 10 : 720 000xp nécessaires");
                            player.sendMessage("- Niveau 11 : 900 000xp nécessaires");
                            player.sendMessage("- Niveau 12 : 1 100 000xp nécessaires");
                            player.sendMessage("- Niveau 13 : 1 350 000xp nécessaires");
                            player.sendMessage("- Niveau 14 : 1 600 000xp nécessaires");
                            player.sendMessage("- Niveau 15 : 1 850 000xp nécessaires");
                            player.sendMessage("- Niveau 16 : 2 100 000xp nécessaires");
                            player.sendMessage("- Niveau 17 : 2 400 000xp nécessaires");
                            player.sendMessage("- Niveau 18 : 2 700 000xp nécessaires");
                            player.sendMessage("- Niveau 19 : 3 000 000xp nécessaires");
                            player.sendMessage("- Niveau 20 : 3 500 000xp nécessaires");
                            player.sendMessage("§5===================================");
                        }

                        if (args[1].equalsIgnoreCase("Recompenses")){

                            player.sendMessage("§5============Récompenses Alchimiste============");
                            player.sendMessage("- Niveau 1 : 1 000 écus");
                            player.sendMessage("- Niveau 2 : 3 000 écus");
                            player.sendMessage("- Niveau 3 : 5 000 écus");
                            player.sendMessage("- Niveau 4 : 8 000 écus");
                            player.sendMessage("- Niveau 5 : 12 000 écus, 16 fioles, 8 verrues du nether et 4 bâtons de blazes");
                            player.sendMessage("- Niveau 6 : 16 000 écus");
                            player.sendMessage("- Niveau 7 : 20 000 écus");
                            player.sendMessage("- Niveau 8 : 25 000 écus");
                            player.sendMessage("- Niveau 9 : 30 000 écus");
                            player.sendMessage("- Niveau 10 : 35 000 écus,  32 fioles, 16 verrues du nether et 8 bâtons de blazes ");
                            player.sendMessage("- Niveau 11 : 41 000 écus");
                            player.sendMessage("- Niveau 12 : 47 000 écus");
                            player.sendMessage("- Niveau 13 : 53 000 écus");
                            player.sendMessage("- Niveau 14 : 60 000 écus");
                            player.sendMessage("- Niveau 15 : 65 000 écus, 64 fioles, 32 verrues du nether et 16 bâtons de blazes");
                            player.sendMessage("- Niveau 16 : 72 000 écus");
                            player.sendMessage("- Niveau 17 : 78 000 écus");
                            player.sendMessage("- Niveau 18 : 86 000 écus");
                            player.sendMessage("- Niveau 19 : 92 000 écus");
                            player.sendMessage("- Niveau 20 : 100 000 écus, 128 fioles, 64 verrues du nether et 32 bâtons de blazes");
                            player.sendMessage("§5==========================================");
                        }

                        if (args[1].equalsIgnoreCase("Avantages")){

                            player.sendMessage("§5============Avantages Alchimiste============");
                            player.sendMessage("- Seuls joueurs a pouvoir utiliser l'alambic");
                            player.sendMessage("- Seuls joueurs a pouvoir planter des verrues du nether");
                            player.sendMessage("§5========================================");
                        }
                    }

                }
            }
        }
        return true;
    }
}
