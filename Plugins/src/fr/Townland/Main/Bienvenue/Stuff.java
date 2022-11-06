package fr.Townland.Main.Bienvenue;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Stuff {

    public void setStuff(Player player){
        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack bread = new ItemStack(Material.BREAD, 16);
        ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemStack axe = new ItemStack(Material.STONE_AXE, 1);
        ItemStack shovel = new ItemStack(Material.STONE_SHOVEL, 1);
        ItemStack hoe = new ItemStack(Material.STONE_HOE, 1);
        ItemStack log = new ItemStack(Material.OAK_LOG, 16);
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        player.getInventory().setItem(0, sword);
        player.getInventory().setItem(1, bread);
        player.getInventory().setItem(2, pickaxe);
        player.getInventory().setItem(3, axe);
        player.getInventory().setItem(4, shovel);
        player.getInventory().setItem(5, hoe);
        player.getInventory().setItem(6, log);
        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setBoots(boots);


    }
}
