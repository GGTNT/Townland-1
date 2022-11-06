package fr.Townland.Main.Teleportation.managers;

import fr.Townland.Main.Main;
import fr.Townland.Main.Teleportation.components.Bound;
import fr.Townland.Main.Teleportation.components.Region;
import fr.Townland.Main.Teleportation.ui.Utils;

import java.util.HashMap;
import java.util.Map;

import static fr.Townland.Main.Teleportation.ui.Utils.decolor;

public class RegionManager {

    private Map<String, Region> regions = new HashMap();

    public RegionManager() {
    }
    public void createNewRegion(String name, String description, boolean safezone, Bound bound) {
        Region region = new Region(name, description, bound, safezone);
        this.regions.put(Utils.decolor(name).toLowerCase(), region);
        Main.getInstance().spawnManager.insert_regions(decolor(name).toLowerCase(), String.valueOf(region));

    }
    public Map<String, Region> getRegions() {
        return this.regions;
    }
}
