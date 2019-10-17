package service;

import entity.Apartment;

import java.sql.SQLException;
import java.util.List;

public interface ApDAO {

    public void addApartment(Apartment apartment) throws SQLException;
    public List<Apartment> getAllAp() throws SQLException;
    public void delAp(int id) throws SQLException;
    public List<Apartment> findByPrice (float from, float to) throws SQLException;
}
