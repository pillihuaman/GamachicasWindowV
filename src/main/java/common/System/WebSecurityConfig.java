package common.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;    
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;    
@EnableWebSecurity    
@ComponentScan("common.System")    
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {    
 
	/*@Bean    
  public UserDetailsService userDetailsService() {    
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();    
      manager.createUser(User.withDefaultPasswordEncoder()  
      .username("admin").password("123").roles("ADMIN").build());    
      return manager;    
  }  */
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	      throws Exception {
		  auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
          .withUser("user").password("123").roles("USER").and()
          .withUser("admin").password("123").roles("USER", "ADMIN");
	    }
	
	  
  @Override    
  protected void configure(HttpSecurity http) throws Exception {    
	  http    .authorizeRequests()
      //.antMatchers("/pages/**", "/registration", "/app.html").permitAll()
	  .antMatchers("/","/static/**","/pages/**").permitAll()
	  .anyRequest().authenticated()
      .and()
      .formLogin()
      //.loginPage("/login")
      .permitAll()
      .and()
      .logout()
      .permitAll();
	  
	
        
  }    
}    