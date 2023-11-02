package nl.delphinity.qr_goats.persistence.interfaces;

import nl.delphinity.qr_goats.domain.Account;

public interface IAccountDAO extends IGenericDAO<Account, String> {

	Account findByEmail(String email);

}
