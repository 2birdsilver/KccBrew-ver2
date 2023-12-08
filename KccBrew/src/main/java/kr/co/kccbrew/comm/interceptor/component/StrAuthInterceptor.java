package kr.co.kccbrew.comm.interceptor.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class StrAuthInterceptor extends Interceptor { 
	/**
	 * 클라이언트 요청을 컨트롤러에 전달 전
	 * 세션 값, 계정 권한 체크
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object userId=session.getAttribute("userTypeCd");
		if(!userId.equals("02")) {
			System.out.println(request.getContextPath());
			System.out.println(userId);
			if(userId.equals("03")) {
				response.sendRedirect(request.getContextPath()+"mechanicMain");
			}else if(userId.equals("01")) {
				System.out.println(request.getContextPath());
				System.out.println(userId);
				response.sendRedirect(request.getContextPath()+"adminMain");
			}
			return false;
		}
		return true;
	}
	/**
	 * API 접근한 IP 세션에 저장
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		String ip = getClientIp(request);
		session.setAttribute("userIp", ip);
	}
}