package btltweb5.iosstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import btltweb5.iosstar.Service.IuserService;
import btltweb5.iosstar.Service.implement.userServiceImplement;
import btltweb5.iosstar.Utils.Constant;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")

public class RegisterController extends HttpServlet {

	IuserService service = new userServiceImplement();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String alertMsg = "";
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
			}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
			}
			boolean isSuccess = service.register(username, password, email, fullname, phone);
					if (isSuccess) {
					
					req.setAttribute("alert", alertMsg);
					resp.sendRedirect(req.getContextPath() + "/login");
					} else {
					alertMsg = "System error!";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
					}
			}
	
					
}
