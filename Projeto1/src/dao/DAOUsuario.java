package dao;

import java.util.List;

//import com.db4o.query.Query;
import com.db4o.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario>{
	public Usuario read (Object chave) {
		try{
			String email = (String) chave;
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.email=:e", Usuario.class);
			q.setParameter("e", email);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
		
	//Query's
	
	public  List<Usuario> consultarPorVideo(String link) {
		TypedQuery<Usuario> q = manager.createQuery("select vs.usuario from Visualizacao vs where vs.video = "
				+ "(select v from Video v where v.link =:l)", Usuario.class);
		q.setParameter("l", link);
		return q.getResultList();
	}
}
