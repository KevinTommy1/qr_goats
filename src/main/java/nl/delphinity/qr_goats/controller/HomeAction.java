package nl.delphinity.qr_goats.controller;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.domain.Student;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class HomeAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> sessionMap;

    private Persoon per;
    private Student stud;
    private Account acc;

    @Override
    public String execute() {
        acc = (Account) sessionMap.get("Account");
        return "SUCCESS";
    }

    public String profiel() {
        acc = (Account) sessionMap.get("Account");
        return "SUCCESS";
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.sessionMap = session;
    }

    public Persoon getPer() {
        return per;
    }

    public void setPer(Persoon per) {
        this.per = per;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

}
