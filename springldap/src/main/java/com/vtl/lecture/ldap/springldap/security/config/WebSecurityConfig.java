package com.vtl.lecture.ldap.springldap.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false)
public class WebSecurityConfig {

	@Value("${spring.ldap.url}")
	private String ldapURL;

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

		/*
		 * http .authorizeHttpRequests((requests)->requests.requestMatchers("/",
		 * "/home", "/unsecuregreetings", "/authenticate") .permitAll() .anyRequest()
		 * .fullyAuthenticated() ) .formLogin();
		 */

		/*
		 * http.addFilterAfter( new LDAPUserNamePwdAuthnFilter(),
		 * UsernamePasswordAuthenticationFilter.class); return http.build();
		 */
		
		
		 /** http .httpBasic() .and()
		  .authorizeHttpRequests(
		  (requests)->requests.requestMatchers
		         ("/", "/home", "/unsecuregreetings", "/authenticate","/h2-console")
		         .permitAll()
		         .requestMatchers("/v1/api/authn").authenticated()
		         .requestMatchers("/v1/api/courses").hasAnyAuthority("ROLE_VTL_LECTURER","ROLE_VTL_TEACHER", "ROLE_VTL_TRAINER","ROLE_VTL_LEARNER")
		         .requestMatchers("/v1/api/addCourse").hasAnyAuthority("ROLE_VTL_LECTURER","ROLE_VTL_TEACHER", "ROLE_VTL_TRAINER")
		         .requestMatchers("/v1/api/deleteCourse").hasAuthority("ROLE_VTL_LECTURER")
		         .anyRequest().authenticated()
		    )
		    .csrf()
		    .disable()
		    .headers()
		    .frameOptions()
		    .disable(); **/
		 
		  http .httpBasic() .and()
		  .authorizeHttpRequests(
		  (requests)->requests.requestMatchers
		         ("/", "/home", "/unsecuregreetings", "/authenticate","/h2-console")
		         .permitAll()
		         .requestMatchers("/v1/api/authn").authenticated()
		         .requestMatchers("/v1/api/courses").hasAnyAuthority("ROLE_VTL_LECTURER","ROLE_VTL_TEACHER", "ROLE_VTL_TRAINER","ROLE_VTL_LEARNER")
		         .requestMatchers("/v1/api/addCourse").hasAnyAuthority("ROLE_VTL_LECTURER","ROLE_VTL_TEACHER", "ROLE_VTL_TRAINER")
		          .requestMatchers("/v1/api/deleteCourse").hasAuthority("ROLE_VTL_LECTURER")
		         .anyRequest().authenticated()
		    )
		    .csrf()
		    .disable()
		    .headers()
		    .frameOptions()
		    .disable();
		/*
		 * http .authorizeHttpRequests() .requestMatchers(toH2Console()) .permitAll()
		 * .anyRequest() .authenticated() .and() .csrf()
		 * .ignoringRequestMatchers(toH2Console()) .disable()
		 * .headers().frameOptions().disable();
		 */
		
		
		
		
		  
		
		  
		 
		/*
		 * http .httpBasic() .and() .authorizeHttpRequests() .anyRequest()
		 * .authenticated() .and() .csrf() .disable();
		 */
		return http.build();

	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns(userDnPatterns).groupSearchBase(groupSearchBase)
				.groupSearchFilter(groupSearchFilter).contextSource().url(ldapURL).managerDn(managerDn)
				.managerPassword(managerPassword);
	}

}
