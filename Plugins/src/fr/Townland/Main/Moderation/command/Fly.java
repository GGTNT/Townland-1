package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class Fly implements CommandExecutor{
    ArrayList<Player> fly = new ArrayList<>();
    private final Rank rank;

    public Fly(Rank rank) {
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (rank.hasPowerInf((Player) sender, 5)) {
            sender.sendMessage("§cVous n'avez pas la permission");
        }else{
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (fly.contains(player)) {
                        player.setAllowFlight(false);
                        fly.remove(player);
                        player.sendMessage("§cVous ne pouvez maintenant plus voler.");
                    } else if (!fly.contains(player)) {
                        player.setAllowFlight(true);
                        fly.add(player);
                        player.sendMessage("§aVous pouvez maintenant voler.");
                        return true;
                    }
                }
            }

        return true;
    }
    @EventHandler
    public void onDamage(EntityDamageEvent d){
        Entity entite = d.getEntity();
        if(entite instanceof Player && fly.contains(entite)){
            d.setCancelled(true);
        }
    }
}
