import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/method")
public class MyServlet extends HttpServlet {

    /**
     * Метод GET
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        req.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/method.jsp")
                .forward(req, resp);
    }

    /**
     * Метод POST
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        req.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/method.jsp")
                .forward(req, resp);
    }

    /**
     * Метод PUT
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        req.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/method.jsp")
                .forward(forwardReq(req), resp);
    }

    /**
     * Метод DELETE
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        req.setAttribute("method", method);

        getServletContext()
                .getRequestDispatcher("/method.jsp")
                .forward(forwardReq(req), resp);
    }

    /**
     * Подменяет запрос на GET
     */
    private ServletRequest forwardReq(HttpServletRequest req) {
        return new HttpServletRequestWrapper(req) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
    }
}
