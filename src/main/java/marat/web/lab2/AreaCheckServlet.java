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
import java.util.stream.Collectors;

@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private final Graph graph = new Graph(new Figure[]{new VoidFigure(), new Triangle(-1, 0.5), new Circle(3, 0.5), new Rectangle(1, -0.5)});

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long now = System.currentTimeMillis();
        response.setContentType("application/json");

        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));

        boolean hitResult = graph.checkHit(x, y, r);

        LocalTime currentTime = LocalTime.now();
        ResultRay ray = new ResultRay(x, y, r, hitResult, currentTime, ((double)System.currentTimeMillis() - now) / 1000);
        response.getWriter().println(ray.convertToJSON().toString());
    }
}
