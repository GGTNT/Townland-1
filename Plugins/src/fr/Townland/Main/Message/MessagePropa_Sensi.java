package fr.Townland.Main.Message;

import fr.Townland.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessagePropa_Sensi{

    public MessagePropa_Sensi(){
        Scheduler();
    }

    public final void Scheduler() {

        //Message réseaux
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
                player.sendMessage(ChatColor.GREEN + "N'hesitez pas à nous soutenir via différents réseaux :");
                player.sendMessage(ChatColor.GREEN + "Discord :" + ChatColor.BLUE + " https://discord.gg/z7ZcJJ5pJJ");
                player.sendMessage(ChatColor.GREEN + "YouTube :" + ChatColor.BLUE + " https://youtube.com/channel/UCqkWd3YFfo40q9ONUGTV-cQ");
                player.sendMessage(ChatColor.GREEN + "Twitch :" +ChatColor.BLUE + "");
                player.sendMessage(ChatColor.GREEN + "Instagram :" + ChatColor.BLUE + "");
                player.sendMessage(ChatColor.GREEN + "Twitter :" + ChatColor.BLUE + " https://twitter.com/Townland11");
                player.sendMessage(ChatColor.GREEN + "TikTok :" + ChatColor.BLUE + " https://www.tiktok.com/@townland_");
                player.sendMessage(ChatColor.GREEN + "Reddit :" + ChatColor.BLUE + " https://www.reddit.com/");
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
            }
        },0L,20L*3600);

        //Message cheat
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
                player.sendMessage(ChatColor.RED + "Tout type de cheat est interdit et sanctionable");
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
            }
        },20L*600,20L*3600);

        //Message vote
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
                player.sendMessage(ChatColor.GREEN + "Vous pouvez gagner différentes récompenses en");
                player.sendMessage(ChatColor.GREEN + "et nous soutenir en votant sur le site :");
                player.sendMessage(ChatColor.BLUE + "lien du site");
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
            }
        },20L*1200,20L*3600);

        //Message afk
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
                player.sendMessage(ChatColor.RED + "L'AFK ainsi que les anti AFK sont interdit et");
                player.sendMessage(ChatColor.RED + "sanctionnable sur le serveur");
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
            }
        },20L*1800,20L*3600);

        //Message boutique
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
                player.sendMessage(ChatColor.GREEN + "Vous pouvez obtenir des récompenses exclusifs,");
                player.sendMessage(ChatColor.GREEN + "des grades, des avantages... via notre boutique :");
                player.sendMessage(ChatColor.BLUE + "lien de la boutique");
                player.sendMessage(ChatColor.DARK_AQUA + "==================================================");
            }
        },20L*2400,20L*3600);

        //Message langage
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
                player.sendMessage(ChatColor.RED + "Le langage grossier, les propos racistes, homophobe...");
                player.sendMessage(ChatColor.RED + "sont strictement interdit et sanctionable");
                player.sendMessage(ChatColor.DARK_AQUA + "=============================================");
            }
        },20L*3000,20L*3600);
    }
}
