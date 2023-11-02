package nl.delphinity.qr_goats.persistence.factories;

public enum DAOFactories {

	HIBERNATE(HibernateDAOFactory.class),
	TESTDATA(TestDAOFactory.class);

	private final Class<? extends DAOFactory> factory;
	
	DAOFactories(Class<? extends DAOFactory> factory) {
		this.factory = factory;
	}

	public Class<? extends DAOFactory> getFactory() {
		return factory;
	}
	
}
