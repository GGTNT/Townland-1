package fr.Townland.Main.TabList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CustomTabList implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        player.setPlayerListHeader(ChatColor.GRAY + "*━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━*" + ChatColor.GREEN + "\nTOWNLAND" + ChatColor.GRAY + "\n*━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━*");
        player.setPlayerListFooter(ChatColor.GREEN + "\nSite Web : §ftownland.fr" + ChatColor.BLUE + "\nDiscord : §fdiscord.gg/townland");

    }
}
























