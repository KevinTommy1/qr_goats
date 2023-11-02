package nl.delphinity.qr_goats.persistence.test.dao;


import java.util.List;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IMeldingDAO;


public class TestMeldingDAO extends GenericTestDAO<Melding, Integer> implements IMeldingDAO{
	
	private static TestMeldingDAO instance;
	

	public static TestMeldingDAO getInstance() {
		if (instance == null) {
			instance = new TestMeldingDAO();
		}
		return instance;
	} 

	

	@Override
	public Melding findByStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(boolean add) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Melding> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
