package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDAO extends GenericHibernateDAO<Account, String> implements IAccountDAO {

	private static final Logger logger = LogManager.getLogger(AccountDAO.class);

	@Override
	public Account findByEmail(String email) {
		Session session = getSession();
		Transaction transaction = null;
		Account entity = null;

		try {
			transaction = session.beginTransaction();
			entity = session.get(getPersistentClass(), email);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.error("Error occurred while fetching Account by email.", e);
		} finally {
			session.close();
		}

		return entity;
	}
}