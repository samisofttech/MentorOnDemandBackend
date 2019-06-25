package com.iiht.mentor.userprofile.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ServerSecurityConfigurer extends WebSecurityConfigurerAdapter
{

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/signup").permitAll().and()
				.authorizeRequests().antMatchers("/**").permitAll().and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().and().authorizeRequests()
				.antMatchers("/webjars/**", "/swagger-ui.html", "/swagger-resources", "/v2/api-docs").permitAll()
				.anyRequest().authenticated().and().sessionManagement().and().csrf().disable();
	}

}