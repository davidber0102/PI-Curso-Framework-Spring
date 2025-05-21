package mx.davdev.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		Session ses = fac.openSession();
		try {
			Cliente cliente1 = new Cliente("Daniel", "lopez", "Calle 1");
			DetallesCliente dcliente1 = new DetallesCliente("www.gg.com", "0022325", "Tercer Cliente");
			// Asociar los objetos
			cliente1.setDc(dcliente1);
			
			ses.beginTransaction();
			// se guarda la informacion en las dos talas relacionadas
			ses.save(cliente1);
			ses.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			
			System.out.println("Terminado .. . . . ");
			
			ses.close();

		}finally {
			fac.close();
		}
		

	}

}
