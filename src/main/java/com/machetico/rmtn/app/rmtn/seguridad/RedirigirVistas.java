package com.machetico.rmtn.app.rmtn.seguridad;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class RedirigirVistas extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
			throws IOException, ServletException{
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		if (authorities.stream().anyMatch(auth->auth.getAuthority().equals("Admin"))) {
			setDefaultTargetUrl("/Admin");
		}else if(authorities.stream().anyMatch(auth->auth.getAuthority().equals("Empleado"))) {
			setDefaultTargetUrl("/Empleado");
		}else {
			setDefaultTargetUrl("/Cliente");
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
