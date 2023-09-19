public class TestPersonne {
    public static void main(String[] args) {
        Personne pers1 = new Personne("Lolo Caca", 25, 6, 2004,"konizzpqdl");
        System.out.println(pers1);
        System.out.println("age ctr annee" + pers1.AgeFinAnnee());
        System.out.println("2025: " + pers1.AgeFin2025());
    }
}
