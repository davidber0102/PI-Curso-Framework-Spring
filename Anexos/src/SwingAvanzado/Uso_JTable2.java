package SwingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Uso_JTable2 {
	public static void main(String[] args) {
		JFrame mr = new MarcoTablaPersonalizado();
		mr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mr.setVisible(true);
	}
	
}

class MarcoTablaPersonalizado extends JFrame{
	public MarcoTablaPersonalizado() {
		setTitle("Tabla Personalizada");
		setBounds(400, 300, 400, 300);
		
		ModeloTablaPersonalizada modelo = new ModeloTablaPersonalizada();
		JTable tabla = new JTable(modelo);
		add( new JScrollPane(tabla));
	}
	

}

class ModeloTablaPersonalizada extends AbstractTableModel {

    @Override
    public int getColumnCount() { //Número fijo
        return 3;
    }
    
    @Override
    public int getRowCount() { //Irá variando cuando añadamos retos (falta configurarlo)
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	int z = rowIndex + 1;
        int y = columnIndex + 2;
        
        return " " + z + " " + y;

    }
    
    @Override
    public String getColumnName(int c){ //Configuraré esto cuando arregle el error del JScrollPane
        return "Columna " + c;
    }
  

    
} 