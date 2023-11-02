package nl.delphinity.qr_goats.controller;

import com.opensymphony.xwork2.ActionSupport;

import nl.delphinity.qr_goats.domain.*;
import org.apache.struts2.action.SessionAware;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class MeldingAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> sessionMap;

    private Melding meld;
    private String opmerking;
    private String reden;

    private LocalDateTime datum;
    private LocalDate begindatum;
    private LocalTime begintijd;
    private LocalDate einddatum;
    private LocalTime eindtijd;

    public String studentMeldZiek() {

        Student st = (Student) sessionMap.get("Student");
        Melding m = new ZiekMelding(st.getId(), LocalDateTime.now(), st);
        st.addMelding(m);
        
        return "SUCCESS";
    }

    public String studentMeldLaat() {

        Student st = (Student) sessionMap.get("Student");
        Melding laatmelding = new LaatMelding(st.getId(), LocalDateTime.now() , st, opmerking, reden);
        st.addMelding(laatmelding);
        
        return "SUCCESS";
    }

    public String verlofAanvragen() {

        Student st = (Student) sessionMap.get("Student");
        Melding verlofMelding = new VerlofMelding(st.getId(), LocalDateTime.now(), st, opmerking, begindatum, begintijd, einddatum, eindtijd);
        st.addMelding(verlofMelding);

        return "SUCCESS";

    }

    public Melding getMeld() {
        return meld;
    }

    public void setMeld(Melding meld) {
        this.meld = meld;
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

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(String begindatum) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(begindatum, formatter);
            this.begindatum = date;
        } catch (DateTimeParseException e) {
        }
    }

    public LocalTime getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(String begintijd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.begintijd = LocalTime.parse(begintijd, formatter);
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(String einddatum) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(einddatum, formatter);
            this.einddatum = date;
        } catch (DateTimeParseException e) {
        }
    }

    public LocalTime getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(String eindtijd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.eindtijd = LocalTime.parse(eindtijd, formatter);
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.sessionMap = session;
    }

}