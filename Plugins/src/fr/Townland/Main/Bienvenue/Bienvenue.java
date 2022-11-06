package fr.Townland.Main.Bienvenue;

import com.google.common.collect.Maps;
import fr.Townland.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Map;

public class Bienvenue implements Listener {

    private int Co = 0;
    private Stuff stuff;
    private RequestBvn requestBvn;
    private static final Map<Integer, Integer> bvn = Maps.newHashMap();

    public Bienvenue(){
        requestBvn = new RequestBvn(Main.getInstance());
        stuff = new Stuff();
    }

    @EventHandler
    public void Connection(PlayerJoinEvent event) {

        //message du join
        Co++;
        Player player = (Player) event.getPlayer();
        event.setJoinMessage(ChatColor.GRAY + "--> " + player.getName() + " a rejoint le serveur " + "[" + Co + "] !");

        //message de bienvenue
        if(!event.getPlayer().hasPlayedBefore()) {

            bvn.put(1, bvn.get(1) + 1);
            stuff.setStuff(event.getPlayer());
            player.sendTitle("§2Bienvenue Sur Townland !", "", 10, 70, 20);

            for (Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(ChatColor.AQUA + "=========================");
                players.sendMessage(ChatColor.YELLOW + "Bienvenue à " + event.getPlayer().getName() + " sur Townland !");
                players.sendMessage(ChatColor.YELLOW + "Le " + bvn.get(1) + "ème Joueur !");
                players.sendMessage(ChatColor.AQUA + "=========================");
            }
        }
    }

    @EventHandler
    public void deConnection(PlayerQuitEvent e){
        //message du quitte
        Co--;
        Player player = (Player) e.getPlayer();
        e.setQuitMessage(ChatColor.GRAY + "--> " + player.getName() + " a quitté le serveur " + "[" + Co + "] !");
    }

    public void setBVN() {
        bvn.put(1,requestBvn.getBienvenue());
    }

    public int getBVN() {
        return bvn.get(1);
    }

    public void saveBVN(){
        //sauvegarder les bienvenues
        requestBvn.setBienvenue(bvn.get(1));
    }

}
