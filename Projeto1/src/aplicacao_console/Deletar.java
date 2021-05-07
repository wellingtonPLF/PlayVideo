package aplicacao_console;

import fachada.Fachada;
import modelo.Visualizacao;


public class Deletar {

	public Deletar(){
		try {
			Fachada.inicializar();
	
			try{
				Fachada.apagarVisualizacao(8);
				System.out.println("Apagou a visualizacao de ID: 8");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try{
				Fachada.apagarVisualizacao(2);
				System.out.println("Apagou a visualizacao de ID: 2");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}