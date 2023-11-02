package nl.delphinity.qr_goats.persistence.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {
	
	T save(T entity);
	
	void delete(T entity);
	
	T findById(ID id);
	
	List<T> findAll();
	
}
