package mx.davdev.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {	
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nombre, String apellido, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ "]";
	}
	
	public DetallesCliente getDc() {
		return dc;
	}

	public void setDc(DetallesCliente dc) {
		this.dc = dc;
	}

	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void agregaPedidos(Pedido elPedido) {
		if(pedidos==null) pedidos = new ArrayList<>();
		pedidos.add(elPedido);
		elPedido.setCliente(this);
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private DetallesCliente dc;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {CascadeType.MERGE  , CascadeType.DETACH  , CascadeType.PERSIST  , CascadeType.REFRESH})
	private List<Pedido> pedidos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
}
