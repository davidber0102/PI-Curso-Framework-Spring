package SwingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mr2 = new MarcoArbol();
		mr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mr2.setVisible(true);
	}

}
class MarcoArbol extends JFrame{
	public MarcoArbol() {
		setTitle("Prueba de Arbol");
		setBounds(400, 300, 200, 200);
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
		DefaultMutableTreeNode pais = new DefaultMutableTreeNode("España");
		raiz.add(pais);
		
		DefaultMutableTreeNode comunidad = new DefaultMutableTreeNode("Madrid");
		pais.add(comunidad);
		
		DefaultMutableTreeNode mostoles = new DefaultMutableTreeNode("Mostoles");
		comunidad.add(mostoles);
		
		DefaultMutableTreeNode alcobendas = new DefaultMutableTreeNode("Alcobendas");
		comunidad.add(alcobendas);
		
		comunidad = new DefaultMutableTreeNode("Cantabria");
		pais.add(comunidad);
		
		DefaultMutableTreeNode santillana = new DefaultMutableTreeNode("Santilla del Mar");
		comunidad.add(santillana);
		
		
		pais = new DefaultMutableTreeNode("Alemania");
		raiz.add(pais);
		
		comunidad = new DefaultMutableTreeNode("Baviera");
		pais.add(comunidad);
		
		DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");
		comunidad.add(munich);
		
		JTree arbol = new JTree(raiz);
		
		// LaminaArbol lamina = new LaminaArbol(arbol);
		// add(lamina);
		
		Container laminaContenido = getContentPane();
		laminaContenido.add( new JScrollPane(arbol));
	}
}


class LaminaArbol extends JPanel {
	public LaminaArbol(JTree miarbol) {
		setLayout(new BorderLayout());
		add(miarbol, BorderLayout.NORTH);
	}
}
	