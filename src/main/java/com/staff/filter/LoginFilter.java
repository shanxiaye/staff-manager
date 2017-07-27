package com.staff.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse servletResponse = (HttpServletResponse)response;
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		String path = servletRequest.getServletPath();
		String pa = path.substring(path.lastIndexOf("/")+1);
		String ContextPath = servletRequest.getContextPath();
		String PathInfo = servletRequest.getPathInfo();
		String PathTranslated = servletRequest.getPathTranslated();
		System.out.println("ContextPath:"+ContextPath);
		System.out.println("PathInfo:"+PathInfo);
		System.out.println("PathTranslated:"+PathTranslated);
		System.out.println("path:"+path);
		System.out.println("pa:"+pa);
		if(pa.endsWith("js") || pa.endsWith("html") || pa.endsWith("css") || "/attendance.jsp".equals(path) || pa.endsWith("login") || pa.endsWith("register") || pa.endsWith("attendance") || path.contains("jquery-easyui-1.5.2")){
			chain.doFilter(request, response);
		}else{
			HttpSession session = servletRequest.getSession();
			Object name= session.getAttribute("name");
			if(name != null){
				chain.doFilter(request, response);
			}else{
				servletResponse.sendRedirect("/staff-management/attendance.jsp");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
