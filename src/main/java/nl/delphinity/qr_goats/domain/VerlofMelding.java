package nl.delphinity.qr_goats.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(
        foreignKey = @ForeignKey(name = "FK_verlofmelding_melding_id")
)
public class VerlofMelding extends Melding {

    private String opmerking;
    private LocalDate begindatum;
    private LocalTime begintijd;
    private LocalDate einddatum;
    private LocalTime eindtijd;

    public VerlofMelding() { }

    public VerlofMelding(int id, LocalDateTime datum,  Student student, String opmerking, LocalDate begindatum, LocalTime begintijd, LocalDate einddatum, LocalTime eindtijd) {
        super(id, datum,  student);
        this.opmerking = opmerking;
        this.begindatum = begindatum;
        this.begintijd = begintijd;
        this.einddatum = einddatum;
        this.eindtijd = eindtijd;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalTime getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(LocalTime begintijd) {
        this.begintijd = begintijd;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
    }

    public LocalTime getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(LocalTime eindtijd) {
        this.eindtijd = eindtijd;
    }

    @Override
    public String toString() {
        return "VerlofMelding{" +
                "opmerking='" + opmerking + '\'' +
                ", begindatum=" + begindatum +
                ", begintijd=" + begintijd +
                ", einddatum=" + einddatum +
                ", eindtijd=" + eindtijd +
                '}';
    }

}
