package fr.Townland.Main.Moderation.command.Bans;

import fr.Townland.Main.Main;
import fr.Townland.Main.mysql.DbManage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerInfos implements Listener {

    public void update(Player player){
        try{
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT player_name FROM bans WHERE player_uuid = ?");
            preparedStatement.setString(1,player.getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                PreparedStatement update = DbManage.getConnection().prepareStatement("UPDATE bans SET player_name = ? WHERE player_uuid = ?");
                update.setString(1,player.getName());
                update.setString(2,player.getUniqueId().toString());
                update.executeUpdate();
                update.close();
            }else{
                PreparedStatement insert = DbManage.getConnection().prepareStatement("INSERT INTO bans (player_uuid,player_name) VALUES(?,?)");

                insert.setString(1,player.getUniqueId().toString());
                insert.setString(2,player.getName());
                insert.executeUpdate();
                insert.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

    public boolean exists(String playerName) {
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT * FROM bans WHERE player_name= ?");
            preparedStatement.setString(1, playerName);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    public UUID getUUID(String playerName){
            try{
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT player_uuid FROM bans WHERE player_name = ?");
                preparedStatement.setString(1,playerName);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){
                    return UUID.fromString(rs.getString("player_uuid"));
                }
            }catch (SQLException e) {
                e.printStackTrace();

            }
            throw new NullPointerException("Le joueur n'a pas d'information dans la table ban");
        }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        update(player);
    }
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player player = e.getPlayer();
        Main.getInstance().banManager.checkDuration(player.getUniqueId());
        if(Main.getInstance().banManager.isBanned(player.getUniqueId())){
            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            e.setKickMessage("§cVous êtes banni de Townland\n\n§7Raison : §f" + Main.getInstance().banManager.getReason(player.getUniqueId())+ "\n\n§7Temps restant : §f"+Main.getInstance().banManager.getTimeLeft(player.getUniqueId()));
        }
    }
    }