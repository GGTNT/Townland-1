package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Invsee implements CommandExecutor {
    private final Rank rank;

    public Invsee(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("invsee") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 5)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    Player po = Bukkit.getServer().getPlayer(args[0]);
                    if (po == null) {
                        p.sendMessage(ChatColor.RED + "[INVSEE] Joueur introuvable");
                        return false;
                    }
                    else if (rank.hasPowerSup((Player) po, 4)) {
                            p.sendMessage("§cVous ne pouvez pas voir l'inventaire d'un membre du staff.");
                            return false;

                    } else {
                        Inventory inv = Bukkit.createInventory(null, 5 * 9, po.getName() + " > Inventaire");

                        for(int i = 0; i < 36; i++){
                            if(po.getInventory().getItem(i) != null){
                                inv.setItem(i, po.getInventory().getItem(i));
                            }
                        }

                        inv.setItem(36, po.getInventory().getHelmet());
                        inv.setItem(37, po.getInventory().getChestplate());
                        inv.setItem(38, po.getInventory().getLeggings());
                        inv.setItem(39, po.getInventory().getBoots());

                        p.openInventory(inv);
                    }
                } else{
                    p.sendMessage("§cVeuillez spécifié un joueur");
                }

            }
        }
        return false;
    }
}
