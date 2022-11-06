package fr.Townland.Main.Works.Farmer;

import fr.Townland.Main.Main;
import fr.Townland.Main.mysql.DbManage;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RequestFarmer {

    private final Main main;
    private final HashMapFarmer hashMapFarmer;
    private int MelonX;
    private int MelonY;
    private int MelonZ;
    private String MelonWorld;
    private int PumpkinX;
    private int PumpkinY;
    private int PumpkinZ;
    private String PumpkinWorld;
    private int SugarCanneX;
    private int SugarCanneY;
    private int SugarCanneZ;
    private String SugarCanneWorld;

    public RequestFarmer(Main main, HashMapFarmer hashMapFarmer){
        this.main = main;
        this.hashMapFarmer = new HashMapFarmer();
    }

    //récupérer l'xp d'un joueur de son métier
    public Integer getXP(String work, Player player){

        if (work.equals("farmer")){
            try {
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT XPFarmer FROM players WHERE uuid_player = ?");
                preparedStatement.setString(1, player.getUniqueId().toString());

                ResultSet rs = preparedStatement.executeQuery();
                int XPfarmer = 0;
                while (rs.next()){
                    XPfarmer = rs.getInt("XPFarmer");
                }
                if (!hashMapFarmer.getXpfarmer().containsKey(player.getUniqueId().toString())){
                    return XPfarmer;
                }
                if (hashMapFarmer.getXpfarmer().containsKey(player.getUniqueId().toString())){
                    if (hashMapFarmer.getXPFarmer(player) != 0){
                        return hashMapFarmer.getXPFarmer(player);
                    }
                }
                return XPfarmer;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void changeXP(String work, Player player, Integer xp) {

        if (work.equals("farmer")) {
            try {

                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET XPFarmer = ? WHERE uuid_player = ? ");
                preparedStatement.setInt(1, xp);
                preparedStatement.setString(2, player.getUniqueId().toString());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //récupérer le métier du joueur
    public Boolean getWork(String work, UUID uuid){

        if (work.equals("farmer")){
            try {
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT WorkFarmer FROM players WHERE uuid_player = ?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet rs = preparedStatement.executeQuery();
                Boolean WorkFarmer = false;
                while (rs.next()){

                    WorkFarmer = rs.getBoolean("WorkFarmer");
                }
                return WorkFarmer;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    //changer le métier join
    public void updateWork(String work, Boolean o, Player player){

        if (work.equals("farmer")){
            try {

                if (o == false){
                    PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET WorkFarmer = ? WHERE uuid_player = ?");
                    preparedStatement.setBoolean(1, o);
                    preparedStatement.setString(2, player.getUniqueId().toString());
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    if (hashMapFarmer.getXPFarmer(player) != 0 || hashMapFarmer.getXPFarmer(player) == null){
                        hashMapFarmer.removeXP(hashMapFarmer.getXPFarmer(player), player);
                    }
                    return;
                }
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE players SET WorkFarmer = ? WHERE uuid_player = ?");
                preparedStatement.setBoolean(1, o);
                preparedStatement.setString(2, player.getUniqueId().toString());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //set les valeurs de départ
    public void setupProfil(Player player){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO players (uuid_player, pseudo_player, WorkFarmer, XPFarmer,coins) VALUES (?, ?, ?, ?, ?)");
            //l'uuid du joueur
            preparedStatement.setString(1, player.getUniqueId().toString());
            //le peseudo du joueur
            preparedStatement.setString(2, player.getName());
            //le métier farmeur du joueur
            preparedStatement.setBoolean(3,false);
            //l'xp du métier farmeur du joeur
            preparedStatement.setInt(4,0);
            //ajouter le field coins
            preparedStatement.setFloat(5,0);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //enregistrement des co du bloc posé
    public void setupMelon(Location location, int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO melon_location (coLocationMelon, MelonX, MelonY, MelonZ, WorldMelon, M) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, location.toString());
            preparedStatement.setInt(2, location.getBlockX());
            preparedStatement.setInt(3, location.getBlockY());
            preparedStatement.setInt(4, location.getBlockZ());
            preparedStatement.setString(5, location.getWorld().getName());
            preparedStatement.setInt(6, index);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //enregistrement des co du bloc posé
    public void setupPumpkin(Location location, int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO pumpkin_location (coLocationPumpkin, PumpkinX, PumpkinY, PumpkinZ, WorldPumpkin P) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, location.toString());
            preparedStatement.setInt(2, location.getBlockX());
            preparedStatement.setInt(3, location.getBlockY());
            preparedStatement.setInt(4, location.getBlockZ());
            preparedStatement.setString(5, location.getWorld().getName());
            preparedStatement.setInt(6, index);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //enregistrement des co du bloc posé
    public void setupSugarCanne(Location location, int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO sugar_canne_location (coLocationSugarCanne, SugarX, SugarY, SugarZ, WorldSugar, S) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, location.toString());
            preparedStatement.setInt(2, location.getBlockX());
            preparedStatement.setInt(3, location.getBlockY());
            preparedStatement.setInt(4, location.getBlockZ());
            preparedStatement.setString(5, location.getWorld().getName());
            preparedStatement.setInt(6, index);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //retirer la location du bloc
    public void removeMelon(){

            try {

                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM melon_location");
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    //retirer la location du bloc
    public void removePumpkin(){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM pumpkin_location");
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //retirer la location du bloc
    public void removeSugarCanne(){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("DELETE FROM sugar_canne_location");
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int countMelonLoc(){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT count(*) FROM melon_location");
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt("count(*)");
            }
            return count;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void locationMelon(int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT MelonX, MelonY, MelonZ, WorldMelon FROM melon_location WHERE M = ?");
            preparedStatement.setInt(1, index);
            ResultSet rs = preparedStatement.executeQuery();
            int Melonx = 0;
            int Melony = 0;
            int Melonz = 0;
            String Melonworld = "";
            while (rs.next()){
                Melonx = rs.getInt("MelonX");
                Melony = rs.getInt("MelonY");
                Melonz = rs.getInt("MelonZ");
                Melonworld = rs.getString("WorldMelon");
            }
            MelonX = Melonx;
            MelonY = Melony;
            MelonZ = Melonz;
            MelonWorld = Melonworld;
            return;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int countPumpkinLoc(){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT count(*) FROM pumpkin_location");
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt("count(*)");
            }
            return count;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void locationPumpkin(int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT PumpkinX, PumpkinY, PumpkinZ, WorldPumpkin FROM pumpkin_location WHERE P = ?");
            preparedStatement.setInt(1, index);
            ResultSet rs = preparedStatement.executeQuery();
            int Pumpkinx = 0;
            int Pumpkiny = 0;
            int Pumpkinz = 0;
            String Pumpkinworld = "";
            while (rs.next()){
                Pumpkinx = rs.getInt("MelonX");
                Pumpkiny = rs.getInt("MelonY");
                Pumpkinz = rs.getInt("MelonZ");
                Pumpkinworld = rs.getString("WorldMelon");
            }
            PumpkinX = Pumpkinx;
            PumpkinY = Pumpkiny;
            PumpkinZ = Pumpkinz;
            PumpkinWorld = Pumpkinworld;
            return;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int countSugarCanneLoc(){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT count(*) FROM sugar_canne_location");
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt("count(*)");
            }
            return count;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void locationSugarCanne(int index){

        try {

            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT SugarX, SugarY, SugarZ, WorldSugar FROM sugar_canne_location WHERE S = ?");
            preparedStatement.setInt(1, index);
            ResultSet rs = preparedStatement.executeQuery();
            int Sugarx = 0;
            int Sugary = 0;
            int Sugarz = 0;
            String Sugarworld = "";
            while (rs.next()){
                Sugarx = rs.getInt("SugarX");
                Sugary = rs.getInt("SugarY");
                Sugarz = rs.getInt("SugarZ");
                Sugarworld = rs.getString("WorldSugar");
            }
            SugarCanneX = Sugarx;
            SugarCanneY = Sugary;
            SugarCanneZ = Sugarz;
            SugarCanneWorld = Sugarworld;
            return;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getMelonX() {
        return MelonX;
    }

    public int getMelonY() {
        return MelonY;
    }

    public int getMelonZ() {
        return MelonZ;
    }

    public String getMelonWorld() {
        return MelonWorld;
    }

    public int getPumpkinX() {
        return PumpkinX;
    }

    public int getPumpkinY() {
        return PumpkinY;
    }

    public int getPumpkinZ() {
        return PumpkinZ;
    }

    public String getPumpkinWorld() {
        return PumpkinWorld;
    }

    public int getSugarCanneX() {
        return SugarCanneX;
    }

    public int getSugarCanneY() {
        return SugarCanneY;
    }

    public int getSugarCanneZ() {
        return SugarCanneZ;
    }

    public String getSugarCanneWorld() {
        return SugarCanneWorld;
    }
}