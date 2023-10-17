class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private Serie serie;

    public Etudiant(String matricule, String nom, String prenom, Serie serie) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.serie = serie;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Serie getSerie() {
        return serie;
    }

    public boolean changerSerie(Serie nouvelleSerie) {
        if (nouvelleSerie != serie && serie.getDelegue() != this) {
            serie = nouvelleSerie;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Matricule: " + matricule + ", Nom: " + nom + ", Prénom: " + prenom + ", Série: " + serie.getNom();
    }
}