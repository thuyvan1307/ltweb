package btltweb5.iosstar.Controller;

import java.io.IOException;
import btltweb5.iosstar.Model.usermodel;
import btltweb5.iosstar.Service.IuserService;
import btltweb5.iosstar.Service.implement.userServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/forgotpassword"})

public class ForgotPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IuserService service = new userServiceImplement();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		 String alertMsg="";
		  if (service.checkExistEmail(email)) {
				service.updatePassword(email, "2"); 	
		  }
		  else
		  {
			  alertMsg = "Tài khoản hoặc Email không tồn tại";
		  }
		  req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);

	}
	
}