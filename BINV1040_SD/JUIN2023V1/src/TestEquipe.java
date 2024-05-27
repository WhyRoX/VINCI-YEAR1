import java.util.Arrays;
import java.util.Scanner;

public class TestEquipe {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu==null) {
            if (recu!=null) {

                System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {

            System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
            System.exit(0);
        }
    }

    /**
     * Cette methode appelle la methode assertEquals avec un message d'erreur adequat
     * @param numeroMessage le numero du message a afficher en cas d'erreur
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a recu en realite
     */
    private static void assertEquals(int numeroMessage, Object attendu, Object recu) {
        String[] message = new String[10];
        message[0]="Test ko, la methode n'a pas renvoye ce qui etait attendu";
        message[1]="Test ko, apres appel de la methode, le nombre d'elements dans le map n'est pas celui attendu";
        message[2]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens -->";
        message[3]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens <--";
        assertEquals(message[numeroMessage],attendu,recu);
    }

    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("Programme Test pour la classe Equipe");
        System.out.println("************************************");
        int choix = 0;
        do {
            System.out.println("1 -> Tester le constructeur");
            System.out.println("2 -> Tester la methode insererApresChef()");
            System.out.println("3 -> Tester la methode tronquerAPartir()");
            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testConstructeur();
                    break;
                case 2:
                    testInsererApresChef();
                    break;
                case 3:
                    testTronquerAPartir();
                    break;
                default:
                    break;
            }
        } while (choix >= 1 && choix <= 3 );

    }

    private static void testConstructeur() {
        System.out.println();
        System.out.println("Equipe()");
        System.out.println("--------");
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest+" : construction d'1 equipe avec marie comme chef");
        try{
            Equipe equipe = new Equipe("marie");
            assertEquals(1, 1, equipe.nombreEquipiers());
            assertEquals(2, "(marie)", equipe.teteQueue());
            assertEquals(3, "(marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();


        System.out.println("Tous les tests ont reussi");
        System.out.println();
        System.out.println();

    }

    private static void testInsererApresChef() {
        System.out.println();
        System.out.println("insererApresChef()");
        System.out.println("------------------");
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest+ ": l'equipe contient plusieurs equipiers - le nouvel equipier n'est pas deja present");
        try{
            String[] tableTestee = {"marie","pierre","leo","mia"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "tim";
            System.out.println("table avant insertion : "+ Arrays.toString(tableTestee));
            System.out.println("on insere : "+equipier);
            assertEquals(0, true, equipe.insererApresChef(equipier));
            assertEquals(1, 5, equipe.nombreEquipiers());
            assertEquals(2, "(marie,tim,pierre,leo,mia)", equipe.teteQueue());
            assertEquals(3, "(mia,leo,pierre,tim,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipe contient plusieurs equipiers - le nouvel equipier est deja present");
        try{
            String[] tableTestee = {"marie", "pierre", "leo", "hugo", "mia", "eva"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "hugo";
            System.out.println("table avant insertion : "+ Arrays.toString(tableTestee));
            System.out.println("on insere : "+equipier);
            assertEquals(0, false, equipe.insererApresChef(equipier));
            assertEquals(1, 6, equipe.nombreEquipiers());
            assertEquals(2, "(marie,pierre,leo,hugo,mia,eva)", equipe.teteQueue());
            assertEquals(3, "(eva,mia,hugo,leo,pierre,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();


        //test3
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipe ne contient qu'un seul equipier (le chef) - le nouvel equipier n'est pas le chef");

        try{
            String[] tableTestee = {"marie"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "tim";
            System.out.println("table avant insertion : "+ Arrays.toString(tableTestee));
            System.out.println("on insere : "+equipier);
            assertEquals(0, true, equipe.insererApresChef(equipier));
            assertEquals(1, 2, equipe.nombreEquipiers());
            assertEquals(2, "(marie,tim)", equipe.teteQueue());
            assertEquals(3, "(tim,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
        System.out.println();

    }


    private static void testTronquerAPartir() {

        System.out.println();
        System.out.println("tronquerAPartir()");
        System.out.println("-----------------");
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest+ ": l'equipier a partir duquel se font les suppressions est present dans la liste");
        try{
            String[] tableTestee = {"marie", "pierre", "leo", "hugo", "mia", "eva"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "leo";
            System.out.println("table avant suppressions: "+ Arrays.toString(tableTestee));
            System.out.println("on supprime a partir de : "+equipier);
            assertEquals(0, true, equipe.tronquerAPartir(equipier));
            assertEquals(1, 2, equipe.nombreEquipiers());
            assertEquals(2, "(marie,pierre)", equipe.teteQueue());
            assertEquals(3, "(pierre,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipier a partir duquel se font les suppressions est celui qui suit le chef");
        try{
            String[] tableTestee = {"marie", "pierre", "leo", "hugo", "mia", "eva"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "pierre";
            System.out.println("table avant suppressions: "+ Arrays.toString(tableTestee));
            System.out.println("on supprime a partir de : "+equipier);
            assertEquals(0, true, equipe.tronquerAPartir(equipier));
            assertEquals(1, 1, equipe.nombreEquipiers());
            assertEquals(2, "(marie)", equipe.teteQueue());
            assertEquals(3, "(marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test3
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipier a partir duquel se font les suppressions est le dernier de la liste");
        try{
            String[] tableTestee = {"marie", "pierre","hugo", "mia", "eva"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "eva";
            System.out.println("table avant suppressions: "+ Arrays.toString(tableTestee));
            System.out.println("on supprime a partir de : "+equipier);
            assertEquals(0, true, equipe.tronquerAPartir(equipier));
            assertEquals(1, 4, equipe.nombreEquipiers());
            assertEquals(2, "(marie,pierre,hugo,mia)", equipe.teteQueue());
            assertEquals(3, "(mia,hugo,pierre,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test4
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipier a partir duquel se font les suppressions n'est pas present dans la liste");
        try{
            String[] tableTestee = {"marie", "pierre","hugo", "mia", "eva"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "sam";
            System.out.println("table avant suppressions: "+ Arrays.toString(tableTestee));
            System.out.println("on supprime a partir de : "+equipier);
            assertEquals(0, false, equipe.tronquerAPartir(equipier));
            assertEquals(1, 5, equipe.nombreEquipiers());
            assertEquals(2, "(marie,pierre,hugo,mia,eva)", equipe.teteQueue());
            assertEquals(3, "(eva,mia,hugo,pierre,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test5
        numeroTest++;
        System.out.println("test "+numeroTest+ ": l'equipe contient plusieurs equipiers - l'equipier a partir duquel se font les suppressions est le chef");
        try{
            String[] tableTestee = {"marie", "pierre","hugo", "mia"};
            Equipe equipe = new Equipe(tableTestee);
            String equipier = "marie";
            System.out.println("table avant suppressions: "+ Arrays.toString(tableTestee));
            System.out.println("on supprime a partir de : "+equipier);
            assertEquals(0, false, equipe.tronquerAPartir(equipier));
            assertEquals(1, 4, equipe.nombreEquipiers());
            assertEquals(2, "(marie,pierre,hugo,mia)", equipe.teteQueue());
            assertEquals(3, "(mia,hugo,pierre,marie)", equipe.queueTete());
        } catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();






        System.out.println("Tous les tests ont reussi");
        System.out.println();
        System.out.println();
    }


}
