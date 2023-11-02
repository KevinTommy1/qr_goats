package nl.delphinity.qr_goats.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import java.util.Objects;

@Entity
@Polymorphism(type = PolymorphismType.IMPLICIT)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persoon")
public class Persoon implements Comparable<Persoon> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 60)
	private String voornaam;

	@Column(length = 20)
	private String tussenvoegsel;

	@Column(nullable = false, length = 60)
	private String achternaam;

	public Persoon() { }

	public Persoon(Integer id, String voornaam, String tussenvoegsel, String achternaam) {
		this.id = id;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
	}

	public Persoon(String voornaam, String tussenvoegsel, String achternaam) {
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String naam) {
		this.voornaam = naam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
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

		Persoon other = (Persoon) obj;

		return Objects.equals(id, other.id);

	}

	@Override
	public String toString() {
		return voornaam + (tussenvoegsel == null ? " " : " " + tussenvoegsel + " ") + achternaam;
	}

	public int compareTo(Persoon other) {
		// TODO fix dit, als tussenvoegsel null is bij een persoon dan is er een error
		int temp = voornaam.compareTo(other.voornaam);
		if (temp == 0) {
			int temp2 = achternaam.compareTo(other.achternaam);
			if (temp2 == 0) {
				if (tussenvoegsel == null || other.tussenvoegsel == null) {
					return 0;
				} else {
					int temp3 = tussenvoegsel.compareTo(other.tussenvoegsel);
					return temp3;
				}
			}
			return temp2;
		}
		return temp;
	}

}