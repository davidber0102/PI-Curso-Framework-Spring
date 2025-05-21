package davdev.mx.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import davdev.mx.controlador.entity.Cliente;

@Repository
public class ClienteDAOclase implements ClienteDAO {

	@Override
	@Transactional
	public List<Cliente> getClientes() {
	
		// obetner la session
		Session sesion = sessionFactory.getCurrentSession();
		
		// crear la consulta(Query)
		Query<Cliente> mq = sesion.createQuery("from Cliente", Cliente.class);
		
		// ejecutar la query y devolver resultados
		List<Cliente> clientes = mq.getResultList();
		return clientes;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		// obetner la session
		Session sesion = sessionFactory.getCurrentSession();
		
		// Inserta el cliente
		//sesion.save(elCliente);
		sesion.saveOrUpdate(elCliente);
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		// obtener la sesion
		Session sesion = sessionFactory.getCurrentSession();
		
		// obtener la infoirmaicon del clienter seleccionado por id
		Cliente elCliente = sesion.get(Cliente.class, id);
		
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		// obtener la sesion
		Session sesion = sessionFactory.getCurrentSession();
		
		// borrar el cliente de la bbdd utilizando como criterio su id correspondiene
		Query consulta = sesion.createQuery("delete from Cliente where id=:IdDelCliente");
		
		consulta.setParameter("IdDelCliente", id);
		
		consulta.executeUpdate();
		
	}

}
