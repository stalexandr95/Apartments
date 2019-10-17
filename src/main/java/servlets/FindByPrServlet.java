package servlets;

import controller.ApController;
import entity.Apartment;
import service.SQLApDAOImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindByPrServlet extends HttpServlet {
    private ApController ap;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        ap = new ApController(new SQLApDAOImplementation());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float from = Float.parseFloat(req.getParameter("from"));
        float to = Float.parseFloat(req.getParameter("to"));
        List<Apartment> apartments = ap.findbyPrice(from,to);
        req.setAttribute("apartmentsByPrice", apartments);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/apartments_by_price.jsp");
        rd.forward(req,resp);
    }
}
