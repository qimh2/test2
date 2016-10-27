package com.qimh.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EnCodeFilter implements Filter  {

	Map<String, String> params = new HashMap<String, String>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("EncodeFilter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("doFilter in......");
		
	    String encodeCoding = params.get("EncodeCoding");
	    request.setCharacterEncoding(encodeCoding);
	    response.setCharacterEncoding(encodeCoding);
	    chain.doFilter(request, response);
	    System.out.println("EncodeFilter doFilter");
		
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// TODO Auto-generated method stub
		Enumeration<String> names = cfg.getInitParameterNames();
		while (names.hasMoreElements()) {
		String name = names.nextElement();
		params.put(name, cfg.getInitParameter(name));
		}
		System.out.println("EncodeFilter init");
	}

}
