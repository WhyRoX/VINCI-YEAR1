import java.util.Comparator;

public class ComparateurPersonneAvecPriorite implements Comparator<PersonneAvecPriorite> {

    public int compare(PersonneAvecPriorite p1, PersonneAvecPriorite p2) {
       return p1.getPriorite() - p2.getPriorite();
    }

}
