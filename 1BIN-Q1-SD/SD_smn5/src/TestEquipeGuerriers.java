import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestEquipeGuerriers {

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
                System.out.println(""+messageErreur+"\nAttendu=\n"+attendu+"\nRecu=\n"+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(""+messageErreur+"\nAttendu="+attendu+"\nRecu="+recu);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe EquipeGuerriers");
        System.out.println("*********************************************");
        int choix = 0;
        do {
            System.out.println("1 -> Tester le constructeur");
            System.out.println("2 -> Tester la methode nombreGuerriersEnVie()");
            System.out.println("3 -> Tester la methode jouer()");
            System.out.println("4 -> Tester la methode getGuerrier()");
            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testConstructeur();
                    break;
                case 2:
                    testNombreGuerriers();
                    break;
                case 3:
                    testJouer();
                    break;
                case 4:
                    testGetGuerrier();
                    break;
            }
        } while (choix >= 1 && choix <= 4 );
    }

    private static void testConstructeur() {
        System.out.println();
        System.out.println("Tests constructeur");
        System.out.println("------------------");
        Guerrier g1;
        Guerrier g2;
        Guerrier g3;
        Guerrier g4;
        Guerrier g5;
        System.out.println();
        System.out.println("Test 1 : creation d'une equipe de 5 guerriers avec 6 points de vie");

        g1 = new Guerrier(1,6);
        g2 = new Guerrier(2,6);
        g3 = new Guerrier(3,6);
        g4 = new Guerrier(4,6);
        g5 = new Guerrier(5,6);

        ArrayList<Guerrier> a1 = new ArrayList<Guerrier>();
        a1.add(g1);
        a1.add(g2);
        a1.add(g3);
        a1.add(g4);
        a1.add(g5);


        LinkedList<Guerrier> l1 = new LinkedList<Guerrier>();
        l1.add(g1);
        l1.add(g2);
        l1.add(g3);
        l1.add(g4);
        l1.add(g5);

        EquipeGuerriers equipeAttendue = new EquipeGuerriers(a1, l1, 6);

        try{
            EquipeGuerriers equipeRecue = new EquipeGuerriers(5,6);
            assertEquals("Test 1 ko : contenu ko",equipeAttendue.toString(),equipeRecue.toString());
        }catch(Exception e){
            System.out.println("Test 1 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 ok");

        System.out.println();
        System.out.println("Test 2 : creation d'une equipe de 0 guerrier avec 6 points de vie");
        try{
            EquipeGuerriers equipeRecue = new EquipeGuerriers(0,6);
            System.out.println("Test 2 ko");
            System.out.println("Il faut au moins 1 guerrier vivant pour combattre la creature du mal");
            System.out.println("Il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(IllegalArgumentException e){

        }catch(Exception e){
            System.out.println("Test 2 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 ok");

        System.out.println();
        System.out.println("Test 3 : creation d'une equipe de 3 guerriers avec 0 point de vie");
        try{
            EquipeGuerriers equipeRecue = new EquipeGuerriers(3,0);
            System.out.println("Test 3 ko");
            System.out.println("Il faut au moins 1 guerrier vivant pour combattre la creature du mal");
            System.out.println("Il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(IllegalArgumentException e){

        }catch(Exception e){
            System.out.println("Test 3 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 ok");


        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testNombreGuerriers() {
        System.out.println();
        System.out.println("Tests nombreGuerriers()");
        System.out.println("-----------------------");
        Guerrier g1;
        Guerrier g2;
        Guerrier g3;
        Guerrier g4;
        Guerrier g5;
        ArrayList<Guerrier> a;
        LinkedList<Guerrier> l;
        EquipeGuerriers equipe;

        g1 = new Guerrier(1,6);
        g2 = new Guerrier(2,6);
        g3 = new Guerrier(3,6);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);

        l = new LinkedList<Guerrier>();

        equipe = new EquipeGuerriers(a, l, 6);

        if(equipe.nombreGuerriersEnVie()==3){
            System.out.println("Revoyez votre methode : FEU ROUGE");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Test 1 : exemple de l'enonce");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);
        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);
        equipe = new EquipeGuerriers(a, l, 6);

        System.out.println(equipe.toString());

        assertEquals("Test 1 ko",3,equipe.nombreGuerriersEnVie());
        System.out.println("Test 1 ok");


        System.out.println();
        System.out.println("Test 2 : l'equipe compte 5 guerriers tous vivants");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,5);
        g3 = new Guerrier(3,5);
        g4 = new Guerrier(4,5);
        g5 = new Guerrier(5,5);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);
        a.add(g5);

        l = new LinkedList<Guerrier>();
        l.add(g1);
        l.add(g2);
        l.add(g3);
        l.add(g4);
        l.add(g5);

        equipe = new EquipeGuerriers(a, l, 5);

        System.out.println(equipe.toString());

        assertEquals("Test 2 ko",5,equipe.nombreGuerriersEnVie());
        System.out.println("Test 2 ok");



        System.out.println();
        System.out.println("Test 3 : l'equipe compte 3 guerriers tous morts");

        g1 = new Guerrier(1,0);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,0);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);

        l = new LinkedList<Guerrier>();

        equipe = new EquipeGuerriers(a, l, 6);

        System.out.println(equipe.toString());

        assertEquals("Test 3 ko",0,equipe.nombreGuerriersEnVie());
        System.out.println("Test 3 ok");




        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testJouer() {

        System.out.println();
        System.out.println("Tests jouer()");
        System.out.println("-------------");

        Guerrier g1;
        Guerrier g2;
        Guerrier g3;
        Guerrier g4;

        ArrayList<Guerrier> a;
        LinkedList<Guerrier> l;
        EquipeGuerriers equipe;

        Guerrier g1A;
        Guerrier g2A;
        Guerrier g3A;
        Guerrier g4A;

        ArrayList<Guerrier> aAttendu;
        LinkedList<Guerrier> lAttendu;
        EquipeGuerriers equipeAttendue;


        System.out.println("Test 1 : exemple de l'enonce");
        System.out.println("Le guerrier qui joue perd 3 points de vie");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        g1A = new Guerrier(1,5);
        g2A = new Guerrier(2,0);
        g3A = new Guerrier(3,2);
        g4A = new Guerrier(4,1);

        aAttendu = new ArrayList<Guerrier>();
        aAttendu.add(g1A);
        aAttendu.add(g2A);
        aAttendu.add(g3A);
        aAttendu.add(g4A);

        lAttendu = new LinkedList<Guerrier>();

        lAttendu.add(g1A);
        lAttendu.add(g3A);
        lAttendu.add(g4A);

        equipeAttendue = new EquipeGuerriers(aAttendu, lAttendu, 6);

        try{

            Guerrier guerrier = equipe.jouer(3);
            if(guerrier==null){
                System.out.println("Test 1 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero()!= g4.getNumero()){
                System.out.println("Test 1 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Selon le jeu, c'est le guerrier 4 qui aurait du combattre.");
                System.exit(0);
            }
            if(guerrier.getPointsDeVie()!= 1){
                System.out.println("Test 1 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Ce guerrier a perdu 3 points de vie, il devrait lui rester 1 point de vie");
                System.exit(0);
            }
            assertEquals("Test 1 ko : contenu apres le jeu ko",equipeAttendue.toString(),equipe.toString());
        }catch(Exception e){
            System.out.println("Test 1 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 ok");


        System.out.println();
        System.out.println("Test 2 : exemple de l'enonce");
        System.out.println("Le guerrier qui joue perd 4 points de vie");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        g1A = new Guerrier(1,5);
        g2A = new Guerrier(2,0);
        g3A = new Guerrier(3,2);
        g4A = new Guerrier(4,0);

        aAttendu = new ArrayList<Guerrier>();
        aAttendu.add(g1A);
        aAttendu.add(g2A);
        aAttendu.add(g3A);
        aAttendu.add(g4A);

        lAttendu = new LinkedList<Guerrier>();
        lAttendu.add(g1A);
        lAttendu.add(g3A);

        equipeAttendue = new EquipeGuerriers(aAttendu, lAttendu, 6);

        try{
            Guerrier guerrier = equipe.jouer(4);
            if(guerrier==null){
                System.out.println("Test 2 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero()!= g4.getNumero()){
                System.out.println("Test 2 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Selon le jeu, c'est le guerrier 4 qui aurait du combattre.");
                System.exit(0);
            }
            if(guerrier.getPointsDeVie()!= 0){
                System.out.println("Test 2 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Ce guerrier a perdu 4 points de vie, il devrait lui rester 0 point de vie");
                System.exit(0);
            }
            assertEquals("Test 2 ko : contenu apres le jeu ko",equipeAttendue.toString(),equipe.toString());
        }catch(Exception e){
            System.out.println("Test 2 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 ok");


        System.out.println();
        System.out.println("Test 3 : exemple de l'enonce");
        System.out.println("Le guerrier qui joue perd 6 points de vie");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        g1A = new Guerrier(1,5);
        g2A = new Guerrier(2,0);
        g3A = new Guerrier(3,2);
        g4A = new Guerrier(4,0);

        aAttendu = new ArrayList<Guerrier>();
        aAttendu.add(g1A);
        aAttendu.add(g2A);
        aAttendu.add(g3A);
        aAttendu.add(g4A);

        lAttendu = new LinkedList<Guerrier>();
        lAttendu.add(g1A);
        lAttendu.add(g3A);

        equipeAttendue = new EquipeGuerriers(aAttendu, lAttendu, 6);

        try{
            Guerrier guerrier = equipe.jouer(4);
            if(guerrier==null){
                System.out.println("Test 3 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero()!= g4.getNumero()){
                System.out.println("Test 3 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Selon le jeu, c'est le guerrier 4 qui aurait du combattre.");
                System.exit(0);
            }
            if(guerrier.getPointsDeVie()!= 0){
                System.out.println("Test 3 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Ce guerrier a perdu 6 points de vie, il devrait lui rester 0 point de vie");
                System.exit(0);
            }
            assertEquals("Test 3 ko : contenu apres le jeu ko",equipeAttendue.toString(),equipe.toString());
        }catch(Exception e){
            System.out.println("Test 3 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 ok");


        System.out.println();
        System.out.println("Test 4 : equipe avec 3 guerriers");
        System.out.println("Seul le guerrier numero 2 est vivant. Avant de jouer, il a 3 points de vie");
        System.out.println("Il perd 5 points de vie");
        g1 = new Guerrier(1,0);
        g2 = new Guerrier(2,3);
        g3 = new Guerrier(3,0);
        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);

        l = new LinkedList<Guerrier>();
        l.add(g2);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        g1A = new Guerrier(1,0);
        g2A = new Guerrier(2,0);
        g3A = new Guerrier(3,0);

        aAttendu = new ArrayList<Guerrier>();
        aAttendu.add(g1A);
        aAttendu.add(g2A);
        aAttendu.add(g3A);

        lAttendu = new LinkedList<Guerrier>();

        equipeAttendue = new EquipeGuerriers(aAttendu, lAttendu, 6);

        try{
            Guerrier guerrier = equipe.jouer(5);
            if(guerrier==null){
                System.out.println("Test 4 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero()!= g2.getNumero()){
                System.out.println("Test 4 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Selon le jeu, c'est le guerrier 2 qui aurait du combattre.");
                System.exit(0);
            }
            if(guerrier.getPointsDeVie()!= 0){
                System.out.println("Test 4 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Ce guerrier a perdu 5 points de vie, il devrait lui rester 0 point de vie");
                System.exit(0);
            }
            assertEquals("Test 4 ko : contenu apres le jeu ko",equipeAttendue.toString(),equipe.toString());
        }catch(Exception e){
            System.out.println("Test 4 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 ok");


        System.out.println();
        System.out.println("Test 5 : exemple de l'enonce");
        System.out.println("Le guerrier qui joue perd -5 points de vie");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        try{
            Guerrier guerrier = equipe.jouer(-5);
            System.out.println("Test 5 ko");
            System.out.println("Le nombre de points de vie perdu est negatif");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }
        catch(Exception e){
            System.out.println("Test 5 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 ok");


        System.out.println();
        System.out.println("Test 6 : exemple de l'enonce");
        System.out.println("Le guerrier qui joue perd 0 point de vie");

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        try{
            Guerrier guerrier = equipe.jouer(0);
            System.out.println("Test 6 ko");
            System.out.println("Le nombre de points de vie perdu est 0");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }
        catch(Exception e){
            System.out.println("Test 6 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 ok");

        System.out.println();
        System.out.println("Test 7 : tous les guerriers sont morts");

        g1 = new Guerrier(1,0);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,0);
        g4 = new Guerrier(4,0);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        try{
            Guerrier guerrier = equipe.jouer(2);
            System.out.println("Test 7 ko");
            System.out.println("Il n'y a plus de guerrier vivant");
            System.out.println("Il fallait lancer une NoSuchElementException");
            System.exit(0);
        }catch(NoSuchElementException e){
        }
        catch(Exception e){
            System.out.println("Test 7 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 7 ok");


        //Les tests precedents fonctionnent si la recherche se fait dans l'arrayList en partant de la fin!
        System.out.println();
        System.out.println("Test 8 : 3 guerriers vivants");
        System.out.println("C'est le guerrier 2 qui doit jouer");
        System.out.println("Il a 6 points de vie et il va en perdre 5");

        g1 = new Guerrier(1,6);
        g2 = new Guerrier(2,6);
        g3 = new Guerrier(3,6);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);

        l = new LinkedList<Guerrier>();
        l.add(g2);
        l.add(g3);
        l.add(g1);

        equipe = new EquipeGuerriers(a, l, 6);
        System.out.println("L'equipe avant le jeu :");
        System.out.println(equipe.toString());

        g1A = new Guerrier(1,6);
        g2A = new Guerrier(2,1);
        g3A = new Guerrier(3,6);

        aAttendu = new ArrayList<Guerrier>();
        aAttendu.add(g1A);
        aAttendu.add(g2A);
        aAttendu.add(g3A);

        lAttendu = new LinkedList<Guerrier>();
        lAttendu.add(g3A);
        lAttendu.add(g1A);
        lAttendu.add(g2A);

        equipeAttendue = new EquipeGuerriers(aAttendu, lAttendu, 6);

        try{
            Guerrier guerrier = equipe.jouer(5);
            if(guerrier==null){
                System.out.println("Test 8 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero()!= 2){
                System.out.println("Test 8 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Selon le jeu, c'est le guerrier 2 qui aurait du combattre.");
                System.exit(0);
            }
            if(guerrier.getPointsDeVie()!= 1){
                System.out.println("Test 8 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.out.println("Ce guerrier a perdu 5 points de vie, il devrait lui rester 1 point de vie");
                System.exit(0);
            }
            assertEquals("Test 8 ko : contenu apres le jeu ko",equipeAttendue.toString(),equipe.toString());
        }catch(Exception e){
            System.out.println("Test 8 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 8 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testGetGuerrier() {
        System.out.println();
        System.out.println("Tests getGuerrier()");
        System.out.println("-------------------");

        Guerrier g1;
        Guerrier g2;
        Guerrier g3;
        Guerrier g4;

        ArrayList<Guerrier> a;
        LinkedList<Guerrier> l;
        EquipeGuerriers equipe;

        Guerrier g1A;
        Guerrier g2A;
        Guerrier g3A;
        Guerrier g4A;

        g1 = new Guerrier(1,5);
        g2 = new Guerrier(2,0);
        g3 = new Guerrier(3,2);
        g4 = new Guerrier(4,4);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);
        a.add(g3);
        a.add(g4);

        l = new LinkedList<Guerrier>();
        l.add(g4);
        l.add(g1);
        l.add(g3);

        equipe = new EquipeGuerriers(a, l, 6);

        System.out.println();
        System.out.println("Test 1 : exemple de l'enonce");
        System.out.println("'get' guerrier numero 2");
        System.out.println(equipe.toString());

        try{
            Guerrier guerrier = equipe.getGuerrier(2);
            if(guerrier==null){
                System.out.println("Test 1 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero() != 2){
                System.out.println("Test 1 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.exit(0);
            }

        }catch (Exception e){
            System.out.println("Test 1 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 ok");

        System.out.println();
        System.out.println("Test 2 : exemple de l'enonce");
        System.out.println("'get' guerrier numero 1");
        System.out.println(equipe.toString());

        try{
            Guerrier guerrier = equipe.getGuerrier(1);
            if(guerrier==null){
                System.out.println("Test 2 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero() != 1){
                System.out.println("Test 2 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.exit(0);
            }

        }catch (Exception e){
            System.out.println("Test 2 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 ok");

        System.out.println();
        System.out.println("Test 3 : exemple de l'enonce");
        System.out.println("'get' guerrier numero 4");
        System.out.println(equipe.toString());
        try{
            Guerrier guerrier = equipe.getGuerrier(4);
            if(guerrier==null){
                System.out.println("Test 3 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero() != 4){
                System.out.println("Test 3 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.exit(0);
            }

        }catch (Exception e){
            System.out.println("Test 3 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 ok");

        System.out.println();
        System.out.println("Test 4 : exemple de l'enonce");
        System.out.println("'get' guerrier numero 0");
        System.out.println(equipe.toString());
        try{
            Guerrier guerrier = equipe.getGuerrier(0);
            if(guerrier==null){
                System.out.println("Test 4 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            System.out.println("Test 4 ko");
            System.out.println("Il n'y a pas de guerrier numero 0");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }catch (Exception e){
            System.out.println("Test 4 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 ok");

        System.out.println();
        System.out.println("Test 5 : exemple de l'enonce");
        System.out.println("'get' guerrier numero 5");
        System.out.println(equipe.toString());
        try{
            Guerrier guerrier = equipe.getGuerrier(5);
            if(guerrier==null){
                System.out.println("Test 5 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            System.out.println("Test 5 ko");
            System.out.println("Il n'y a pas de guerrier numero 5");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }catch (Exception e){
            System.out.println("Test 5 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 ok");

        System.out.println();
        System.out.println("Test 6 : exemple de l'enonce");
        System.out.println("'get' guerrier numero -1");
        System.out.println(equipe.toString());
        try{
            Guerrier guerrier = equipe.getGuerrier(-1);
            if(guerrier==null){
                System.out.println("Test 6 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            System.out.println("Test 6 ko");
            System.out.println("Il n'y a pas de guerrier numero -1");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }catch (Exception e){
            System.out.println("Test 6 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 ok");

        System.out.println();
        System.out.println("Test 7 : l'equipe compte 2 guerriers");
        System.out.println("'get' guerrier numero 3");

        g1 = new Guerrier(1,6);
        g2 = new Guerrier(2,6);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);

        l = new LinkedList<Guerrier>();
        l.add(g1);
        l.add(g2);

        equipe = new EquipeGuerriers(a, l, 6);

        System.out.println(equipe.toString());
        try{
            Guerrier guerrier = equipe.getGuerrier(3);
            if(guerrier==null){
                System.out.println("Test 7 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            System.out.println("Test 7 ko");
            System.out.println("Il n'y a pas de guerrier numero 3");
            System.out.println("Il fallait lancer une IllegalArgumentException");
            System.exit(0);
        }catch(IllegalArgumentException e){

        }catch (Exception e){
            System.out.println("Test 7 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 7 ok");

        //pour tester l'existence du numero, il faut le faire en tenant compte des vivants et des morts
        System.out.println();
        System.out.println("Test 8 : l'equipe compte 2 guerriers morts");
        System.out.println("'get' guerrier numero 2");

        g1 = new Guerrier(1,0);
        g2 = new Guerrier(2,0);

        a = new ArrayList<Guerrier>();
        a.add(g1);
        a.add(g2);

        l = new LinkedList<Guerrier>();

        equipe = new EquipeGuerriers(a, l, 6);

        System.out.println(equipe.toString());
        try {
            Guerrier guerrier = equipe.getGuerrier(2);
            if (guerrier == null) {
                System.out.println("Test 8 ko");
                System.out.println("la methode a renvoye null");
                System.exit(0);
            }
            if(guerrier.getNumero() != 2){
                System.out.println("Test 8 ko");
                System.out.println("la methode a renvoye le guerrier : "+guerrier);
                System.exit(0);
            }
        } catch (Exception e){
            System.out.println("Test 8 ko");
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 8 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }
}
