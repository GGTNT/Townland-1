package fr.Townland.Main.Teleportation.listeners;

import fr.Townland.Main.Main;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final Main main;

    public SpawnListeners(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        //When a player joins for the first time, teleport them to the spawn if it is set
        if(!e.getPlayer().hasPlayedBefore()){
            Location location = main.getConfig().getLocation("spawn");
            if(location != null){
                //spawn them
                e.getPlayer().teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e){
        //When the player dies, respawn them at the spawn location if set
        Location location = main.getConfig().getLocation("spawn");
        if(location != null){
            //spawn them
            e.setRespawnLocation(location);
        }
    }

}