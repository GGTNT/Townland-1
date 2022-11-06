package fr.Townland.Main.Moderation.command.Mute;

import fr.Townland.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class MuteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("mute")){
            if(args.length < 3){
                helpMessage(sender);
                return false;
            }
            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exists(targetName)){
                sender.sendMessage("§cJoueur introuvable");
            }
            UUID targetuuid = Main.getInstance().playerInfos.getUUID(targetName);
            if(Main.getInstance().muteManager.isMute(targetuuid)){
                sender.sendMessage("§cCe joueur est déjà mute");
                return false;
            }
            String reason = "";
            for(int i = 2; i < args.length; i++){
                reason += args[i] + " ";
            }

            if(args[1].equalsIgnoreCase("perm")){
                Main.getInstance().muteManager.mute(targetuuid,-1,reason);
                sender.sendMessage("§c[Mute] §fVous avez mute §6" + targetName);
                Bukkit.getServer().broadcastMessage("§c[Mute] §6" + targetName + " §cvient de se faire mute par§6 " + sender.getName());
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
            long muteTime = unit.getToSecond() * duration;

            Main.getInstance().muteManager.mute(targetuuid,muteTime,reason);
            sender.sendMessage("§c[MUTE] §fVous avez mute §6" + targetName);
            Bukkit.getServer().broadcastMessage("§c[MUTE] §6" + targetName + " §cvient de se faire mute par§6 " + sender.getName());
            return false;
        }

        if(label.equalsIgnoreCase("unmute")){
            if(args.length != 1){
                sender.sendMessage("§c/unmute <joueur>");
                return false;
            }
            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exists(targetName)){
                sender.sendMessage("§cJoueur introuvable");

            }
            UUID targetuuid = Main.getInstance().playerInfos.getUUID(targetName);
            if(!Main.getInstance().muteManager.isMute(targetuuid)){
                sender.sendMessage("§cCe joueur n'est pas mute");
                return false;
            }
            Main.getInstance().muteManager.unmute(targetuuid);;
            sender.sendMessage("§c[UNMUTE] §fVous avez unmute §6" + targetName);
            return false;
        }
        return false;
    }
    public void helpMessage(CommandSender sender){
        sender.sendMessage("§6/mute <joueur> perm <raison>");
        sender.sendMessage("§6/mute <joueur>:<durée> <raison>");

    }

}
