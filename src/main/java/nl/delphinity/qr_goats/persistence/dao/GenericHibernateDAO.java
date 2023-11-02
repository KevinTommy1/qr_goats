package nl.delphinity.qr_goats.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;

import nl.delphinity.qr_goats.persistence.interfaces.IGenericDAO;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.criteria.JpaCriteriaQuery;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	private final Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null)
			throw new IllegalStateException("Session has not been set on DAO before usage");
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T save(T entity) {
		try {
			getSession().beginTransaction();
			getSession().persist(entity);
			getSession().getTransaction().commit();
		} catch (PersistenceException e) {

			entity = null;

			if (getSession().getTransaction() != null)
				getSession().getTransaction().rollback();

			if(e.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
				System.out.println(cve.getSQLException().getSQLState());
				throw (ConstraintViolationException) e.getCause();
			}

		}

		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().beginTransaction();
		getSession().remove(entity);
		getSession().getTransaction().commit();
	}

	@Override
	public T findById(ID id) {
		getSession().beginTransaction();
		T entity = getSession().find(getPersistentClass(), id);
		getSession().getTransaction().commit();
		return entity;
	}

	@Override
	public List<T> findAll() {
		getSession().beginTransaction();

		JpaCriteriaQuery<T> query = getSession().getCriteriaBuilder().createQuery(getPersistentClass());
		query.select(query.from(getPersistentClass()));
		List<T> list = getSession().createQuery(query).getResultList();

		getSession().getTransaction().commit();

		return list;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
