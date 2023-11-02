package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.*;
import nl.delphinity.qr_goats.persistence.test.dao.TestAcountDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestMeldingDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestOpleidingDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;

public class TestDAOFactory extends DAOFactory {

	@Override
	public IAccountDAO getAccountDAO() {
		return TestAcountDAO.getInstance();
	}

	@Override
	public IStudentDAO getStudentDAO() {
		return TestStudentDAO.getInstance();
	}

	@Override
	public IOpleidingDAO getOpleidingDAO() {
		return TestOpleidingDAO.getInstance();
	}

	@Override
	public IPersoonDAO getPersoonDAO() {
		return null;
	}

	@Override
	public IMeldingDAO getMeldingDAO() {
		return TestMeldingDAO.getInstance();
	}

	@Override
	public ILaatMeldingDAO getLaatMeldingDAO() {
		return null;
	}

	@Override
	public IZiekMeldingDAO getZiekMeldingDAO() {
		return null;
	}

	@Override
	public ICardLogDAO getCardLogDAO() {
		return null;
	}


	@Override
	public IVerlofMeldingDAO getVerlofMeldingDAO() {
		return null;
	}

	@Override
	public IAnswerDAO getAnswerDAO() {
		return null;
	}

	@Override
	public IQuestionDAO getQuestionDAO() {
		return null;
	}

}
