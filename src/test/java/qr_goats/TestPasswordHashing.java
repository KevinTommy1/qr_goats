package qr_goats;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import nl.delphinity.qr_goats.domain.PasswordHashing;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;

public class TestPasswordHashing {

	@Test
	public void PasswordHashing() {

		String broodje = "broodje";

		try {
			assertTrue(PasswordHashing.verifyPassword(broodje, PasswordHashing.createHash(broodje)));
		} catch (CannotPerformOperationException | InvalidHashException e) {
			e.printStackTrace();
		}

	}

}