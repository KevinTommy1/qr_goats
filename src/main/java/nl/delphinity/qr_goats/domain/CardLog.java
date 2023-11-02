package nl.delphinity.qr_goats.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "card_log")
public class CardLog implements Comparable<CardLog> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDateTime date;

	public CardLog() { }

	public CardLog(Integer id, Student student, LocalDateTime date) {
		this.id = id;
		this.student = student;
		this.date = date;
	}

	public CardLog(Student student, LocalDateTime date) {
		this.student = student;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + (id == null ? 0 : id.hashCode());

		return result;

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		CardLog other = (CardLog) obj;

		return id != null && id.equals(other.getId());

	}

	@Override
	public String toString() {
		return "Cardlog [id=" + id + ", student=" + student + ", date=" + date + "]";
	}

	@Override
	public int compareTo(CardLog other) {
		return this.date.compareTo(other.date);
	}

}
