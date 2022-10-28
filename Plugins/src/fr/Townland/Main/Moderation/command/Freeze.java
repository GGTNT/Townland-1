package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Freeze implements CommandExecutor, Listener {
    public Main main;
    public Rank rank;

    public Freeze(Rank rank, Main main) {
    this.rank = rank;
    this.main = main;
    }
    @EventHandler
    public void onPLayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (main.frozen.contains(p)) {
            e.setTo(e.getFrom());
            p.sendMessage("§bFreeze : Tu es freeze.");
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent d) {
        Entity entite = d.getEntity();
        if (entite instanceof Player && main.frozen.contains(entite)) {
            d.setCancelled(true);
        }
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (label.equalsIgnoreCase("freeze") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 5)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            } else {
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "Joueur introuvable");
                        return true;
                    } else {
                        po.sendMessage("§b[Freeze] §fTu as été freeze par §6" + p.getName() + " §fne te déconnecte pas.");
                        main.frozen.add(po);
                        p.sendMessage("§b[Freeze] §fVous avez freeze §6" + args[0]);
                        return true;
                    }
                } else {
                    p.sendMessage("§cVeuillez spécifié un joueur.");
                }
            }
        }
        if (label.equalsIgnoreCase("unfreeze") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 5)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            } else {
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "Joueur introuvable");
                        return true;
                    } else {
                        po.sendMessage("§b[Freeze] §fTu as été unfreeze par §6" + p.getName() + " §f, bon jeu :)");
                        main.frozen.remove(po);
                        p.sendMessage("§b[Freeze] §fVous avez unfreeze §6" + args[0]);
                        return true;
                    }
                } else {
                    p.sendMessage("§cVeuillez spécifié un joueur.");
                }
            }
        }
        return false;
    }

}
