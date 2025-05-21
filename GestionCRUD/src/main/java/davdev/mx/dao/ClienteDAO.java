package davdev.mx.dao;

import java.util.List;

import davdev.mx.controlador.entity.Cliente;

public interface ClienteDAO {
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elCliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);

}
