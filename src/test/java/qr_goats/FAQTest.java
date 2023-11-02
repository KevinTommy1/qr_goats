package qr_goats;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Answer;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.Question;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FAQTest {

	private Opleiding opleiding;
	private Question question1;
	private Answer answer1;
	private Answer answer2;
	private Account gino;

	@BeforeEach
	public void setUp() {
		opleiding = new Opleiding();
		question1 = new Question();
		answer1 = new Answer();
		answer2 = new Answer();
		gino = new Account();
	}

	@Test
	public void testAddAnswer() {
		DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());

		gino.setMachtigingen(2);
		
		question1.setQuestionName("Test vraag");
		answer1.setAnswerName("Test antwoord");
		answer2.setAnswerName("Test antwoord 2");
		opleiding.setNaam("Test opleiding");

		assertTrue(question1.addAnswer(answer1, gino));
		assertTrue(question1.addAnswer(answer2, gino));

		opleiding.addQuestion(question1, gino);
		assertEquals(2, question1.getAnswers().size());
		System.out.println(question1.getAnswers());
		System.out.println(opleiding.getQuestions());
		assertTrue(question1.getAnswers().contains(answer1));

	}
	
	@Test
	public void testDeleteFaq() {
		DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());

		gino.setMachtigingen(2);

		question1.setQuestionName("Test vraag");
		answer1.setAnswerName("Test antwoord");
		answer2.setAnswerName("Test antwoord 2");
		opleiding.setNaam("Test opleiding");

		question1.addAnswer(answer1, gino);
		question1.addAnswer(answer2, gino);
		opleiding.addQuestion(question1, gino);

		assertTrue(question1.deleteAnswer(answer1, gino));
		assertTrue(question1.deleteAnswer(answer2, gino));
		
		assertEquals(0, question1.getAnswers().size());
		assertFalse(question1.getAnswers().contains(answer1));
		assertFalse(question1.getAnswers().contains(answer2));
	}
}
