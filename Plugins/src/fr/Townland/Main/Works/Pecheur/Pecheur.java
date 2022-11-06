package fr.Townland.Main.Works.Pecheur;

import fr.Townland.Main.Economie.DataEconomie.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Pecheur {

    private final HashMapPecheur hashMapPecheur;
    private final RequestPecheur requestPecheur;

    public Pecheur(HashMapPecheur hashMapPecheur, RequestPecheur requestPecheur) {
        this.hashMapPecheur = hashMapPecheur;
        this.requestPecheur = requestPecheur;
    }

    //message et récompenses du level up
    public void messageLevelUp(Player player, int xpwin){
        int xpavant = hashMapPecheur.getXpPecheur(player);
        int xpapres = xpavant + xpwin;
        PlayerInfo targetInfo = new PlayerInfo(player);

            ItemStack canne1 = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta canne1M = canne1.getItemMeta();
            canne1M.setDisplayName("§dCanne des Abîmes");
            canne1M.setLore(Arrays.asList("canne à pêche du Pêcheur du niveau 5"));
            canne1M.addEnchant(Enchantment.DURABILITY, 1, true);
            canne1M.addEnchant(Enchantment.LURE, 1, true);
            canne1.setItemMeta(canne1M);

            ItemStack canne2 = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta canne2M = canne2.getItemMeta();
            canne2M.setDisplayName("§dCanne des Syphon");
            canne2M.setLore(Arrays.asList("Canne à pêche du Pêcheur du niveau 10"));
            canne2M.addEnchant(Enchantment.DURABILITY, 2, true);
            canne2M.addEnchant(Enchantment.LURE, 2, true);
            canne2M.addEnchant(Enchantment.LUCK, 1, true);
            canne2.setItemMeta(canne2M);

            ItemStack canne3 = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta canne3M = canne3.getItemMeta();
            canne3M.setDisplayName("§dCanne des océans");
            canne3M.setLore(Arrays.asList("Canne à pêche du Pêcheur du niveau 15"));
            canne3M.addEnchant(Enchantment.DURABILITY, 3, true);
            canne3M.addEnchant(Enchantment.LURE, 3, true);
            canne3M.addEnchant(Enchantment.LUCK, 2, true);
            canne3.setItemMeta(canne3M);

            ItemStack canne4 = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta canne4M = canne4.getItemMeta();
            canne4M.setDisplayName("§dCanne du Déluge");
            canne4M.setLore(Arrays.asList("Canne à pêche du Pêcheur du niveau 20"));
            canne4M.addEnchant(Enchantment.DURABILITY, 4, true);
            canne4M.addEnchant(Enchantment.LURE, 4, true);
            canne4M.addEnchant(Enchantment.LUCK, 3, true);
            canne4.setItemMeta(canne4M);

        //lvl1
        if (xpavant < 10000 && xpapres > 10000) {
            player.sendMessage("§2Bravo tu es passé niveau 1 !!");
            targetInfo.addCoins(1000);
        }
        //lvl2
        if (xpavant < 30000 && xpapres > 30000) {
            player.sendMessage("§2Bravo tu es passé niveau 2 !!");
            targetInfo.addCoins(3000);
        }
        //lvl3
        if (xpavant < 60000 && xpapres > 60000) {
            player.sendMessage("§2Bravo tu es passé niveau 3 !!");
            targetInfo.addCoins(5000);
        }
        //lvl4
        if (xpavant < 100000 && xpapres > 100000) {
            player.sendMessage("§2Bravo tu es passé niveau 4 !!");
            targetInfo.addCoins(8000);
        }
        //lvl5
        if (xpavant < 150000 && xpapres > 150000) {
            player.sendMessage("§2Bravo tu es passé niveau 5 !!");
            targetInfo.addCoins(12000);
            player.getInventory().addItem(canne1);
        }
        //lvl6
        if (xpavant < 220000 && xpapres > 220000) {
            player.sendMessage("§2Bravo tu es passé niveau 6 !!");
            targetInfo.addCoins(16000);
        }
        //lvl7
        if (xpavant < 300000 && xpapres > 300000) {
            player.sendMessage("§2Bravo tu es passé niveau 7 !!");
            targetInfo.addCoins(20000);
        }
        //lvl8
        if (xpavant < 400000 && xpapres > 400000) {
            player.sendMessage("§2Bravo tu es passé niveau 8 !!");
            targetInfo.addCoins(25000);
        }
        //lvl9
        if (xpavant < 550000 && xpapres > 550000) {
            player.sendMessage("§2Bravo tu es passé niveau 9 !!");
            targetInfo.addCoins(30000);
        }
        //lvl10
        if (xpavant < 720000 && xpapres > 720000) {
            player.sendMessage("§2Bravo tu es passé niveau 10 !!");
            targetInfo.addCoins(35000);
            player.getInventory().addItem(canne2);
        }
        //lvl11
        if (xpavant < 900000 && xpapres > 900000) {
            player.sendMessage("§2Bravo tu es passé niveau 11 !!");
            targetInfo.addCoins(41000);
        }
        //lvl12
        if (xpavant < 1100000 && xpapres > 1100000) {
            player.sendMessage("§2Bravo tu es passé niveau 12 !!");
            targetInfo.addCoins(47000);
        }
        //lvl13
        if (xpavant < 1350000 && xpapres > 1350000) {
            player.sendMessage("§2Bravo tu es passé niveau 13 !!");
            targetInfo.addCoins(53000);
        }
        //lvl14
        if (xpavant < 1600000 && xpapres > 1600000) {
            player.sendMessage("§2Bravo tu es passé niveau 14 !!");
            targetInfo.addCoins(60000);
        }
        //lvl15
        if (xpavant < 1850000 && xpapres > 1850000) {
            player.sendMessage("§2Bravo tu es passé niveau 15 !!");
            targetInfo.addCoins(65000);
            player.getInventory().addItem(canne3);
        }
        //lvl16
        if (xpavant < 2100000 && xpapres > 2100000) {
            player.sendMessage("§2Bravo tu es passé niveau 16 !!");
            targetInfo.addCoins(72000);
        }
        //lvl16
        if (xpavant < 2400000 && xpapres > 2400000) {
            player.sendMessage("§2Bravo tu es passé niveau 17 !!");
            targetInfo.addCoins(78000);
        }
        //lvl18
        if (xpavant < 2700000 && xpapres > 2700000) {
            player.sendMessage("§2Bravo tu es passé niveau 18 !!");
            targetInfo.addCoins(86000);
        }
        //lvl19
        if (xpavant < 3000000 && xpapres > 3000000) {
            player.sendMessage("§2Bravo tu es passé niveau 19 !!");
            targetInfo.addCoins(92000);
        }
        //lvl20
        if (xpavant < 3500000 && xpapres > 3500000) {
            player.sendMessage("§2Bravo tu es passé niveau 20 !!");
            targetInfo.addCoins(100000);
            player.getInventory().addItem(canne4);
        }
        }

        public void SavePecheurXP(){

        for (Player player : Bukkit.getOnlinePlayers()){
            requestPecheur.setWorkPecheur(player, hashMapPecheur.getWorkpecheur(player));
            }
        }

        public void SavePecheurWork(){

            for (Player player : Bukkit.getOnlinePlayers()) {
                requestPecheur.setXPPecheur(player, hashMapPecheur.getXpPecheur(player));
            }
        }

        public void setupPecheur(){

            for (Player player : Bukkit.getOnlinePlayers()) {
                hashMapPecheur.setupWorkpecheur(player, requestPecheur.getWorkPecheur(player));
                hashMapPecheur.setXppecheur(player, requestPecheur.getXPPecheur(player));
            }
        }
    }