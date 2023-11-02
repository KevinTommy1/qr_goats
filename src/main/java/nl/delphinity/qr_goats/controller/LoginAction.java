package nl.delphinity.qr_goats.controller;

import java.awt.image.BufferedImage;
import java.util.Map;

import org.apache.struts2.action.SessionAware;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.domain.QRCode;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private Map<String, Object> sessionMap;
	private Account acc;
	private Persoon per;
	private Student stud;
	private Opleiding opl;
	private String lastcardlog;
	private QRCode qrcode = new QRCode();
	private boolean optijd;
	private String oudww;
	private String nieuwww1;
	private String nieuwww2verify;

	public String execute() {
		acc = (Account) sessionMap.get("Account");
		return "SUCCESS";
	}

	public String login() {
	    try {
	        // Perform login check
	        if (acc.loginCheck()) {
	            // Logic for successful login

	            // Set Account, Student, Opleiding, and QRImage session attributes
	            acc = DAOFactory.getFactory().getAccountDAO().findByEmail(acc.getEmail());
	            sessionMap.putIfAbsent("Account", acc);

	            //TODO haal student weg, gebruik account om toegang aan student te krijgen
	            stud = DAOFactory.getFactory().getStudentDAO().findByEmail(acc.getEmail());
	            sessionMap.putIfAbsent("Student", stud);

	            opl = OpleidingFacade.getInstance().getOpleiding();
	            sessionMap.putIfAbsent("Opleiding", opl);

	            String studentenNummer = stud.getStudentNr();
	            QRCode.generateQR(studentenNummer);
	            sessionMap.putIfAbsent("QRImage", qrcode);

	            return "SUCCESS"; // Successful login
	        } else {
	            return "ERROR"; // Return "ERROR" result when login fails
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "ERROR"; // Return "ERROR" result on exception
	    }
	}

	public String logOut() {
		sessionMap.clear();
		HibernateSessionManager.getSessionFactory().getCurrentSession().close();
		return "SUCCESS";
	}

	public String wijzigWachtwoord() {
		if (nieuwww1.equals(nieuwww2verify)) {
			acc = (Account) sessionMap.get("Account");
			if (acc.changePassword(oudww, nieuwww1)) {
				sessionMap.put("Account", acc);
				return SUCCESS;
			}
		}
		return ERROR;
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

	public String getOudww() {
		return oudww;
	}

	public void setOudww(String oudww) {
		this.oudww = oudww;
	}

	public String getNieuwww1() {
		return nieuwww1;
	}

	public void setNieuwww1(String nieuwww1) {
		this.nieuwww1 = nieuwww1;
	}

	public String getNieuwww2verify() {
		return nieuwww2verify;
	}

	public void setNieuwww2verify(String nieuwww2verify) {
		this.nieuwww2verify = nieuwww2verify;
	}

	public boolean isOptijd() {
		return optijd;
	}

	public void setOptijd(boolean optijd) {
		this.optijd = optijd;
	}

	public String getLastcardlog() {
		return lastcardlog;
	}

	public void setLastcardlog(String lastcardlog) {
		this.lastcardlog = lastcardlog;
	}

	public Persoon getPer() {
		return per;
	}

	public void setPer(Persoon per) {
		this.per = per;
	}

	public QRCode getQrcode() {
		return qrcode;
	}

	public void setQrcode(QRCode qrcode) {
		this.qrcode = qrcode;
	}

}
