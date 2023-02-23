package com.vtl.lecture.ldap.springldap.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Value("${spring.ldap.url}")
	private String ldapURL;
	@Value("${spring.ldap.port}")
	private String ldapPort;

	@Value("${spring.ldap.userDnPatterns}")
	private String userDnPatterns;

	@Value("${spring.ldap.groupSearchBase}")
	private String groupSearchBase;
	@Value("${spring.ldap.groupSearchFilter}")
	private String groupSearchFilter;

	@Value("${spring.ldap.mangerDn}")
	private String managerDn;
	@Value("${spring.ldap.managerPwd}")
	private String managerPassword;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		/*
		 * http.authorizeHttpRequests((requests) -> requests.requestMatchers("/",
		 * "/home", "/unsecuregreetings")
		 * .permitAll().anyRequest().fullyAuthenticated()) .formLogin((form) ->
		 * form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());
		 */

		
		  http .authorizeHttpRequests((requests)->requests.requestMatchers("/",
		  "/home", "/unsecuregreetings") .permitAll() .anyRequest()
		  .fullyAuthenticated() ) .formLogin();
		 

		return http.build();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns(userDnPatterns).groupSearchBase(groupSearchBase)
				.groupSearchFilter(groupSearchFilter).contextSource().url(ldapURL).port(Integer.parseInt(ldapPort))
				.managerDn(managerDn).managerPassword(managerPassword);
	}

}
