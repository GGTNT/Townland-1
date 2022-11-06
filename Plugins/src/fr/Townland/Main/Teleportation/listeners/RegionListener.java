package fr.Townland.Main.Teleportation.listeners;

import fr.Townland.Main.Main;
import fr.Townland.Main.Teleportation.components.Bound;
import fr.Townland.Main.Teleportation.components.Region;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import static fr.Townland.Main.Teleportation.ui.Utils.msgPlayer;

public class RegionListener implements Listener {


    private Map<String, Region> regions;
    private Map<UUID, Bound> regionSetup;
    private Map<UUID,Region> playerRegion = new HashMap<>();

    public RegionListener(Main main) {
        regions = main.getRegionManager().getRegions();
        regionSetup = main.regionCmd.getRegionSetup();
        new BukkitRunnable(){
            @Override
            public void run() {
                for (UUID uuid : regionSetup.keySet()) {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player == null) continue;
                    Bound bound = regionSetup.get(uuid);
                    if (!bound.isComplete()) continue;
                    Bound newBound = new Bound(bound.getMin(), bound.getMax());
                    newBound.assignCorrectBounds();
                    Location min = newBound.getMin(), max = newBound.getMax();
                    for (int x = min.getBlockX(); x <= max.getBlockX() + 1; x++) {
                        for (int y = min.getBlockY(); y <= max.getBlockY() + 1; y++) {
                            for (int z = min.getBlockZ(); z <= max.getBlockZ() + 1; z++) {
                                if(x == min.getBlockX() || x == max.getBlockX() + 1 || y == min.getBlockY() || y == max.getBlockY() + 1 || z == min.getBlockZ() || z == max.getBlockZ() + 1) player.spawnParticle(Particle.VILLAGER_HAPPY,x,y,z,1);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(main,0L,5L);
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(!regionSetup.containsKey(player.getUniqueId()))return;
        Bound bound = regionSetup.get(player.getUniqueId());
        Block block = event.getClickedBlock();
        if(block == null)return;
        switch (event.getAction()){
            case LEFT_CLICK_BLOCK:
                event.setCancelled(true);
                bound.setMin(block.getLocation());
                msgPlayer(player,"&aLocation 1 défini !");
                break;
            case RIGHT_CLICK_BLOCK:
                event.setCancelled(true);
                bound.setMax(block.getLocation());
                msgPlayer(player,"&aLocation 2 défini !");
                break;
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Region current = playerRegion.get(player.getUniqueId()),active = null;
        for(Region region : regions.values()){
            if(!region.getBound().isWithinBounds(player.getLocation()))continue;
            active = region;
            if(current == region)continue;
            player.sendMessage("§cVous entrez dans le spawn.");
        }


        this.playerRegion.put(player.getUniqueId(), active);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            Region region = (Region) this.playerRegion.get(player.getUniqueId());
            if (region != null && region.isSafezone()) {
                event.setCancelled(true);
            }

        }
    }
    @EventHandler
    public void onBukket(PlayerBucketEmptyEvent e){
        Player player = e.getPlayer();
        Material bucket = e.getBucket();
        Region region = (Region) this.playerRegion.get(player.getUniqueId());
        if (region != null && region.isSafezone()) {


            if (bucket.toString().contains("LAVA")) {
                player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
                e.setCancelled(true);
            }

            if (bucket.toString().contains("WATER")) {
                player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
                e.setCancelled(true);
            }
            }

        }
    @EventHandler
    public void onBlockBroken(BlockBreakEvent e){
       Player player = e.getPlayer();
       Region region = (Region) this.playerRegion.get(player.getUniqueId());
       if (region != null && region.isSafezone()) {
           player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
            e.setCancelled(true);
       }
    }
    @EventHandler
    public void onPlacedBlock(BlockPlaceEvent e){
        Player player = e.getPlayer();
        Region region = (Region) this.playerRegion.get(player.getUniqueId());
        if (region != null && region.isSafezone()) {
            player.sendMessage("§cVous ne pouvez pas faire ça dans le spawn.");
            e.setCancelled(true);
        }
    }
}
