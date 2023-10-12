public class TestMembre {
    public static void main(String[] args) {
        Membre membre1 = new Membre("Leconte", "Emmeline", 123456789);
        boolean initParrainMembre1 = membre1.creerParrain(membre1);

        System.out.println(membre1);
        System.out.println("Résultat parrainage avec membre1 : " + initParrainMembre1);


        Membre membre2 = new Membre("Cambron", "Isabelle", 987654321);
        boolean initParrainMembre1ToMembre2 = membre1.creerParrain(membre2);

        System.out.println("Membre1 après initialisation du parrain avec membre2 : " + membre1);
        System.out.println("Résultat de l'initialisation du parrainage avec membre2 : " + initParrainMembre1ToMembre2);


        Membre membre3 = new Membre("Baroni", "Raphaël", 111223344);
        boolean initParrainMembre1ToMembre3 = membre1.creerParrain(membre3);

        System.out.println("Membre1 après tentative d'initialisation du parrain avec membre3 : " + membre1);
        System.out.println("Résultat de l'initialisation du parrainage avec membre3 : " + initParrainMembre1ToMembre3);
    }
}
