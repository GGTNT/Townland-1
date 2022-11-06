package fr.Townland.Main.Teleportation.commands;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SpawnClaim implements CommandExecutor {
    protected Main main;
    private Rank rank;

    public SpawnClaim(Main main,String name,Rank rank){
        this.main = main;
        main.getCommand(name).setExecutor(this);
        this.rank = rank;
    }
    protected abstract void execute(Player player, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (rank.hasPowerInf((Player) sender, 5)) {
            sender.sendMessage("§cVous n'avez pas la permission.");
            return false;
        }
        if(sender instanceof Player) execute((Player) sender, args);
        return true;
    }
}
