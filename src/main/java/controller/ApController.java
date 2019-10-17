package controller;

import entity.Apartment;
import service.ApDAO;

import java.sql.SQLException;
import java.util.List;

public class ApController {

    private ApDAO apDAO;

    public ApController(ApDAO apDAO) {
        this.apDAO = apDAO;
    }

    public void addAp(Apartment apartment) {
        try {
            apDAO.addApartment(apartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Apartment> getAllAp() {
        try {
            return apDAO.getAllAp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delAp(int id) {
        try {
            apDAO.delAp(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Apartment> findbyPrice(float from, float to) {
        try {
            return apDAO.findByPrice(from,to);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
