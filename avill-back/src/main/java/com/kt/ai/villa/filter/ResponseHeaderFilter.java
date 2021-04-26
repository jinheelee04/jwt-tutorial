package com.kt.ai.villa.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
@Component
public class ResponseHeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServleteResposne = (HttpServletResponse) response;
		httpServleteResposne.setHeader("Content-Type", "application/json;charset=UTF-8");

		chain.doFilter(request, response);
	}

}
