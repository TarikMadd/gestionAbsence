package com.ensa.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsUtils;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	protected void configure(HttpSecurity http) throws Exception{
		 //http.csrf().disable();
		//http.authorizeRequests().anyRequest().hasRole("ADMIN");
		//http.csrf().disable().authorizeRequests();
		
		http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/api/**")
						.hasAnyRole("USER","BO")
					.antMatchers("/**")
						.hasRole("ADMIN").and()
							.csrf().disable().headers()
								.frameOptions().disable();
		/*http.cors().and().csrf().disable().httpBasic()
		.and().
        authorizeRequests()
        .antMatchers("/api/user").hasRole("ADMIN")
        .antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
        .antMatchers("/").permitAll()
        .anyRequest().authenticated()
        .and().csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		/*http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/api/**")
						.hasRole("USER")
					.antMatchers("api/**")
						.hasRole("ADMIN").and()
							.csrf().disable().headers()
								.frameOptions().disable();
		 /*
		 http  
	        .antMatcher("/")                                 
	        .authorizeRequests()  
	            .anyRequest().hasRole("ADMIN")  
	            .and()  
	        .httpBasic();  */
	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
	/*	auth.inMemoryAuthentication().passwordEncoder(
				NoOpPasswordEncoder.getInstance())
		.withUser("user").password("password1")
		.roles("USER").and().withUser("admin").password("password2")
		.roles("USER","ADMIN");*/
		auth.userDetailsService(userDetailsService).passwordEncoder(
			NoOpPasswordEncoder.getInstance());
	} 
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        //web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		 web.ignoring().requestMatchers(CorsUtils::isPreFlightRequest);
	    }
	
}
