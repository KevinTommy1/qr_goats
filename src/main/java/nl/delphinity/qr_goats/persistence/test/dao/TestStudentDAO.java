package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;


public class TestStudentDAO extends GenericTestDAO<Student, String> implements IStudentDAO {
	

	private static TestStudentDAO instance;
	private final SortedSet<Student> studenten;
	

	private TestStudentDAO() {
		

		studenten = new TreeSet<Student>();

		for (int i = 1; i < 101; i++) {
			
			int NR = 100000 + i;
			
			
			Student stud = new Student();
			stud.setVoornaam("Eren" + i);
			stud.setAchternaam("test" + i);
			stud.setTussenvoegsel("test" + i);
			stud.setId(i);	
			stud.setStudentNr(Integer.toString(NR));
			stud.setOpleiding(OpleidingFacade.getInstance().getOpleiding());
			studenten.add(stud);
		}
	}

	
	@Override
	public Student findById(String studentenNR) {
		for (Student s : studenten) {
			if (s.getStudentNr().equals(studentenNR)) {

				return s;
			}
		}

		return null;
	}

	public static TestStudentDAO getInstance() {
		if (instance == null)
			instance = new TestStudentDAO();
		return instance;
	}

	@Override
	public Student findByEmail(String email) {
		if (instance == null)
			instance = new TestStudentDAO();

		for (Student s : studenten)
			if (s.getAccount().getEmail().equals(email))
				return s;

		return null;
	}

	@Override
	public Student save(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> findAll() {
		return new ArrayList<>(studenten);
	}

	public SortedSet<Student> getStudenten() {
		return studenten;
	}

}
