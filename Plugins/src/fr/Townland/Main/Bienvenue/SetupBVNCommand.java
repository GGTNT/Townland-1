package fr.Townland.Main.Bienvenue;

import fr.Townland.Main.TabList.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupBVNCommand implements CommandExecutor {

    private final Rank rank;
    private final RequestBvn requestBvn;

    public SetupBVNCommand(Rank rank, RequestBvn requestBvn) {
        this.rank = rank;
        this.requestBvn = requestBvn;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equals("setbvn")){
            if (rank.hasPower((Player) sender, 7)){
                if (sender instanceof Player){
                    return true;
                }else {
                    int nb = Integer.parseInt(args[0]);
                    requestBvn.setupBienvenue(nb);
                    sender.sendMessage("§2Bienvenue créé dans la bdd !");
                }
            }
        }
        return true;
    }
}
