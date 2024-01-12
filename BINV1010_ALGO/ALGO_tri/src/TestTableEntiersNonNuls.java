import java.util.Arrays;
import java.util.NoSuchElementException;

public class TestTableEntiersNonNuls {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

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
                System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        int choix;

        System.out.println("******************************************");
        System.out.println("Tests pour la classe TableNegatifsPositifs");
        System.out.println("******************************************");
        do{
            System.out.println("Menu");
            System.out.println("****");
            System.out.println("1 -> TableEntiersNonNuls()");
            System.out.println("2 -> moyennePositifs()");
            System.out.println("3 -> troisPlusPetitsEntiers()");
            System.out.println("4 -> supprimerDerniereOccurrence()");
            System.out.print("\nEntrez votre choix : ");

            choix=scanner.nextInt();

            switch(choix){
                case 1: testerConstructeur();
                    break;
                case 2: testerMoyennePositifs();
                    break;
                case 3: testerTroisMin();
                    break;
                case 4: testerSupprimerDer();
                    break;
            }
        }while(choix >=1 && choix<=4);

        System.out.println("\nFin des tests");
    }

    private static void testerConstructeur() {
        System.out.println();
        System.out.println("TableEntiersNonNuls()");
        System.out.println("---------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {1,-2,3};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {1,-2,3};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",3,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {1,2,3,4,5,6,7,8,9,10};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {1,2,3,4,5,6,7,8,9,10};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",10,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test3
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {1,2,3,4,5,6,7,8,9,10,11};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {1,2,3,4,5,6,7,8,9,10};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",10,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test4
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {0,0,0,1,0,2,0,3,0};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {1,2,3};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",3,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test5
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {0,0,0,1,2,0,3,4,0,0,0,5,0,0};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {1,2,3,4,5};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",5,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test6
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {0,0,0,0};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",0,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test7
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",0,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != MAX (10)",10,table.getNbEntiers() + table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) table ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerMoyennePositifs() {
        System.out.println();
        System.out.println("moyennePositifs()");
        System.out.println("-----------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,8,3,-1,1};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,5);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",4.0,table.moyennePositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test2
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {2,-5,8,3,-1,1};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,6);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",3.5,table.moyennePositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test3
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,-3,-3,-3,-3,-3,-3,-3,-3,5};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",6.0,table.moyennePositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test4
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,-2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,3);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,table.moyennePositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test5
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,0);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,table.moyennePositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();


        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerTroisMin() {
        System.out.println();
        System.out.println("troisPlusPetitsEntiers()");
        System.out.println("------------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);

        try{
            int[] tableARecopier = {5,-8,3,-1,11};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,5);
            int[] tableAttendue = {-8,-1,3};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a plus de 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test2
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {5,8,3,2};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,4);
            int[] tableAttendue = {2,3,5};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a plus de 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test3
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {4,8,17,9,11,15,7,22,2,5};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            int[] tableAttendue = {2,4,5};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a plus de 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();


        numeroTest++;
        //test4
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {8,4,17,9,2,22,2,5};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,8);
            int[] tableAttendue = {2,2,4};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a plus de 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test5
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3,3,3,3,3,3,3};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,7);
            int[] tableAttendue = {3,3,3};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a plus de 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test6
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3,2,1};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,3);
            int[] tableAttendue = {1,2,3};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("table attendue : "+Arrays.toString(tableAttendue));
            int[] tableRecue = table.troisPlusPetitsEntiers();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",3,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu table renvoyee ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a 3 entiers dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test7
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,7};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,2);
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("Exception attendue : NoSuchElementException");
            int[] tableRecue = table.troisPlusPetitsEntiers();
            System.out.println("test "+numeroTest+ "ko, il y a moins de 3 entiers dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {

        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test8
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,0);
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("Exception attendue : NoSuchElementException");
            int[] tableRecue = table.troisPlusPetitsEntiers();
            System.out.println("test "+numeroTest+ "ko, il y a moins de 3 entiers dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {

        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();



        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerSupprimerDer() {
        System.out.println();
        System.out.println("supprimerDerniereOccurrence()");
        System.out.println("-----------------------------");

        System.out.println();
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {2,-4,6,8};
            int nbEntiers = 4;
            int entierASupprimer = 6;
            int[]tableAttendue = {2,-4,8};
            int nbEntiersAttendu = 3;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,5,6};
            int nbEntiers = 6;
            int entierASupprimer = 1;
            int[]tableAttendue = {2,3,4,5,6};
            int nbEntiersAttendu = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test3
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,5,6,7,8,9,10};
            int nbEntiers = 10;
            int entierASupprimer = 4;
            int[]tableAttendue = {1,2,3,5,6,7,8,9,10};
            int nbEntiersAttendu = 9;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test4
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,5,6,7,8,9,10};
            int nbEntiers = 10;
            int entierASupprimer = 10;
            int[]tableAttendue = {1,2,3,4,5,6,7,8,9};
            int nbEntiersAttendu = 9;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test5
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,12,3,12,5};
            int nbEntiers = 5;
            int entierASupprimer = 12;
            int[]tableAttendue = {1,12,3,5};
            int nbEntiersAttendu = 4;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test6
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,12,3,1,5,1};
            int nbEntiers = 6;
            int entierASupprimer = 1;
            int[]tableAttendue = {1,12,3,1,5};
            int nbEntiersAttendu = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test7
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,15,9,6};
            int nbEntiers = 4;
            int entierASupprimer = 3;
            int[]tableAttendue = {1,15,9,6};
            int nbEntiersAttendu = 4;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test8
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            int nbEntiers = 0;
            int entierASupprimer = 22;
            int[]tableAttendue = {};
            int nbEntiersAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test9
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,5,6,7,8,9,10};
            int nbEntiers = 10;
            int entierASupprimer = 777;
            int[]tableAttendue = {1,2,3,4,5,6,7,8,9,10};
            int nbEntiersAttendu = 10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("suppression "+entierASupprimer);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.supprimerDerniereOccurrence(entierASupprimer));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

}
