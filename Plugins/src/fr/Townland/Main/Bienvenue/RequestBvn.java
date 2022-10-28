package fr.Townland.Main.Bienvenue;

import fr.Townland.Main.Main;
import fr.Townland.Main.mysql.DbManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBvn {

    private final Main main;

    public RequestBvn(Main main) {
        this.main = main;
    }


    public Integer getBienvenue(){
            try {
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("SELECT NombreB FROM bienvenue WHERE Id = ?");
                preparedStatement.setInt(1, 1);
                ResultSet rs = preparedStatement.executeQuery();
                int BVN = 0;
                while (rs.next()){
                    BVN = rs.getInt("NombreB");
                }

                return BVN;
            }catch (SQLException e){
                e.printStackTrace();
            }
        return null;
    }

    public void setBienvenue(int bvn) {
            try {
                PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("UPDATE bienvenue SET NombreB = ? WHERE Id = ? ");
                preparedStatement.setInt(1, bvn);
                preparedStatement.setInt(2, 1);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public void setupBienvenue(int bvn) {
        try {
            PreparedStatement preparedStatement = DbManage.getConnection().prepareStatement("INSERT INTO bienvenue (Id, NombreB) VALUES (?, ?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, bvn);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
