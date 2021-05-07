package aplicacao_console;

import fachada.Fachada;
import modelo.Video;
import modelo.Visualizacao;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Video v;
			Visualizacao visu;
			
			try {v=Fachada.cadastrarVideo("youtube.com/watch?v=rxoiZZ8UBEY", "C'mon Talk", "Bernhoft Song");}catch(Exception e){System.out.println(e.getMessage());}
			try {v=Fachada.cadastrarVideo("youtube.com/watch?v=ZHRXmYdwc1o","Hold Me While You Wait", "Lewis Capaldi Song");}catch(Exception e){System.out.println(e.getMessage());}	
			try {v=Fachada.cadastrarVideo("youtube.com/watch?v=s3IAHXP1dfs","This City", "Sam Fischer Song");}catch(Exception e){System.out.println(e.getMessage());}
			try {v=Fachada.cadastrarVideo("youtube.com/watch?v=vO15zpO5kc4"," SAVAGE LOVE", "Jason Derulo Song");}catch(Exception e){System.out.println(e.getMessage());}
			//try {v=Fachada.cadastrarVideo("youtube.com/watch?v=W6e1TctNyw8"," WaterFall", "Sia feat Pink");}catch(Exception e){System.out.println(e.getMessage());}
			//try {v=Fachada.cadastrarVideo("youtube.com/watch?v=ApXoWvfEYVU","Sunflower", "Post Malone");}catch(Exception e){System.out.println(e.getMessage());}
		
			try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=vO15zpO5kc4", "Carl@gmail.com", 7);}catch(Exception e){System.out.println(e.getMessage());}
			try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=rxoiZZ8UBEY", "Carl@gmail.com", 9);}catch(Exception e){System.out.println(e.getMessage());}
			try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=s3IAHXP1dfs","Thomas@gmail.com", 8);}catch(Exception e){System.out.println(e.getMessage());}
			try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=s3IAHXP1dfs","Carl@gmail.com", 7);}catch(Exception e){System.out.println(e.getMessage());}
			try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=Testando","Jason@gmail.com", 7);}catch(Exception e){System.out.println(e.getMessage());}
			//try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=ZHRXmYdwc1o","Thomas@gmail.com", 3);}catch(Exception e){System.out.println(e.getMessage());}
			//try {visu=Fachada.registrarVisualizacao("youtube.com/watch?v=ZHRXmYdwc1o","Guilherme@gmail.com", 5);}catch(Exception e){System.out.println(e.getMessage());}
						
			try {Fachada.adicionarAssunto("youtube.com/watch?v=rxoiZZ8UBEY","NorwegianMusic");}catch(Exception e){System.out.println(e.getMessage());}
			try {Fachada.adicionarAssunto("youtube.com/watch?v=s3IAHXP1dfs","Australian Song");}catch(Exception e){System.out.println(e.getMessage());}
			try {Fachada.adicionarAssunto("youtube.com/watch?v=vO15zpO5kc4","USA song");}catch(Exception e){System.out.println(e.getMessage());}
			try {Fachada.adicionarAssunto("youtube.com/watch?v=Testando","Testando");}catch(Exception e){System.out.println(e.getMessage());}
			//try {Fachada.adicionarAssunto("youtube.com/watch?v=vO15zpO5kc4","BTS");}catch(Exception e){System.out.println(e.getMessage());}
			//try {Fachada.adicionarAssunto("youtube.com/watch?v=W6e1TctNyw8","Pretty good song");}catch(Exception e){System.out.println(e.getMessage());}
			//try {Fachada.adicionarAssunto("youtube.com/watch?v=ApXoWvfEYVU","Spider-Boy");}catch(Exception e){System.out.println(e.getMessage());}

		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}
	
	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}