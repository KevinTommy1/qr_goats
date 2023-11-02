package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Question;
import nl.delphinity.qr_goats.persistence.interfaces.IQuestionDAO;

public class QuestionDAO extends GenericHibernateDAO<Question, Integer> implements IQuestionDAO {

}