package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.persistence.interfaces.IOpleidingDAO;

public class TestOpleidingDAO extends GenericTestDAO<Opleiding, Integer> implements IOpleidingDAO {

    private static TestOpleidingDAO instance;
    private final ArrayList<Opleiding> opleidingen;

    public static TestOpleidingDAO getInstance() {
        if (instance == null)
            instance = new TestOpleidingDAO();
        return instance;
    }

    private TestOpleidingDAO() {
        opleidingen = new ArrayList<>() {{
            add(
                    new Opleiding(1, "Test Opleiding")
            );
        }};
    }

    @Override
    public Opleiding save(Opleiding entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Opleiding entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Opleiding findById(Integer id) {

        for (Opleiding o : opleidingen) {
            if (Objects.equals(o.getId(), id)) {
                return o;
            }
        }

        return null;
    }

    @Override
    public List<Opleiding> findAll() {
        return null;
    }

}
