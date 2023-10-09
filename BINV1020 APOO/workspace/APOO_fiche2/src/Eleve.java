public class Eleve {
    private String nom;
    private String prenom;
    private Cours coursPrincipal;
    private Cours coursComplementaire;

    public Eleve(String nom, String prenom, Cours coursPrincipal, Cours coursComplementaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.coursPrincipal = coursPrincipal;
        this.coursComplementaire = coursComplementaire;
        this.coursPrincipal.inscrireEleve();
        this.coursComplementaire.inscrireEleve();
        //this.coursPrincipal.desinscrireEleve();
        //this.coursComplementaire.inscrireEleve();
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Cours getCoursPrincipal() {
        return coursPrincipal;
    }

    public Cours getCoursComplementaire() {
        return coursComplementaire;
    }

    public void setCoursComplementaire(Cours coursComplementaire) {
        this.coursComplementaire = coursComplementaire;
        this.coursComplementaire.inscrireEleve();
        this.coursComplementaire.desinscrireEleve();


    }
    @Override
    public String toString() {
        return nom + " " + prenom + "\nCours principal : " + coursPrincipal.getIntitule() +
                "\nCours complémentaire : " + coursComplementaire.getIntitule();
    }
}