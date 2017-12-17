package fiap.scj.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fiap.scj.persistencia.interfaces.Dao;
import fiap.scj.persistencia.util.JpaUtil;

public class GenericDao<T> implements Dao<T> {
	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.em = JpaUtil.getEntityManager();
		this.classe = classe;
	}

	@Override
	public T adicionar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		System.out.println("entidade persistida");
		return entidade;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar(String jpql, Object... params) {
		Query query = em.createQuery(jpql);
		for(int i = 0; i < params.length; i++)
			query.setParameter(i, params[i]);
		return query.getResultList();
	}

	
	@Override
	public List<T> listar() {
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	
	@Override
	public void atualizar(T entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		System.out.println("entidade atualizada");

	}

	@Override
	public void remover(T entidade) {
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		System.out.println("entidade removida");
	}

	@Override
	public T buscar(String jpql, Object... params) {
		try {
			Query query = em.createQuery(jpql);
			for(int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
			return (T) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public T buscar(int id) {
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		return entidade;
	}
}
