package davdev.mx.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import davdev.mx.controlador.entity.Cliente;
import davdev.mx.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class PruebaController {
	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		// obtener los clientes desde el DAO
		List<Cliente> losClientes = clienteDAO.getClientes();
		
		
		// AGREGAR LOS CLIENTES AL MODELO
		elModelo.addAttribute("clientes", losClientes);
		
		return "lista-clientes";
		
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model elModelo) {
		
		// bind de datos de clientes
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente", elCliente);
		
		return "formularioCliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		// inserta cliente en bbddd
		clienteDAO.insertarCliente(elCliente);		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int id, Model elModel ) {

		// obtener el cliente con el id
		Cliente elCliente = clienteDAO.getCliente(id);
		
		
		// establecer el cliente como atributo del modelo
		elModel.addAttribute("cliente", elCliente);
		
		
		// Enviar al formulario
		return "formularioCliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int id) {

		// eliminar el cliente con el id
		 clienteDAO.eliminarCliente(id);
		
		
		// redireccion a la lista de clientes
		 return "redirect:/cliente/lista";
	}
		
	
	
	
	
	@Autowired
	private ClienteDAO clienteDAO;
}
