package fr.Townland.Main.mysql;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.UUID;

public class DbManage {
    private String urlBase;
    private String host;
    private String database;
    private String userName;
    private String password;
    private static Connection connection;

    public DbManage(String urlBase, String host, String database, String userName, String password){
        this.urlBase = urlBase;
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }
    public static Connection getConnection(){
        return connection;
    }
    public void createAccount(UUID uuid){
        if(!hasAccount(uuid)){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid_player, pseudo_player, WorkFarmer, XPFarmer,coins) VALUES (?,?,?,?,?)");
                preparedStatement.setString(1,uuid.toString());
                preparedStatement.setString(2, Bukkit.getPlayer(uuid).getName());
                preparedStatement.setInt(3,0);
                preparedStatement.setInt(4,0);
                preparedStatement.setFloat(5,0.0F);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public boolean hasAccount(UUID uuid){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM players WHERE uuid_player = ?");
            preparedStatement.setString(1,uuid.toString());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                return true;
            }
            return false;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     Méthode pour se connecter à a db
     */
    public void connexion(){
        if(!isOnline()){
            try {
                connection = DriverManager.getConnection(this.urlBase + this.host + ":3307/" + this.database, this.userName, this.password);

                //  connection = DriverManager.getConnection(this.urlBase + this.host + "/" + this.database, this.userName, this.password);
                System.out.println("[DatabaseManager] Succefully connected !");
                return;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    /**
     Méthode pour se deconnecter à a db
     */
    public void deconnexion(){
        if(isOnline()){
            try {
                connection.close();
                System.out.println("§a[EconnomiePlugin] Sucefully disconnected");
                return;
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public boolean isOnline(){
        try{
            if ((connection == null) || (connection.isClosed())){
                return false;
            }
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
