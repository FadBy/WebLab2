package marat.web.lab2;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import marat.web.lab2.figures.*;
import marat.web.lab2.figures.VoidFigure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private final Graph graph = new Graph(new Figure[]{new VoidFigure(), new Triangle(-1, 0.5), new Rectangle(-1, -0.5), new Circle(4, 0.5)});
    private final Logger logger = Logger.getLogger(AreaCheckServlet.class.getName());
    private final String sessionTableName = "table";

    public AreaCheckServlet() {
        logger.info("constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        logger.info("service");
    }

    @Override
    public void destroy() {
        super.destroy();
        logger.info("destroy");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long now = System.currentTimeMillis();
        response.setContentType("application/json");
        logger.info(String.format("servlet %s was called", logger.getName()));

        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));
        boolean hitResult = graph.checkHit(x, y, r);

        LocalTime currentTime = LocalTime.now();
        ResultRay ray = new ResultRay(x, y, r, hitResult, currentTime, ((double)System.currentTimeMillis() - now) / 1000);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(sessionTableName) == null) {
            session = request.getSession(true);
            session.setAttribute(sessionTableName, new ArrayList<ResultRay>());
        }
        ((List<ResultRay>)request.getSession().getAttribute("table")).add(ray);
        response.getWriter().println(ray.convertToJSON().toString());
    }
}
