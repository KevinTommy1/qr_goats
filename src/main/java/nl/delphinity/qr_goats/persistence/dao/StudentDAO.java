package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class StudentDAO extends GenericHibernateDAO<Student, String> implements IStudentDAO {

	@Override
	public Student findByEmail(String email) {
		getSession().beginTransaction();
		Student entity = getSession().createQuery("FROM Student WHERE account.email = :email", Student.class)
				.setParameter("email", email)
				.getSingleResult();
		getSession().getTransaction().commit();
		return entity;
	}

}