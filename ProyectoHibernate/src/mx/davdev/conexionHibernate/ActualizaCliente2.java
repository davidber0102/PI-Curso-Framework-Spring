package mx.davdev.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class ActualizaCliente2 {
	public static void main(String[] args) {	
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			ses.beginTransaction();
			ses.createQuery("update Clientes set Apellidos = 'Dominguez' where Apellidos LIKE 'D%' ").executeUpdate();
			
			ses.getTransaction().commit();
			System.out.println("RegistroS ActualizadoS correctamente en BBDD");
			

			System.out.println("Terminado .. . . . ");
			
			ses.close();
		}finally {
			fac.close();
		}
		
		
		//Ejecutar Transaccion SQL

	}

}
