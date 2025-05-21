package paqGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

public class pruebaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEjemplo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaGUI frame = new pruebaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pruebaGUI() {
		setBackground(UIManager.getColor("Button.disabledShadow"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));

		setContentPane(contentPane);
		
		txtEjemplo = new JTextField();
		txtEjemplo.setHorizontalAlignment(SwingConstants.CENTER);
		txtEjemplo.setText("ejemplo");
		contentPane.add(txtEjemplo);
		txtEjemplo.setColumns(50);
		
		JDateChooser dateChooser = new JDateChooser();
		contentPane.add(dateChooser, BorderLayout.NORTH);
	}

}
