package beans;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class visorDeImagenesBean extends JLabel {
	// crear un constructor 
	public visorDeImagenesBean() {
		setBorder(BorderFactory.createEtchedBorder());
	}
	
	// beans/visorDeImagenesBean
	// crear metodo getter y setter
	public void setEscogeImagen(String elegirImagen) {
		try {
			archivo = new File(elegirImagen);
			setIcon(new ImageIcon(ImageIO.read(archivo)));
		}catch(IOException e) {
			archivo = null;
			setIcon(null);
		}
	}
	
	//
	public String getEscpgeImagen() {
		if(archivo==null) return null;
		else return archivo.getPath();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}
	
	private File archivo;
	
}
