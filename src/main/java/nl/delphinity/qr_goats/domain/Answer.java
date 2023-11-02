package nl.delphinity.qr_goats.domain;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer implements Comparable<Answer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(nullable = false, name = "answer_name")
	private String answerName;

	public Answer() { }

	public Answer(Integer id, Question question, String answerName) {
		this.id = id;
		this.question = question;
		this.answerName = answerName;
	}

	public Answer(Question question, String answerName) {
		this.question = question;
		this.answerName = answerName;
	}

	public Question getQuestion() {
		return question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(Question owningQuestion) {
		this.question = owningQuestion;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answer) {
		this.answerName = answer;
	}

	@Override
	public String toString() {
		return answerName;
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
			return true;

		Answer other = (Answer) obj;

		return Objects.equals(id, other.id);

	}

	@Override
	public int compareTo(Answer o) {
        return this.answerName.compareToIgnoreCase(o.answerName);
	}

}