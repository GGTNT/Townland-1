package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;

public class TempBan implements CommandExecutor {
    private final Rank rank;

    public TempBan(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("tempban")) {
            if (rank.hasPowerInf((Player) sender, 5)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 0) {
                    sender.sendMessage("§cVeuillez spécifié un joueur.");
                    return true;
                }
                if(args.length == 1){
                    String format = args[1].substring(args.length - 1, args.length);
                    int duration = Integer.valueOf(args[1].substring(0, args.length - 1));
                    long time = 0;

                    switch (format){
                        case "m":
                            time = duration * 1000;
                            break;
                        case "h":
                            time = duration * 1000 * 60;
                            break;
                        case "d":
                            time = duration * 1000 * 60 * 24;
                        default:
                            sender.sendMessage("Veuillez rentrer une date correct");
                            return true;
                    }
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage("§cImpossible de trouver ce joueur.");
                    return true;
                }
                target.kickPlayer(cc("&7&lTownland>> &f&lVous avez été banni !\n\nBanni par : " + sender.getName() + "&f&l\nRaison: " + args[1] ));
                target.getServer().getBanList(BanList.Type.NAME);
                Bukkit.getBanList(BanList.Type.NAME).addBan(args[0],(cc("&7&lTownland>> &f&lVous avez été banni !\n\nModérateur : " + sender.getName() + "&f&l\nRaison: " + args[1] )), null, null);
                sender.sendMessage("§c[BAN] §fVous avez banni §6" + target.getName());
                Bukkit.getServer().broadcastMessage("§c[BAN] §6" + target.getName() + " §cvient de se faire ban par§6 " + sender.getName());
            }
        }
        return true;
    }
    public String cc(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    @EventHandler
    public void OnJoinBan(PlayerLoginEvent e) {
        if (e.getPlayer().isBanned()) {
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED, cc("&cVous êtes banni de Townland !\n\n&7&lOuvrez un ticket sur le Discord\n\n>>&f&l https://discord.townland.fr"));
        }
    }

}
