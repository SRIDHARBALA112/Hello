package com.springboot;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
public class Myappconfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("sam").password(("{noop}sam")).authorities("Admin");
		auth.inMemoryAuthentication().withUser("john").password(("{noop}john")).authorities("Employee");
		auth.inMemoryAuthentication().withUser("guru").password(("{noop}guru")).authorities("Student");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		//URL Access Details
       .antMatchers("/home").permitAll()
       .antMatchers("/welcome").authenticated()
       .antMatchers("/admin").hasAuthority("Admin")
       .antMatchers("/employee").hasAuthority("Employee")
       .antMatchers("/student").hasAuthority("Student")
       .antMatchers("/common").hasAnyAuthority("Admin","Employee")
       //.anyRequest().permitAll() or authenticated or hasAuthority
       .anyRequest().permitAll()
		
		//Login Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)
		//Logout Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//Exception Details
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");
       
		
				
	}
	

}
