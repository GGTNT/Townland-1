package fr.Townland.Main.Teleportation.components;

import org.bukkit.Location;
public class Bound {
    private Location min;
    private Location max;

    public Bound() {
    }

    public Bound(Location min, Location max) {
        this.min = min;
        this.max = max;
    }

    public boolean isComplete() {
        return this.min != null && this.max != null;
    }

    public boolean isWithinBounds(Location location) {
        int minX = this.min.getBlockX();
        int minY = this.min.getBlockY();
        int minZ = this.min.getBlockZ();
        int maxX = this.max.getBlockX() + 1;
        int maxY = this.max.getBlockY() + 1;
        int maxZ = this.max.getBlockZ() + 1;
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        return x >= (double)minX && x <= (double)maxX && y >= (double)minY && y <= (double)maxY && z >= (double)minZ && z <= (double)maxZ;
    }

    public void assignCorrectBounds() {
        int minX = this.min.getBlockX();
        int minY = this.min.getBlockY();
        int minZ = this.min.getBlockZ();
        int maxX = this.max.getBlockX();
        int maxY = this.max.getBlockY();
        int maxZ = this.max.getBlockZ();
        int tempZ;
        if (minX > maxX) {
            tempZ = minX;
            minX = maxX;
            maxX = tempZ;
        }

        if (minY > maxY) {
            tempZ = minY;
            minY = maxY;
            maxY = tempZ;
        }

        if (minZ > maxZ) {
            tempZ = minZ;
            minZ = maxZ;
            maxZ = tempZ;
        }

        this.min = new Location(this.min.getWorld(), (double)minX, (double)minY, (double)minZ);
        this.max = new Location(this.max.getWorld(), (double)maxX, (double)maxY, (double)maxZ);
    }

    public Location getMin() {
        return this.min;
    }

    public void setMin(Location min) {
        this.min = min;
    }

    public Location getMax() {
        return this.max;
    }

    public void setMax(Location max) {
        this.max = max;
    }

}
