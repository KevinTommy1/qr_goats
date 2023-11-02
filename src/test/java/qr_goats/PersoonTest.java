package qr_goats;

import nl.delphinity.qr_goats.domain.Persoon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersoonTest {
	
	@Test
    public void testCompareTo() {

        Persoon p1 = new Persoon(1, "John", "van", "Doe");
        Persoon p2 = new Persoon(2, "Jane", "van der", "Doe");
        Persoon p3 = new Persoon(3, "John", "van", "Smith");
        Persoon p4 = new Persoon(4, "John", null, "Doe" );
        Persoon p5 = new Persoon(5, "John", "van", "Doe");

        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p1) < 0);

        assertTrue(p1.compareTo(p3) < 0);
        assertTrue(p3.compareTo(p1) > 0);

        assertTrue(p2.compareTo(p3) < 0);
        assertTrue(p3.compareTo(p2) > 0);

        assertEquals(p1.compareTo(p4), 0);
        assertEquals(p4.compareTo(p1), 0);

        assertEquals(p1.compareTo(p5), 0);
        assertEquals(p5.compareTo(p1), 0);
        
    }

}
