package qr_goats;

import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.factories.HibernateDAOFactory;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpleidingTest {

    private Opleiding opleiding;

    @BeforeEach
    public void setUp() {

        DAOFactory.setFactory(DAOFactories.TESTDATA.getFactory());
        opleiding = OpleidingFacade.getInstance().getOpleiding();

        for (Student s : TestStudentDAO.getInstance().getStudenten())
            opleiding.addStudent(s);

    }

    @Test
    public void OpleidingNullTest() {
        assertNotNull(opleiding);
    }

    @Test
    public void OpleidingStudentTest() {
        assertEquals(100, opleiding.getStudenten().size());
    }

}
