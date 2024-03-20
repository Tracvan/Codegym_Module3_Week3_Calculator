import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalulateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        double firstOperand = Double.parseDouble(req.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(req.getParameter("secondOperand"));
        double result = 0;
        String op = "";
        if (firstOperand != 0 && secondOperand != 0) {
            String operator = req.getParameter("operator");
            switch (operator) {
                case "addition":
                    result = firstOperand + secondOperand;
                    op="+";
                    break;
                case "subtraction":
                    result = firstOperand - secondOperand;
                    op="-";
                    break;
                case "multiplication":
                    result = firstOperand * secondOperand;
                    op="*";
                    break;
                case "division":
                    result = firstOperand / secondOperand;
                    op="/";
                    break;
            }
        } else {
            out.println("Operand can not be 0");
        }
        req.setAttribute("result", result);
        req.setAttribute("firstOperand", firstOperand);
        req.setAttribute("secondOperand", secondOperand);
        req.setAttribute("operator",op);

        RequestDispatcher dispatcher = req.getRequestDispatcher("calculate.jsp");
        dispatcher.forward(req, resp);
    }
}
