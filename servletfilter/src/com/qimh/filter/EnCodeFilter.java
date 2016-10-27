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
	
	/**
	 * Servlet容器在销毁过滤器实例前调用该方法，
	 * 在该方法中释放Servlet过滤器占用的资源。
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("EncodeFilter destroy");
	}

	/**
	 * 该方法完成实际的过滤操作，当客户端请求方法与过滤器设置匹配的URL时，
	 * Servlet容器将先调用过滤器的doFilter方法。
	 * FilterChain用户访问后续过滤器。
	 */
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

	/**
	 * web 应用程序启动时，web 服务器将创建Filter 的实例对象，
	 * 并调用其init方法，读取web.xml配置，完成对象的初始化功能，
	 * 从而为后续的用户请求作好拦截的准备工作（filter对象只会创建一次，init方法也只会执行一次）。
	 * 开发人员通过init方法的参数，可获得代表当前filter配置信息的FilterConfig对象。
	 */
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
