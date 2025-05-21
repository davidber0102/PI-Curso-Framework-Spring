package davdev.mx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConectaCRUD() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// creamos variables con la el apoyo de la libreria y usuario y contraseña
		String jdbcURL="jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
		String usuario= "root";
		String psw = "dBd#C4rt0$202A";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.print("nombre de la BBDD: " + jdbcURL + "\n");
			Class.forName(driver);
			Connection myConex = DriverManager.getConnection(jdbcURL, usuario, psw);	
			out.print(" <br> CONEXION EXITOS A LA BBDD " );
			myConex.close();
			
		}catch(Exception e){
			System.out.println("Sin Conexion a Base de Datos!!");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
