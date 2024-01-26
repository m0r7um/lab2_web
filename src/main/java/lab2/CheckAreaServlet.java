package lab2;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lab2.models.Point;
import lab2.models.Points;
import lab2.utils.AddToSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/server/checker")
public class CheckAreaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            AddToSession.add(request);
            /*Point p = ((Points) request.getSession().getAttribute("points")).getPoints().get(0);
            PrintWriter w = response.getWriter();
            w.write(String.valueOf(p.getY()) + p.getX() + p.getR());*/
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception ignored) {
            /*PrintWriter writer = response.getWriter();*/
            /*writer.write(ignored.toString());
            writer.flush();*/
        }
    }
}
