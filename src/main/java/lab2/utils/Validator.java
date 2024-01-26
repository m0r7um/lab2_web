package lab2.utils;

import jakarta.servlet.http.HttpServletRequest;

public class Validator {
    public static boolean validateRequest(HttpServletRequest request) throws NumberFormatException {
        var X = (String) request.getParameter("x");
        var Y = (String) request.getParameter("y");
        var R = (String) request.getParameter("r");

        if (X == null || Y == null || R == null){
            return false;
        }
        if (X.isEmpty() && Y.isEmpty() && R.isEmpty()){
            return false;
        }
        return !(Double.parseDouble(Y) > 5.0) || !(Double.parseDouble(Y) < -3.0);
    }
}
