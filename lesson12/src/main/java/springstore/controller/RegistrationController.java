package springstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springstore.service.RegistrationService;


@Controller
@RequestMapping("registration")
public class RegistrationController {
	private List<String> errorText;
	private String result ;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping
	public String registrationDefault() {
		return "registration";
	}
	
	@PostMapping(params = {
			"name",
			"email",
			"password",
			"passwordRepeat",
			"gender",
			"region",
			"comment",
			"browser"		
	}) 
	public String registration(ModelMap modelMap,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "passwordRepeat") String passwordRepeat,
			@RequestParam(name = "gender") String gender,
			@RequestParam(name = "region") String region,
			@RequestParam(name = "comment") String comment,
			@RequestParam(name = "browser") String browser) {
		
		
		errorText = registrationService.getErrorList(name, email, password, passwordRepeat, gender, region, comment, browser);
		
		if(errorText.isEmpty()) {

		result = registrationService.registrated(name, email, passwordRepeat, gender, region, comment);
		}
		modelMap.addAttribute("errorText", errorText);
		modelMap.addAttribute("result", result);
		
		
		return "registration";
	}
	

}
