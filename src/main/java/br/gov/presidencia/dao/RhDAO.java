package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Rh;

public class RhDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Session s = HibernateUtil.getSessionFactory().openSession();
	private javax.persistence.EntityManager em;
	
	public RhDAO() {
		this.em = ConexaoFactory.getEntityManager();
	}
	
	public boolean incluir(Rh rh) {
		try {
			s.getTransaction().begin();
			s.createNativeQuery("insert into rh values (?,?,?,?,?,?,?,?,?,?,?,?)")
			.setParameter(1, null)
			.setParameter(2, 1)
			.setParameter(3, rh.getMatriculaPr())
			.setParameter(4, rh.getMatriculaSiape())
			.setParameter(5, rh.getOrgaoOrigem())
			.setParameter(6, rh.getPossePr())
			.setParameter(7, rh.getAtividade().getIdAtividade())
			.setParameter(8, rh.getDepartamento().getIdDepartamento())
			.setParameter(9, rh.getFuncionario().getIdFuncionario())
			.setParameter(10, rh.getGraduacao().getIdGraduacao())
			.setParameter(11, rh.getGratificacao().getIdGratificacao())
			.setParameter(12, rh.getSetor().getIdSetor()).executeUpdate();
			
			s.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Integer id) {
		this.em.getTransaction().begin();
		Rh rh = consultar(id);
		this.em.remove(rh);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Rh rh) {
		
		try {
			this.em.getTransaction().begin();
			this.em.merge(rh);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Rh consultar(long id) {
		return this.em.find(Rh.class,id);
	}
	
	public List<Rh> listar() {
		List<Rh> r = s.createQuery("from Rh", Rh.class).list();
		s.close();
		return r;
	}
	
	public Rh consultarPorFuncionario(Integer idFuncionario) {
		Query q = this.em.createQuery("SELECT r FROM Rh r WHERE r.funcionario.idFuncionario = "+idFuncionario);
		return  q.getResultList().isEmpty() ? new Rh() : (Rh) q.getResultList().get(0);
	}

}
