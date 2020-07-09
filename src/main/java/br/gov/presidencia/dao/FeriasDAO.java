package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.gov.presidencia.dao.conexao.HibernateUtil;
import br.gov.presidencia.entity.Ferias;

	public class FeriasDAO implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Session s = HibernateUtil.getSessionFactory().openSession();
		private javax.persistence.EntityManager em;
		
		public FeriasDAO() {
			this.em = ConexaoFactory.getEntityManager();
		}
		public boolean incluir(Ferias ferias) {
			this.em.getTransaction().begin();
			this.em.persist(ferias);
			try {
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) { 
				return false;
			}
		}

		public boolean excluir(Ferias ferias) {
			this.em.getTransaction().begin();
			this.em.remove(ferias);
			try {
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		public boolean alterar(Ferias ferias) {
			this.em.merge(ferias);
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		public Ferias consultar(long id) {
			return this.em.find(Ferias.class,id);
		}
		
		public List<Ferias> listar() {
			List<Ferias> f = s.createQuery("from Ferias", Ferias.class).list();
			s.close();
			return f;
		}
	
	
}
