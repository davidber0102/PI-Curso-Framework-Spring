package mx.davdev.com.SeguridadSpring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig  extends WebSecurityConfigurerAdapter {	
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(usuarios.username("David").password("987654").roles("administrador"))
		.withUser(usuarios.username("Antonio").password("3210").roles("usuario"))
		.withUser(usuarios.username("Ana").password("1234").roles("ayudante"))
		.withUser(usuarios.username("Laura").password("56789").roles("administrador"))
		.withUser(usuarios.username("Juan").password("963").roles("ayudante"));
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("David")
	        .password("DavidPass")
	        .roles("USER")
	        .build());
	    manager.createUser(User.withUsername("Juan")
	        .password("JuanAdminPass")
	        .roles("USER", "ADMIN")
	        .build());
	    manager.createUser(User.withUsername("Daniel")
		        .password("DanielPass")
		        .roles("USER")
		        .build());	    
	    manager.createUser(User.withUsername("Sandra")
		        .password("SandraPass")
		        .roles("USER")
		        .build());
	    return manager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(AbstractHttpConfigurer::disable)
	        .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
	            authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
	                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
	                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
	                .requestMatchers("/login/**").permitAll()
	                .anyRequest().authenticated())
	        .httpBasic(Customizer.withDefaults())
	        .sessionManagement(httpSecuritySessionManagementConfigurer ->
	            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	    return http.build();
	}
	
	  @Bean
	  public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring().antMatchers("/js/**", "/images/**"); 
	  }*/
}

