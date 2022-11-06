package fr.Townland.Main.Teleportation.listeners;

import fr.Townland.Main.Teleportation.components.Bound;
import fr.Townland.Main.Teleportation.components.Region;
import fr.Townland.Main.mysql.DbManage;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SpawnManager {
    public void create_region(String name, String description, boolean safezone, Bound bound) {
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO regionManager (name,description,safezone,bound) VALUES (?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setBoolean(3, safezone);
            preparedStatement.setString(4, bound.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void insert_regions(String name,String region) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO regions (name,region) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, region);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public void insert_regionSetup(UUID uuid,Bound Bound) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO regionSetup (uuid,Bound) VALUES (?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, Bound.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public void cancel(UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM regionSetup WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Bound recup_user(UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT uuid FROM regionSetup WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                rs.getString("uuid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean recup_name(String name){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT name FROM regionManager");
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean recup_uuid(UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT uuid FROM regionSetup");
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
