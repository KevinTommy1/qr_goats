package qr_goats;

import static org.junit.jupiter.api.Assertions.*;

import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class StudentTest {

    private Student student1;

    private Student student2;
    private Melding melding1;
    private Melding melding2;

    private Melding melding3;
    private Melding melding4;

    @BeforeEach
    public void setup() {
        DAOFactory.setFactory(DAOFactories.TESTDATA.getFactory());
        Opleiding opleiding = OpleidingFacade.getInstance().getOpleiding();

        for (Student student : TestStudentDAO.getInstance().getStudenten()) {
            opleiding.addStudent(student);
        }

        student1 = new Student("111111", 100001, "Student", " ", "Aids");
        melding1 = new Melding(student1.getId(), LocalDateTime.now(), student1);
        melding2 = new Melding(student1.getId(), LocalDateTime.now(), student1);

        student2 = new Student("222222", 100002, "admin", " ", "kanker");
        melding3 = new Melding(student2.getId(), LocalDateTime.now(), student2);
        melding4 = new Melding(student2.getId(), LocalDateTime.now(), student2);

        opleiding.addStudent(student1);
        student1.setOpleiding(opleiding);

        opleiding.addStudent(student2);
        student2.setOpleiding(opleiding);
    }

    @Test
    void testAddMelding_newMelding() {
        // Arrange
        Melding melding1 = new Melding(student1.getId(), LocalDateTime.now(), student1);
        Melding melding2 = new Melding(student1.getId(), LocalDateTime.now(), student1);

        Melding melding3 = new Melding(student2.getId(), LocalDateTime.now(), student2);
        Melding melding4 = new Melding(student2.getId(), LocalDateTime.now(), student2);

        // Act
        Melding result1 = student1.addMelding(melding1);
        Melding result2 = student1.addMelding(melding2);

        Melding result3 = student2.addMelding(melding3);
        Melding result4 = student2.addMelding(melding4);

        // Assert
        assertEquals(melding1, result1);
        assertEquals(melding2, result2);
        assertEquals(melding1, student1.getMeldingen().iterator().next());
        assertEquals(melding2, student1.getMeldingen().iterator().next());
        assertEquals(student1, melding1.getStudent());
        assertEquals(student1, melding2.getStudent());

        assertEquals(melding3, result3);
        assertEquals(melding4, result4);
        assertEquals(melding3, student2.getMeldingen().iterator().next());
        assertEquals(melding4, student2.getMeldingen().iterator().next());
        assertEquals(student2, melding3.getStudent());
        assertEquals(student2, melding4.getStudent());
    }

    @Test
    void testAddMelding_existingMelding() {
        // Arrange
        student1.addMelding(melding1);
        student1.addMelding(melding2);
        student2.addMelding(melding3);
        student2.addMelding(melding4);

        // Act
        Melding result1 = student1.addMelding(melding1);
        Melding result2 = student1.addMelding(melding2);

        Melding result3 = student2.addMelding(melding3);
        Melding result4 = student2.addMelding(melding4);

        // Assert
        assertEquals(melding1, result1);
        assertEquals(melding2, result2);
        assertEquals(melding1, student1.getMeldingen().iterator().next());
        assertEquals(melding2, student1.getMeldingen().iterator().next());
        assertEquals(student1, melding1.getStudent());
        assertEquals(student1, melding2.getStudent());

        assertEquals(melding3, result3);
        assertEquals(melding4, result4);
        assertEquals(melding3, student2.getMeldingen().iterator().next());
        assertEquals(melding4, student2.getMeldingen().iterator().next());
        assertEquals(student2, melding3.getStudent());
        assertEquals(student2, melding4.getStudent());
    }

    @Test
    void testAddMelding_multipleMeldings() {
        // Arrange
        student1.addMelding(melding1);
        student1.addMelding(melding2);

        student2.addMelding(melding3);
        student2.addMelding(melding4);

        // Act
        Melding result1 = student1.addMelding(melding1);
        Melding result2 = student1.addMelding(melding2);

        // Assert
        assertEquals(melding1, result1);
        assertEquals(melding2, result2);

        SortedSet<Melding> studentMeldings = student1.getMeldingen();
        if (studentMeldings != null) {
            Iterator<Melding> iterator = studentMeldings.iterator();
            assertEquals(melding1, iterator.next());
            assertEquals(melding2, melding1);
            assertFalse(iterator.hasNext());
        } else {
            fail("getMeldingen() returned null");
        }

        SortedSet<Melding> student2Meldings = student2.getMeldingen();
        if (student2Meldings != null) {
            Iterator<Melding> iterator = student2Meldings.iterator();
            assertEquals(melding3, iterator.next());
            assertEquals(melding4, melding3);
            assertFalse(iterator.hasNext());
        } else {
            fail("getMeldingen() returned null");
        }

        assertEquals(student1, melding1.getStudent());
        assertEquals(student1, melding2.getStudent());

        assertEquals(student2, melding3.getStudent());
        assertEquals(student2, melding4.getStudent());
    }


    @Test
    public void testFindStudentByEmail() {
        TestStudentDAO studentDAO = TestStudentDAO.getInstance();
        Student student = studentDAO.findById("100001");

        Account account = new Account("test@example.com", "123");
        student.setAccount(account);

        assertNotNull(studentDAO.findByEmail(account.getEmail()));
    }

    @Test
    public void laatMeldenTest() {


        Student student = DAOFactory.getFactory().getStudentDAO().findById("100001");


        Melding melding = student.addMelding(new LaatMelding(student.getId(),LocalDateTime.now(),  student, "yeah...", "Overige"));

        // Check if melding is added to student
        assertTrue(student.getMeldingen().contains(melding));

        // Check if opmerking is set
        assertEquals(((LaatMelding) melding).getOpmerking(), "yeah...");
        // Check if reden is set
        assertEquals(((LaatMelding) melding).getReden(), "Overige");

        // Check if melding has correct student
        assertEquals(melding.getStudent(), student);

    }

    @Test
    public void ziekMeldenTest() {


        Student student = DAOFactory.getFactory().getStudentDAO().findById("100001");
        LocalDateTime datum = LocalDateTime.now();

        Melding m1 = student.addMelding(new ZiekMelding(student.getId(),datum ,  student));

        // Check if melding is added to student
        assertTrue(student.getMeldingen().contains(m1));

        // Check if melding has correct student
        assertEquals(m1.getStudent(), student);

    }

}