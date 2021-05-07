package aplicacao_console;

import fachada.Fachada;


public class Consultar {

	public Consultar(){

		try {
			Fachada.inicializar();
			System.out.println("1.procurando vídeos com o assunto: [NorwegianMusic]\n"+
			Fachada.consultarVideosPorAssunto("NorwegianMusic") );
			System.out.println("2.procurando vídeos do usuário: [Carl@gmail.com]\n"+
			Fachada.consultarVideosPorUsuario("Carl@gmail.com") );
			System.out.println("3.procurando usuários por vídeo: [youtube.com/watch?v=s3IAHXP1dfs]\n"+
			Fachada.consultarUsuariosPorVideo("youtube.com/watch?v=s3IAHXP1dfs") );
			System.out.println("4.procurando vídeos com o assunto: [Sam Fischer Song]\n"+
			Fachada.consultarVideosPorAssunto("Sam Fischer Song") );
			System.out.println("5.procurando vídeos do usuário: [Thomas@gmail.com]\n"+
			Fachada.consultarVideosPorUsuario("Thomas@gmail.com") );
			System.out.println("---------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}