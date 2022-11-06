package fr.Townland.Main.Teleportation.Test;

import fr.Townland.Main.Main;
import fr.Townland.Main.Teleportation.components.Region;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ClaimManager implements Listener {
    /*
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        new GamePlayer(event.getPlayer().getName());
    }

    @EventHandler
    public void onPlacedBlock(BlockPlaceEvent e){
        Player player = e.getPlayer();
        for(int x = 0; x < Main.getInstance().regions.size(); x++) {
            if (Main.getInstance().regions.get(x).isInArea(e.getBlock().getLocation()))
                player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBlockBroken(BlockBreakEvent e){
        Player player = e.getPlayer();
        for(int x = 0; x < Main.getInstance().regions.size(); x++) {
            if (Main.getInstance().regions.get(x).isInArea(e.getBlock().getLocation()))
                player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            for(int x = 0; x < Main.getInstance().regions.size(); x++){
                if(Main.getInstance().regions.get(x).isInArea(event.getClickedBlock().getLocation()))
                    event.setCancelled(true);
                    player.sendMessage("§Vous ne pouvez pas faire ça dans le spawn");
                if(player.getItemInHand().getType() == Material.WATER_BUCKET || player.getItemInHand().getType() == Material.LAVA_BUCKET){
                    event.setCancelled(true);
                    player.sendMessage("§Vous ne pouvez pas faire ça dans le spawn");
                }
            }
        }

        if(event.getAction() == Action.LEFT_CLICK_BLOCK){

            if(player.getItemInHand().getType() == Material.DIAMOND_HOE){
                event.setCancelled(true);
                GamePlayer gp = GamePlayer.gamePlayers.get(player.getName());
                if(gp.getPos1() == null){
                    gp.setPos1(event.getClickedBlock().getLocation());
                    player.sendMessage("§Postion 1 défini !");

                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            gp.setPos1(null);
                            gp.setPos2(null);
                        }
                    },20*60);
                    return;
                }
                RegionManager region = new RegionManager(gp.getPos1(),gp.getPos2(),player.getName());

                String[] loc = new String[]{""+ gp.getPos1().getX(), "" + gp.getPos1().getY(),"" + gp.getPos1().getZ(),"" + gp.getPos2().getX(),"" + gp.getPos2().getY(),"" + gp.getPos2().getZ(),player.getLocation().getWorld().getName(),player.getName()};
                Main.getInstance().getConfig().set(player.getUniqueId().toString(),loc);
                Main.getInstance().config.save();
                Main.getInstance().regions.add(region);
                player.sendMessage("§aPosition 2 défini");
                player.sendMessage("§eSpawn défini");
                gp.setPos1(null);
                gp.setPos2(null);
            }
        }
    }
     */
}









































