import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Projet{
    private int numero;
    private String nom;
    private boolean termine;
    private ArrayList<Developpeur> developpeurs = new ArrayList<>();
    private static int nombreDeProjets=0;

    public Projet(String nom) {
        this.nom = nom;
        this.numero = ++nombreDeProjets;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public boolean isTermine() {
        return termine;
    }
    public boolean ajouter(Developpeur developpeur) {
        if (termine) return false;
        if (developpeurs.contains(developpeur)) return false;
        developpeur.signalerNouveauProjet();
        return developpeurs.add(developpeur);
    }
    public boolean retirer(Developpeur developpeur) {
        if (termine) return false;
        boolean retire = developpeurs.remove(developpeur);
        if (retire) developpeur.signalerFinDuProjet();
        return retire;
    }
    public boolean terminer() {
        if (termine) return false;
        for (Developpeur dev : developpeurs) {
            dev.signalerFinDuProjet();
        }
        this.termine = true;
        return true;
    }
    public Iterator <Developpeur> iterator() {
        return developpeurs.iterator();
    }


    @Override
    public String toString() {
        String infos = "Projet " + numero + " : " + nom;
        if (termine) infos += " termine";
        else infos += " en cours";
        infos += "\nDeveloppeur(s) sur le projet : ";
        for (Developpeur developpeur : developpeurs) {
            infos +="\n" + developpeur;
        }
        return infos;
    }
}

