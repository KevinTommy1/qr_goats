package qr_goats;

import java.time.LocalDateTime;
import java.util.SortedSet;

import org.junit.jupiter.api.Test;

import nl.delphinity.qr_goats.domain.CardLog;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class Cardlogtest {

	private SortedSet<Student> studenten;

	@Test
	public void testGetCheckIns() {
		DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());

		studenten = OpleidingFacade.getInstance().getOpleiding().getStudenten();

		for (Student student : studenten) {
			student.addCardlog(new CardLog(1, student, LocalDateTime.now()));
			SortedSet<CardLog> cardlogs = student.getCardLogs();
			for (CardLog cardlog : cardlogs) {
				System.out.println("====================================================");
				System.out.println("Date: " + cardlog.getDate());
				System.out.println("Id: " + cardlog.getId());
				System.out.println("Student: " + cardlog.getStudent());
			}

		}

	}
}
