public class Article {
    private String reference;
    private String nom;
    private String description;
    private double prixHT;
    private double tauxTVA;

    public Article(String reference, String nom, String description, double prixHT, double tauxTVA) {
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixHT = prixHT;
        this.tauxTVA = tauxTVA;
    }
    public Article(String reference, String nom, String description, double prixHT) {
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixHT = prixHT;
        this.tauxTVA = 21;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public double calculerPrixTVAComprise() {
        return getPrixHT() * (1 + tauxTVA/100);
    }

    public double calculerPrixTVAComprise(double reduction) {
        return calculerPrixTVAComprise() * (1 - reduction / 100);
    }

    @Override
    public String toString() {
        return getNom() + " " + getReference() + "\n Reference" + getReference();
    }

}
