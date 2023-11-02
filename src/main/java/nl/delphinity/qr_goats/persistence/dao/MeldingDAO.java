package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IMeldingDAO;

public class MeldingDAO extends GenericHibernateDAO<Melding, Integer> implements IMeldingDAO {

    @Override
    public Melding findByStudent(Student student) {
        getSession().beginTransaction();
        Melding entity = getSession().find(getPersistentClass(), student.getId());
        getSession().getTransaction().commit();
        return entity;
    }

    @Override
    public void save(boolean add) {
        if (add) {
            getSession().beginTransaction();
            getSession().persist(this);
            getSession().getTransaction().commit();
        }
    }

}
