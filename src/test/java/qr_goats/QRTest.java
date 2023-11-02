//package qr_goats;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import com.opensymphony.xwork2.interceptor.annotations.Before;
//
//import nl.delphinity.qr_goats.domain.QRCode;
//import nl.delphinity.qr_goats.domain.Student;
//import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
//import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
//
//public class QRTest {
//
//	@Before
//	public void createDatabase() {
//		
////	   DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
//	}
//	
//	@Test
//	
//	public void qrCodeCreateTest() {
//		QRCode qrCode = new QRCode();
//        Student student = new Student(1, "Misha", "123456@student.scalda.nl", null);
//        System.out.println(qrCode.generateQR(student.getStudentenNR()));
//        assertNotNull(qrCode.generateQR(student.getStudentenNR()));
//	}
//
//}
