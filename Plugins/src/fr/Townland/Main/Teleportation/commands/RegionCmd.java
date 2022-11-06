package fr.Townland.Main.Teleportation.commands;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import fr.Townland.Main.Teleportation.components.Bound;
import fr.Townland.Main.Teleportation.listeners.RegionListener;
import fr.Townland.Main.Teleportation.managers.RegionManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static fr.Townland.Main.Teleportation.ui.Utils.decolor;
import static fr.Townland.Main.Teleportation.ui.Utils.msgPlayer;

public class RegionCmd extends SpawnClaim{
    private RegionManager regionManager;
    private Map<UUID, Bound> regionSetup = new HashMap<>();
    private Rank rank;

    public RegionCmd(Main main,Rank rank){
        super(main,"region",rank);
        regionManager = main.getRegionManager();
        this.rank = rank;
    }
    @Override
    protected void execute(Player player, String[] args) {
        if(args.length == 0){
            msgPlayer(player,"&eHelp : /region create");
            return;
        }

        switch (args[0].toLowerCase()){
            case "create":
                if(!regionSetup.containsKey(player.getUniqueId())){
                    regionSetup.put(player.getUniqueId(),new Bound());
                    Main.getInstance().spawnManager.insert_regionSetup(player.getUniqueId(),new Bound());
                    msgPlayer(player,"&eClic droit &fpour mettre la pemière position\n&eClique gauche &fpour mettre la deuxième position\n&eHelp : /region create <nom region> <true/false>");
                }else if(args.length == 1){
                    regionSetup.remove(player.getUniqueId());
                    Main.getInstance().spawnManager.cancel(player.getUniqueId());
                    msgPlayer(player,"&cCréation de la région annulée !");
                }else if(args.length < 3){
                    msgPlayer(player,"&eHelp : /region create <nom region> <true/false>");
                }else{
                    Bound bound = regionSetup.get(player.getUniqueId());
                    System.out.println("-------");
                    System.out.println(Main.getInstance().spawnManager.recup_user(player.getUniqueId()));
                    System.out.println("--------");
                    //TODO changer le pointer bound
                    if(!bound.isComplete()){
                        msgPlayer(player,"&eVeuillez séléctionner deux coté opposé.");

                        return;
                    }
                    String name = args[1],safeInput = args[2].toLowerCase();
                    boolean safezone;
                    if(safeInput.equalsIgnoreCase("true")){
                        safezone = true;
                    }else if(safeInput.equalsIgnoreCase("false")){
                        safezone = false;
                    }else{
                        msgPlayer(player,"&fVous avez oublié <true/false> !");

                        return;
                    }
                    StringBuilder builder = new StringBuilder();
                    for (int i = 4; i <= args.length; i++){
                        builder.append(args[i - 1]).append(" ");
                    }
                    String description = builder.toString().trim();
                    bound.assignCorrectBounds();
                    if(Main.getInstance().spawnManager.recup_name(decolor(name).toLowerCase())){
                        msgPlayer(player,"&fLes claims du spawn ont déjà été défini !");
                        return;
                    }
                    regionManager.createNewRegion(name,description,safezone,bound);
                    Main.getInstance().spawnManager.create_region(name,description,safezone,bound);
                    regionSetup.remove(player.getUniqueId());
                    Main.getInstance().spawnManager.cancel(player.getUniqueId());
                    msgPlayer(player,"&fCréation du spawn !");

                }

                break;
            default:
                msgPlayer(player,"&cImpossible de trouver "+args[0]+ " !");
                break;
        }
    }
    public Map<UUID,Bound> getRegionSetup(){
        return regionSetup;
    }
}