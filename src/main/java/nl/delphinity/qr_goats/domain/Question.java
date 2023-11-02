package nl.delphinity.qr_goats.domain;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "question")
public class Question implements Comparable<Question> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SortedSet<Answer> answers;

	@ManyToOne
	@JoinColumn(name = "opleiding_id")
	private Opleiding opleiding;

	@Column(nullable = false, name = "question_name")
	private String questionName;

	public Question() { }

	public Question(Integer id, SortedSet<Answer> answers, String questionName) {
		this.id = id;
		this.answers = answers;
		this.questionName = questionName;
	}

	public Question(String questionName) {
		this.questionName = questionName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SortedSet<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(SortedSet<Answer> answers) {
		this.answers = answers;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String question) {
		this.questionName = question;
	}

	public Opleiding getOpleiding() {
		return opleiding;
	}

	public void setOpleiding(Opleiding opleiding) {
		this.opleiding = opleiding;
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

		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Question other = (Question) obj;

		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return questionName;
	}

	@Override
	public int compareTo(Question o) {
		return this.questionName.compareToIgnoreCase(o.questionName);
	}


	public boolean addAnswer(Answer answer, Account account) {

		if (account.getMachtigingen() < 2)
			return false;

		if (answers == null)
			answers = new TreeSet<>();

		answers.add(answer);
		DAOFactory.getFactory().getAnswerDAO().save(answer);
		return true;
	}
	
	public boolean deleteAnswer(Answer answer, Account account) {
		
		if (account.getMachtigingen() < 2)
			return false;
		
		if (answers == null)
			answers = new TreeSet<>();

		answers.remove(answer);
		DAOFactory.getFactory().getAnswerDAO().delete(answer);
		return true;
	}
}
