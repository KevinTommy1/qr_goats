package nl.delphinity.qr_goats.domain;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import jakarta.persistence.*;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@Table(name = "opleiding")
public class Opleiding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "naam", length = 20, nullable = false)
    private String naam;

    @OneToMany(mappedBy = "opleiding", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SortedSet<Student> studenten;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "opleiding_id")
    private SortedSet<Question> questions;

    public Opleiding() { }

    public Opleiding(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Opleiding(String naam) {
        this.naam = naam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public SortedSet<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(SortedSet<Student> studenten) {
        this.studenten = studenten;
    }

    public SortedSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(SortedSet<Question> questions) {
        this.questions = questions;
    }

    public void removeStudent(Student s) {
        studenten.remove(s);
        s.setOpleiding(null);
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

        Opleiding other = (Opleiding) obj;

        return Objects.equals(id, other.id);

    }

    @Override
    public String toString() {
        return naam;
    }

    public boolean addQuestion(Question question, Account account) {

        if (account.getMachtigingen() < 2)
            return false;

        if (questions == null)
            questions = new TreeSet<>();

        question.setOpleiding(this);
        questions.add(question);
        DAOFactory.getFactory().getQuestionDAO().save(question);
        return true;

    }
    
    public boolean deleteQuestion(Question question, Account account) {
    	if (account.getMachtigingen() < 2)
    		return false;
    	
		if (questions == null)
			questions = new TreeSet<>();

    	
    	questions.remove(question);
    	DAOFactory.getFactory().getQuestionDAO().delete(question);
    	return true;
    }

    public void addStudent(Student student) {

        if (studenten == null)
            studenten = new TreeSet<>();

        student.setOpleiding(this);
        studenten.add(student);

    }

}
