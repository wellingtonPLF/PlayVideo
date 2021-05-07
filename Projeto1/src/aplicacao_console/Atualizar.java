package aplicacao_console;

import fachada.Fachada;

public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("Alterando usuario: x9@gmail.com para x1@gmail.com...");
			Fachada.alterarUsuario("x9@gmail.com", "x1@gmail.com");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Alterando usuario: Carl@gmail.com para Carla@gmail.com...");
			Fachada.alterarUsuario("Carl@gmail.com", "Carla@gmail.com");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}