package fr.Townland.Main.Teleportation.ui;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Utils {
    public Utils() {
    }

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String decolor(String string) {
        return ChatColor.stripColor(color(string));
    }

    public static void msgPlayer(Player player, String... strings) {
        String[] var2 = strings;
        int var3 = strings.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String string = var2[var4];
            player.sendMessage(color(string));
        }

    }
}