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

    public void changerSerie(Serie nouvelleSerie) {
        if (nouvelleSerie != serie) {
            if (serie.getDelegue() == null || !serie.getDelegue().equals(this)) {
                serie = nouvelleSerie;
            } else {
                throw new IllegalStateException("L'étudiant est délégué de sa série actuelle.");
            }
        } else {
            throw new IllegalArgumentException("La nouvelle série est identique à la série actuelle.");
        }
    }

    @Override
    public String toString() {
        return "Matricule: " + matricule + ", Nom: " + nom + ", Prénom: " + prenom + ", Série: " + serie.getNom();
    }
}