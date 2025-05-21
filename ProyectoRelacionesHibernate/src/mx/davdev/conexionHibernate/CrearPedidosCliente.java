package mx.davdev.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		Session ses = fac.openSession();
		try {
			ses.beginTransaction();
			
			// Obtener el cliente de la tabla cliente de la BBDD
			Cliente c2 = ses.get(Cliente.class, 6);
			
			// crear pedido del cliente
		
			Pedido pedido1 = new Pedido( new GregorianCalendar(2020,7,5));
			Pedido pedido2 = new Pedido( new GregorianCalendar(2020,6,15) );
			Pedido pedido3 = new Pedido( new GregorianCalendar(2020,4,25) );
			
			// agregar pedidos creados al cliente creado
			c2.agregaPedidos(pedido1);
			c2.agregaPedidos(pedido2);
			c2.agregaPedidos(pedido3);
			
			// guarar los Pedidos en la BBDD en la tabla pedido
			ses.save(pedido1);
			ses.save(pedido2);
			ses.save(pedido3);
			
			ses.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			
			System.out.println("Terminado .. . . . ");
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			ses.close();
			fac.close();	
		}
	}

}
