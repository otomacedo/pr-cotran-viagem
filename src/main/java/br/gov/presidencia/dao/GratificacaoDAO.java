package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Gratificacao;

public class GratificacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;
	private Session s = HibernateUtil.getSessionFactory().openSession();
	public GratificacaoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Gratificacao gratificacao) {
		this.em.getTransaction().begin();
		this.em.persist(gratificacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Long id) {
		this.em.getTransaction().begin();
		Gratificacao gratificacao = consultar(id);
		this.em.remove(gratificacao);
		em.getTransaction().commit();
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Gratificacao gratificacao) {
		this.em.merge(gratificacao);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Gratificacao consultar(long id) {
		return this.em.find(Gratificacao.class,id);
	}

	public List<Gratificacao> listar() {
		List<Gratificacao> g = s.createQuery("from Gratificacao", Gratificacao.class).list();
		return g;
	
	}
}
