package com.wbl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wbl.form.RegistrationForm;
import com.wbl.service.UserService;
import com.wbl.util.PageConstants;
import com.wbl.util.URIConstants;

@Controller
@RequestMapping(value = URIConstants.ROOT)
public class DefaultController {

	private final UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

	@Autowired
	public DefaultController(UserService userService) {
		if (userService == null) {
			throw new IllegalArgumentException("UserService cannot be null");
		}
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return PageConstants.HOME_PAGE;
	}

	@RequestMapping(value = URIConstants.REGISTRATION_PAGE, method = RequestMethod.GET)
	public String viewRegistartionPage(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return PageConstants.REGISTRATION_PAGE;
	}

	@RequestMapping(value = URIConstants.REGISTRATION_PAGE, method = RequestMethod.POST)
	public String registerUser(@Valid RegistrationForm registrationForm, BindingResult result, Model model) {

		if (!StringUtils.isEmpty(registrationForm.getEmail()) && userService.emailExists(registrationForm.getEmail())) {
			result.rejectValue("email", "user.email.exists", "Email already in Use !");
		}

		if (!result.hasErrors()) {

			this.userService.registerUser(registrationForm);
			model.addAttribute("isSuccess", true);
		}

		return PageConstants.HOME_PAGE;
	}

	@RequestMapping(value = URIConstants.ACCESS_DENIED, method = RequestMethod.GET)
	public String accessDenied(Model model) {
		return "accessdenied";
	}

	@RequestMapping(value = URIConstants.LOGIN, method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value = "error", required = false) String error) {
		model.addAttribute("msg", "THIS IS LOGIN");
		return "login";
	}

	@RequestMapping(value = URIConstants.LOGOUT, method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

}
