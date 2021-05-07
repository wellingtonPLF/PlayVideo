package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaRegistro {
	private JFrame frame;
	private JLabel label_0;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	
	/**
	 * Create the application.
	 */
	public TelaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Registro");
		frame.setBounds(100, 100, 600, 201);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label_0 = new JLabel("Link:");
		label_0.setHorizontalAlignment(SwingConstants.RIGHT);
		label_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_0.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label_0);
		
		label_1 = new JLabel("Email:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Nota:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 82, 71, 14);
		frame.getContentPane().add(label_2);
		
		
		textField_0 = new JTextField();
		textField_0.setBounds(91, 23, 400, 20);
		frame.getContentPane().add(textField_0);
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 51, 110, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 79, 110, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("Registrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = textField_0.getText();
					String email = textField_1.getText();
					String nota = textField_2.getText();
					Fachada.registrarVisualizacao(link, email, Integer.parseInt(nota));
					textField_0.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(frame, "Registro realizado!");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			}
		});
		
		button.setBounds(91, 107, 110, 23);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
	}
}
