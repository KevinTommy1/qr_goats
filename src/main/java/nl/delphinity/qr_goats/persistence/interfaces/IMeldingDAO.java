package nl.delphinity.qr_goats.persistence.interfaces;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;

public interface IMeldingDAO extends IGenericDAO<Melding, Integer> {

    Melding findByStudent(Student student);

    void save(boolean add);
}
