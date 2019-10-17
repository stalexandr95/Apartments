package service;

import entity.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLApDAOImplementation implements ApDAO {

    private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartment?serverTimezone=Europe/Kiev";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "asd1324354657";

    public SQLApDAOImplementation() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addApartment(Apartment apartment) throws SQLException {
        try (Connection cn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD)) {
            String sql = "INSERT INTO apartment (region, adress, countOfRooms, price) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, apartment.getRegion());
                ps.setString(2, apartment.getAddress());
                ps.setString(3, String.valueOf(apartment.getArea()));
                ps.setString(4, String.valueOf(apartment.getCountOfRooms()));
                ps.setString(5, String.valueOf(apartment.getPrice()));
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Apartment> getAllAp() throws SQLException {
        List<Apartment> apartments = new ArrayList<>();
        try (Connection cn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD)) {
            try (PreparedStatement ps = cn.prepareStatement("select * from apartment")){
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String region = rs.getString("region");
                    String adress = rs.getString("adress");
                    int countOfRooms = rs.getInt("countOfRooms");
                    float area = rs.getInt("area");
                    float price = rs.getFloat("price");
                    Apartment apartment = new Apartment(id, region, adress, countOfRooms, area, price);
                    apartments.add(apartment);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return apartments;
    }

    @Override
    public void delAp(int id) throws SQLException {
        try (Connection cn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD)) {
            String sql = "DELETE FROM apartment WHERE id = " + id;
            try (Statement st = cn.createStatement()){
                st.execute(sql);
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Apartment> findByPrice(float from, float to) throws SQLException {
        List<Apartment> apartments = new ArrayList<>();
        try (Connection cn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement ps = cn.prepareStatement("select * from apartment")){
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                  int id = rs.getInt("id");
                  String region = rs.getString("region");
                  String address = rs.getString("address");
                  int countOfRooms = rs.getInt("countOfRooms");
                  float area = rs.getInt("area");
                  float price = rs.getFloat("price");
                  Apartment apartment = new Apartment(id, region, address, countOfRooms, area, price);
                  if (price >= from && price <= to) {
                      apartments.add(apartment);
                  }
              }
            }
        } catch (SQLException e) {
            throw e;
        }
        return apartments;
    }
}
