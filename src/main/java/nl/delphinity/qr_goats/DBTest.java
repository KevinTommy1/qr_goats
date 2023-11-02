package nl.delphinity.qr_goats;

import java.time.LocalDateTime;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.CardLog;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.PasswordHashing;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class DBTest {

	public static void main(String[] args) {

		DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession(); // Om het static blok te activeren.

		Opleiding o;
		if (OpleidingFacade.getInstance().getOpleiding() == null) {
			o = new Opleiding("Software Developer");
		} else {
			o = OpleidingFacade.getInstance().getOpleiding();
		}

		Account user = new Account();
		try {
			user.setWachtwoord(PasswordHashing.createHash("user"));
			user.setEmail("user@example.com");
			user.setMachtigingen(1);
		} catch (CannotPerformOperationException e) {
			e.printStackTrace();
		}
		DAOFactory.getFactory().getAccountDAO().save(user);

		Account admin = new Account();
		try {
			admin.setWachtwoord(PasswordHashing.createHash("admin"));
			admin.setMachtigingen(2);
			admin.setEmail("admin@example.com");
		} catch (CannotPerformOperationException e) {
			e.printStackTrace();
		}
		DAOFactory.getFactory().getAccountDAO().save(admin);

		Student s1 = new Student();
		s1.setAccount(user);
		s1.setAchternaam("User");
		s1.setVoornaam("User");
		s1.setStudentNr("111111");

		Student s2 = new Student();
		s2.setAccount(admin);
		s2.setAchternaam("Admin");
		s2.setVoornaam("Admin");
		s2.setStudentNr("222222");

		o.addStudent(s1);
		o.addStudent(s2);

		CardLog cl1 = new CardLog();
		cl1.setId(1);
		cl1.setDate(LocalDateTime.now());
		cl1.setStudent(s1);
		
		CardLog cl2 = new CardLog();
		cl2.setId(2);
		cl2.setDate(LocalDateTime.now());
		cl2.setStudent(s2);
		
		DAOFactory.getFactory().getOpleidingDAO().save(o);

		HibernateSessionManager.shutdown();
	}

}
