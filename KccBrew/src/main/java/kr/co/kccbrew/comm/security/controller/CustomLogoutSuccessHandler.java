package kr.co.kccbrew.comm.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import kr.co.kccbrew.sysMng.alarm.controller.EchoHandler;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Authentication authentication)
					throws IOException, ServletException {
		log.info("CustomLogoutSuccessHandler.onLogoutSuccess");

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userId = userDetails.getUsername();

		Map<String, WebSocketSession> userIdSessions = EchoHandler.userIdSessions;
		Map<String, WebSocketSession> adminIdSessions = EchoHandler.adminSessions;
		userIdSessions.remove(userId);
		adminIdSessions.remove(userId);

		response.sendRedirect("/login");
	}
}
