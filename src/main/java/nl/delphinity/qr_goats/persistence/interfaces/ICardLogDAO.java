package nl.delphinity.qr_goats.persistence.interfaces;

import nl.delphinity.qr_goats.domain.CardLog;

import java.util.List;

public interface ICardLogDAO extends IGenericDAO<CardLog, String> {

    CardLog findByStudent(String studentNr);

    List<CardLog> findAllByStudent(String studentNr, int limit);

}
