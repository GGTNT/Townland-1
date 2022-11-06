package fr.Townland.Main.Economie.DataEconomie;

import fr.Townland.Main.mysql.DbManage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class SignShopManager {
    public void setShop(UUID uuid,String player_name, Double x, Double y, Double z) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO Shop (player_uuid,player_name,x,y,z) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, player_name);
            preparedStatement.setDouble(3, x);
            preparedStatement.setDouble(4, y);
            preparedStatement.setDouble(5, z);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public void supSign(UUID uuid,Double x,Double y,Double z){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM Shop WHERE player_uuid = ? AND x = ? AND y = ? AND z = ?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setDouble(2, x);
            preparedStatement.setDouble(3, y);
            preparedStatement.setDouble(4, z);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
