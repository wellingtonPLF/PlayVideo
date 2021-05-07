package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

//import com.db4o.query.Query;
import com.db4o.*;

import modelo.Assunto;

public class DAOAssunto extends DAO<Assunto> {
	public Assunto read (Object chave) {
		try{
			String palavra = (String) chave;
			TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a where a.palavra=:p", Assunto.class);
			q.setParameter("p", palavra);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
}
