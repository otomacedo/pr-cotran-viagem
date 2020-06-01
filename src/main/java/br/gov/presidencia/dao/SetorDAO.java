package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.gov.presidencia.entity.Setor;

public class SetorDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;

	public SetorDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Setor setor) {
		this.em.getTransaction().begin();
		this.em.persist(setor);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Setor setor) {
		this.em.getTransaction().begin();
		this.em.remove(setor);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Setor setor) {
		this.em.merge(setor);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Setor consultar(long id) {
		return this.em.find(Setor.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> listar() {
		Query q = this.em.createQuery("SELECT c FROM Setor c");
		return q.getResultList();
	}
}

