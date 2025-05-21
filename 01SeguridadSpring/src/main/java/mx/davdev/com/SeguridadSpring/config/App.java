package mx.davdev.com.SeguridadSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mx.davdev.com.SeguridadSpring")
public class App {
	
	@Bean
	public ViewResolver vwResolver() {
		InternalResourceViewResolver vwResolver = new InternalResourceViewResolver();
		vwResolver.setPrefix("/WEB-INF/view/");
		vwResolver.setSuffix(".jsp");
		return vwResolver;
	}
}
