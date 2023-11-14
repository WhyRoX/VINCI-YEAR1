class Serie {
    private char nom;
    private Etudiant delegue;

    public Serie(char nom) {
        this.nom = nom;
        this.delegue = null;
    }

    public char getNom() {
        return nom;
    }

    public Etudiant getDelegue() {
        return delegue;
    }

    public void elireDelegue(Etudiant etudiant) {
        if (etudiant.getSerie() == this && delegue == null) {
            delegue = etudiant;
        } else {
            throw new IllegalArgumentException("Paramètre invalide pour l'élection du délégué.");
        }
    }

    @Override
    public String toString() {
        if (delegue != null) {
            return "Série " + nom + " - Délégué: " + delegue.getNom() + " " + delegue.getPrenom();
        } else {
            return "Série " + nom + " - Pas de délégué";
        }
    }
}