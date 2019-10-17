package servlets;

import controller.ApController;
import service.SQLApDAOImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelApServlet extends HttpServlet {
    private ApController ap;

    @Override
    public void init() throws ServletException {
        super.init();
        ap = new ApController(new SQLApDAOImplementation());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ap.delAp(id);
        resp.sendRedirect("/index.jsp");
    }
}
