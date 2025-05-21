package mx.davdev.aop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import mx.davdev.aop.dao.ClienteDAO;
import mx.davdev.aop.dao.ClienteVIPDAO;
import mx.davdev.aop.servicios.MediconServicio;

public class ClasePrincipal {
	public static void main(String[] args) {	
		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);		
		
		// obtenr el bean del contendor de Spring
		/*ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		try {
		boolean miParam = true;		
		elCliente.encuentraCliente(miParam);
		}catch(Exception e) {
			
			System.out.println("Excepcion lanzada desde la clase principal");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		*/
		
		// VIDEO 88 MINUTO 11
		
		MediconServicio elServicio = contexto.getBean("mediconServicio", MediconServicio.class);
		
		System.out.println("Llamando al metodo getServicio()");
		
		String datos = elServicio.getServicio();
		
		System.out.println("Devolucion del metodo: " + datos);
		
		
		
			
		// cerrar el contexto
		contexto.close();
	}
}
