package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {
    private final Rank rank;

    public Gm(Rank rank) {
        this.rank = rank;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("gamemode") && sender instanceof Player) {
            if (rank.hasPowerInf((Player) sender, 6)) {
                sender.sendMessage("§cVous n'avez pas la permission");
            }else{
                if (args.length == 1) {
                    if(args[0].equals("spectateur")){
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage("§b[GameMode] §fVous êtes maintenant en mode §6" + args[0]);
                    }
                    else if (args[0].equals("creative")){
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("§b[GameMode] §fVous êtes maintenant en mode §6" + args[0]);
                    }
                    else if (args[0].equals("survie")){
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("§b[GameMode] §fVous êtes maintenant en mode §6" + args[0]);
                    } else{
                        p.sendMessage("[Gamemode] help : /gamemode survie | creative | spectateur");
                    }


                }

            }
        }
        return false;
    }
}
