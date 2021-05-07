package dao;

import java.util.List;

//import com.db4o.query.Query;
import com.db4o.*;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Usuario;
import modelo.Video;

public class DAOVideo extends DAO<Video>{
	public Video read (Object chave) {			
		try {
			String nome = (String) chave;
			TypedQuery<Video> q = manager.createQuery("select v from Video v where v.nome=:n", Video.class);
			q.setParameter("n", nome);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Video readLink (Object chave) {
		try {
			String link = (String) chave;
			TypedQuery<Video> q = manager.createQuery("select v from Video v where v.link=:l", Video.class);
			q.setParameter("l", link);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	//Query's
	
	public  List<Video> consultarPorUsuario(String email) {
		TypedQuery<Video> q = manager.createQuery("select video from Visualizacao vs where vs.usuario = "
				+ "(select u from Usuario u where u.email=:e)", Video.class);
		q.setParameter("e", email);
		return q.getResultList();
	}
	
	public  List<Video> consultarPorAssunto(String palavra) {
		TypedQuery<Video> q = manager.createQuery("select v from Assunto a join a.videos v where a.palavra=:p", Video.class);
		q.setParameter("p", palavra);
		return q.getResultList();
	}
}
