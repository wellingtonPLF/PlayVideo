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

public class TelaCadastro {
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
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro");
		frame.setBounds(100, 100, 600, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label_0 = new JLabel("Link:");
		label_0.setHorizontalAlignment(SwingConstants.RIGHT);
		label_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_0.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label_0);
		
		label_1 = new JLabel("Nome:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Assunto:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 82, 71, 14);
		frame.getContentPane().add(label_2);
		
		textField_0 = new JTextField();
		textField_0.setBounds(91, 23, 400, 20);
		frame.getContentPane().add(textField_0);
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 51, 120, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 79, 120, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = textField_0.getText();
					String nome = textField_1.getText();
					String assunto = textField_2.getText();
					Fachada.cadastrarVideo(link, nome, assunto);
					textField_0.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(frame, "Cadastro realizado!");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			}
		});
		
		button.setBounds(91, 114, 108, 23);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
	}
}
