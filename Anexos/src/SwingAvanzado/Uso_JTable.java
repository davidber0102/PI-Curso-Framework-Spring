package SwingAvanzado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Uso_JTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mr = new MarcoTabla();
		mr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mr.setVisible(true);
	}
}

class MarcoTabla extends JFrame{
	public MarcoTabla() {
		setTitle("Prueba de Lista");
		setBounds(400, 300, 400, 300);
		
		JTable planetas = new JTable(datosFila, nombColumnas);
		//JScrollPane scrollpane = new JScrollPane(planetas);
		add( new JScrollPane(planetas), BorderLayout.CENTER);
		
		JButton imprimir = new JButton("Imprimir Tabla");
		
		imprimir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					planetas.print();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JPanel laminaBoton = new JPanel();
		laminaBoton.add(imprimir);
		add(laminaBoton, BorderLayout.SOUTH);
	}
	
	
	private String [] nombColumnas = {"Nombre", "Radio", "Lunas", "Gaseosos"};
	private Object [] [] datosFila= {
			{"Mercurio", 2440.0, 0, false},
			{"Venus", 6052.0, 0, false},
			{"Tierra", 6378.0, 1, false},
			{"Marte", 3397.0, 2, false},
			{"Jupiter", 70192.0, 16, true},
			{"Saturno", 60268.0, 18, true},
			{"Urano", 25559.0, 17, true},
			{"Neptuno", 24766.0, 8, true},		
			{"Pluton", 1137.0, 1, false},
			
	};
}