package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.ArrayList;
import java.util.List;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;

public class TestAcountDAO implements IAccountDAO {

	private static TestAcountDAO instance;

	private ArrayList<Account> accounts;

	private TestAcountDAO() {
		accounts = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Account a = new Account();
			a.setEmail("nummer"+i+"@student.scalda.nl");
			a.setWachtwoord("milan"+i);
			accounts.add(a);
		}
	}

	public static TestAcountDAO getInstance() {
		if (instance == null) {
			instance = new TestAcountDAO();
		}
		return instance;
	}

	@Override
	public Account save(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByEmail(String email) {
		for(Account s : accounts) {
			if(s.getEmail().equals(email)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
