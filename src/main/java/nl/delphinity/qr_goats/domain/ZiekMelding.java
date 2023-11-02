package nl.delphinity.qr_goats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_ziekmelding_meldingID"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class ZiekMelding extends Melding {
	
	public ZiekMelding() { }
	
	public ZiekMelding(int id, LocalDateTime datum, Student student) {
		super(id, datum, student);
	}

	@Override
	public String toString() {
		return "ZiekMelding{" +
				"id=" + super.getId() +
				", datum=" + super.getDatum() +
				", student=" + super.getStudent() +
				'}';
	}

}
