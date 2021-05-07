package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOUsuario;
import dao.DAOAssunto;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Fachada {
	private static DAOAssunto daoassunto = new DAOAssunto();  
	private static DAOVideo daovideo = new DAOVideo();  
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
	private static DAOUsuario daousuario = new DAOUsuario();
	private static int id = 0;
	 
	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	// ----------------------------------------! Done ! ----------------------------------------
	public static Video cadastrarVideo(String link, String nome, String palavra) 
			throws Exception {
		DAO.begin();
		Video v = daovideo.read(nome);
		if(v!=null) {
			//Found
			DAO.rollback();	
			throw new Exception("O vídeo [" + nome + "] já existe");
		}
		v = new Video(link, nome);
		daovideo.create(v);
		
		Assunto assunto = daoassunto.read(palavra);
		if (assunto==null) {
			//Not found
			assunto = new Assunto(palavra);
			daoassunto.create(assunto);		//new subject
		}
		
		v.adicionar(assunto);
		assunto.adicionar(v);
		daovideo.update(v);
		daoassunto.update(assunto);
		DAO.commit();
		return v;
	}
	
	public static void adicionarAssunto(String link, String palavra) throws Exception {
		DAO.begin();	
		Assunto assunto = daoassunto.read(palavra);
		if(assunto != null) {
			DAO.rollback();
			throw new Exception("O assunto [" + palavra + "]já foi adicionado!");
		}
		
		Video v = daovideo.readLink(link);
		if (v==null) {
			DAO.rollback();	
			throw new Exception("Video inexistente!");
		}
		
		assunto = new Assunto(palavra);
		daoassunto.create(assunto);	
	
		assunto.adicionar(v);
		v.adicionar(assunto);
		daovideo.update(v);
		daoassunto.update(assunto);
		DAO.commit();
	}
	
	public static Visualizacao localizarVisualizacao(int id) throws Exception {
		Visualizacao visu = daovisualizacao.read(id);
		if (visu==null){
			DAO.rollback();
			throw new Exception("Visualização de Id: ["+ id + "] é inexistente!");
		}
		System.out.println("Visualização localizada!");
		return visu;
	}
	
	public static Visualizacao registrarVisualizacao(String link, String email, int nota) throws  Exception{
		DAO.begin();
		
		Visualizacao procurando;
		Visualizacao visu;
		double media = 0;
		
		Usuario usuario = daousuario.read(email);
		if(usuario == null) {
			usuario = new Usuario(email);
			daousuario.create(usuario);		//new user
		}
		Video video = daovideo.readLink(link);
		if (video==null) {
			DAO.rollback();	
			throw new Exception("Video inexistente!");
		}
		
		while (true) {
			procurando = daovisualizacao.read(id);
			if(procurando !=null) {
				//If this exist then 
				id++;
			}
			else {
				break;
			}
		}
		
		List<Usuario> usuariosDoVideo = consultarUsuariosPorVideo(link);
		
		for(Usuario u : usuariosDoVideo) {
			if(u == usuario) {
				throw new Exception("O usuario: ["+ usuario.getEmail() + "] já visualizou este video!");
			}
		}
		
		visu = new Visualizacao(id, nota, usuario, video);		
		usuario.adicionar(visu);
		video.adicionar(visu);
		
		for(Visualizacao vs : video.getVisu()) {
			media += vs.getNota();
		}
		
		media = media/(video.getVisu().size());
		
		video.setMedia(media);
		daousuario.update(usuario);
		daovideo.update(video);
		daovisualizacao.create(visu);
		DAO.commit();
		return visu;
	}
	
	public static void alterarUsuario(String email, String emailnovo) throws Exception{
		DAO.begin();		
		Usuario usuario = daousuario.read(email);	//searching user
		if (usuario==null) {
			DAO.rollback();
			throw new Exception("Usuário [" + email + "] inexistente!");
		}
		usuario.setEmail(emailnovo); 			
		daousuario.update(usuario);     	
		DAO.commit();
		System.out.println("Atualização concluida!");
	}
	
	public static void apagarVisualizacao(int id) throws Exception {
		DAO.begin();
		Visualizacao visu = localizarVisualizacao(id);
		
		Usuario usuario = visu.getUsuario();
		usuario.remover(visu);
		visu.setUsuario(null);
		
		Video video = visu.getVideo();
		video.remover(visu);
		visu.setVideo(null);

		daousuario.update(usuario);
		daovideo.update(video);
		daovisualizacao.delete(visu);
		DAO.commit();
	}

	// ----------------------------------------! List of All ! ----------------------------------------

	public static List<Video> listarVideos(){
		return daovideo.readAll();
	}

	public static List<Visualizacao> listarVisualizacoes(){
		return daovisualizacao.readAll();
	}
	
	public static List<Usuario> listarUsuarios(){
		return daousuario.readAll();
	}
	
	public static List<Assunto> listarAssuntos(){
		return daoassunto.readAll();
	}

	// -----------------------------------------! Query's !---------------------------------------
	
	/**********************************************************
	 * 
	 * CONSULTAS IMPLEMENTADAS NOS DAO
	 * 
	 **********************************************************/
	
	public static List<Video> consultarVideosPorAssunto(String palavra) {
		if(palavra.isEmpty())
			return daovideo.readAll();
		else
			return daovideo.consultarPorAssunto(palavra);
	}
	
	public static List<Video> consultarVideosPorUsuario(String email) {
		if(email.isEmpty())
			return daovideo.readAll();
		else
			return daovideo.consultarPorUsuario(email);
	}

	public static List<Usuario> consultarUsuariosPorVideo(String link) {
		if(link.isEmpty())
			return daousuario.readAll();
		else
			return daousuario.consultarPorVideo(link);
	}
}
