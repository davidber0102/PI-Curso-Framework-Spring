package mx.davdev.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		Session ses = fac.openSession();

		//Crea obj Clientes
		try {
			ses.beginTransaction();			
			// obtener que cliente quiero eliminar
			DetallesCliente detCliente = ses.get(DetallesCliente.class, 4);
			
			if(detCliente!=null) {
				System.out.println("Elimnado al Cliente" + detCliente.getCliente());		
				ses.delete(detCliente);
				ses.getTransaction().commit();
				System.out.println("Registros Eliminados correctamente en BBDD");		
			}	else {
				System.out.println("Sin movimientos en la BBDD .. . . . ");
				System.out.println("Terminado .. . . . ");				
			}
			ses.close();
		}finally {
			fac.close();
		}

	}

}
