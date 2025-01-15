import java.time.LocalDate;

public class TestCompteEnBanque {
    public static void main(String[] args) {
        PersonneCp titulaire1 = new PersonneCp("Jean", "Dupont");
        LocalDate dateValiditeIDCard1 = LocalDate.of(2025, 12, 31);
        String numero1 = "000-000000089-89";
        LocalDate dateOuverture1 = LocalDate.of(2023, 10, 1);
        double solde1 = 1200;

        PersonneCp titulaire2 = new PersonneCp("Alice", "Martin");
        LocalDate dateValiditeIDCard2 = LocalDate.of(2024, 8, 15);
        String numero2 = "111-111111111-11";
        LocalDate dateOuverture2 = LocalDate.of(2023, 10, 1);
        double solde2 = 800;

        CompteEnBanque compte1 = new CompteEnBanque(titulaire1, dateValiditeIDCard1, numero1, dateOuverture1, solde1);
        CompteEnBanque compte2 = new CompteEnBanque(titulaire2, dateValiditeIDCard2, numero2, dateOuverture2, solde2);

        // Affichage du compte 1
        System.out.println("Informations du compte 1 :");
        System.out.println(compte1);
        System.out.println();

        // Dépôt sur le compte 1
        double montantDepot1 = 100;
        if (compte1.deposerArgent(montantDepot1)) {
            System.out.println("Dépôt de " + montantDepot1 + " sur le compte 1 effectué avec succès.");
        } else {
            System.out.println("Le dépôt sur le compte 1 n'a pas pu être effectué. Montant invalide.");
        }
        System.out.println("Informations du compte 1 après le dépôt :");
        System.out.println(compte1);
        System.out.println();

        // Retrait sur le compte 1
        double montantRetrait1 = 200;
        if (compte1.retirerArgent(montantRetrait1)) {
            System.out.println("Retrait de " + montantRetrait1 + " sur le compte 1 effectué avec succès.");
        } else {
            System.out.println("Le retrait sur le compte 1 n'a pas pu être effectué. Montant invalide ou solde insuffisant.");
        }
        System.out.println("Informations du compte 1 après le retrait :");
        System.out.println(compte1);
        System.out.println();

        // Affichage du compte 2
        System.out.println("Informations du compte 2 :");
        System.out.println(compte2);
        System.out.println();

        // Dépôt sur le compte 2
        double montantDepot2 = 150;
        if (compte2.deposerArgent(montantDepot2)) {
            System.out.println("Dépôt de " + montantDepot2 + " sur le compte 2 effectué avec succès.");
        } else {
            System.out.println("Le dépôt sur le compte 2 n'a pas pu être effectué. Montant invalide.");
        }
        System.out.println("Informations du compte 2 après le dépôt :");
        System.out.println(compte2);
        System.out.println();

        // Retrait sur le compte 2
        double montantRetrait2 = 100;
        if (compte2.retirerArgent(montantRetrait2)) {
            System.out.println("Retrait de " + montantRetrait2 + " sur le compte 2 effectué avec succès.");
        } else {
            System.out.println("Le retrait sur le compte 2 n'a pas pu être effectué. Montant invalide ou solde insuffisant.");
        }
        System.out.println("Informations du compte 2 après le retrait :");
        System.out.println(compte2);
        System.out.println();

        // Virement sur le compte 2
        double montantVirement = 300;
        if (compte1.effectuerVirement(compte2, montantVirement)) {
            System.out.println("Virement de " + montantVirement + " du compte 1 vers le compte 2 effectué avec succès.");
        } else System.out.println("Le virement n'a pas pu être effectué. Montant invalide ou solde insuffisant.");

        System.out.println("Informations du compte 1 après le virement :");
        System.out.println(compte1);
        System.out.println();

        System.out.println("Informations du compte 2 après le virement :");
        System.out.println(compte2);
    }
}
