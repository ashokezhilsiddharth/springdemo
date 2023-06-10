package com.vtl.lecture.ldap.springldap.auth.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vtl.lecture.ldap.springldap.auth.context.UserContext;

@Component
public class UserContextFacadeImpl implements UserContextFacade {

	@Override
	public UserContext getUserContext() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserContext userContext = new UserContext();
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			roles.add(grantedAuthority.getAuthority());
		}
		if(roles.isEmpty()) {
			roles.add("Roles Not Found");
			userContext.setRoles(roles);
		}else {
			userContext.setRoles(roles);
		}
		
		userContext.setUserName(authentication.getName());
		
		return userContext;
	}

	

}
