import java.util.Objects;

public class PersonneAvecPriorite {

    public String prenom;
    public int priorite;

    public PersonneAvecPriorite(String prenom, int priorite) {
        this.prenom = prenom;
        this.priorite = priorite;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getPriorite() {
        return priorite;
    }

    @Override
    public String toString() {
        return prenom + " (" +
                priorite +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneAvecPriorite that = (PersonneAvecPriorite) o;
        return priorite == that.priorite && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, priorite);
    }
}
