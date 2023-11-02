package nl.delphinity.qr_goats.controller;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.domain.*;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class FAQVerwijderenAction implements SessionAware {

    private String id;
    private Map<String, Object> session;

    public String delete() {
        Opleiding opleiding = OpleidingFacade.getInstance().getOpleiding();
        System.out.println(id);
        Question question = DAOFactory.getFactory().getQuestionDAO().findById(Integer.parseInt(id));

        Account account = (Account) session.get("Account");
        opleiding.deleteQuestion(question, account);

        return "SUCCESS";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
