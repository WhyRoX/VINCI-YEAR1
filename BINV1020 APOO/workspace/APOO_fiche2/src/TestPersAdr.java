public class TestPersAdr {
    public static void main(String[] args) {
        Adresse adresse = new Adresse("Rue de la gare", "34","5000", "Namur");
        Adresse nouvelleAdresse = new Adresse("Koningslosesteenweg","XX", "1853", "Strombeek-Bever");

        Date dateDeNaissance1 = new Date(1990, 5,15);
        Personne personne1 = new Personne("Schmidt", "Paul", dateDeNaissance1, adresse);

        Date dateDeNaissance2 = new Date(1985, 4, 30);
        Personne personne2 = new Personne("Gobert", "Valérie", dateDeNaissance2, adresse);

        personne1.demenager(nouvelleAdresse.getRue(), nouvelleAdresse.getNumero(), nouvelleAdresse.getCodePostal(), nouvelleAdresse.getVille());
        System.out.println(personne1);
        System.out.println(personne2);
    }

}
