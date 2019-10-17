package servlets;

import controller.ApController;
import entity.Apartment;
import service.SQLApDAOImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddApServlet extends HttpServlet {
    private ApController ap;

    @Override
    public void init() throws ServletException {
        super.init();
        ap = new ApController(new SQLApDAOImplementation());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String region = req.getParameter("region");
        String address = req.getParameter("address");
        int countOfRooms = Integer.parseInt(req.getParameter("countOfRooms"));
        float area = Float.parseFloat(req.getParameter("area"));
        float price = Float.parseFloat(req.getParameter("price"));

        Apartment apartment = new Apartment(region, address, countOfRooms, area ,price);
        ap.addAp(apartment);
    }
}
