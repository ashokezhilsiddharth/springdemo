package com.vtl.springldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.vtl.authentication.ldap.HomeController;

@SpringBootApplication
@ComponentScan(basePackageClasses = HomeController.class)
public class SpringLdapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLdapApplication.class, args);
	}

}
