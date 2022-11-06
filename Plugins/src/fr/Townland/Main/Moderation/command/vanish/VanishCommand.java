package fr.Townland.Main.Moderation.command.vanish;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    private Main main;
    private Rank rank;
    public VanishCommand(Main main,Rank rank) {
        this.main = main;
        this.rank = rank;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if (rank.hasPowerInf((Player) sender, 6)) {
                sender.sendMessage("§cVous n'avez pas la permission");
                return false;
            }
            if(main.invisible_list.contains(player)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(main,player);
                }
                main.invisible_list.remove(player);
                player.sendMessage("§cVous êtes maintenant visible !");
            }else if(!main.invisible_list.contains(player)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    if (rank.hasPowerSup((Player) people, 6)) {
                        people.showPlayer(main,player);
                    }
                    else {
                        people.hidePlayer(main, player);
                    }
                }
                main.invisible_list.add(player);
                player.sendMessage("§aVous êtes maintenant en vanish !");
            }

        }

        return true;
    }
}































