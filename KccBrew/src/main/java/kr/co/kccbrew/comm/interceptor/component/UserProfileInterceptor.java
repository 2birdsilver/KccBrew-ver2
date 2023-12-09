package kr.co.kccbrew.comm.interceptor.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import kr.co.kccbrew.comm.security.controller.CustomAuthenticationSuccessHandler;
import kr.co.kccbrew.comm.security.model.UserVo;

public class UserProfileInterceptor extends Interceptor{
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;

	@Override
	public boolean preHandle(HttpServletRequest request, 
															HttpServletResponse response, 
															Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			UserVo user = (UserVo) session.getAttribute("user");

			/*사용자 프로필 업데이트*/
			successHandler.SaveTasksInSessions(session, user);
		}
		return true;
	}
}
