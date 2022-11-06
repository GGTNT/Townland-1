package fr.Townland.Main.Economie.listeners.player;

import fr.Townland.Main.Main;
import fr.Townland.Main.Economie.DataEconomie.PlayerInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Main.INSTANCE.database.createAccount(player.getUniqueId());

        new PlayerInfo(player);
    }
}
