package com.vtl.lecture.ldap.springldap.auth.facade;

import org.springframework.security.core.Authentication;


public interface UserAuthFacade {

	Authentication getAuthentication();
}
