package fr.Townland.Main.Economie.commands;

import fr.Townland.Main.Economie.DataEconomie.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        PlayerInfo playerInfo = new PlayerInfo(player);

        if (args.length == 0){
            player.sendMessage("§eVous avez actuellement §6" + playerInfo.getCoinsNumber() + "coins");
            return true;
        }
        if (args.length >= 1){
            if(args[0].equalsIgnoreCase("add")){

                if(args.length == 3){
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        float amount = Float.valueOf(args[1]);
                        PlayerInfo targetInfo = new PlayerInfo(target);
                        if (amount < 0) {
                            player.sendMessage("§cVeuillez entrer un nombre valide.");
                        } else {
                            targetInfo.addCoins(amount);
                            player.sendMessage("§eVous avez envoyer §b" + amount + " coins à §6" + target.getName());
                            target.sendMessage("§eVous avez reçu §6" + amount + " coins");
                        }
                    }else{
                        player.sendMessage("§cJoueur introuvable.");
                    }
                }
            }
            if(args[0].equalsIgnoreCase("remove")) {

                if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        float amount = Float.valueOf(args[1]);
                        PlayerInfo targetInfo = new PlayerInfo(target);
                        if(amount < 0){
                            player.sendMessage("§cVeuillez entrer un nombre valide.");
                        }else {
                            try {
                                targetInfo.removeCoins(amount);
                                player.sendMessage("§eVous avez retiré §b" + amount + " coins à §6" + target.getName());
                                target.sendMessage( player.getName() + " §evous a retiré §6" + amount + " coins");
                            } catch (NumberFormatException e) {
                                player.sendMessage("§cVeuillez entrer un nombre valide.");
                            }
                        }
                    }
                }
            }
            if(args[0].equalsIgnoreCase("pay")) {

                if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        try {
                        float amount = Float.valueOf(args[1]);
                        PlayerInfo playerInfo1 = new PlayerInfo(player);
                        PlayerInfo targetInfo = new PlayerInfo(target);
                        if(amount < 0){
                            player.sendMessage("§cVeuillez entrer un nombre valide.");
                        }else {

                                if (amount > playerInfo.getCoinsNumber()){
                                    player.sendMessage("§cVous n'avez pas asser d'argent.");
                                }
                                else {
                                    playerInfo1.removeCoins(amount);
                                    targetInfo.addCoins(amount);
                                    player.sendMessage("§evous avez envoyé §b" + amount + "coins à §6" + target.getName());
                                    target.sendMessage(player.getName() + " §evous a envoyé §b" + amount + " coins");
                                }
                            }
                            }catch (NumberFormatException e) {
                            player.sendMessage("§cVeuillez entrer un nombre valide.");
                        }
                    }
                }
            }
            if(args[0].equalsIgnoreCase("set")) {

                if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        try {
                            float amount = Float.valueOf(args[1]);
                            PlayerInfo targetInfo = new PlayerInfo(target);
                            if(amount < 0){
                                player.sendMessage("§cVeuillez entrer un nombre valide.");
                            }else {
                                targetInfo.setCoins(amount);
                                player.sendMessage("§evous avez mis le compte de §6" + target.getName() + "à §b" + amount + "coins");
                                target.sendMessage(player.getName() + " §e a mis votre compte à §b" + amount + " coins");
                                }
                        }catch (NumberFormatException e) {
                            player.sendMessage("§cVeuillez entrer un nombre valide.");
                        }
                    }
                }
            }
        }
        return true;
    }
}













