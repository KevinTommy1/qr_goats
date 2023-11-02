package nl.delphinity.qr_goats.domain;

import java.util.Objects;

import jakarta.persistence.*;

import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@Table(
        name = "account",
        indexes = {
                @Index(columnList = "email")
        }
)
public class Account implements Comparable<Account> {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String wachtwoord;

    @Column(columnDefinition = "int default 1", nullable = false, length = 1)
    private Integer machtigingen;

    public Account() { }

    public Account(String email, String wachtwoord) {
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public Account(String email, String wachtwoord, int machtigingen) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.machtigingen = machtigingen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Integer getMachtigingen() {
        return machtigingen;
    }

    public void setMachtigingen(Integer machtigingen) {
        this.machtigingen = machtigingen;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (email == null ? 0 : email.hashCode());

        return result;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Account other = (Account) obj;

        return Objects.equals(email, other.email);

    }

    @Override
    public String toString() {
        return email + " " + wachtwoord;
    }

    @Override
    public int compareTo(Account other) {
        int temp = email.compareTo(other.email);
        if (temp == 0) {
            return wachtwoord.compareTo(other.wachtwoord);
        }
        return temp;
    }

    public boolean loginCheck() {

        Account other = DAOFactory.getFactory().getAccountDAO().findByEmail(email);

        if (other == null) {
            return false;
        } else
            try {
                return PasswordHashing.verifyPassword(this.wachtwoord, other.wachtwoord);
            } catch (CannotPerformOperationException | InvalidHashException e) {
                e.printStackTrace();
            }

        return false;

    }

    public boolean changePassword(String oudWachtwoord, String nieuwWachtwoord) {
        try {
            if (PasswordHashing.verifyPassword(oudWachtwoord, wachtwoord) && !PasswordHashing.verifyPassword(nieuwWachtwoord, wachtwoord)) {
                wachtwoord = PasswordHashing.createHash(nieuwWachtwoord);
                DAOFactory.getFactory().getAccountDAO().save(this);
                return true;
            }
        } catch (CannotPerformOperationException | InvalidHashException e) {
            e.printStackTrace();
        }
        return false;
    }


}
	

