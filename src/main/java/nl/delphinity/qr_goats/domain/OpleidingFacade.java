package nl.delphinity.qr_goats.domain;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class OpleidingFacade {

	private static OpleidingFacade instance;
	private final Opleiding opleiding;
	
	private OpleidingFacade() {
		opleiding = DAOFactory.getFactory().getOpleidingDAO().findById(1);
	}
	
	public static OpleidingFacade getInstance() {
		if (instance == null)
			instance = new OpleidingFacade();
		return instance;
	}
	
	public Opleiding getOpleiding() {
		return opleiding;
	}

}
