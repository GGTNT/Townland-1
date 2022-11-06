package fr.Townland.Main.Works.Pecheur;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.Map;

public class HashMapPecheur {

    private static final Map<String, Integer> xppecheur = Maps.newHashMap();
    private static final Map<String, Boolean> workpecheur = Maps.newHashMap();

    public static Map<String, Boolean> getWorkpecheur() {
        return workpecheur;
    }

    public static Map<String, Integer> getXppecheur() {
        return xppecheur;
    }

    public boolean getWorkpecheur(Player player) {
        return workpecheur.get(player.getUniqueId().toString());
    }

    public Integer getXpPecheur(Player player) {
        return xppecheur.get(player.getUniqueId().toString());
    }

    public void setXppecheur(Player player, Integer xp){
        xppecheur.replace(player.getUniqueId().toString(), xp);
    }

    public void setupXppecheur(Player player, Integer xp){
        xppecheur.put(player.getUniqueId().toString(), xp);
    }

    public void setWorkpecheur(Player player, Boolean work){
        workpecheur.replace(player.getUniqueId().toString(), work);
    }
    public void setupWorkpecheur(Player player, Boolean work){
        workpecheur.put(player.getUniqueId().toString(), work);
    }
    public void addXppecheur(Player player, Integer xp){
        xppecheur.replace(player.getUniqueId().toString(), xppecheur.get(player.getUniqueId().toString()) + xp);
    }

}
