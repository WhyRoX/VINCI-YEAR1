public class TestLivre {
    public static void main(String[] args) {
        Livre livre1 = new Livre("1035201937", "Frere de sang", "Mikael Ollivier", 8.00, 2018, 142);
        Livre livre2 = new Livre("1035201957", "Frere de ", "Mikael ", 8.50, 2098, 192);
        System.out.println("Livre : " + livre1.titre + livre1.anneeEdition + livre1.auteur);
        System.out.println(livre2);
  }
}
