package mx.davdev.com.PrimerProyecto_SpringRest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages ="mx.davdev.com.PrimerProyecto_SpringRest")
public class AppConfig {

}
