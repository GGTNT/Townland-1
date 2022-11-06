package fr.Townland.Main.Works.Pecheur;

import fr.Townland.Main.mysql.DbManage;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestPecheur {

    private HashMapPecheur hashMapPecheur;

    public RequestPecheur(HashMapPecheur hashMapPecheur){
        this.hashMapPecheur = hashMapPecheur;
    }

    public void setWorkPecheur(Player player, Boolean values){
        try {
             PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET WorkPecheur = ? WHERE uuid_player = ?");
                preparedStatement.setBoolean(1, values);
                preparedStatement.setString(2, player.getUniqueId().toString());
                preparedStatement.executeUpdate();
                preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Boolean getWorkPecheur(Player player){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT WorkPecheur FROM players WHERE uuid_player = ?");
            preparedStatement.setString(1, player.getUniqueId().toString());

            ResultSet rs = preparedStatement.executeQuery();
            Boolean WorkPecheur = false;
            while (rs.next()){

                WorkPecheur = rs.getBoolean("WorkPecheur");
            }
            return WorkPecheur;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer getXPPecheur(Player player){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT XPPecheur FROM players WHERE uuid_player = ?");
            preparedStatement.setString(1, player.getUniqueId().toString());

            ResultSet rs = preparedStatement.executeQuery();
            int XPPecheur = 0;
            while (rs.next()){
                XPPecheur = rs.getInt("XPPecheur");
            }
            if (!hashMapPecheur.getXppecheur().containsKey(player.getUniqueId().toString())){
                return XPPecheur;
            }
            if (hashMapPecheur.getXppecheur().containsKey(player.getUniqueId().toString())){
                if (HashMapPecheur.getXppecheur().get(player.getUniqueId().toString()) != 0){
                    return hashMapPecheur.getXpPecheur(player);
                }
            }
            return XPPecheur;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void setXPPecheur(Player player, Integer xp){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET XPPecheur = ? WHERE uuid_player = ? ");
            preparedStatement.setInt(1, xp);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
