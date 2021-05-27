package com.mcit.webapp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/hello")
public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("--- Destory Filter ---");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// filter logic
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// get print writer 
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(email.equals("admin@gmail.com")) {
			if(password.equals("admin@123")) {
				chain.doFilter(request, response);
			} else {
				out.println("<h2 style='color:red'> Invalid Password </h2>");
			}			
			
		} else {
			out.println("<h2 style='color:red'> User not found with email "+email +"</h2>");
			out.println("<p> Hint : email -> admin@gmail.com </p>");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("--- Initialize Filter ---");
	}

}
