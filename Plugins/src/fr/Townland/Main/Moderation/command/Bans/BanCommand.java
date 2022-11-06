package fr.Townland.Main.Moderation.command.Bans;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BanCommand implements CommandExecutor {
    private final Rank rank;

    public BanCommand(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("ban")){
            if (rank.hasPowerInf((Player) sender, 6)) {
                sender.sendMessage("§cVous n'avez pas la permission");
                return false;
            }

            if(args.length < 3){
                helpMessage(sender);
                return false;
            }
            String targetName = args[0];
            Player po = Bukkit.getServer().getPlayer(args[0]);
            if (rank.hasPowerSup((Player) po, 3)) {
                sender.sendMessage("§cVous ne pouvez pas bannir un membre de la modération");
                return false;
            }
            if(!Main.getInstance().playerInfos.exists(targetName)){
                sender.sendMessage("§cJoueur introuvable");
            }
            UUID targetuuid = Main.getInstance().playerInfos.getUUID(targetName);
            if(Main.getInstance().banManager.isBanned(targetuuid)){
                sender.sendMessage("§cCe joueur est déjà banni");
                return false;
            }
            String reason = "";
            for(int i = 2; i < args.length; i++){
                reason += args[i] + " ";
            }

            if(args[1].equalsIgnoreCase("perm")){
                Main.getInstance().banManager.ban(targetuuid,-1,reason);
                sender.sendMessage("§c[BAN] §fVous avez banni §6" + targetName);
                Bukkit.getServer().broadcastMessage("§c[BAN] §6" + targetName + " §cvient de se faire ban par§6 " + sender.getName());
                return false;

            }
            if(!args[1].contains(":")){
                helpMessage(sender);
                return false;
            }
            int duration = 0;
            try{
                duration = Integer.parseInt(args[1].split(":")[0]);
            }catch (NumberFormatException e){
                sender.sendMessage("§cLa valeur durée est invalide");
            }
            if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
                sender.sendMessage("§cUnité de temps invalide");
                for(TimeUnit units : TimeUnit.values()){
                    sender.sendMessage("§b "+units.getName() + "§f: §e" + units.getShortcut());
                }
                return false;
            }
            TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
            long banTime = unit.getToSecond() * duration;

            Main.getInstance().banManager.ban(targetuuid,banTime,reason);
            sender.sendMessage("§c[BAN] §fVous avez banni §6" + targetName);
            Bukkit.getServer().broadcastMessage("§c[BAN] §6" + targetName + " §cvient de se faire ban par§6 " + sender.getName());
            return false;
        }

        if(label.equalsIgnoreCase("unban")){
            if (rank.hasPowerInf((Player) sender, 6)) {
                sender.sendMessage("§cVous n'avez pas la permission");
                return false;
            }
            if(args.length != 1){
                sender.sendMessage("§c/unban <joueur>");
                return false;
            }
            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exists(targetName)){
                sender.sendMessage("§cJoueur introuvable");

            }
            UUID targetuuid = Main.getInstance().playerInfos.getUUID(targetName);
            if(!Main.getInstance().banManager.isBanned(targetuuid)){
                sender.sendMessage("§cCe joueur n'est pas banni");
                return false;
            }
            Main.getInstance().banManager.unban(targetuuid);;
            sender.sendMessage("§c[UNBAN] §fVous avez débanni §6" + targetName);
            return false;
        }
        if(label.equalsIgnoreCase("check")){
            if (rank.hasPowerInf((Player) sender, 4)) {
                sender.sendMessage("§cVous n'avez pas la permission");
                return false;
            }
            if(args.length != 1){
                sender.sendMessage("§c/check <joueur>");
                return false;
            }
            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exists(targetName)){
                sender.sendMessage("§cJoueur introuvable");
            }
            UUID targetuuid = Main.getInstance().playerInfos.getUUID(targetName);
            sender.sendMessage("§7-----------------------------------------------------");
            sender.sendMessage("§ePseudo : §b" + args[0]);
            sender.sendMessage("§eUUID : §b" + targetuuid.toString());
            sender.sendMessage("§eBanni : " + (Main.getInstance().banManager.isBanned(targetuuid) ? "§a✔" : "§c✖"));

            if(Main.getInstance().banManager.isBanned(targetuuid)){
                sender.sendMessage("");
                sender.sendMessage("§6Raison : §c" + Main.getInstance().banManager.getReason(targetuuid));
                sender.sendMessage("§6Temps restant : §f" + Main.getInstance().banManager.getTimeLeft(targetuuid));
            }

            sender.sendMessage("§7-----------------------------------------------------");
            sender.sendMessage("§ePseudo : §b" + args[0]);
            sender.sendMessage("§eUUID : §b" + targetuuid.toString());
            sender.sendMessage("§eMute : " + (Main.getInstance().muteManager.isMute(targetuuid) ? "§a✔" : "§c✖"));

            if(Main.getInstance().muteManager.isMute(targetuuid)){
                sender.sendMessage("§6Raison : §c" + Main.getInstance().muteManager.getReason(targetuuid));
                sender.sendMessage("§6Temps restant : §f" + Main.getInstance().muteManager.getTimeLeft(targetuuid));
            }

            sender.sendMessage("§7-----------------------------------------------------");
        }
        return false;
    }
    public void helpMessage(CommandSender sender){
        sender.sendMessage("§6/ban <joueur> perm <raison>");
        sender.sendMessage("§6/ban <joueur>:<durée> <raison>");

    }

}
