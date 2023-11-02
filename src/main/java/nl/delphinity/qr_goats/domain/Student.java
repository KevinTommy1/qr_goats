package nl.delphinity.qr_goats.domain;

import java.util.SortedSet;
import java.util.TreeSet;

import jakarta.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_student_personID"))
@Table(name = "student")
public class Student extends Persoon {

	@Column(name = "studenten_nr", nullable = false, length = 6, unique = true)
	private String studentNr;

	@OneToOne
	@JoinColumn(name = "account_email")
	private Account account;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	@Cascade(CascadeType.PERSIST)
	private SortedSet<Melding> meldingen;

	@ManyToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "opleiding_id", nullable = false)
	private Opleiding opleiding;

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private SortedSet<CardLog> cardLogs;

	@Transient
	private QRCode qrCode;

	@Transient
	private boolean isIngecheckt;

	public Student() {
	}

	public Student(String studentNr, Integer id, String naam, String tussenvoegsel, String achternaam) {
		super(id, naam, tussenvoegsel, achternaam);
		this.studentNr = studentNr;
	}

	public Melding addMelding(Melding m) {

		if (meldingen == null) {
			meldingen = new TreeSet<>();
		}
		meldingen.add(m);
		m.setStudent(this);
		return m;
	}

	public void removeMelding(Melding m) {
		meldingen.remove(m);
		m.setStudent(null);
	}

	public void addCardlog(CardLog log) {

		if (cardLogs == null)
			cardLogs = new TreeSet<>();

		cardLogs.add(log);
		log.setStudent(this);

	}

	public String getStudentNr() {
		return studentNr;
	}

	public void setStudentNr(String studentNr) {
		this.studentNr = studentNr;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public SortedSet<Melding> getMeldingen() {
		return meldingen;
	}

	public void setMeldingen(SortedSet<Melding> meldingen) {
		this.meldingen = meldingen;
	}

	public Opleiding getOpleiding() {
		return opleiding;
	}

	public void setOpleiding(Opleiding opleiding) {
		this.opleiding = opleiding;
	}

	public SortedSet<CardLog> getCardLogs() {
		return cardLogs;
	}

	public void setCardLogs(SortedSet<CardLog> cardLogs) {
		this.cardLogs = cardLogs;
	}

	public QRCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QRCode qrCode) {
		this.qrCode = qrCode;
	}

	public boolean isIngecheckt() {
		return isIngecheckt;
	}

	public void setIngecheckt(boolean ingecheckt) {
		isIngecheckt = ingecheckt;
	}
	
	public int compareTo(Student other) {
		return studentNr.compareTo(other.studentNr);
	}

}