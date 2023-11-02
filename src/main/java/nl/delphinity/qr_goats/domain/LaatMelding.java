package nl.delphinity.qr_goats.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_laatmelding_meldingID"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class LaatMelding extends Melding {

	private String opmerking;
	
	@Column(nullable = false, length = 15)
	private String reden;

	public LaatMelding() { }

	public LaatMelding(int id, LocalDateTime datum, Student student, String opmerking, String reden) {
		super(id, datum, student);
		this.opmerking = opmerking;
		this.reden = reden;
	}

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	public String getReden() {
		return reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
	}

	@Override
	public String toString() {
		return "LaatMelding{" +
				"id=" + super.getId() +
				", datum=" + super.getDatum() +
				", student=" + super.getStudent() +
				", opmerking='" + opmerking + '\'' +
				", reden='" + reden + '\'' +
				'}';
	}

}
