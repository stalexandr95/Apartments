package servlets;

import controller.ApController;
import entity.Apartment;
import service.SQLApDAOImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllApServlet extends HttpServlet {
    private ApController ap;

    @Override
    public void init() throws ServletException {
        super.init();
        ap = new ApController(new SQLApDAOImplementation());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Apartment> apartments = ap.getAllAp();
        req.setAttribute("apartments", apartments);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/all_aps.jsp");
        rd.forward(req, resp);
    }
}
