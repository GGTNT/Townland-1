package fr.Townland.Main.Works.Pecheur;

import fr.Townland.Main.TabList.Rank;
import net.minecraft.server.v1_16_R3.Items;
import net.minecraft.server.v1_16_R3.Potions;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PecheurListener implements Listener {

    private final HashMapPecheur hashMapPecheur;
    private final RequestPecheur requestPecheur;
    private final Rank rank;
    private final Pecheur pecheur;

    public PecheurListener(HashMapPecheur hashMapPecheur, RequestPecheur requestPecheur, Rank rank, Pecheur pecheur) {
        this.hashMapPecheur = hashMapPecheur;
        this.requestPecheur = requestPecheur;
        this.rank = rank;
        this.pecheur = pecheur;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        hashMapPecheur.setupWorkpecheur(event.getPlayer(), requestPecheur.getWorkPecheur(event.getPlayer()));
        hashMapPecheur.setupXppecheur(event.getPlayer(), requestPecheur.getXPPecheur(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        requestPecheur.setWorkPecheur(event.getPlayer(), hashMapPecheur.getWorkpecheur(event.getPlayer()));
        requestPecheur.setXPPecheur(event.getPlayer(), hashMapPecheur.getXpPecheur(event.getPlayer()));
        HashMapPecheur.getWorkpecheur().remove(event.getPlayer().getUniqueId().toString());
        HashMapPecheur.getXppecheur().remove(event.getPlayer().getUniqueId().toString());
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        requestPecheur.setWorkPecheur(event.getPlayer(), hashMapPecheur.getWorkpecheur(event.getPlayer()));
        requestPecheur.setXPPecheur(event.getPlayer(), hashMapPecheur.getXpPecheur(event.getPlayer()));
        HashMapPecheur.getWorkpecheur().remove(event.getPlayer().getUniqueId().toString());
        HashMapPecheur.getXppecheur().remove(event.getPlayer().getUniqueId().toString());
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){

        if (!hashMapPecheur.getWorkpecheur(event.getPlayer())){
            event.setCancelled(true);
        }else if (hashMapPecheur.getWorkpecheur(event.getPlayer())) {

            if (hashMapPecheur.getXpPecheur(event.getPlayer()) < 3500000) {

            if (event.getCaught() instanceof Item) {
                Item item = (Item) event.getCaught();

                //poissons
                if (event.getCaught() == Items.SALMON || event.getCaught() == Items.COD) {
                    hashMapPecheur.addXppecheur(event.getPlayer(), 40);
                    event.getPlayer().sendMessage("§a+40xp ");
                    pecheur.messageLevelUp(event.getPlayer(), 40);
                }

                //déchets
                if (event.getCaught() == Items.PUFFERFISH || event.getCaught() == Items.TROPICAL_FISH || event.getCaught() == Items.BOWL || event.getCaught() == Items.LEATHER || event.getCaught() == Items.LEATHER_BOOTS || event.getCaught() == Items.ROTTEN_FLESH || item.getItemStack().getType() == Material.TRIPWIRE || event.getCaught() == Items.STICK || event.getCaught() == Items.STRING || event.getCaught() == Potions.WATER || event.getCaught() == Items.BONE || event.getCaught() == Items.INK_SAC) {
                    hashMapPecheur.addXppecheur(event.getPlayer(), 60);
                    event.getPlayer().sendMessage("§a+60xp ");
                    pecheur.messageLevelUp(event.getPlayer(), 60);
                }

                //trésors
                if (item.getItemStack().getType() == Material.ENCHANTED_BOOK) {
                    hashMapPecheur.addXppecheur(event.getPlayer(), 100);
                    event.getPlayer().sendMessage("§a+100xp ");
                    pecheur.messageLevelUp(event.getPlayer(), 100);
                }
                if (item.getItemStack().getType() == Material.BOW || event.getCaught() == Items.FISHING_ROD) {
                    if (item.getItemStack().getEnchantments().size() >= 1) {
                        hashMapPecheur.addXppecheur(event.getPlayer(), 100);
                        event.getPlayer().sendMessage("§a+100xp ");
                        pecheur.messageLevelUp(event.getPlayer(), 100);
                    }
                }

            }
            }
        }
        }
    }