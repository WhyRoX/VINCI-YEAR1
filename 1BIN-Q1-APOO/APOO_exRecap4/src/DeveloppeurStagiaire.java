/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class DeveloppeurStagiaire extends Developpeur{
    private String ecole;

    public DeveloppeurStagiaire(String nom, String specialite, String ecole) {
        super(nom, specialite, 100);
        this.ecole = ecole;
    }

    public String getEcole() {
        return ecole;
    }

    @Override
    public String toString() {
        return "Stagiaire " + super.toString() + ", Ecole : " + ecole;
    }

}
