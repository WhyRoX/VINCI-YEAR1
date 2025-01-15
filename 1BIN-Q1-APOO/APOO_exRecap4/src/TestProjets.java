/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class TestProjets {

    public static void main(String[] args) {
        /*  Scenario 1  */
        Projet projet1 = new Projet("Site stages");
        Developpeur olivier = new Developpeur("Olivier", "infra", 3500.0);
        Developpeur zoe = new DeveloppeurStagiaire("Zoe", "back-end", "IPL");
        Developpeur loic = new Developpeur("Loic",3000);

        /*  Scenario 2  */
        projet1.ajouter(olivier);
        projet1.ajouter(zoe);
        projet1.ajouter(loic);
        projet1.retirer(loic);
        System.out.println(projet1);
        System.out.println();

        /*  Scenario 3  */
        projet1.terminer();
        System.out.println(projet1);

    }


}
