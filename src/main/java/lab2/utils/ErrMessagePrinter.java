package lab2.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ErrMessagePrinter {
    public static void print(HttpServletResponse response, String message) {
        response.setStatus(400);
        response.setContentType("application/json");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.print(
                    new HashMap<>() {{
                        put("error", message);
                    }}
            );
            printWriter.flush();
        } catch (IOException ignored) {

        }
    }
}
