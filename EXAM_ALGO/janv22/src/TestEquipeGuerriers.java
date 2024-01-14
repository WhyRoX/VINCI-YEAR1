import java.util.Arrays;
import java.util.NoSuchElementException;

public class TestEquipeGuerriers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur
     *            message a afficher en cas de probleme
     * @param attendu
     *            la valeur qu'on s'attendait a recevoir
     * @param recu
     *            la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur);
                System.out.println("Attendu : " + attendu);
                System.out.println("Recu : " + recu);
                System.exit(0);
            }
        } else {
            if (attendu instanceof Character && recu instanceof String) {
                attendu = "" + attendu;
            }
            if (attendu instanceof String && recu instanceof Character) {
                recu = "" + recu;
            }
            if (!attendu.equals(recu)) {
                System.out.println(messageErreur);
                System.out.println("Attendu : " + attendu);
                System.out.println("Recu : " + recu);
                System.exit(0);
            }
        }

    }

    public static void main(String [] args){

        int choix;
        System.out.println("***********************************************");
        System.out.println("Programme Test pour la classe EquipeGuerriers :");
        System.out.println("***********************************************");
        do{
            System.out.println();
            System.out.println("1 -> Tester la methode 'donnerNumeroProchainGuerrier()'");
            System.out.println("2 -> Tester la methode 'recevoirDegats()'");
            System.out.println("3 -> Tester la methode 'tableGuerriersEnVie()'");
            System.out.println("4 -> Tester la methode 'tableGuerriersMorts()'");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testDonnerNumeroProchainGuerrier();
                    break;
                case 2: testRecevoirDegats();
                    break;
                case 3: testTableGuerriersVivants();
                    break;
                case 4: testTableGuerriersMorts();
                    break;
            }
        }while(choix >=1&&choix<=4);
        System.out.println("\nFin des tests");
    }

    private static EquipeGuerriers enonce(){
        Guerrier[] tableEnonce = new Guerrier[6];
        tableEnonce[0]=new Guerrier(2,2);
        tableEnonce[1]=new Guerrier(3,4);
        tableEnonce[2]=new Guerrier(6,4);
        tableEnonce[3]=new Guerrier(5,6);
        tableEnonce[4]=new Guerrier(1,0);
        tableEnonce[5]=new Guerrier(4,0);
        return new EquipeGuerriers(tableEnonce,4);
    }

    private static EquipeGuerriers equipeTousVivants(){
        return new EquipeGuerriers(6,12);
    }

    private static EquipeGuerriers equipe1GuerrierVivant(){
        Guerrier[] tableEnonce = new Guerrier[5];
        tableEnonce[0]=new Guerrier(2,2);
        tableEnonce[1]=new Guerrier(3,0);
        tableEnonce[2]=new Guerrier(4,0);
        tableEnonce[3]=new Guerrier(5,0);
        tableEnonce[4]=new Guerrier(1,0);
        return new EquipeGuerriers(tableEnonce,1);
    }

    private static EquipeGuerriers equipeTousMorts(){
        Guerrier[] tableEnonce = new Guerrier[5];
        tableEnonce[0]=new Guerrier(2,0);
        tableEnonce[1]=new Guerrier(3,0);
        tableEnonce[2]=new Guerrier(4,0);
        tableEnonce[3]=new Guerrier(5,0);
        tableEnonce[4]=new Guerrier(1,0);
        return new EquipeGuerriers(tableEnonce,0);
    }


    private static void testDonnerNumeroProchainGuerrier() {
        System.out.println("test 1 : equipe de l'exemple de l'enonce");
        EquipeGuerriers equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
           assertEquals("test 1 ko : numero guerrier ko",5,equipeTestee.donnerNumeroProchainGuerrier());
           assertEquals("test 1 ko : le nombre de guerriers en vie a ete modifie",4,equipeTestee.nombreGuerriersEnVie());
           assertEquals("test 1 ko : le contenu de la table a ete modifie","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (6pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 : equipe apres appel du constructeur");
        equipeTestee = equipeTousVivants();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 2 ko : numero guerrier ko",1,equipeTestee.donnerNumeroProchainGuerrier());
        }catch (Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 : equipe avec 1 seul guerrier vivant ");
        equipeTestee = equipe1GuerrierVivant();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 3 ko : numero guerrier ko",2,equipeTestee.donnerNumeroProchainGuerrier());
        }catch (Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 : equipe avec tous les guerriers morts ");
        equipeTestee = equipeTousMorts();
        System.out.println(equipeTestee);
        try{
            equipeTestee.donnerNumeroProchainGuerrier();
            System.out.println("test 4 ko : il fallait une exception de type NoSuchElementException");
            System.exit(0);
        }catch (NoSuchElementException e){
            System.out.println("test 4 ok");
        }catch (Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            System.out.println("test 4 ko : il fallait une exception de type NoSuchElementException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Tous les tests ont reussi");
    }

    private static void testRecevoirDegats() {
        System.out.println("test 1 : equipe de l'exemple de l'enonce - le guerrier 5 perd 6 points de vie");
        EquipeGuerriers equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 1 ko : nouveaux points de vie ko",0,equipeTestee.recevoirDegats(6));
            assertEquals("test 1 ko : le nombre de guerriers en vie est ko (le guerrier qui vient de jouer est mort)",3,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 1 ko : le contenu de la table est ko","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (0pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 : equipe de l'exemple de l'enonce - le guerrier 5 perd 1 point de vie");
        equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 2 ko : nouveaux points de vie ko",5,equipeTestee.recevoirDegats(1));
            assertEquals("test 2 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue n'est pas mort)",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 2 ko : le contenu de la table est ko","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (5pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 : equipe de l'exemple de l'enonce - le guerrier 5 perd 3 points de vie");
        equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 3 ko : nouveaux points de vie ko",3,equipeTestee.recevoirDegats(3));
            assertEquals("test 3 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue n'est pas mort)",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 3 ko : le contenu de la table est ko","[G2 (2pts), G5 (3pts), G3 (4pts), G6 (4pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 : equipe de l'exemple de l'enonce - le guerrier 5 perd 2 points de vie");
        equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 4 ko : nouveaux points de vie ko",4,equipeTestee.recevoirDegats(2));
            assertEquals("test 4 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue n'est pas mort)",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 4 ko : le contenu de la table est ko","[G2 (2pts), G5 (4pts), G3 (4pts), G6 (4pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("test 5 : equipe de l'exemple de l'enonce - le guerrier 5 perd 5 points de vie");
        equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 5 ko : nouveaux points de vie ko",1,equipeTestee.recevoirDegats(5));
            assertEquals("test 5 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue n'est pas mort)",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 5 ko : le contenu de la table est ko","[G5 (1pts), G2 (2pts), G3 (4pts), G6 (4pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 5 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 5 ok");

        System.out.println("test 6 : equipe apres appel du constructeur - le guerrier 1 perd 3 points de vie");
        equipeTestee = equipeTousVivants();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 6 ko : nouveaux points de vie ko",9,equipeTestee.recevoirDegats(3));
            assertEquals("test 6 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue n'est pas mort)",6,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 6 ko : le contenu de la table est ko","[G1 (9pts), G6 (12pts), G5 (12pts), G4 (12pts), G3 (12pts), G2 (12pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 6 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 6 ok");

        System.out.println("test 7 : equipe avec 1 seul guerrier vivant - le guerrier perd 6 points de vie");
        equipeTestee = equipe1GuerrierVivant();
        System.out.println(equipeTestee);
        try{
            assertEquals("test 7 ko : nouveaux points de vie ko",0,equipeTestee.recevoirDegats(6));
            assertEquals("test 7 ko : le nombre de guerriers en vie est ko (le guerrier qui a joue est mort)",0,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 7 ko : le contenu de la table est ko","[G2 (0pts), G3 (0pts), G4 (0pts), G5 (0pts), G1 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 7 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 7 ok");

        System.out.println();
        System.out.println("test 8 : equipe avec tous les guerriers morts ");
        equipeTestee = equipeTousMorts();
        System.out.println(equipeTestee);
        try{
            equipeTestee.recevoirDegats(1);
            System.out.println("test 8 ko : il fallait une exception de type NoSuchElementException");
            System.exit(0);
        }catch (NoSuchElementException e){
            System.out.println("test 8 ok");
        }catch (Exception e){
            System.out.println("test 8 ko : il y a eu une exception inattendue");
            System.out.println("test 8 ko : il fallait une exception de type NoSuchElementException");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println();
        System.out.println("test 9 : equipe de l'exemple de l'enonce - points de vie negatifs");
        equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            equipeTestee.recevoirDegats(-5);
            System.out.println("test 9 ko : il fallait une exception de type IllegalArgumentException");
            System.exit(0);
        }catch (IllegalArgumentException e){
            System.out.println("test 9 ok");
        }catch (Exception e){
            System.out.println("test 9 ko : il y a eu une exception inattendue");
            System.out.println("test 9 ko : il fallait une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }


        System.out.println("Tous les tests ont reussi");
    }

    private static void testTableGuerriersVivants() {
        System.out.println("test 1 : equipe de l'exemple de l'enonce");
        EquipeGuerriers equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersEnVie();
            if(tableRecue==null){
                System.out.println("test1 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 1 ko : taille physique table renvoyee ko",4,tableRecue.length);
            assertEquals("test 1 ko : contenu table renvoyee ko","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (6pts)]", Arrays.toString(tableRecue));
            assertEquals("test 1 ko : le nombre de guerriers en vie a ete modifie",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 1 ko : le contenu de la table a ete modifie","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (6pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 : equipe apres appel du constructeur");
        equipeTestee = equipeTousVivants();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersEnVie();
            if(tableRecue==null){
                System.out.println("test 2 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 2 ko : taille physique table renvoyee ko",6,tableRecue.length);
            assertEquals("test 2 ko : contenu table renvoyee ko","[G6 (12pts), G5 (12pts), G4 (12pts), G3 (12pts), G2 (12pts), G1 (12pts)]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 : equipe avec 1 guerrier en vie");
        equipeTestee = equipe1GuerrierVivant();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersEnVie();
            if(tableRecue==null){
                System.out.println("test 3 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 3 ko : taille physique table renvoyee ko",1,tableRecue.length);
            assertEquals("test 3 ko : contenu table renvoyee ko","[G2 (2pts)]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 : equipe avec tous les guerriers morts");
        equipeTestee = equipeTousMorts();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersEnVie();
            if(tableRecue==null){
                System.out.println("test 4 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 4 ko : taille physique table renvoyee ko",0,tableRecue.length);
            assertEquals("test 4 ko : contenu table renvoyee ko","[]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println("Tous les tests ont reussi");
    }

    private static void testTableGuerriersMorts() {
        System.out.println("test 1 : equipe de l'exemple de l'enonce");
        EquipeGuerriers equipeTestee = enonce();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersMorts();
            if(tableRecue==null){
                System.out.println("test1 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 1 ko : taille physique table renvoyee ko",2,tableRecue.length);
            assertEquals("test 1 ko : contenu table renvoyee ko","[G1 (0pts), G4 (0pts)]", Arrays.toString(tableRecue));
            assertEquals("test 1 ko : le nombre de guerriers en vie a ete modifie",4,equipeTestee.nombreGuerriersEnVie());
            assertEquals("test 1 ko : le contenu de la table a ete modifie","[G2 (2pts), G3 (4pts), G6 (4pts), G5 (6pts), G1 (0pts), G4 (0pts)]",equipeTestee.toString());
        }catch (Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 : equipe apres appel du constructeur");
        equipeTestee = equipeTousVivants();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersMorts();
            if(tableRecue==null){
                System.out.println("test 2 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 2 ko : taille physique table renvoyee ko",0,tableRecue.length);
            assertEquals("test 2 ko : contenu table renvoyee ko","[]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 : equipe avec 1 guerrier en vie");
        equipeTestee = equipe1GuerrierVivant();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersMorts();
            if(tableRecue==null){
                System.out.println("test 3 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 3 ko : taille physique table renvoyee ko",4,tableRecue.length);
            assertEquals("test 3 ko : contenu table renvoyee ko","[G3 (0pts), G4 (0pts), G5 (0pts), G1 (0pts)]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 : equipe avec tous les guerriers morts");
        equipeTestee = equipeTousMorts();
        System.out.println(equipeTestee);
        try{
            Guerrier[] tableRecue = equipeTestee.tableGuerriersMorts();
            if(tableRecue==null){
                System.out.println("test 4 ko : votre methode renvoie null");
                System.exit(0);
            }
            assertEquals("test 4 ko : taille physique table renvoyee ko",5,tableRecue.length);
            assertEquals("test 4 ko : contenu table renvoyee ko","[G2 (0pts), G3 (0pts), G4 (0pts), G5 (0pts), G1 (0pts)]", Arrays.toString(tableRecue));
        }catch (Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");
        System.out.println("Tous les tests ont reussi");
    }

}
