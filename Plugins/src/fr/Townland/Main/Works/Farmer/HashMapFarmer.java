package fr.Townland.Main.Works.Farmer;

import com.google.common.collect.Maps;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Map;

public class HashMapFarmer {

    private static final Map<String, Integer> xpfarmer = Maps.newHashMap();
    private static final Map<String, Boolean> workfarmer = Maps.newHashMap();
    private final ArrayList<Location> coMelon = new ArrayList<>();
    private final ArrayList<Location> coPumpkin = new ArrayList<>();
    private final ArrayList<Location> coSugarCanne = new ArrayList<>();

    public void addXPFarmer(Player player, Integer xp){
        if (xpfarmer.containsKey(player.getUniqueId().toString())){
            int xps = xpfarmer.get(player.getUniqueId().toString());
            xpfarmer.remove(player.getUniqueId().toString());
            xpfarmer.put(player.getUniqueId().toString(),xp + xps);
            return;
        }
        xpfarmer.put(player.getUniqueId().toString(),xp);
    }

    public Map<String, Integer> getXpfarmer() {
        return xpfarmer;
    }

    public Integer getXPFarmer(Player player){
        return xpfarmer.get(player.getUniqueId().toString());
    }

    public void removeXP(Integer xp, Player player){
        int xps = xpfarmer.get(player.getUniqueId().toString());
        xpfarmer.remove(player);
        xpfarmer.put(player.getUniqueId().toString(), xps - xp);
    }

    public void removeWorkFarmer(Player player){
        workfarmer.remove(player.getUniqueId().toString());
    }

    public void addWorkFarmer(Player player, Boolean bool){
        workfarmer.put(player.getUniqueId().toString(), bool);
    }

    public Boolean getWork(Player player){
        return workfarmer.get(player.getUniqueId().toString());
    }

    public ArrayList<Location> getCoMelon() {
        return coMelon;
    }

    public ArrayList<Location> getCoPumpkin() {
        return coPumpkin;
    }

    public ArrayList<Location> getCoSugarCanne() {
        return coSugarCanne;
    }
}
