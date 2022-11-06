package fr.Townland.Main.Works.Farmer;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

public class FarmerListener implements Listener {

    private final Farmer farmer;
    private final RequestFarmer requestFarmer;
    private final Rank rank;
    private final HashMapFarmer hashMapFarmer;

    public FarmerListener(RequestFarmer requestFarmer, Rank rank, HashMapFarmer hashMapFarmer, Farmer farmer){
        this.requestFarmer = requestFarmer;
        this.rank = rank;
        this.farmer = farmer;
        this.hashMapFarmer = hashMapFarmer;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        hashMapFarmer.setupWorkFarmer(event.getPlayer(), requestFarmer.getWorkFarmer(event.getPlayer().getUniqueId()));
        hashMapFarmer.addXPFarmer(event.getPlayer(), requestFarmer.getXPFarmer(event.getPlayer()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
            requestFarmer.SetXPFarmer(event.getPlayer(), hashMapFarmer.getXpfarmer().get(event.getPlayer().getUniqueId().toString()));
            requestFarmer.SetWorkFarmer(hashMapFarmer.getWorkFarmer(event.getPlayer()),event.getPlayer());
            hashMapFarmer.getXpfarmer().remove(event.getPlayer().getUniqueId().toString());
            hashMapFarmer.removeWorkFarmer(event.getPlayer());
    }

    @EventHandler
    public void onKick(PlayerKickEvent event){
        if (hashMapFarmer.getXpfarmer().containsKey(event.getPlayer().getUniqueId().toString())){
            requestFarmer.SetXPFarmer(event.getPlayer(), hashMapFarmer.getXpfarmer().get(event.getPlayer().getUniqueId().toString()));
            hashMapFarmer.getXpfarmer().remove(event.getPlayer().getUniqueId().toString());
        }
        hashMapFarmer.removeWorkFarmer(event.getPlayer());
    }

    //enregistrement des co des citrouilles et melon (pas de dupli xp) + desactivation canne asucre et cacao pour non farmer
    @EventHandler
    public void onPlayerPosBlock(BlockPlaceEvent event){

        if (event.getBlock().getType() == Material.SUGAR_CANE || event.getBlock().getType() == Material.COCOA_BEANS){
            if (!hashMapFarmer.getWorkFarmer(event.getPlayer())){
                if (!rank.hasPowerSup(event.getPlayer(), 7)){
                    event.setCancelled(true);
                }else {
                    if (event.getBlock().getType().equals(Material.SUGAR_CANE)){
                        hashMapFarmer.getCoSugarCanne().add(event.getBlock().getLocation());
                    }
                }
            }else {
                if (event.getBlock().getType().equals(Material.SUGAR_CANE)){
                    hashMapFarmer.getCoSugarCanne().add(event.getBlock().getLocation());
                }
            }
        }
        if (event.getBlock().getType().equals(Material.PUMPKIN)){
            hashMapFarmer.getCoPumpkin().add(event.getBlock().getLocation());
        }
        if (event.getBlock().getType().equals(Material.MELON)){
            hashMapFarmer.getCoMelon().add(event.getBlock().getLocation());
        }

    }

    //désactivation de la plante et labourage
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getClickedBlock() == null){
            return;
        }

        if (event.getPlayer().getItemInHand().getType() == Material.WOODEN_HOE || event.getPlayer().getItemInHand().getType() == Material.IRON_HOE || event.getPlayer().getItemInHand().getType() == Material.GOLDEN_HOE || event.getPlayer().getItemInHand().getType() == Material.DIAMOND_HOE || event.getPlayer().getItemInHand().getType() == Material.NETHERITE_HOE || event.getPlayer().getItemInHand().getType() == Material.WHEAT_SEEDS || event.getPlayer().getItemInHand().getType() == Material.BEETROOT_SEEDS || event.getPlayer().getItemInHand().getType() == Material.MELON_SEEDS || event.getPlayer().getItemInHand().getType() == Material.PUMPKIN_SEEDS) {

            if (!rank.hasPowerInf(event.getPlayer(), 6)) {
                return;
            }
            if (hashMapFarmer.getWorkFarmer(event.getPlayer())) {
                return;
            }
            if (!hashMapFarmer.getWorkFarmer(event.getPlayer()) || rank.hasPowerInf(event.getPlayer(), 6)) {
                Action action = event.getAction();

                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() ==  Material.WOODEN_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() ==  Material.STONE_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.DIAMOND_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.IRON_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.GOLDEN_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.NETHERITE_HOE && event.getClickedBlock().getType().equals(Material.DIRT)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.DIAMOND_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.STONE_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.IRON_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() ==  Material.GOLDEN_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.WOODEN_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.NETHERITE_HOE && event.getClickedBlock().getType().equals(Material.GRASS_BLOCK)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.WHEAT_SEEDS && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.BEETROOT_SEEDS && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.MELON_SEEDS && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.PUMPKIN_SEEDS && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() ==  Material.CARROT && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
                if (action == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.POTATO && event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerBreakBLock(BlockBreakEvent event) {

        //supression dans la bdd les blocks cultures meme si pas farmeur
        if (!hashMapFarmer.getWorkFarmer(event.getPlayer())) {
            RemoveCoMelon(event);
            RemoveCoPumpkin(event);
            RemoveCoSugar(event);
        }

        if (event.getBlock().getType() == Material.WHEAT || event.getBlock().getType() == Material.CARROTS || event.getBlock().getType() == Material.POTATOES || event.getBlock().getType() == Material.BEETROOTS || event.getBlock().getType() == Material.PUMPKIN || event.getBlock().getType() == Material.MELON || event.getBlock().getType() == Material.SUGAR_CANE || event.getBlock().getType() == Material.COCOA) {

            if (hashMapFarmer.getWorkFarmer(event.getPlayer())) {
                Player player = event.getPlayer();
                int XP = hashMapFarmer.getXPFarmer(player);
                //lvl1
                if (XP < 10000) {

                    RemoveCoMelon(event);
                    RemoveCoPumpkin(event);
                    RemoveCoSugar(event);

                    if (event.getBlock().getType() == Material.WHEAT) {
                        if (farmer.isFullyGrown(event.getBlock())) {
                            hashMapFarmer.addXPFarmer(player, 10);
                            player.sendMessage("§a+10xp ");
                            farmer.messageLevelUp(event.getPlayer(), 10000, "§2Bravo tu es passé niveau 1 !!", false);
                            return;
                        }
                    }
                }
                //lvl2
                if (XP >= 10000) {
                    if (XP < 30000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 30000, "§2Bravo tu es passé niveau 2 !!", false);
                                return;
                            }
                        }
                    }

                    //lvl3
                    if (XP >= 30000) {
                        if (XP < 60000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 60000, "§2Bravo tu es passé niveau 3 !!", false);
                                    return;
                                }
                            }
                        }
                    }

                    //lvl4
                    if (XP >= 60000) {
                        if (XP < 100000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.CARROTS) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 100000, "§2Bravo tu es passé niveau 4 !!", false);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 5);
                                    player.sendMessage("§a+5xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 100000, "§2Bravo tu es passé niveau 4 !!", false);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.POTATOES) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 100000, "§2Bravo tu es passé niveau 4 !!", false);
                                    return;
                                }
                            }
                        }
                    }
                }

                //lvl5
                if (XP >= 100000) {
                    if (XP < 150000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 150000, "§2Bravo tu es passé niveau 5 !!", true);
                                return;
                            }

                        }
                        if (event.getBlock().getType() == Material.POTATOES) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 150000, "§2Bravo tu es passé niveau 5 !!", true);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.CARROTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 150000, "§2Bravo tu es passé niveau 5 !!", true);
                                return;
                            }
                        }
                    }
                }

                //lvl6
                if (XP >= 150000) {
                    if (XP < 220000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 220000, "§2Bravo tu es passé niveau 6 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.POTATOES) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 220000, "§2Bravo tu es passé niveau 6 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.CARROTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 220000, "§2Bravo tu es passé niveau 6 !!", false);
                                return;
                            }
                        }
                    }
                }

                //lvl7
                if (XP >= 220000) {
                    if (XP < 300000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 300000, "§2Bravo tu es passé niveau 7 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.POTATOES) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 5);
                                player.sendMessage("§a+5xp ");
                                farmer.messageLevelUp(event.getPlayer(), 300000, "§2Bravo tu es passé niveau 7 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.CARROTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 5);
                                player.sendMessage("§a+5xp ");
                                farmer.messageLevelUp(event.getPlayer(), 300000, "§2Bravo tu es passé niveau 7 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 15);
                                player.sendMessage("§a+15xp ");
                                farmer.messageLevelUp(event.getPlayer(), 300000, "§2Bravo tu es passé niveau 7 !!", false);
                                return;
                            }
                        }
                    }
                }

                //lvl8
                if (XP >= 300000) {
                    if (XP < 400000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 400000, "§2Bravo tu es passé niveau 8 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 15);
                                player.sendMessage("§a+15xp ");
                                farmer.messageLevelUp(event.getPlayer(), 400000, "§2Bravo tu es passé niveau 8 !!", false);
                                return;
                            }
                        }
                    }
                }

                //lvl9
                if (XP >= 400000) {
                    if (XP < 550000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 550000, "§2Bravo tu es passé niveau 9 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 550000, "§2Bravo tu es passé niveau 9 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.SUGAR_CANE) {
                            if (!hashMapFarmer.getCoSugarCanne().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 550000, "§2Bravo tu es passé niveau 9 !!", false);
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }
                }

                //lvl10
                if (XP >= 550000) {
                    if (XP < 720000) {

                        RemoveCoMelon(event);
                        RemoveCoPumpkin(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 720000, "§2Bravo tu es passé niveau 10 !!", true);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 720000, "§2Bravo tu es passé niveau 10 !!", true);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.SUGAR_CANE) {
                            if (!hashMapFarmer.getCoSugarCanne().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 550000, "§2Bravo tu es passé niveau 10 !!", true);
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }
                }

                //lvl11
                if (XP >= 720000) {
                    if (XP < 900000) {

                        RemoveCoMelon(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 900000, "§2Bravo tu es passé niveau 11 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 5);
                                player.sendMessage("§a+5xp ");
                                farmer.messageLevelUp(event.getPlayer(), 900000, "§2Bravo tu es passé niveau 11 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.PUMPKIN) {
                            if (!hashMapFarmer.getCoPumpkin().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 15);
                                player.sendMessage("§a+15xp ");
                                farmer.messageLevelUp(event.getPlayer(), 900000, "&2Bravo tu es passé niveau 11 !!", false);
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.SUGAR_CANE) {
                            if (!hashMapFarmer.getCoSugarCanne().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 5);
                                player.sendMessage("§a+5xp ");
                                farmer.messageLevelUp(event.getPlayer(), 550000, "§2Bravo tu es passé niveau 11 !!", false);
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }
                }

                //lvl12
                if (XP >= 900000) {
                    if (XP < 1100000) {

                        RemoveCoMelon(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1100000, "§2Bravo tu es passé niveau 12 !!", false);
                                player.sendMessage("ok");
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.PUMPKIN) {
                            if (!hashMapFarmer.getCoPumpkin().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 15);
                                player.sendMessage("§a+15xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1100000, "§2Bravo tu es passé niveau 12 !!", false);
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }
                }

                //lvl13
                if (XP >= 1100000) {
                    if (XP < 1350000) {

                        RemoveCoMelon(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1350000, "§2Bravo tu es passé niveau 13 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.PUMPKIN) {
                            if (!hashMapFarmer.getCoPumpkin().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 10);
                                player.sendMessage("§a+10xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1350000, "§2Bravo tu es passé niveau 13 !!", false);
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            } else {
                                hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }
                }

                //lvl14
                if (XP >= 1350000) {
                    if (XP < 1600000) {

                        RemoveCoPumpkin(event);
                        RemoveCoSugar(event);

                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (farmer.isFullyGrown(event.getBlock())) {
                                hashMapFarmer.addXPFarmer(player, 2);
                                player.sendMessage("§a+2xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1600000, "§2Bravo tu es passé niveau 14 !!", false);
                                return;
                            }
                        }
                        if (event.getBlock().getType() == Material.MELON) {
                            if (!hashMapFarmer.getCoMelon().contains(event.getBlock().getLocation())) {
                                hashMapFarmer.addXPFarmer(player, 15);
                                player.sendMessage("§a+15xp ");
                                farmer.messageLevelUp(event.getPlayer(), 1600000, "§2Bravo tu es passé niveau 14 !!", false);
                                hashMapFarmer.getCoMelon().remove(event.getBlock().getLocation());
                                return;
                            }
                        }
                    }

                    //lv15
                    if (XP >= 1600000) {
                        if (XP < 1850000) {

                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            System.out.println("5");
                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 2);
                                    player.sendMessage("§a+2xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 1850000, "§2Bravo tu es passé niveau 15 !!", true);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.MELON) {
                                if (!hashMapFarmer.getCoMelon().contains(event.getBlock().getLocation())) {
                                    hashMapFarmer.addXPFarmer(player, 15);
                                    player.sendMessage("§a+15xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 1850000, "§2Bravo tu es passé niveau 15 !!", true);
                                    hashMapFarmer.getCoMelon().remove(event.getBlock().getLocation());
                                    return;
                                }
                            }
                        }
                    }

                    //lvl16
                    if (XP >= 1850000) {
                        if (XP < 2100000) {

                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 2);
                                    player.sendMessage("§a+2xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 21000000, "§2Bravo tu es passé niveau 16 !!", false);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.MELON) {
                                if (!hashMapFarmer.getCoMelon().contains(event.getBlock().getLocation())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 21000000, "§2Bravo tu es passé niveau 16 !!", false);
                                    hashMapFarmer.getCoMelon().remove(event.getBlock().getLocation());
                                    return;
                                } else {
                                    hashMapFarmer.getCoMelon().remove(event.getBlock().getLocation());
                                    return;
                                }
                            }
                        }
                    }

                    //lvl17
                    if (XP >= 2100000) {
                        if (XP < 2400000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 2);
                                    player.sendMessage("§a+2xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 24000000, "§2Bravo tu es passé niveau 17 !!", false);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.COCOA) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 15);
                                    player.sendMessage("§a+15xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 24000000, "§2Bravo tu es passé niveau 17 !!", false);
                                    return;
                                }
                            }
                        }
                    }

                    //lvl18
                    if (XP >= 2400000) {
                        if (XP < 2700000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 2);
                                    player.sendMessage("§a+2xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 27000000, "§2Bravo tu es passé niveau 18 !!", false);
                                    return;
                                }
                            }
                            if (event.getBlock().getType() == Material.COCOA) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 15);
                                    player.sendMessage("§a+15xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 27000000, "§2Bravo tu es passé niveau 18 !!", false);
                                    return;
                                }
                            }
                        }
                    }

                    //lvl19
                    if (XP >= 2700000) {
                        if (XP < 3000000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 30000000, "§2Bravo tu es passé niveau 19 !!", false);
                                    return;
                                }
                            }
                        }
                    }

                    //lvl20
                    if (XP >= 3000000) {
                        if (XP < 3500000) {

                            RemoveCoMelon(event);
                            RemoveCoPumpkin(event);
                            RemoveCoSugar(event);

                            if (event.getBlock().getType() == Material.WHEAT) {
                                if (farmer.isFullyGrown(event.getBlock())) {
                                    hashMapFarmer.addXPFarmer(player, 10);
                                    player.sendMessage("§a+10xp ");
                                    farmer.messageLevelUp(event.getPlayer(), 3500000, "§2Bravo tu es passé niveau 20 tu as fini le niveau de farmer Félicitation !!", true);
                                }
                            }
                        }
                    }
                    RemoveCoMelon(event);
                    RemoveCoPumpkin(event);
                    RemoveCoSugar(event);
                }
            }
        }
    }

    @EventHandler
    public void CraftItem(CraftItemEvent event) {

        ItemStack item = event.getRecipe().getResult();
        HumanEntity human = event.getView().getPlayer();
        int amount = farmer.getAmountCraftItem(Material.BREAD, event);

        if (human instanceof Player) {
            Player player = (Player) human;
                if (item.getType() == Material.BREAD) {
                if (hashMapFarmer.getWorkFarmer(player)) {
                    int XP = hashMapFarmer.getXPFarmer(player);

                    //lvl1
                    if (XP < 10000) {
                        int xp = 10*amount;
                        hashMapFarmer.addXPFarmer(player, xp);
                        player.sendMessage("§a+" + xp + "xp");
                        farmer.messageLevelUp(player, 10000, "§2Bravo tu es passé niveau 1 !!", false);
                        return;
                    }

                    //lvl2
                    if (XP >= 10000) {
                        if (XP < 30000) {
                            int xp = 10*amount;
                            hashMapFarmer.addXPFarmer(player, xp);
                            player.sendMessage("§a+" + xp + "xp");
                            farmer.messageLevelUp(player, 30000, "§2Bravo tu es passé niveau 2 !!", false);
                            return;
                        }
                    }

                    //lvl3
                    if (XP >= 30000) {
                        if (XP < 60000) {
                            int xp = 10*amount;
                            hashMapFarmer.addXPFarmer(player, xp);
                            player.sendMessage("§a+" + xp + "xp");
                            farmer.messageLevelUp(player, 60000, "§2Bravo tu es passé niveau 3 !!", false);
                            return;
                        }
                    }

                    //lvl4
                    if (XP >= 60000) {
                        if (XP < 100000) {
                            int xp = 5*amount;
                            hashMapFarmer.addXPFarmer(player, xp);
                            player.sendMessage("§a+" + xp+ "xp ");
                            farmer.messageLevelUp(player, 100000, "§2Bravo tu es passé niveau 4 !!", false);
                            return;
                        }
                    }


                        //lvl19
                    if (XP >= 2700000) {
                        if (XP < 3000000) {
                            int xp = 10*amount;
                            hashMapFarmer.addXPFarmer(player, xp);
                            player.sendMessage("§a+" + xp + "xp");
                            farmer.messageLevelUp(player, 3000000, "§2Bravo tu es passé niveau 19 !!", false);
                            return;
                        }
                    }

                        //lvl20
                    if (XP >= 3000000) {
                        if (XP < 3500000) {
                            int xp = 10*amount;
                            hashMapFarmer.addXPFarmer(player, xp);
                            player.sendMessage("§a+" + xp + "xp");
                            farmer.messageLevelUp(player, 35000000, "§2Bravo tu es passé niveau 20 tu as fini le niveau de farmeur GG !!", true);
                        }
                    }
                    }else if (hashMapFarmer.getWorkFarmer(player)) {
                    event.getInventory().setResult(new ItemStack(Material.AIR));
                }
                }
            }
        }

        //break bloc co
        public void RemoveCoMelon(BlockBreakEvent event){
            if (event.getBlock().getType() == Material.MELON) {
                hashMapFarmer.getCoMelon().remove(event.getBlock().getLocation());
            }
        }

    public void RemoveCoPumpkin(BlockBreakEvent event){
        if (event.getBlock().getType() == Material.PUMPKIN) {
            hashMapFarmer.getCoPumpkin().remove(event.getBlock().getLocation());
        }
    }

    public void RemoveCoSugar(BlockBreakEvent event){
        if (event.getBlock().getType() == Material.SUGAR_CANE) {
            hashMapFarmer.getCoSugarCanne().remove(event.getBlock().getLocation());
        }
    }





    }