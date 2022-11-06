package fr.Townland.Main.Command;

import fr.Townland.Main.Bienvenue.Bienvenue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//cette class est utilisé pour des tests
public class TestCommand implements CommandExecutor {

    private Bienvenue bienvenue;

    public TestCommand(Bienvenue bienvenue){
        this.bienvenue = bienvenue;
    }
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String s, String[] args) {
        if(Sender instanceof Player) {
            Player player = (Player) Sender;
            if (s.equals("test")) {
                Sender.sendMessage(String.valueOf(bienvenue.getBVN()));
            }

        }
        return true;
    }
}

