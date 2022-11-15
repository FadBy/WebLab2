package marat.web.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(value = "/*")
public class CorrectUriFilter implements Filter {
    private final Logger logger = Logger.getLogger(CorrectUriFilter.class.getName());
    private final String AreaCheckServletUri = "/lab2_Web_exploded/AreaCheckServlet";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;
        if (httpRequest.getRequestURI().equals("/lab2_Web_exploded/AreaCheckServlet")) {
            logger.info("Main Filter hide unavailable servlet - AreaCheckServlet");
            httpResponse.sendError(404, "Not Found");
            return;
        }
        chain.doFilter(request, response);
    }
}
