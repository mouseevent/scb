package scb.ot.dashboard.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	public final static String SESSION_KEY = "SESSION_KEY";
	private static Logger logger = Logger.getLogger(AuthenticationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_KEY) != null)
			return true;
		String url = "/login";
		logger.info("redirecting");
		response.sendRedirect(url);
		return false;
	}
}