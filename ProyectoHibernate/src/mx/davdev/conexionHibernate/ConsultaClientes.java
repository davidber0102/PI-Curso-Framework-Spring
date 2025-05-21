package mx.davdev.conexionHibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	public static void main(String[] args) {
			SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();				
			Session ses = fac.openSession();
			
			try {
				// Comenzar sesion
				ses.beginTransaction();
				
				// Consulta de Clientes
				System.out.println(" BBDD");
				
				// lectura de registros
				List<Clientes> losclientes = ses.createQuery("from Clientes").getResultList();
				// mostrat los clientes
				
				ReccorreClientesConsultados(losclientes);
				System.out.println("Buscando .. . . . ");
				// dame los que se apellida gomez
				 losclientes = ses.createQuery("from Clientes cl where cl.apellidos = 'Gomez' ").getResultList();
				 ReccorreClientesConsultados(losclientes);		
					
				///muestra los que vvien en Toollocan o se apellida Diaz
					System.out.println("Buscando .. . . . ");
					 losclientes = ses.createQuery("from Clientes cl where cl.apellidos = 'Diaz'"
					 		+ "or cl.direccion= 'Toollocan'").getResultList();
						ReccorreClientesConsultados(losclientes);
				
				//commit
					ses.getTransaction().commit();
				
				System.out.println("Terminado .. . . . ");
				ses.close();
			}finally {
				fac.close();
			}

	}

	private static void ReccorreClientesConsultados(List<Clientes> losclientes) {
		for(Clientes c:losclientes) {
			System.out.println("BBdd:" + c);
		}
	}

}
