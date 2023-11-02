package nl.delphinity.qr_goats.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.CardLog;
import nl.delphinity.qr_goats.domain.QRCode;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.action.SessionAware;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

public class IncheckAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private Map<String, Object> sessionMap;
	private boolean optijd;
	private String lastcardlog;
	private Student stud;
	private QRCode qrcode = new QRCode();
	private BufferedImage qrimage;
	private Account acc;
	private List<String> registraties;

	public String formatCardLog(LocalDateTime datetime) {
		LocalDateTime now = LocalDateTime.now();

		Duration duration = Duration.between(datetime, now);
		long days = duration.toDays();
		long hours = duration.toHours();
		long minutes = duration.toMinutes();
		
		if (days == 1) {
			return days + " dag geleden, " + datetime.format(DateTimeFormatter.ofPattern("HH:mm"));
		} else if (days > 0) {
			return days + " dagen geleden, " + datetime.format(DateTimeFormatter.ofPattern("HH:mm"));
		} else if (hours > 0) {
			return "vandaag, " + datetime.format(DateTimeFormatter.ofPattern("HH:mm"));
		} else if (minutes > 0) {
			return minutes + " minuten geleden";
		} else {
			return "zojuist";
		}
	}

	public String loadQR() {
	    stud = (Student) sessionMap.get("Student");
	    acc = (Account) sessionMap.get("Account");

	    CardLog log = DAOFactory.getFactory().getCardLogDAO().findByStudent(stud.getStudentNr());

	    String studentenNummer = stud.getStudentNr();
	    BufferedImage qrImage = QRCode.generateQR(studentenNummer);

	    // Convert BufferedImage to base64-encoded string
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	        ImageIO.write(qrImage, "png", baos);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    byte[] imageBytes = baos.toByteArray();
	    String base64Image = Base64.encodeBase64String(imageBytes);

	    // Store the base64-encoded image in session attribute
	    sessionMap.put("QRImage", base64Image);

	    if (log == null) {
	        lastcardlog = "U heeft nooit ingecheckt";
	    } else {
	        lastcardlog = formatCardLog(log.getDate());
	    }

		registraties = DAOFactory.getFactory()
				.getCardLogDAO()
				.findAllByStudent(
						stud.getStudentNr(),
						10
				).stream() // Hier zetten we de List<CardLog> om naar een Stream<CardLog>.
				.map(
						c -> formatCardLog(c.getDate()) // Hierin zetten we het CardLog object om naar String d.m.v de formatCardLog en map methode.
				)
				.collect(Collectors.toList()); // Hiermee zetten we de stream terug naar een List<String>.

	    optijd = qrcode.isOptijd(LocalDateTime.now());

	    return "SUCCESS";
	}

	public QRCode getQrcode() {
		return qrcode;
	}

	public void setQrcode(QRCode qrcode) {
		this.qrcode = qrcode;
	}

	public BufferedImage getQrimage() {
		return qrimage;
	}

	public void setQrimage(BufferedImage qrimage) {
		this.qrimage = qrimage;
	}

	public Boolean getOptijd() {
		return optijd;
	}

	public void setOptijd(Boolean optijd) {
		this.optijd = optijd;
	}

	public String getLastcardlog() {
		return lastcardlog;
	}

	public void setLastcardlog(String lastcardlog) {
		this.lastcardlog = lastcardlog;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
  
	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
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

	public List<String> getRegistraties() {
		return registraties;
	}

	public void setRegistraties(List<String> registraties) {
		this.registraties = registraties;
	}

}
