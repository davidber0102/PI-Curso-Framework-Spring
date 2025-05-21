package mx.davdev.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class ActualizaCliente {

	public static void main(String[] args) {	
		// Crear Session_Factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		// Crear OBJ Session
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			int clientId=1 ;
			ses.beginTransaction();
			Clientes c2 =  ses.get(Clientes.class, clientId);
			c2.setNombre("Jorge");
			c2.setApellidos("Aceves");
			
			ses.getTransaction().commit();
			System.out.println("Registro Actualizado correctamente en BBDD");
			

			System.out.println("Terminado .. . . . ");
			
			ses.close();
		}finally {
			fac.close();
		}
		
		
		//Ejecutar Transaccion SQL

	}

}
