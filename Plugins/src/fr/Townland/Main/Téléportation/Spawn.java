package fr.Townland.Main.Téléportation;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spawn implements CommandExecutor {
    private final Rank rank;
    private final Main main;
    private List<UUID> que;
    public Spawn(Rank rank, Main main) {
        this.rank = rank;
        this.main = main;
        this.que = new ArrayList<>();
    }
    int count = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (rank.hasPower(p, 7)){

            if (label.equalsIgnoreCase("setspawn")) {

                if (args.length == 0) {
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".world", p.getLocation().getWorld().getName());
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".x", p.getLocation().getX());
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".y", p.getLocation().getY());
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".z", p.getLocation().getZ());
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".pitch", p.getEyeLocation().getPitch());
                    Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString() + ".yaw", p.getEyeLocation().getYaw());
                    Main.getInstance().saveConfig();
                    p.sendMessage("§aLe spawn à bien été sauvegardé !");
                    return false;


                }

            }
            if (label.equalsIgnoreCase("spawn")) {
                if (args.length == 0) {
                    if (Main.getInstance().getConfig().contains("spawn." + p.getUniqueId().toString())) {
                        World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("spawn." + p.getUniqueId().toString() + ".world"));
                        double x = Main.getInstance().getConfig().getDouble("spawn." + p.getUniqueId().toString() + ".x");
                        double y = Main.getInstance().getConfig().getDouble("spawn." + p.getUniqueId().toString() + ".y");
                        double z = Main.getInstance().getConfig().getDouble("spawn." + p.getUniqueId().toString() + ".z");
                        double pitch = Main.getInstance().getConfig().getDouble("spawn." + p.getUniqueId().toString()+ ".pitch");
                        double yaw = Main.getInstance().getConfig().getDouble("spawn." + p.getUniqueId().toString() + ".yaw");
                        if(rank.hasPowerInf((Player) sender, 2)) {
                            this.addQue(p.getUniqueId());
                            new BukkitRunnable() {
                                int delay = 5;
                                @Override
                                public void run() {
                                    if (delay == 0){
                                        p.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
                                        p.sendMessage("§aVous avez été téléporté au spawn ");
                                        cancelQue(p.getUniqueId());
                                        this.cancel();
                                    }else{

                                        p.sendMessage("§eTéléporation dans §o " + --delay + " secondes");
                                    }
                                }
                            }.runTaskTimer(main,0,20);
                        }else{
                            p.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
                            p.sendMessage("§aVous avez été téléporté au spawn ");
                        }

                    }
                }

            }
            if (label.equalsIgnoreCase("delspawn")) {
                if (args.length == 0) {
                    p.sendMessage("§cErreur : /delspawn");
                    return false;
                }
                if (args.length == 1) {
                    if (Main.getInstance().getConfig().contains("spawn." + p.getUniqueId().toString())) {
                        Main.getInstance().getConfig().set("spawn." + p.getUniqueId().toString(), null);
                        Main.getInstance().saveConfig();
                        p.sendMessage("§aLe spawn a bien été supprimé !");
                        return false;
                    }
                }
            }

        }else {
            p.sendMessage("§cVous n'avez pas la permission !");
        }

        return false;
    }
    public void addQue(UUID id){
        this.que.add(id);
    }
    public void cancelQue(UUID id){
        this.que.remove(id);
    }
    public boolean isQued(UUID id){
        return this.que.contains(id);
    }

}
