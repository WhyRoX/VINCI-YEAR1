/**
 * @author Coded by Enes Yumer
 * @Date 13-11-23
 */
import java.time.LocalDateTime;
import java.time.Duration;
public class AppelTelephonique {
    private LocalDateTime dateAppel;
    private Duration dureeAppel;
    private String numeroAppele;
    private static double tarifAppel = 0.15;

    public AppelTelephonique(LocalDateTime dateAppel, Duration dureeAppel, String numeroAppele) {
        if (dateAppel == null || dureeAppel == null || numeroAppele == null)
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être null");
        if (tarifAppel <= 0) throw new IllegalArgumentException("Le tarif ne peut pas être négatif ou nul");
        if (dureeAppel.isNegative()) throw new IllegalArgumentException("La durée ne peut pas être négative");
        if (dateAppel.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("La date ne peut pas être dans le futur");

        this.dateAppel = dateAppel;
        this.dureeAppel = dureeAppel;
        this.numeroAppele = numeroAppele;
    }

    public AppelTelephonique(LocalDateTime dateAppel, Duration dureeAppel, String numeroAppele, double tarifAppel) {
        this(dateAppel, dureeAppel, numeroAppele);
        AppelTelephonique.tarifAppel = tarifAppel;
    }

    public LocalDateTime getDateAppel() {
        return dateAppel;
    }

    public void setDateAppel(LocalDateTime dateAppel) {
        this.dateAppel = dateAppel;
    }

    public Duration getDureeAppel() {
        return dureeAppel;
    }

    public void setDureeAppel(Duration dureeAppel) {
        this.dureeAppel = dureeAppel;
    }


    public String getNumeroAppele() {
        return numeroAppele;
    }

    public void setNumeroAppele(String numeroAppele) {
        this.numeroAppele = numeroAppele;
    }

    public double getTarifAppel() {
        return tarifAppel;
    }

    public void setTarifAppel(double coutAppel) {
        if (tarifAppel <= 0) throw new IllegalArgumentException("Le tarif ne peut pas être négatif ou nul");
        tarifAppel = coutAppel;
    }

    @Override
    public String toString() {
        return "AppelTelephonique{" +
                "dateAppel= " + dateAppel +
                ", dureeAppel= " + dureeAppel + '\'' +
                ", numeroAppele= '" + numeroAppele + '\'' +
                ", tarifAppel= " + tarifAppel +
                '}';
    }
}
