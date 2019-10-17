package service;

import entity.Apartment;

import java.sql.SQLException;
import java.util.List;

public class ApService {
    private ApDAO apDAO;

    public ApService(ApDAO apDAO) {
        this.apDAO = apDAO;
    }

    public ApDAO getApDAO() {
        return apDAO;
    }

    public void setApDAO(ApDAO apDAO) {
        this.apDAO = apDAO;
    }

    public void addApartment(Apartment apartment) throws SQLException {
        apDAO.addApartment(apartment);
    }

    public List<Apartment> getAllApartment() throws SQLException {
        return apDAO.getAllAp();
    }
}
