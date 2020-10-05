package com.team02.groupware.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
    	System.out.println("프리핸들");
    	
    	HttpSession session = request.getSession();
    	
    	String loginStatus = (String) session.getAttribute("login");
    	
    	// 세션에 로그인 정보가 없을경우
    	if(!"ok".equals(loginStatus)) {	
    		
    		response.sendRedirect("/loginPage");
    		return false;
    	}
    	
    	
		return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	System.out.println("포스트핸들");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
    	System.out.println("컴플리트핸들");
    }
}

	
	
