public class Livre {

    int isbn;
    String titre;
    String auteur;
    double prix;
    int anneeEdition;
    int nbrePage;

    Livre(int nIsbn, String nTitre, String nAuteur, double nPrix, int nAnneeEdition, int nNbrePage) {
        isbn = nIsbn;
        titre = nTitre;
        auteur = nAuteur;
        prix = nPrix;
        anneeEdition = nAnneeEdition;
        nbrePage = nNbrePage;
    }
    public String toString() {
        return "Livre :" +
                "isbn = " + isbn +
                ", titre = '" + titre + '\'' +
                ", auteur = '" + auteur + '\'' +
                ", prix = " + prix +
                ", anneeEdition = " + anneeEdition +
                ", nbrePage = " + nbrePage
                ;
    }
}
