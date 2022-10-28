package fr.Townland.Main.Téléportation;

import fr.Townland.Main.mysql.DbManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class HomeManager {
    public void home(UUID uuid, String nom, Double x, Double y, Double z, Float pitch, Float yaw) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO Home (player_uuid,nom_home,x,y,z,pitch,yaw) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom);
            preparedStatement.setDouble(3, x);
            preparedStatement.setDouble(4, y);
            preparedStatement.setDouble(5, z);
            preparedStatement.setFloat(6, pitch);
            preparedStatement.setFloat(7, yaw);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public double x(UUID uuid,String nom_home) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT x,nom_home FROM Home WHERE player_uuid = ? AND nom_home = ?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom_home);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("je passe laà");
            while(rs.next()){
                return rs.getDouble("x");

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }

    public double y(UUID uuid,String nom_home) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT y FROM Home WHERE player_uuid = ? AND nom_home =?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom_home);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getDouble("y");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public double z(UUID uuid,String nom_home) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT z FROM Home WHERE player_uuid = ? AND nom_home =?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom_home);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getDouble("z");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }    public float pitch(UUID uuid,String nom_home) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT pitch FROM Home WHERE player_uuid = ? AND nom_home =?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom_home);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getFloat("pitch");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public float yaw(UUID uuid,String nom_home) {

        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT yaw FROM Home WHERE player_uuid = ? AND nom_home =?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, nom_home);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getFloat("yaw");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public String nom_home(UUID uuid,String arg){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT nom_home FROM Home WHERE player_uuid = ?");
            preparedStatement.setString(1,uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                if (rs.getString("nom_home").contains(arg)){
                    return rs.getString("nom_home");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return "";
    }
    public Integer check_count(UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT COUNT(*) AS total FROM Home WHERE player_uuid= ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public void suphome(String nom_home,UUID uuid){
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM Home WHERE nom_home=? AND player_uuid = ?");
            preparedStatement.setString(1, nom_home);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }



}
