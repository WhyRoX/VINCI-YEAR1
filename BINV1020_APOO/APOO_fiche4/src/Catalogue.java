import java.util.ArrayList;
import java.util.Objects;

public class Catalogue {
    private ArrayList<Livre> livres;

    public Catalogue() {
        livres = new ArrayList<Livre>();
    }

    public boolean contient(Livre livre) { return livres.contains(livre);}

    public boolean ajouter(Livre livre) {
        if (!contient(livre)){
            return livres.add(livre);

        };
        return false;
    }

    public boolean retirer(Livre livre) {
        return livres.remove(livre);
    }
    public boolean estVide() { return livres.isEmpty();}

    public int nombreDeLivres() {return livres.size();}


    public Livre chercherLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null;
    }

    public String toString() {
        String txt = "Liste des livres : \n";
        for (Livre livre : livres) {
            txt += livre.toString() + "\n";
        }
        return txt;
    }
}
