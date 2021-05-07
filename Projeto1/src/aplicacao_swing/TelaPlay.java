package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import fachada.Fachada;
import modelo.Video;

public class TelaPlay {

	private JFrame frmConsultar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_0;
	private JButton button_1;
	private JTextField textField_0;

	/**
	 * Create the application.
	 */
	public TelaPlay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultar = new JFrame();
		frmConsultar.setTitle("Consultar");
		frmConsultar.setBounds(100, 100, 505, 283);
		frmConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultar.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 21, 409, 116);
		frmConsultar.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		button_0 = new JButton("Listar todos os videos cadastrados!");
		button_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_0.setHorizontalAlignment(SwingConstants.LEFT);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link dos Videos");
					List<Video> lista = Fachada.listarVideos();
					for(Video v : lista)
						model.addRow(new Object[]{ v.getLink()});

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button_0.setBounds(90, 158, 240, 23);
		frmConsultar.getContentPane().add(button_0);

		button_1 = new JButton("[Play]");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://www.";
				url = url+textField_0.getText();
				try {
					Desktop.getDesktop().browse(new URL(url).toURI());

				} catch (MalformedURLException evt) {
					evt.printStackTrace();
				} catch (IOException evt) {
					evt.printStackTrace();
				} catch (URISyntaxException evt) {
					evt.printStackTrace();
				}
				textField_0.setText("");
				url = "";
			}
		});
		
		button_1.setBounds(340, 192, 70, 23);
		frmConsultar.getContentPane().add(button_1);

		textField_0 = new JTextField();
		textField_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_0.setColumns(10);
		textField_0.setBounds(90, 192, 240, 23);
		frmConsultar.getContentPane().add(textField_0);

		frmConsultar.setVisible(true);
	}
}
