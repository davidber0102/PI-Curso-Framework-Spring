package mx.davdev.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ObtenerPedidosCliente {

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
			//Cliente c2 = ses.get(Cliente.class, 6);
			Query<Cliente> consulta = ses.createQuery("SELEC CL FROM Cliente CL JOIN  FETCH CL.pedidos WHERE CL.id=:elClienteId", Cliente.class);
			consulta.setParameter("elClienteId", 7);
			
			Cliente c2 = consulta.getSingleResult();
			
			System.out.println("Cliente:  " + c2);
			// System.out.println("Pedidos: " + c2.getPedidos());
			
			ses.getTransaction().commit();
			System.out.println("Registro selecionados correctamente en BBDD");
			
			System.out.println("Terminado .. . . . ");
			ses.close();
			System.out.println("Pedidos: " + c2.getPedidos());
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			ses.close();
			fac.close();	
		}
	}

}
