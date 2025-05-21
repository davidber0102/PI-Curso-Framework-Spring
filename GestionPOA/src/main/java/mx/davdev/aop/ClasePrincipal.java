package mx.davdev.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mx.davdev.aop.dao.ClienteDAO;
import mx.davdev.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {
	public static void main(String[] args) {		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);		
		
		// obtenr el bean del contendor de Spring
		ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteVIPDAO elClienteVIP = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
		
		// llamasr al metodo
		Cliente cl1 = new Cliente();
			elCliente.insertaCliente(cl1);  // ESTE ES L NOMBRE DEL METODO QUE DEBE DE COICIDIR CON LA ANOTACION @Before
			elClienteVIP.insertaCliente();  // ESTE ES L NOMBRE DEL METODO QUE DEBE DE COICIDIR CON LA ANOTACION @Before
		
		// cerrar el contexto
		contexto.close();
	}
}
