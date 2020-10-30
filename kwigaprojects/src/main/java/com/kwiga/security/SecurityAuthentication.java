package com.kwiga.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kwiga.service.Credentialservice;

@EnableWebSecurity
@Configuration
public class SecurityAuthentication extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	PasswordEncoder PasswordEncoder;
	
	@Autowired
	Credentialservice credentialservice;
	
	@Autowired
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// first way of using inMemoryAuthentication
		/*
		auth.inMemoryAuthentication()
		.withUser("masengesho")
		.password("{noop}masengesho")
		.roles("user-role");
		*/
		
		/*
		//second way of using inMemoryAuthentication
		auth.inMemoryAuthentication()
		.withUser("peter")
		.password(PasswordEncoder.encode("123456789"))
		.roles("user-role");
		*/
		
		//auth.userDetailsService(this.credentialservice);
		
		//auth.authenticationProvider(daoAuthenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//http.authorizeRequests().antMatchers("/user**");
		http.cors().and().csrf().disable();
	}
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(getpasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.credentialservice);
		
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder getpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
}
