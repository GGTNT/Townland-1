package fr.Townland.Main.Teleportation.components;

import fr.Townland.Main.Teleportation.ui.Utils;

public class Region {
    private String name;
    private String description;
    private String rawName;
    private Bound bound;
    private boolean safezone;

    public Region(String name, String description, Bound bound, boolean safezone) {
        this.name = name;
        this.description = description;
        this.rawName = Utils.decolor(name);
        this.bound = bound;
        this.safezone = safezone;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRawName() {
        return this.rawName;
    }

    public Bound getBound() {
        return this.bound;
    }

    public boolean isSafezone() {
        return this.safezone;
    }
}
