package scb.ot.dashboard.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import scb.ot.dashboard.config.AuthenticationInterceptor;
import scb.ot.dashboard.entity.User;
import scb.ot.dashboard.service.UserService;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	private final String SUCCESS = "forward:/";
	private final String REDIRECT = "redirect:/login";
	private final String LOGIN = "login";

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String userId, @RequestParam("password") String password, HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute(AuthenticationInterceptor.SESSION_KEY) != null) {
			return SUCCESS;
		}

		User user = findUser(userId, password);
		if (null != user) {
			session.setAttribute(AuthenticationInterceptor.SESSION_KEY, user);
			logger.info(user + " loggin successfully");
			return SUCCESS;
		}

		attributes.addFlashAttribute("error", "Login failed");
		return REDIRECT;
	}

	@GetMapping("/login")
	public String login() {
		return LOGIN;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(AuthenticationInterceptor.SESSION_KEY);
		return LOGIN;
	}

	private User findUser(String userId, String password) {
		return userService.findUserByUserIdAndPassword(userId, password);
	}

}
