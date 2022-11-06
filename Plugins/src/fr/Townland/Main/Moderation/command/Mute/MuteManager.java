package fr.Townland.Main.Moderation.command.Mute;

import fr.Townland.Main.mysql.DbManage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MuteManager {
    public void mute(UUID uuid,long endInSeconds,String reason){
        if(isMute(uuid))return;

        long endToMillis = endInSeconds * 1000;
        long end = endToMillis + System.currentTimeMillis();

        if(endInSeconds == -1){
            end = -1;
        }

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO mute_players (player_uuid,end,reason) VALUES (?,?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setLong(2, end);
            preparedStatement.setString(3, reason);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if(Bukkit.getPlayer(uuid) != null){
            Player target = Bukkit.getPlayer(uuid);
            target.sendMessage("§cVous avez été mute");
        }
    }
    public void unmute(UUID uuid){
        if(!isMute(uuid))return;
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM mute_players WHERE player_uuid=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public boolean isMute(UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT * FROM mute_players WHERE player_uuid= ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    public void checkDuration(UUID uuid){
        if(!isMute(uuid))return;

        if(getEnd(uuid) == -1)return;

        if (getEnd(uuid) < System.currentTimeMillis()) {
            unmute(uuid);
        }
    }
    public long getEnd(UUID uuid){
        if(!isMute(uuid))return 0;
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT * FROM mute_players WHERE player_uuid=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getLong("end");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public String getTimeLeft(UUID uuid){
        if(!isMute(uuid)) return "§cNon mute";

        if(getEnd(uuid) == -1){
            return "§cPermanent";
        }

        long tempsRestant = (getEnd(uuid) - System.currentTimeMillis()) / 1000;
        int mois = 0;
        int jours = 0;
        int heures = 0;
        int minutes = 0;
        int secondes = 0;

        while(tempsRestant >= TimeUnit.MOIS.getToSecond()){
            mois++;
            tempsRestant -= TimeUnit.MOIS.getToSecond();
        }
        while(tempsRestant >= TimeUnit.JOUR.getToSecond()){
            jours++;
            tempsRestant -= TimeUnit.JOUR.getToSecond();
        }
        while(tempsRestant >= TimeUnit.HEURE.getToSecond()){
            heures++;
            tempsRestant -= TimeUnit.HEURE.getToSecond();
        }
        while(tempsRestant >= TimeUnit.MINUTE.getToSecond()){
            minutes++;
            tempsRestant -= TimeUnit.MINUTE.getToSecond();
        }
        while(tempsRestant >= TimeUnit.SECONDE.getToSecond()){
            secondes++;
            tempsRestant -= TimeUnit.SECONDE.getToSecond();
        }
        System.out.println(minutes);
        return mois + " " + TimeUnit.MOIS.getName() + " " + jours + " " + TimeUnit.JOUR.getName() + " " + heures + " " + TimeUnit.HEURE.getName() + " " + minutes + " " + TimeUnit.MINUTE.getName() + " " + secondes + " " + TimeUnit.SECONDE.getName();
    }
    public String getReason(UUID uuid){
        if(!isMute(uuid))return "§cNon mute";
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT * FROM mute_players WHERE player_uuid=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getString("reason");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return "§cNon mute";
    }
}
