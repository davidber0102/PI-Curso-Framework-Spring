package mx.davdev.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

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
			Cliente elCliente = ses.get(Cliente.class, 2);
			
			if(elCliente!=null) {
				System.out.println("Elimnado al Cliente" + elCliente.getNombre());		
				ses.delete(elCliente);
				ses.getTransaction().commit();
				System.out.println("Registros Eliminados correctamente en BBDD");		
			}	else {
				System.out.println("Sin movimientos en la BBDD .. . . . ");
				System.out.println("Terminado .. . . . ");				
			}
		//	ses.createQuery("delete Clientes where Direccion = 'Arboledas' ").executeUpdate();
			ses.close();
		}finally {
			fac.close();
		}

	}

}
