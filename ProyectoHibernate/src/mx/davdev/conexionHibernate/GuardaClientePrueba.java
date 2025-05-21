package mx.davdev.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class GuardaClientePrueba {

	public static void main(String[] args) {	
		// Crear Session_Factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		// Crear OBJ Session
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			Clientes cliente1 = new Clientes("Sandra", "Morales", "Arboledas");
			ses.beginTransaction();
			ses.save(cliente1);
			ses.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			
			// lectura de registros
			ses.beginTransaction();
			System.out.println("Lectura del registro con ID: " + cliente1.getId());
			Clientes clienteInsertado = ses.get(Clientes.class, cliente1.getId());
			System.out.println("Registro: " + clienteInsertado);
			ses.getTransaction().commit();
			System.out.println("Terminado .. . . . ");
			
			ses.close();
		}finally {
			fac.close();
		}
		
		
		//Ejecutar Transaccion SQL

	}

}
