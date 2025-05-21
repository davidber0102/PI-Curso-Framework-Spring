package mx.davdev.com.SeguridadSpring.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;
import javax.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mx.davdev.com.SeguridadSpring")
@PropertySource("classpath:persistencia-mysql.properties")
public class App {
	
	@Autowired
	private Environment env;
	
	// ---------- sistema de log para revisiones
	private Logger miLogger = Logger.getLogger(getClass().getName());
	
	
	@Bean
	public ViewResolver vwResolver() {
		InternalResourceViewResolver vwResolver = new InternalResourceViewResolver();
		vwResolver.setPrefix("/WEB-INF/view/");
		vwResolver.setSuffix(".jsp");
		return vwResolver;
	}
	
	// definir bean para seguridad
	
	// video 105 minuto 15
	@Bean
	public DataSource seguridadDatasource() {		
		// crear el pool de conexxiones
		ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();
		
		// establecer el driver en el jdbc
		try {
			seguridadDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// hacer log con las propiedades de conexion
		miLogger.info("URL de la BBDD: " + env.getProperty("jdbc.url"));
		miLogger.info("UUsiario conectadp a la BBDD: " + env.getProperty("jdbc.user"));
				
		// establecer propiedades de conexion con BBDD
		seguridadDataSource.setJdbcUrl(env.getProperty("jdbc.url"));		
		seguridadDataSource.setUser(env.getProperty("jdbc.user"));		
		seguridadDataSource.setPassword(env.getProperty("jdbc.password"));		
		
		// establecer las propiedades del pool de conexiones
		seguridadDataSource.setInitialPoolSize(getPropPool("connection.pool.initialPoolSize"));
		seguridadDataSource.setMinPoolSize(getPropPool("connection.pool.minPoolSize"));
		seguridadDataSource.setMaxPoolSize(getPropPool("connection.pool.maxPoolSize"));
		seguridadDataSource.setMaxIdleTime(getPropPool("connection.pool.maxIdleTime"));
		
		
		return seguridadDataSource;
	}
	
	private int getPropPool(String nombreProp) {
		String propVal = env.getProperty(nombreProp);
		int propPool = Integer.parseInt(propVal);
		return propPool;
		
	}
}
