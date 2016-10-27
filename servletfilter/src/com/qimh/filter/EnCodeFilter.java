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
	 * Servlet���������ٹ�����ʵ��ǰ���ø÷�����
	 * �ڸ÷������ͷ�Servlet������ռ�õ���Դ��
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("EncodeFilter destroy");
	}

	/**
	 * �÷������ʵ�ʵĹ��˲��������ͻ������󷽷������������ƥ���URLʱ��
	 * Servlet�������ȵ��ù�������doFilter������
	 * FilterChain�û����ʺ�����������
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
	 * web Ӧ�ó�������ʱ��web ������������Filter ��ʵ������
	 * ��������init��������ȡweb.xml���ã���ɶ���ĳ�ʼ�����ܣ�
	 * �Ӷ�Ϊ�������û������������ص�׼��������filter����ֻ�ᴴ��һ�Σ�init����Ҳֻ��ִ��һ�Σ���
	 * ������Աͨ��init�����Ĳ������ɻ�ô���ǰfilter������Ϣ��FilterConfig����
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
