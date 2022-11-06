package fr.Townland.Main.Teleportation.commands;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final Main main;
    private final Rank rank;

    public SetSpawnCommand(Main main,Rank rank){
        this.main = main;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Make sure that they are a player
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (rank.hasPowerInf((Player) sender, 5)) {
                player.sendMessage("§cVous n'avez pas la permission.");
                return false;
            }
            //get the players location
            Location location = player.getLocation();

            //set the spawn location in the config.yml
//            spawnPlugin.getConfig().set("spawn.x", location.getX());
//            spawnPlugin.getConfig().set("spawn.y", location.getY());
//            spawnPlugin.getConfig().set("spawn.z", location.getZ());

            //A Location is a special type of object that can be saved to a config.yml automatically by bukkit
            //This is because it implements ConfigurationSerializable
            main.getConfig().set("spawn", location);

            //save the config.yml
            main.saveConfig();

            //send a message to the player
            player.sendMessage("§aSpawn défini !");

        }else{
            System.out.println("§cVous n'êtes pas un joueur.");
        }

        return true;
    }
}