//package qr_goats;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import nl.delphinity.qr_goats.domain.Melding;
//import nl.delphinity.qr_goats.domain.Opleiding;
//import nl.delphinity.qr_goats.domain.OpleidingFacade;
//import nl.delphinity.qr_goats.domain.Student;
//import nl.delphinity.qr_goats.domain.VerlofMelding;
//import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
//import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
//import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
//
//public class VerlofAanvragenTest {
//	private Opleiding opleiding;
//	
//	@Before
//	public void setup() {
//
//		DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
//		
//		opleiding = OpleidingFacade.getInstance().getOpleiding();
//		
//		for(Student s : TestStudentDAO.getInstance().getStudenten()) {
//	    	 
//	    	 opleiding.addStudent(s);
//	    	 
//	     }  
//
//	}
//
//	@Test
//	public void verlofAanvragenTest() {
//
//		Student student = opleiding.findStudent("100001" );
//		
//
//		Melding m1 = student.verlofAanvragen(opmerking, begindatum, null, null, null));
//
//		// Check if melding is added to student
//		assertTrue(student.getMeldingen().contains(m1));
//
//		// Check if opmerking is set
//		assertEquals(((VerlofMelding) m1).getOpmerking(), "Ik moet naar het ziekenhuis");
//		
//		assertEquals(((VerlofMelding) m1).getBegintijd(), "10:00");
//
//
//	
//
//		// Check if melding has correct student
//		assertEquals(m1.getStudent(), student);
//	}
//}
