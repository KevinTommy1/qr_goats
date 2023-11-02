package nl.delphinity.qr_goats.persistence.factories;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.persistence.dao.*;
import nl.delphinity.qr_goats.persistence.interfaces.*;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class HibernateDAOFactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().getCurrentSession();
	}

	@Override
	public IPersoonDAO getPersoonDAO() {
		GenericHibernateDAO<Persoon, String> dao = null;
		try {
			dao = PersoonDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IPersoonDAO) dao;
	}

	@Override
	public IAccountDAO getAccountDAO() {
		GenericHibernateDAO<Account, String> dao = null;
		try {
			dao = AccountDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IAccountDAO) dao;
	}

	@Override
	public IStudentDAO getStudentDAO() {
		GenericHibernateDAO<Student, String> dao = null;
		try {
			dao = StudentDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IStudentDAO) dao;
	}
	
	@Override
    public IOpleidingDAO getOpleidingDAO() {
		GenericHibernateDAO<Opleiding, Integer> dao = null;
		try {
			dao = OpleidingDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IOpleidingDAO) dao;
    }

	@Override
	public IMeldingDAO getMeldingDAO() {
		GenericHibernateDAO<Melding, Integer> dao = null;
		try {
			dao = MeldingDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IMeldingDAO) dao;
	}

	@Override
	public ILaatMeldingDAO getLaatMeldingDAO() {
		GenericHibernateDAO<LaatMelding, Integer> dao = null;
		try {
			dao = LaatMeldingDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ILaatMeldingDAO) dao;
	}

	@Override
	public IZiekMeldingDAO getZiekMeldingDAO() {
		GenericHibernateDAO<ZiekMelding, Integer> dao = null;
		try {
			dao = ZiekMeldingDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IZiekMeldingDAO) dao;
	}
	
	

	@Override
	public ICardLogDAO getCardLogDAO() {
		GenericHibernateDAO<CardLog, String> dao = null;
		try {
			dao = CardLogDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ICardLogDAO) dao;
	}

	@Override
	public IVerlofMeldingDAO getVerlofMeldingDAO() {
		GenericHibernateDAO<VerlofMelding, Integer> dao = null;
		try {
			dao = VerlofMeldingDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IVerlofMeldingDAO) dao;
	}

	@Override
	public IAnswerDAO getAnswerDAO() {
		GenericHibernateDAO<Answer, Integer> dao = null;
		try {
			dao = AnswerDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IAnswerDAO) dao;
	}

	@Override
	public IQuestionDAO getQuestionDAO() {
		GenericHibernateDAO<Question, Integer> dao = null;
		try {
			dao = QuestionDAO.class.getDeclaredConstructor().newInstance();
			dao.setSession(getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IQuestionDAO) dao;
	}

}
