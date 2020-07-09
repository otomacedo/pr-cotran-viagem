package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Setor;

public class SetorDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Session s = HibernateUtil.getSessionFactory().openSession();
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

	public boolean excluir(Long id) {
		this.em.getTransaction().begin();
		Setor setor = consultar(id);
		this.em.remove(setor);
		em.getTransaction().commit();
		try {
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
	
	public List<Setor> listar() {
		List<Setor> t = s.createQuery("from Setor", Setor.class).list();
		s.close();
		return t;
	}
}

