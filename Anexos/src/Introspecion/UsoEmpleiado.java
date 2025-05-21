package Introspecion;

public class UsoEmpleiado {
	public static void main(String[] args) {
			Persona antonio = new Persona("Antonio");
			System.out.println(antonio.getNombre());
			
			Empleado ana = new Empleado("Ana", 3500);
			System.out.println(ana.getSalario());
			
			//System.out.println(antonio.getClass());
			
			// creamos objeto de la clase class para empezar introspeccion
			Class cl1 = antonio.getClass();
			System.out.println(cl1.getName());
			
			String nombreClase = "introspeccion.Empleado";
			Class cl2;
			
			try {
				cl2 = Class.forName(nombreClase);
				System.out.println(cl2.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nombreClase = "introspeccion.Persona";

			try {
				cl2 = Class.forName(nombreClase);
				System.out.println(cl2.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

class Persona{
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
private String nombre;
}

class Empleado extends Persona{
	public Empleado(String nombre, double salario) {
		super(nombre);
		this.salario = salario;
	}
	
	public void setIncentivo(double incentivo) {
		salario = salario +incentivo;
	}
	
	public String getSalario() {
		return " El salario es:  " + salario;
	}
	
	private double salario;
}