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

/**
 * Servlet Filter implementation class VisitCountFilter
 */
@WebFilter("/hello")
public class VisitCountFilter implements Filter {

	static int count = 0;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("--- Destory Filter ---");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		++count ;
		out.print("<h1> Total visits : "+count +" </h1>");
		chain.doFilter(request, response);
		out.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--- InIT Filter ---");
	}

}
