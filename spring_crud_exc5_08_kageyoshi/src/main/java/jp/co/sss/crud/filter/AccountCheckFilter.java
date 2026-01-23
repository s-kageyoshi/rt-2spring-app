package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

public class AccountCheckFilter extends HttpFilter{
	
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException,ServletException{
		
		String requestURL = request.getRequestURI();
		
		if(requestURL.indexOf("/css/") != -1 ||
			requestURL.indexOf("/templates/") != -1 ||
			requestURL.endsWith("/") ||
			requestURL.endsWith("/login") ||
			requestURL.endsWith("/logout") ||
			requestURL.endsWith("/list")) {
			chain.doFilter(request, response);
			
		}else {
			
			HttpSession session = request.getSession();
			EmployeeBean loginUser = (EmployeeBean) session.getAttribute("loginUser");
			
			if(loginUser.getAuthority() != 2) {
				response.sendRedirect("/spring_crud/");
				return;
				
			}else {
				
				chain.doFilter(request, response);
			}
		}
	}
}
