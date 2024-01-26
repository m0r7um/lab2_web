package lab2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab2.models.Point;
import lab2.utils.BuildPointFromRequest;
import lab2.utils.ErrMessagePrinter;
import lab2.utils.Validator;

import java.io.IOException;

@WebServlet(value="/server/*")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            if (Validator.validateRequest(request)) {
                Point point = BuildPointFromRequest.build(request);
                request.setAttribute("point", point);
                request.getRequestDispatcher("/server/checker").forward(request, response);
            }
        } catch (Exception e) {
            ErrMessagePrinter.print(response, e.getMessage());
        }
    }
}
