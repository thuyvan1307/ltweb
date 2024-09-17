package ltwebct5.iotstar.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltwebct5.iotstar.Config.DBConnectMySQL;

/**
 * Servlet implementation class test
 */
@WebServlet("/dbtest")

public class test extends HttpServlet {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DBConnectMySQL.getDatabaseConnection()) {
            if (connection != null) {
                response.getWriter().println("Database connection established successfully.");
            } else {
                response.getWriter().println("Failed to establish database connection.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database connection failed", e);
        }
    }
}
