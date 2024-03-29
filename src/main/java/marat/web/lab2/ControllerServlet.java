package marat.web.lab2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(ControllerServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        logger.info(String.format("servlet %s was called", logger.getName()));
        logger.info(request.getQueryString());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AreaCheckServlet");
        logger.info("forward to \"\"/AreaCheckServlet\"\"");
        dispatcher.forward(request, response);
    }
}
