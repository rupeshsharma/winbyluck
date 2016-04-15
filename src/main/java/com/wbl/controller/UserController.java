package com.wbl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wbl.form.UserProfileForm;
import com.wbl.util.PageConstants;
import com.wbl.util.URIConstants;

@Controller
@RequestMapping(value = URIConstants.USER)
public class UserController {

	@RequestMapping(value = URIConstants.VIEW_PROFILE, method = RequestMethod.GET)
	public String viewProfilePage(Model model) {
		return PageConstants.VIEW_PROFILE_PAGE;
	}

	@RequestMapping(value = URIConstants.EDIT_PROFILE, method = RequestMethod.GET)
	public String viewEditProfilePage(Model model) {

		model.addAttribute("userProfileForm", new UserProfileForm());

		return PageConstants.EDIT_PROFILE_PAGE;
	}

	@RequestMapping(value = URIConstants.EDIT_PROFILE, method = RequestMethod.POST)
	public String editProfilePage(UserProfileForm userProfileForm, Model model) {

		return PageConstants.EDIT_PROFILE_PAGE;
	}

}
