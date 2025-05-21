package SwingAvanzado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaProductos {
	public static void main(String[] args) {
		JFrame mr = new MarcoTablaProductos();
		mr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mr.setVisible(true);

	}
}

class MarcoTablaProductos extends JFrame{
	public MarcoTablaProductos() {
		setTitle("Productos");
		setBounds(400, 300, 600, 500);
		
		JPanel superior = new JPanel();
		nombresDeTablas = new JComboBox();
		
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root" , "dBd#C4rt0$202A");
			datos = miConexion.getMetaData();
			rs =  datos.getTables(null, null, null, null);
			
			while(rs.next()) {
				nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		nombresDeTablas.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
				String consulta = "SELECT * FROM " + tablaSeleccionada;
				
				try {
					st = miConexion.createStatement();
					st = miConexion.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, 
	                        ResultSet.CONCUR_UPDATABLE);
					rs = st.executeQuery(consulta);
					/* while(rs.next()) {
						System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getNString("CÓDIGOARTÍCULO") );
					} */
					while(rs.next()) {
						modelo = new ResulSetModeloTabla(rs);
						JTable tabla = new JTable(modelo);
						add( new JScrollPane(tabla), BorderLayout.SOUTH);
						validate();
					}	
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		superior.add(nombresDeTablas);
		add(superior, BorderLayout.NORTH);
	}
	
	private JComboBox nombresDeTablas;
	private Connection miConexion = null;	
	private DatabaseMetaData datos;
	private ResultSet rs = null;
	private Statement st;
	private ResulSetModeloTabla modelo;
}

class ResulSetModeloTabla extends AbstractTableModel{
	public ResulSetModeloTabla(ResultSet unResulset) {
		rsRegistro = unResulset;
		
		try {
			resmd = rsRegistro.getMetaData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
			return resmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			rsRegistro.last();
			return rsRegistro.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			rsRegistro.absolute(rowIndex + 1 );
			return rsRegistro.getObject(columnIndex + 1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	@Override
    public String getColumnName(int c){ //Configuraré esto cuando arregle el error del JScrollPane
		try {
			return resmd.getColumnName(c + 1 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	private ResultSetMetaData resmd;
	private ResultSet rsRegistro = null;
}