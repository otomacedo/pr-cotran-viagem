package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Funcionario;

public class FuncionarioDAO implements Serializable{
	private Session s = HibernateUtil.getSessionFactory().openSession();
	private static final long serialVersionUID = 1L;
	private javax.persistence.EntityManager em;

	public FuncionarioDAO () {
		this.em = ConexaoFactory.getEntityManager();
		
	}

	public boolean incluir(Funcionario funcionario) {
		this.em.getTransaction().begin();
		this.em.persist(funcionario);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Integer idFuncionario) {
		try {
			em.getTransaction().begin();
			Funcionario funcionario = consultar(idFuncionario);
			this.em.remove(funcionario);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Funcionario funcionario) {
		this.em.merge(funcionario);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Funcionario consultar(Integer id) {
		return this.em.find(Funcionario.class,id);
	}
	
	public List<Funcionario> listar() {
		List<Funcionario> f = s.createQuery("from Funcionario", Funcionario.class).list();
		s.close();
		return f;
	}
	
}
