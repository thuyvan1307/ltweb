package btltweb5.iosstar.Controller;


import java.io.IOException;
import btltweb5.iosstar.Model.usermodel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session= req.getSession();
	    if(session != null && session.getAttribute("account") != null) {
	        usermodel u=(usermodel) session.getAttribute("account");
	        req.setAttribute("username", u.getUsername());
	        req.setAttribute("password", u.getPassword());
	        req.setAttribute("email", u.getEmail());
	        req.setAttribute("fullname", u.getFullname());
	        req.setAttribute("phone", u.getPhone());
	    } 
	    
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
	
	} 	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 

	}
	
	
}