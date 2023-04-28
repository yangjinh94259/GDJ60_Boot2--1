package com.iu.base.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserSuccessHandler implements AuthenticationSuccessHandler{

	@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
		
			log.error("===========Login 성공 후 실행===========");
			
			String remember = request.getParameter("remember");
			
			log.error("=========={}==========", remember);
			
			if(remember != null && remember.equals("remember")) {
				Cookie cookie = new Cookie("remember",authentication.getName());
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
				
			}
			else {
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("remember")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
	
			response.sendRedirect("/");
			
	}
}
