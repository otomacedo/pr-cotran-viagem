package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Departamento;

public class DepartamentoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;
	private Session s = HibernateUtil.getSessionFactory().openSession();
	public DepartamentoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Departamento departamento) {
		this.em.getTransaction().begin();
		this.em.persist(departamento);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Long id) {
		this.em.getTransaction().begin();
		Departamento departamento = consultar(id);
		this.em.remove(departamento);
		em.getTransaction().commit();
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Departamento departamento) {
		this.em.merge(departamento);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Departamento consultar(long id) {
		return this.em.find(Departamento.class,id);
	}
	
	public List<Departamento> listar() {
		List<Departamento> a = s.createQuery("from Departamento", Departamento.class).list();
		s.close();
		return a;
	}
	
}
