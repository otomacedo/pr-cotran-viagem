package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Atividade;


public class AtividadeDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Session s = HibernateUtil.getSessionFactory().openSession();
	private javax.persistence.EntityManager em;

	public AtividadeDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Atividade atividade) {
		this.em.getTransaction().begin();
		this.em.persist(atividade);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Long id) {
		em.getTransaction().begin();
		Atividade atividade = consultar(id);
		this.em.remove(atividade);
		em.getTransaction().commit();
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Atividade atividade) {
		this.em.merge(atividade);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Atividade consultar(long id) {
		return this.em.find(Atividade.class,id);
	}
	
	public List<Atividade> listar() {
		List<Atividade> a = s.createQuery("from Atividade", Atividade.class).list();
		s.close();
		return a;
		
	}
}
