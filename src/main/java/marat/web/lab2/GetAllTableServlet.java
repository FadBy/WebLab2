package marat.web.lab2;

import com.google.gson.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "GetAllTableServlet", value = "/GetAllTableServlet")
public class GetAllTableServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(GetAllTableServlet.class.getName());
    private final String sessionTableName = "table";

    public GetAllTableServlet() {
        logger.info("constructor");
    }

    @Override
    public void init() throws ServletException {
        logger.info("init");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("service");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        logger.info("destroy");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        logger.info(String.format("servlet %s was called", logger.getName()));
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(sessionTableName) == null) {
            session = request.getSession(true);
            session.setAttribute(sessionTableName, new ArrayList<ResultRay>());
        }
        JsonArray json = new JsonArray();
        for (ResultRay ray : (List<ResultRay>) session.getAttribute(sessionTableName)) {
            json.add(ray.convertToJSON());
        }
        logger.info(String.format("session[\"table\"] = %s", json));
        response.getWriter().println(json.toString());

    }
}
