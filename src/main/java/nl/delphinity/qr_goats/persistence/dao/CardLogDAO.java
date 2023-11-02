package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.CardLog;
import nl.delphinity.qr_goats.persistence.interfaces.ICardLogDAO;

import java.util.List;

public class CardLogDAO extends GenericHibernateDAO<CardLog, String> implements ICardLogDAO {

    @Override
    public CardLog findByStudent(String studentNr) {
        getSession().beginTransaction();
        CardLog cardLog = getSession().createQuery("FROM CardLog WHERE student.studentNr = :studentNr ORDER BY date DESC", CardLog.class)
                .setParameter("studentNr", studentNr)
                .setMaxResults(1)
                .uniqueResult();
        getSession().getTransaction().commit();
        return cardLog;
    }

    @Override
    public List<CardLog> findAllByStudent(String studentNr, int limit) {
        getSession().beginTransaction();
        List<CardLog> result = getSession().createQuery("FROM CardLog WHERE student.studentNr = :studentNr ORDER BY date DESC", CardLog.class)
                .setParameter("studentNr", studentNr)
                .setMaxResults(limit)
                .getResultList();
        getSession().getTransaction().commit();
        return result;
    }

}
