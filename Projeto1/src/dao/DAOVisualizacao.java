package dao;

import java.util.List;

//import com.db4o.query.Query;
import com.db4o.*;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Visualizacao;

public class DAOVisualizacao extends DAO<Visualizacao>{
	public Visualizacao read (Object chave) {
		try {
			int id = (int) chave;
			TypedQuery<Visualizacao> q = manager.createQuery("select vs from Visualizacao vs where vs.id=:i", Visualizacao.class);
			q.setParameter("i", id);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
}
