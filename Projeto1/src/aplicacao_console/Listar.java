package aplicacao_console;

import fachada.Fachada;
import modelo.Video;
import modelo.Visualizacao;
import modelo.Assunto;
import modelo.Usuario;

public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();

			System.out.println("Listagem de Videos:");
			for(Video v : Fachada.listarVideos() )		
				System.out.println(v);
			
			System.out.println("Listagem de Assuntos:");
			for(Assunto assunto : Fachada.listarAssuntos())	
				System.out.println(assunto);

			System.out.println("\nListagem de Visualizações:");
			for(Visualizacao visu : Fachada.listarVisualizacoes())	
				System.out.println(visu);
			
			System.out.println("\nListagem de Usuários:");
			for(Usuario usuario : Fachada.listarUsuarios())	
				System.out.println(usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

