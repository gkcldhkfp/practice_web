package com.itwill.lab04.filter;

import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter extends HttpFilter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -5280907575951483552L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public SecondFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SecondFilter::doFilter() 호출 전");
		
		chain.doFilter(request, response);
		
		System.out.println("SecondFilter::doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
