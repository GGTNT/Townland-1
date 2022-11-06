package fr.Townland.Main.Teleportation.commands;

import fr.Townland.Main.Main;
import fr.Townland.Main.TabList.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class Home implements CommandExecutor, Listener {
    private final Rank rank;
    private final Main main;



    public Home(Rank rank, Main main) {
        this.rank = rank;
        this.main = main;
    }


    @EventHandler
    public void onPLayerMove(PlayerMoveEvent e) {
        if(!e.getFrom().getBlock().equals(e.getTo().getBlock())){
            Player player = e.getPlayer();
            UUID id = player.getUniqueId();
            if(main.que.contains(id))
                main.que.remove(id);
        }
   }
   @EventHandler
   public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof  Player){
            Player player = ((Player) event.getEntity());
            UUID id = player.getUniqueId();
            if(main.que.contains(id))
                main.que.remove(id);
        }
   }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("sethome")) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage("§cErreur : /sethome <nom home>");
                return false;
            }


            if (args.length == 1) {
                if(Main.getInstance().homeManager.nom_home(p.getUniqueId(),args[0]).equalsIgnoreCase(args[0])){
                    p.sendMessage("§cVous avez déjà un home avec le même nom.");
                    return false;
                }

                if(rank.hasPowerInf((Player) sender, 0) ){
                   if(Main.getInstance().homeManager.check_count(p.getUniqueId()) == 1){
                        p.sendMessage("§cVous avez atteint la limite de home pour votre grade.");
                        return false;
                        }
                }
                else if(rank.hasPowerInf((Player) sender, 1) ){
                    if(Main.getInstance().homeManager.check_count(p.getUniqueId()) == 2){
                        p.sendMessage("§cVous avez atteint la limite de home pour votre grade.");
                        return false;
                    }
                }
                else if(rank.hasPowerInf((Player) sender, 2) ){
                    if(Main.getInstance().homeManager.check_count(p.getUniqueId()) == 3){
                        p.sendMessage("§cVous avez atteint la limite de home pour votre grade.");
                        return false;
                    }
                }
                else if(rank.hasPowerInf((Player) sender, 3) ){
                    if(Main.getInstance().homeManager.check_count(p.getUniqueId()) == 4){
                        p.sendMessage("§cVous avez atteint la limite de home pour votre grade.");
                        return false;
                    }
                }
                Main.getInstance().homeManager.home(p.getUniqueId(),args[0],p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ(),p.getEyeLocation().getPitch(), p.getEyeLocation().getYaw());

                p.sendMessage("§aVotre home " + args[0] + " a été créé !");
                return false;
            }
            if (args.length >= 2) {
                p.sendMessage("§cErreur : /sethome <nom home>");
                return false;
            }

        }
        if (label.equalsIgnoreCase("home")) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if(Main.getInstance().homeManager.check_count(p.getUniqueId()) == 0){
                    p.sendMessage("§cVous n'avez pas encore de home.");
                    return false;
                }else {
                    p.sendMessage("§eVos homes sont : ");
                    Main.getInstance().homeManager.name_all_home(p.getUniqueId(),p.getPlayer());
                    return false;
                }
            }
            if (args.length == 1) {
                Double x = Main.getInstance().homeManager.x(p.getUniqueId(),args[0]);
                Double y = Main.getInstance().homeManager.y(p.getUniqueId(),args[0]);
                Double z = Main.getInstance().homeManager.z(p.getUniqueId(),args[0]);
                Float pitch = Main.getInstance().homeManager.pitch(p.getUniqueId(),args[0]);
                Float yaw = Main.getInstance().homeManager.yaw(p.getUniqueId(),args[0]);
                if (Main.getInstance().homeManager.nom_home(p.getUniqueId(),args[0]).equalsIgnoreCase(args[0])) {
                    if (rank.hasPowerInf((Player) sender, 5)) {
                        UUID id = p.getUniqueId();
                        main.que.add(id);
                        p.sendMessage(ChatColor.GOLD + "Téléportation dans 5 secondes");
                        new BukkitRunnable()
                        {
                            int delay = 5;
                            @Override
                            public void run()
                            {
                                if (main.que.contains(id)){

                                    if (delay == 0){
                                        p.sendMessage(ChatColor.GOLD + "Téléportation...");
                                        p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                        main.que.remove(id);
                                        this.cancel();
                                    } else {
                                        delay--;

                                    }
                                } else{
                                    p.sendMessage(ChatColor.RED + "§cTéléportation annulé");
                                    this.cancel();
                                }

                            }
                        }.runTaskTimer(main, 0, 20);
                    } else {
                        p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                        p.sendMessage("§aVous avez été téléporté à votre home " + args[0]);

                    }
                } else {
                    p.sendMessage("§cLe home " + args[0] + " n'existe pas !");
                    return false;
                }
            }
            }
        if (label.equalsIgnoreCase("delhome")) {
            Player p = (Player) sender;
            if (!Main.getInstance().homeManager.nom_home(p.getUniqueId(),args[0]).equalsIgnoreCase(args[0])) {
                p.sendMessage("§cLe home " + args[0] + " n'existe pas !");
                return false;
            }
            if (args.length == 0) {
                p.sendMessage("§cErreur : /delhome <nom>");
                return false;
            }
            if (args.length == 1) {
                p.sendMessage("§aVotre home "+args[0] +" a été supprimé.");
                Main.getInstance().homeManager.suphome(args[0],p.getUniqueId());
            }
            if (args.length >= 2) {
                p.sendMessage("§cErreur : /delhome <nom>");
                return false;
            }

        }
        return false;
    }

}