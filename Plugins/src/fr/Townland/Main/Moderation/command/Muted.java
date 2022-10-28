package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class Muted implements CommandExecutor, Listener {
    private final Rank rank;

    public Muted(Rank rank) {
        this.rank = rank;
    }
    ArrayList<Player> muted = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("mute") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 3)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "[Mute] Joueur introuvable");
                        return false;
                    } else {
                        muted.add(po);
                        p.sendMessage("§b[Mute]§f Vous avez mute §6" + args[0]);
                        for (Player player : Bukkit.getOnlinePlayers()){
                            player.sendMessage("§c[Mute] " + p.getName() + " a été mute");
                        }
                        po.sendMessage("§6[Mute]§f Vous avez été mute par §6" + sender.getName());
                    }
                } else{
                    p.sendMessage("§cVeuillez spécifié un joueur");
                }

            }
        }
        if (label.equalsIgnoreCase("unmute") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 3)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "[Unmute] Joueur introuvable");
                        return false;
                    } else {
                        muted.remove(po);
                        p.sendMessage("§b[Unmute]§f Vous avez unmute §6" + args[0]);
                        po.sendMessage("§6[Unmute]§f Vous avez été unmute par §6" + sender.getName() + ", bon jeu :)");
                    }
                } else{
                    p.sendMessage("§cVeuillez spécifié un joueur");
                }

            }
        }
        return false;
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if (muted.contains(p)) {
            e.setCancelled(true);
            p.sendMessage("§cVous êtes mute.");
        }
    }
}