/**
 * @author Coded by Enes Yumer
 * @Date 13-11-23
 */
import java.time.Duration;
import java.time.LocalDateTime;

public class TestAppelTelephonique {
    public static void main(String[] args) {
        try {
            LocalDateTime dateAppel1 = LocalDateTime.now().minusHours(1);
            Duration dureeAppel1 = Duration.ofMinutes(30);
            AppelTelephonique appel1 = new AppelTelephonique(dateAppel1, dureeAppel1, "1234567890");

            System.out.println("Appel créé : " + appel1);

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'appel : " + e.getMessage());
        }

        try {
            LocalDateTime dateAppel2 = LocalDateTime.now().plusHours(1);
            Duration dureeAppel2 = Duration.ofMinutes(-30); // Durée invalide
            AppelTelephonique appel2 = new AppelTelephonique(dateAppel2, dureeAppel2, "9876543210");
            System.out.println("Appel créé : " + appel2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'appel : " + e.getMessage());
        }
    }
}

