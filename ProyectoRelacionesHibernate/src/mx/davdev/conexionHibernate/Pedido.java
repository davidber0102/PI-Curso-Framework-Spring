package mx.davdev.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;


@Entity
@Table(name="pedido")
public class Pedido {
	
	public Pedido() {
		super();
	}

	public Pedido(GregorianCalendar fecha) {
		super();
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + ", cliente=" + cliente + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha")
	private GregorianCalendar fecha;
	
	@Column(name="forma_pago")
	private String formaPago;
	
	@ManyToOne(cascade = {CascadeType.MERGE  , CascadeType.DETACH  , CascadeType.PERSIST  , CascadeType.REFRESH})
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
}
