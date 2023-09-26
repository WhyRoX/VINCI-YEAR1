public class Adresse {
    private String rue;
    private String numero;
    private String codePostal;
    private String ville;

    public Adresse(String nRue, String nNumero, String nCodePostal, String nVille) {
            rue = nRue;
            numero = nNumero;
            codePostal = nCodePostal;
            ville = nVille;
    }
    public String getRue() {
        return rue;
    }
    public String getNumero() {
        return numero;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public String getVille() {
        return ville;
    }
    public String toString() {
        return rue + ", " + numero + " " + codePostal + " " + ville;
    }
}
