package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.gov.presidencia.entity.TipoGratificacao;

public class TipoGratificacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;
	
	public TipoGratificacaoDAO() {
		this.em = ConexaoFactory.getEntityManager();
	}
	
	public boolean incluir(TipoGratificacao tipoGratificacao) {
		this.em.getTransaction().begin();
		this.em.persist(tipoGratificacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean excluir(TipoGratificacao tipoGratificacao) {
		this.em.getTransaction().begin();
		this.em.remove(tipoGratificacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public boolean alterar(TipoGratificacao tipoGratificacao) {
	try {
		this.em.getTransaction().begin();
		this.em.merge(tipoGratificacao);
		this.em.getTransaction().commit();
		return true;
	} catch (Exception e) {
		return false;
	}	
	}
	
	public TipoGratificacao consultar(long id) {
		return this.em.find(TipoGratificacao.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoGratificacao> listar(){
		Query q = this.em.createQuery("SELECT c FROM TipoGratificacao c");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoGratificacao> listarTiposPorGratificacao(long id) {
		Query q = this.em.createQuery("SELECT g FROM TipoGratificacao g WHERE g.idGratificacao = "+ id);
		return q.getResultList();
	}
	
	
	
}
