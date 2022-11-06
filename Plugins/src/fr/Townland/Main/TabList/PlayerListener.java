package fr.Townland.Main.TabList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final Rank rank;

    public PlayerListener(Rank rank) {
        this.rank = rank;
    }

    @EventHandler
    private void PlayerJoin(PlayerJoinEvent e){
        //charger le grade
        rank.loadPlayer(e.getPlayer());
        e.getPlayer().setScoreboard(rank.getScoreboard());
    }

    @EventHandler
    private void PlayerQuit(PlayerQuitEvent e){
        //decharger le grade
        rank.deletePlayer(e.getPlayer());
    }

    @EventHandler
    private void PlayerChat(AsyncPlayerChatEvent e){
        RankList rankList = rank.getPlayerRank(e.getPlayer());
        //prefix affiché dans le chat que si ce n'est pas un joueur
        if(rankList.getPrefix() == "§8[Fer] " ||rankList.getPrefix() == "§e[OR] " ||rankList.getPrefix() == "§b[Diamant] " ||rankList.getPrefix() == "§a[MODOTEST] " ||rankList.getPrefix() == "§a[MODO] " ||rankList.getPrefix() == "§2[SUPERMODO] " ||rankList.getPrefix() == "§4[ADMIN] " ||rankList.getPrefix() == "§1[Fondateur] "){
            e.setFormat(rankList.getPrefix() + e.getPlayer().getName() + rankList.space + e.getMessage());
        }
    }
}
