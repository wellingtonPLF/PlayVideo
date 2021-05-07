package aplicacao_swing;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaPrincipal {
	
	private JButton play;
	private JFrame frame;
	private JMenu menuVideo;
	private JMenu menuVisu;
	private JMenu menuTocar;
	private JMenuItem menuCadastrarVideo;
	private JMenuItem menuRegistrarVisu;
	private JMenuItem menuListarVideo;
	private JMenuItem menuListarVisu;
	private JLabel label;
	private ImageIcon imagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				Fachada.inicializar();

				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				label.setIcon(imagem);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "Repositório Finalizado!");
			}
		});
		
		frame.setTitle("Repositório");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Inicializando...");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		imagem = new ImageIcon(getClass().getResource("/imagens/imagem.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));//		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);


		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menuVideo = new JMenu("Video");
		menuBar.add(menuVideo);

		menuCadastrarVideo= new JMenuItem("Cadastrar");
		menuCadastrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tela = new TelaCadastro();
			}
		});
		menuVideo.add(menuCadastrarVideo);
		
		menuListarVideo = new JMenuItem("ListarVideo");
		menuListarVideo .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemVideo tela = new TelaListagemVideo();
			}
		});
		menuVideo.add(menuListarVideo);

		//-----------------------------------------------------------------
		menuVisu = new JMenu("Visualizacao");
		menuBar.add(menuVisu);

		menuRegistrarVisu = new JMenuItem("Registrar");
		menuRegistrarVisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRegistro tela = new TelaRegistro();
			}
		});
		menuVisu.add(menuRegistrarVisu);
		
		menuListarVisu = new JMenuItem("ListarVisualização");
		menuListarVisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemVisu tela = new TelaListagemVisu();
			}
		});
		menuVisu.add(menuListarVisu);

		//-----------------------------------------------------------------
		
		play = new JButton();
		play.setText("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaPlay tela = new TelaPlay();
            }
        });
        play.setBounds(550, 300, 100, 50);
        frame.getContentPane().add(play);
        
        frame.setVisible(true);
	}
}
