import java.util.Arrays;

public class TestTableNegatifsPositifs {

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
            System.out.println("1 -> TableNegatifsPositifs()");
            System.out.println("2 -> moyenneStrictementPositifs()");
            System.out.println("3 -> tousStrictementPlusGrands()");
            System.out.println("4 -> supprimerMin()");
            System.out.print("\nEntrez votre choix : ");

            choix=scanner.nextInt();

            switch(choix){
                case 1: testerConstructeur();
                    break;
                case 2: testerMoyenneStrictementPositifs();
                    break;
                case 3: testerTousStrictementPlusGrands();
                    break;
                case 4: testerSupprimerMin();
                    break;
            }
        }while(choix >=1 && choix<=4);

        System.out.println("\nFin des tests");
    }

    private static void testerConstructeur() {
        System.out.println();
        System.out.println("TableNP()");
        System.out.println("---------");

        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {-5,7,-8,1,0,2,-1,1};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            int[] tableAttendue = {-5,-8,-1,7,1,0,2,1};
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",3,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",5,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
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
            int[] tableFournie = {-5,-8};
            int[] tableAttendue = {-5,-8};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",2,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",0,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
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
            int[] tableFournie = {9,8,7,6,5,4,3,2,1,0};
            int[] tableAttendue = {9,8,7,6,5,4,3,2,1,0};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",0,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",10,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
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
            int[] tableFournie = {};
            int[] tableAttendue = {};
            System.out.println("table fournie : table vide : "+Arrays.toString(tableFournie));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",0,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",0,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
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

    private static void testerMoyenneStrictementPositifs() {
        System.out.println();
        System.out.println("moyenneStrictementPositifs()");
        System.out.println("----------------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,1,2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,2,3);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.0,tableNP.moyenneStrictementPositifs());
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
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,0,1,0,2,0};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println(Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,2,6);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.0,tableNP.moyenneStrictementPositifs());
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
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8, -2,3,1,0,2,0,4,0};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,3,7);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.5,tableNP.moyenneStrictementPositifs());
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
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,10,0);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,tableNP.moyenneStrictementPositifs());
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
            int[] tableARecopier = {};
            System.out.println("table testee : table vide : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,0,0);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,tableNP.moyenneStrictementPositifs());
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

    private static void testerTousStrictementPlusGrands() {
        System.out.println();
        System.out.println("tousStrictementPlusGrands()");
        System.out.println("---------------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = -10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = -5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,2,5,4,9,8,10,5,7,6};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 10;
            int entierTeste = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 5;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,2,5,4,9,8,10,5,7,6};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 10;
            int entierTeste = 2;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 6;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,2,5,4,9,8,10,5,7,1};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 10;
            int entierTeste = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 7;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {4,5,6};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 3;
            int entierTeste = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 8;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-9,0,4,2};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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
        numeroTest = 9;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0,7,2,9};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 4;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test10
        numeroTest = 10;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,7,2,9};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 4;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test11
        numeroTest = 11;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,2,9,0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 4;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test12
        numeroTest = 12;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 1;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test13
        numeroTest = 13;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {5};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 1;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test14
        numeroTest = 14;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-2};
            int nbNegatifs = 1;
            int nbPositifsOuNul = 0;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusGrands(entierTeste));
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

        //test15
        numeroTest = 15;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 0;
            int entierTeste = 5;
            System.out.println("table testee : table vide :"+Arrays.toString(tableARecopier));
            System.out.println("tous plus grand : "+entierTeste+ " ?");
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusGrands(entierTeste));
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

        System.out.println();
        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerSupprimerMin() {

        System.out.println();
        System.out.println("supprimerMin()");
        System.out.println("--------------");

        System.out.println();
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int[]tableAttendue = {-5,5,2,3};
            int min = -8;
            int nbNegatifsAttendu = 1;
            int nbPositifsOuNulAttendu = 3;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3,4,5,6,8,9};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 8;
            int[]tableAttendue = {-5,5,2,3,4,5,6,8,9};
            int min = -8;
            int nbNegatifsAttendu = 1;
            int nbPositifsOuNulAttendu = 8;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,5,7,2};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 4;
            int[]tableAttendue = {5,7,2};
            int min = 1;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 3;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,6,4,7,9,4,5};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 7;
            int[]tableAttendue = {7,6,7,9,4,5};
            int min = 4;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 6;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 5;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,6,4,7,9,4,5,4,4,0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 10;
            int[]tableAttendue = {7,6,4,7,9,4,5,4,4};
            int min = 0;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 9;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 6;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 1;
            int[]tableAttendue = {};
            int min = 0;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
        numeroTest = 7;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-8};
            int nbNegatifs = 1;
            int nbPositifsOuNul = 0;
            int[]tableAttendue = {};
            int min = -8;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPositifs tableNP = new TableNegatifsPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : min renvoye",min,tableNP.supprimerMin());
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
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
