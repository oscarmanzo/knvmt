package com.kuehne.nagel.knvmt.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kuehne.nagel.knvmt.config.Constants;

@WebFilter(	filterName = "SecurityFilter",
			urlPatterns = {"view/*"})
public class SecurityFilter implements Filter {

	private static final String URL_LOGIN = "login";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	@Override
	public void destroy(){}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest request 		= (HttpServletRequest) req;
		HttpServletResponse response 	= (HttpServletResponse) resp;
		HttpSession session 			= request.getSession();
		
		UserLogged userLogged = (UserLogged)session.getAttribute(Constants.USER_SESSION);
		
		String url = request.getRequestURI();
		
		System.out.println("SecurityFilter.doFilter: "+ url);
		
		if (userLogged==null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(URL_LOGIN);
			dispatcher.forward(req, resp);
			return;	
		}
		
		chain.doFilter(request, response);
		return;
	}

}
