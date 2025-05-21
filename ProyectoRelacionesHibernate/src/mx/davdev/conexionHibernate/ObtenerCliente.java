package mx.davdev.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			ses.beginTransaction();			
			// obtener DetallesCliente
			DetallesCliente  detCliente = ses.get(DetallesCliente.class, 1);
			System.out.println(detCliente);	
			System.out.println(detCliente.getCliente());	
			
			System.out.println("Ahora vamos a eliminar en cascada..... .. . . . ");	
			ses.delete(detCliente);
	
			ses.getTransaction().commit();


				System.out.println("Terminado .. . . . ");				
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			ses.close();
			fac.close();
		}
	}

}
