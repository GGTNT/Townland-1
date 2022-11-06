package fr.Townland.Main.Moderation.command.vanish.events;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    private Main main;
    private Rank rank;
    public JoinEvent(Main main,Rank rank) {
        this.main = main;
        this.rank = rank;
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        for(int i = 0; i < main.invisible_list.size(); i++){
            if (rank.hasPowerSup((Player) player, 5)) {
                player.showPlayer(main,main.invisible_list.get(i));
            }
            else {
                player.hidePlayer(main, main.invisible_list.get(i));
            }
        }
    }
}


















