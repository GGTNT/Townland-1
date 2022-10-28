package fr.Townland.Main.Moderation.command;

import fr.Townland.Main.mysql.DbManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BanManage {
    private UUID uuid;
    public BanManage(UUID uuid){
        this.uuid = uuid;
    }
    public void addplayer(String name){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET coins = coins + ? WHERE uuid_player = ?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void removeCoins(float amount){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET coins = coins - ? WHERE uuid_player = ?");
            preparedStatement.setFloat(1,amount);
            preparedStatement.setString(2,uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

