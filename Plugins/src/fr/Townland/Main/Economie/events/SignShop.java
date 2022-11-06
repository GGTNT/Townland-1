package fr.Townland.Main.Economie.events;

import fr.Townland.Main.Economie.DataEconomie.PlayerInfo;
import fr.Townland.Main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;


public class SignShop implements Listener {
    @EventHandler
    public void onPlayerClickSign(PlayerInteractEvent e) {

        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getHand().equals(EquipmentSlot.HAND)) {
                if (e.getClickedBlock().getType().equals(Material.OAK_WALL_SIGN)) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    int si = 1;
                    if (s.getLine(0).equals(ChatColor.AQUA + "[VENTE]")) {
                        String priceString = s.getLine(3).replace("$", "");
                        int price = Integer.parseInt(ChatColor.stripColor(priceString));
                        Player p = e.getPlayer();
                        PlayerInfo playerInfo1 = new PlayerInfo(p);
                        if (playerInfo1.getCoinsNumber() > price) {
                            playerInfo1.removeCoins(price);
                            System.out.println(p.getName());
                            p.getInventory().addItem(new ItemStack(Material.DIAMOND));
                            p.sendMessage("Vous avez acheter un diamant à $" + price + " !" );
                        }
                    }
                }
            }
        }
    }
    public Block b;

    @EventHandler
    public void onSignPlacedByPlayer(SignChangeEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType().equals(Material.OAK_WALL_SIGN)) {
            if (e.getPlayer().isOp() || e.getPlayer().hasPermission("sign.create")) {
                if (e.getLine(0).equals("[VENTE]")) {
                    if (!e.getLine(1).isEmpty()) {
                        int price = Integer.parseInt(e.getLine(1));
                        e.setLine(0, ChatColor.AQUA + "[VENTE]");
                        e.setLine(1, ChatColor.YELLOW + e.getPlayer().getName());
                        e.setLine(2, ChatColor.BLUE + "DIAMOND");
                        e.setLine(3, "§a" + price);
                        //System.out.println(chest.getFace(chest) != BlockFace.SELF);


                        Main.getInstance().signShopManager.setShop(e.getPlayer().getUniqueId(), e.getPlayer().getName(), (double) e.getBlock().getLocation().getBlockX(), (double) e.getBlock().getLocation().getBlockY(), (double) e.getBlock().getLocation().getBlockZ());
                    }
                }


            }
        }
    }
    @EventHandler
    public void onSupSign(BlockBreakEvent e) {
        if(e.getBlock().getType().equals(Material.OAK_WALL_SIGN)){
            Main.getInstance().signShopManager.supSign(e.getPlayer().getUniqueId(),(double) e.getBlock().getLocation().getBlockX(), (double) e.getBlock().getLocation().getBlockY(), (double) e.getBlock().getLocation().getBlockZ());
        }
    }


}