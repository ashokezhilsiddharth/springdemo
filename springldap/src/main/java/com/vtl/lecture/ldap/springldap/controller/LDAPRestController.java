package com.vtl.lecture.ldap.springldap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtl.lecture.ldap.springldap.auth.facade.UserAuthFacade;

@RestController
public class LDAPRestController {
	@Autowired
	private UserAuthFacade userAuthFacade;

	@GetMapping("/securegreetings")
	public String secureGreetings() {
		String msg = null;
		String role = null;
		Authentication authentication = userAuthFacade.getAuthentication();
		List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) authentication.getAuthorities();
		String grantedAuthority = grantedAuthorities.get(0).getAuthority();
		if ("ROLE_VTL_LEARNERS".equals(grantedAuthority)) {
			role = "Learner";
		} else if ("ROLE_VTL_LECTURERS".equals(grantedAuthority)) {
			role = "Lecturer";
		}
		msg = "Welcome and Thanks! " + authentication.getName()  + " for joining us as " + role;
		return msg;
	}

}
