package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.*;

public abstract class DAOFactory {
	
	private static DAOFactory factory;
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public static void setFactory(Class<? extends DAOFactory> factory) {
		try {
			DAOFactory.factory = factory.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create DAOFactory: " + factory);
		}		
	}

	public abstract IAccountDAO getAccountDAO();
	public abstract IPersoonDAO getPersoonDAO();
	public abstract IStudentDAO getStudentDAO();
	public abstract IOpleidingDAO getOpleidingDAO();
	public abstract IMeldingDAO getMeldingDAO();
	public abstract ILaatMeldingDAO getLaatMeldingDAO();
	public abstract IZiekMeldingDAO getZiekMeldingDAO();
	public abstract ICardLogDAO getCardLogDAO();
	public abstract IVerlofMeldingDAO getVerlofMeldingDAO();
	public abstract IAnswerDAO getAnswerDAO();
	public abstract IQuestionDAO getQuestionDAO();
	
}
