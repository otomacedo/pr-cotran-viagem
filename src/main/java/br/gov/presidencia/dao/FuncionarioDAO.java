package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.gov.presidencia.entity.Funcionario;

public class FuncionarioDAO implements Serializable{
	
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
		this.em.getTransaction().begin();
		Funcionario removerFuncionario = consultar(idFuncionario);
		this.em.remove(removerFuncionario);
		try {
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

	public Funcionario consultar(long id) {
		return this.em.find(Funcionario.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		Query q = this.em.createQuery("SELECT c FROM Funcionario c");
		return q.getResultList();
	}
	
}
