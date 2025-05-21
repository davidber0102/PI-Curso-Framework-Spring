package SwingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PruebaLista {

	public static void main(String[] args) {
		JFrame mr = new MarcoDeLista();
		mr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mr.setVisible(true);

	}

}


class MarcoDeLista extends JFrame{
	public MarcoDeLista() {
		setTitle("Prueba de Lista");
		setBounds(400, 300, 400, 300);
		String [] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
		
		listaDeMeses = new JList<String>(meses);
		
		listaDeMeses.setVisibleRowCount(4);		
		JScrollPane lamDes = new JScrollPane(listaDeMeses);
		
		laminaDeLista = new JPanel();
		laminaDeLista.add(lamDes);
		
		listaDeMeses.addListSelectionListener( new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				List<String> valores = listaDeMeses.getSelectedValuesList();
				StringBuilder texto = new StringBuilder("Mes selecionado: ");
				for(String elemento: valores) {
					String palabra = elemento;
					texto.append(palabra);
					texto.append(" ");
				}
				rotulo.setText(texto.toString());
			}
			
		});
		
		laminaDeTexto = new JPanel();
		rotulo = new JLabel("Mes selecionado: ");
		laminaDeTexto.add(rotulo);
		
		add(laminaDeLista, BorderLayout.NORTH);
		add(laminaDeTexto, BorderLayout.SOUTH);
	}
	
	private JList<String> listaDeMeses;
	private JPanel laminaDeLista, laminaDeTexto;
	private JLabel rotulo;
}