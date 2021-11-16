package springstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springstore.service.AuthService;

@Controller
@RequestMapping("login")
public class AuthController {

	@Autowired
	public AuthService authService;
	
	@GetMapping
	public String authDefault() {
		return "login";
	}

	@GetMapping(params = { "logout" })
	public String authorization(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(name = "logout") String logout) {
		HttpSession session = request.getSession();
		session.setAttribute("authorized", null);

		return "login";
	}

	@PostMapping(params = { "login", "password" })
	public String logIn(HttpServletRequest request, 
			ModelMap modelMap, 
			@RequestParam(name = "login") String login,
			@RequestParam(name = "password") String password) {
		
		String userName = null;
		String result;
		HttpSession session = request.getSession();
		String loginFromSession = (String) session.getAttribute("authorized");
		userName = authService.checkLogin(login, password);

		if (userName != null) {
			result = userName;
			session.setAttribute("authorized", userName);
			loginFromSession = userName;
		} else {
			result = "Acces denied";
		}
		modelMap.addAttribute("result", result);

		return "login";
	}

}
