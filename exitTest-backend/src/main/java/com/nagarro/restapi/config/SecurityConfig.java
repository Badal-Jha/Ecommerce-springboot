package com.nagarro.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import com.nagarro.restapi.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	//authentication
	
	@Bean
	public UserDetailsService userDetailsService() {

		//using own UserDetails Service
		
		return new MyUserDetailsService();
	}
	
	//authorization
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
         .authorizeHttpRequests(authorize -> {authorize
             .requestMatchers("/user/login","/authenticate","/user/register","/products/**","/login","/reviews/**","/stats","/admin/**").permitAll();
             authorize.requestMatchers("/user").hasRole("USER");
             authorize.requestMatchers("/admin").hasRole("ADMIN");
             authorize.anyRequest().authenticated();
         } )
         .formLogin(Customizer.withDefaults()
         )
         .csrf().disable();
		
//		 return http.csrf().disable()
//	                .authorizeHttpRequests()
//	                .requestMatchers("/register").permitAll()
//	                .and()
//	                .authorizeHttpRequests().requestMatchers("/products/**")
//	                .authenticated().and().formLogin().and().build();
		
//		 http
//         .authorizeHttpRequests(authorize -> {authorize
//             .requestMatchers("/").permitAll();
//             authorize.anyRequest().authenticated();
//            
//         } )
//         .formLogin(Customizer.withDefaults()
//         )
//         .rememberMe(Customizer.withDefaults());

     return http.build();
         


		}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
//
//	   @Bean
//	    public AuthenticationProvider authenticationProvider(){
//	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//	        authenticationProvider.setUserDetailsService(userDetailsService());
//	        authenticationProvider.setPasswordEncoder(passwordEncoder());
//	        return authenticationProvider;
//	    }
	  @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
}