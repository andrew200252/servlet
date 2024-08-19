package org.servlets.dao;

import com.google.gson.Gson;
import org.servlets.models.Unit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/RUSSIA";
    private static final String USER = "postgres";
    private static final String PASSWORD = "bkju99if";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Unit> index(){

        List<Unit> units = new ArrayList<>();
        String sql = "select * from \"ADMINISTRATIVE_UNITS\"";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Unit unit = new Unit();
                unit.setId(resultSet.getInt("ID"));
                unit.setName(resultSet.getString("NAME"));
                unit.setParentId(resultSet.getInt("PARENT_ID"));
                unit.setPopulation(resultSet.getInt("POPULATION"));
                unit.setArea(resultSet.getDouble("AREA"));
                unit.setFoundation(resultSet.getInt("FOUNDATION_YEAR"));
                units.add(unit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return units;
    }

    public void update(Unit unit){
        try {
            String sql = "UPDATE \"ADMINISTRATIVE_UNITS\" SET \"NAME\" = ?," +
                    "\"PARENT_ID\" = ?, \"POPULATION\" = ?,  \"AREA\" = ?," +
                    " \"FOUNDATION_YEAR\" = ? WHERE \"ID\" = " + unit.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, unit.getName());
            preparedStatement.setInt(2, unit.getParentId());
            preparedStatement.setInt(3, unit.getPopulation());
            preparedStatement.setDouble(4, unit.getArea());
            preparedStatement.setInt(5, unit.getFoundation());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void create(Unit unit){
        try {
            String sql = "INSERT INTO \"ADMINISTRATIVE_UNITS\"" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, unit.getName());
            preparedStatement.setInt(2, unit.getParentId());
            preparedStatement.setInt(3, unit.getPopulation());
            preparedStatement.setDouble(4, unit.getArea());
            preparedStatement.setInt(5, unit.getFoundation());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete (Unit unit){
        String sql = "DELETE FROM \"ADMINISTRATIVE_UNITS\" " +
                "WHERE \"ID\" = " + unit.getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
