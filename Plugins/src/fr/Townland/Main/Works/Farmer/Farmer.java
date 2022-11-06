package fr.Townland.Main.Works.Farmer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
public class Farmer {

    private final HashMapFarmer hashMapFarmer;
    private final RequestFarmer requestFarmer;

    public Farmer(HashMapFarmer hashMapFarmer, RequestFarmer requestFarmer){
       this.hashMapFarmer = hashMapFarmer;
        this.requestFarmer = requestFarmer;
    }

    //message et récompenses du level up
    public void messageLevelUp(Player player, int xp, String msg, Boolean itemRecompense){
        int xp1 = hashMapFarmer.getXPFarmer(player);
        if (xp1 >= xp){
            player.sendMessage(msg);

            ItemStack oue1 = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta oue1M = oue1.getItemMeta();
            oue1M.setDisplayName("§dHoue Du Laboure");
            oue1M.setLore(Arrays.asList("Houe du Farmer du niveau 5"));
            oue1M.addEnchant(Enchantment.DURABILITY, 1, true);
            oue1.setItemMeta(oue1M);

            ItemStack oue2 = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta oue2M = oue2.getItemMeta();
            oue2M.setDisplayName("§dHoue De La Récolte");
            oue2M.setLore(Arrays.asList("Houe du Farmer du niveau 10"));
            oue2M.addEnchant(Enchantment.DURABILITY, 3, true);
            oue2M.addEnchant(Enchantment.DIG_SPEED, 3, true);
            oue2.setItemMeta(oue2M);

            ItemStack oue3 = new ItemStack(Material.NETHERITE_HOE, 1);
            ItemMeta oue3M = oue3.getItemMeta();
            oue3M.setDisplayName("§dHoue De La Fertilité");
            oue3M.setLore(Arrays.asList("Houe du Farmer du niveau 15"));
            oue3M.addEnchant(Enchantment.DURABILITY, 3, true);
            oue3M.addEnchant(Enchantment.DIG_SPEED, 4, true);
            oue3.setItemMeta(oue3M);

            ItemStack oue4 = new ItemStack(Material.NETHERITE_HOE, 1);
            ItemMeta oue4M = oue4.getItemMeta();
            oue4M.setDisplayName("§dHoue De La Providence");
            oue4M.setLore(Arrays.asList("Houe du Farmer du niveau 20"));
            oue4M.addEnchant(Enchantment.DURABILITY, 4, true);
            oue4M.addEnchant(Enchantment.DIG_SPEED, 5, true);
            oue4M.addEnchant(Enchantment.MENDING, 1, true);
            oue4.setItemMeta(oue4M);

            if (itemRecompense){
                if (xp >= 150000){
                    if (xp <= 160000 ){
                        player.getInventory().addItem(oue1);
                    }
                       if (xp >= 720000){
                           if (xp <= 730000){
                               player.getInventory().addItem(oue2);
                           }
                           if (xp >= 1850000){
                               if (xp <= 1860000){
                                   player.getInventory().addItem(oue3);
                               }
                               if (xp >= 3500000){
                                       player.getInventory().addItem(oue4);
                                       Bukkit.broadcastMessage("§5Félicitation à " + player.getName() + " qui a le métier de farmer niveau 20 !!");
                               }
                           }
                       }
                }
            }
        }
    }

    public boolean isFullyGrown(Block block){
        return block.getData() == 7;
    }

    public int getAmountCraftItem(Material m, CraftItemEvent e){
        if(!e.getRecipe().getResult().getType().equals(m)) return 0;
        int amount = e.getRecipe().getResult().getAmount();
        if (e.isShiftClick()) {
            int max = e.getInventory().getMaxStackSize();
            org.bukkit.inventory.ItemStack[] matrix = e.getInventory().getMatrix();
            for (org.bukkit.inventory.ItemStack is: matrix) {
                if (is == null || is.getType().equals(Material.AIR))
                    continue;
                int tmp = is.getAmount();
                if (tmp < max && tmp > 0) max = tmp;
            }
            amount *= max;
        }
        return amount;
    }

    public void setupFarmerCo(){

        //ajouter dans la list les co melons de la bdd
        int countMelon = requestFarmer.countMelonLoc();
        int xMelon = 0;
        countMelon--;
        if (countMelon != 0){
            while (xMelon <= countMelon){
                requestFarmer.locationMelon(xMelon);
                int mx = requestFarmer.getMelonX();
                int my = requestFarmer.getMelonY();
                int mz = requestFarmer.getMelonZ();
                String mw = requestFarmer.getMelonWorld();
                Location location = new Location(Bukkit.getWorld(mw), mx, my, mz);
                hashMapFarmer.getCoMelon().add(location);
                xMelon++;
            }
        }

        //ajouter dans la list les co Pumpkin de la bdd
        int countPumpkin = requestFarmer.countPumpkinLoc();
        int xPumpkin = 0;
        countPumpkin--;
        if (countPumpkin != 0){
            while (xPumpkin <= countPumpkin){
                requestFarmer.locationPumpkin(xPumpkin);
                int mx = requestFarmer.getPumpkinX();
                int my = requestFarmer.getPumpkinY();
                int mz = requestFarmer.getPumpkinZ();
                String mw = requestFarmer.getPumpkinWorld();
                Location location = new Location(Bukkit.getWorld(mw), mx, my, mz);
                hashMapFarmer.getCoPumpkin().add(location);
                xPumpkin++;
            }
        }

        //ajouter dans la list les co sugarCanne de la bdd
        int countSugar = requestFarmer.countSugarCanneLoc();
        int xSugar = 0;
        countPumpkin--;
        if (countSugar != 0){
            while (xSugar <= countSugar){
                requestFarmer.locationSugarCanne(xSugar);
                int mx = requestFarmer.getSugarCanneX();
                int my = requestFarmer.getSugarCanneY();
                int mz = requestFarmer.getSugarCanneZ();
                String mw = requestFarmer.getSugarCanneWorld();
                Location location = new Location(Bukkit.getWorld(mw), mx, my, mz);
                hashMapFarmer.getCoSugarCanne().add(location);
                xSugar++;
            }
        }
    }

    public void setupFarmerXP(){

        for (Player player : Bukkit.getOnlinePlayers()){
            hashMapFarmer.addWorkFarmer(player, requestFarmer.getWork("farmer", player.getUniqueId()));
            hashMapFarmer.addXPFarmer(player, requestFarmer.getXP("farmer", player));
        }
    }

    public void saveFarmerCo(){

        //enregistrer dans la bdd les co des Melons
        requestFarmer.removeMelon();
        if (!hashMapFarmer.getCoMelon().isEmpty()){
            int sizeMelon = hashMapFarmer.getCoMelon().size();
            int sm = 0;
            sizeMelon--;
            while (sm <= sizeMelon){
                requestFarmer.setupMelon(hashMapFarmer.getCoMelon().get(sm), sm);
                sm++;
            }
        }

        //enregistrer dans la bdd les co des Pumpkins
        requestFarmer.removePumpkin();
        if (!hashMapFarmer.getCoPumpkin().isEmpty()){
            int sizePumpkin = hashMapFarmer.getCoPumpkin().size();
            int sp = 0;
            sizePumpkin--;
            while (sp <= sizePumpkin){
                requestFarmer.setupPumpkin(hashMapFarmer.getCoPumpkin().get(sp), sp);
                sp++;
            }
        }

        //enregistrer dans la bdd les co des SugarCannes
        requestFarmer.removeSugarCanne();
        if (!hashMapFarmer.getCoSugarCanne().isEmpty()){
            int sizeSugarCanne = hashMapFarmer.getCoSugarCanne().size();
            int ss = 0;
            sizeSugarCanne--;
            while (ss <= sizeSugarCanne){
                requestFarmer.setupSugarCanne(hashMapFarmer.getCoSugarCanne().get(ss), ss);
                ss++;
            }
        }
    }

    public void saveFarmerXP(){

        for (Player player : Bukkit.getOnlinePlayers()){
            if (hashMapFarmer.getXpfarmer().containsKey(player.getUniqueId().toString())){
                requestFarmer.changeXP("farmer", player, hashMapFarmer.getXpfarmer().get(player.getUniqueId().toString()));
                hashMapFarmer.getXpfarmer().remove(player.getUniqueId().toString());
            }
        }
    }
}