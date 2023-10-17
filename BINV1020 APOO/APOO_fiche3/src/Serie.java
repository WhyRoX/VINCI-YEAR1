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

    public boolean elireDelegue(Etudiant etudiant) {
        if (etudiant.getSerie() == this && delegue == null) {
            delegue = etudiant;
            return true;
        }
        return false;
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