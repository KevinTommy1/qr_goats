package nl.delphinity.qr_goats.controller;


import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
import org.apache.struts2.action.SessionAware;

import java.util.Map;


public class FAQAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 1L;

 

    private Map<String, Object> sessionMap;

    private Opleiding opleiding;
    private String question;
    private String answer;
    private Account acc; 
    
    @Override
    public String execute() throws Exception {	
    	acc = (Account) sessionMap.get("Account");	
        opleiding = OpleidingFacade.getInstance().getOpleiding();
        return SUCCESS;
    }

    public String addFaq() {

		opleiding = OpleidingFacade.getInstance().getOpleiding();
		acc = (Account) sessionMap.get("Account");

		Question q = new Question();
		Answer a = new Answer();
		a.setQuestion(q);

		q.setQuestionName(question);
		a.setAnswerName(answer);

		opleiding.addQuestion(q, acc);
		q.addAnswer(a, acc);
		return "SUCCESS";
	}
    
    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	@Override
    public void withSession(Map<String, Object> session) {
        this.sessionMap = session;
    }

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

}