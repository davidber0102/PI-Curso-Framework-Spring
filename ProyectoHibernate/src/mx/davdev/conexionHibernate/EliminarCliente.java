package mx.davdev.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class EliminarCliente {
	public static void main(String[] args) {	
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			ses.beginTransaction();
			ses.createQuery("delete Clientes where Direccion = 'Arboledas' ").executeUpdate();
			
			ses.getTransaction().commit();
			System.out.println("Registros Eliminados correctamente en BBDD");
			

			System.out.println("Terminado .. . . . ");
			
			ses.close();
		}finally {
			fac.close();
		}
		
		
		//Ejecutar Transaccion SQL

	}

}
