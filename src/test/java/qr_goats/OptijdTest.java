package qr_goats;

import nl.delphinity.qr_goats.domain.QRCode;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptijdTest {

	@Test
	public void test() {
		QRCode qr = new QRCode();
		LocalDateTime incheckTijd = LocalDateTime.of(2023, 6, 1, 15, 12);
		assertTrue(qr.isOptijd(incheckTijd));
	}

}
