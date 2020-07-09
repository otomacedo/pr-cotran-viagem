package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Graduacao;


public class GraduacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;

	public GraduacaoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Graduacao graduacao) {
		this.em.getTransaction().begin();
		this.em.persist(graduacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Long id) {
		this.em.getTransaction().begin();
		Graduacao graduacao = consultar(id);
		this.em.remove(graduacao);
		em.getTransaction().commit();
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Graduacao graduacao) {
		this.em.merge(graduacao);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Graduacao consultar(long id) {
		return this.em.find(Graduacao.class,id);
	}
	
	public List<Graduacao> listar() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Graduacao> g = s.createQuery("from Graduacao", Graduacao.class).list();
		s.close();
		return g;
	}

}
