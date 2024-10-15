package btltweb5.iosstar.filter;

import java.io.IOException;

import btltweb5.iosstar.Model.usermodel;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns="/manager/*")
public class ManagerSecurity implements Filter{
	@Override
	public void destroy( ) {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("account");
		usermodel user=(usermodel) obj;
		if(obj !=null && user.getRoleid()==3)
				{
					chain.doFilter(request, response);
					return;//
				}
				else
				{
					resp.sendRedirect(req.getContextPath()+"/login");
				}
	}

public void init(FilterConfig filterConfig) throws ServletException{
}

}

