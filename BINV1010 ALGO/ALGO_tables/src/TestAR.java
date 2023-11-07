import java.util.Arrays;

public class TestAR {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a reçu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu==null) {
            if (recu!=null) {
                System.out.println("-->"+messageErreur+". Attendu="+attendu+" reçu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println("-->"+messageErreur+". Attendu="+attendu+" reçu="+recu);
            System.exit(0);
        }
    }


    public static void main(String[] args) {

        System.out.println("******************************************");
        System.out.println("Programme Test pour la classe Temperatures");
        System.out.println("******************************************");
        int choix = 0;
        do {
            System.out.println("1 -> Tester la methode moyenne()");
            System.out.println("2 -> Tester la methode temperatureMin()");
            System.out.println("3 -> Tester la methode nombreJourDeGel()");
            System.out.println("4 -> Tester la methode joursDeGel()");
            System.out.println("5 -> Tester la methode toutesPositives()");
            System.out.println("6 -> Tester la methode contientAuMoinsUnJourDeGel()");
                     System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testMoyenne();
                    break;
                case 2:
                    testTemperatureMin();
                    break;
                case 3:
                    testNombreJoursDeGel();
                    break;
                case 4:
                    testJoursDeGel();
                    break;
                case 5:
                    testToutesPositives();
                    break;
                case 6:
                    testContientAuMoinsUnJourDeGel();
                    break;
                default:
                    break;
            }
        } while (choix >= 1 && choix <= 6 );

    }

    private static void testMoyenne() {
        int numTest;
        Temperatures temperatures;

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 0.5, temperatures.moyenne());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 3.0, temperatures.moyenne());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();


        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testTemperatureMin() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : min ko", -4.0, temperatures.temperatureMin());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : min ko", -5.0, temperatures.temperatureMin());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 3;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : min ko", 1.0, temperatures.temperatureMin());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testNombreJoursDeGel() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 2, temperatures.nombreJoursDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 5, temperatures.nombreJoursDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 3;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 0, temperatures.nombreJoursDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testJoursDeGel() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if(tableRecue==null){
                System.out.println("test"+numTest+"ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {1,3};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures.toString());
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if(tableRecue==null){
                System.out.println("test"+numTest+"ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {2,4};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 3;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if(tableRecue==null){
                System.out.println("test"+numTest+"ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 4;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures.toString());
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if(tableRecue==null){
                System.out.println("test"+numTest+"ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {1,2,3,4,5};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testToutesPositives() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", false, temperatures.toutesPositives());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", false, temperatures.toutesPositives());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 3;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", true, temperatures.toutesPositives());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testContientAuMoinsUnJourDeGel() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", true, temperatures.contientAuMoinsUnJourDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 2;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", true, temperatures.contientAuMoinsUnJourDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        numTest = 3;
        System.out.println("Test"+numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures.toString());
        try {
            assertEquals("Test" + numTest + " ko", false, temperatures.contientAuMoinsUnJourDeGel());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println( "Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    public static Temperatures chargerTemperatures1(){
        double[]tableTemperatures = {-2,3,-4,5};
        return new Temperatures("Table testee",tableTemperatures);
    }

    public static Temperatures chargerTemperatures2(){
        double[]tableTemperatures = {2,-3,4,-5};
        return new Temperatures("Table testee",tableTemperatures);
    }

    public static Temperatures chargerTemperatures3(){
        double[]tableTemperatures = {5,2,3,4,1};
        return new Temperatures("Table testee",tableTemperatures);
    }

    public static Temperatures chargerTemperatures4(){
        double[]tableTemperatures = {-1,-2,-3,-4,-5};
        return new Temperatures("Table testee",tableTemperatures);
    }

}
