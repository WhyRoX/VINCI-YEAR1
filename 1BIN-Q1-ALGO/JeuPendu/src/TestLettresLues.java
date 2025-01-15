public class TestLettresLues {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
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

    public static void main (String[] args) {
        int choix;
        System.out.println("*******************************************");
        System.out.println("Programme Test pour la classe LettresLues :");
        System.out.println("*******************************************");
        do{
            System.out.println("1 -> Tester la methode 'lettreDejaLue()'");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testLettreDejaLue();
                    break;
            }
        }while(choix>=1 && choix<=1);
        System.out.println("Merci pour votre visite.");
    }

    private static void testLettreDejaLue() {
        System.out.println();
        System.out.println("lettreDejaLue");
        System.out.println("-------------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            boolean[] tableTestee = new boolean[26];
            tableTestee[0]=true;
            tableTestee[1]=true;
            tableTestee[8]=true;
            tableTestee[25]=true;
            LettresLues lettres = new LettresLues(tableTestee);
            System.out.println("Les lettres lues : "+lettres.toString());
            char lettre = 'I';
            System.out.println("lettre verifiee : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, lettres.lettreDejaLue(lettre));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test " + numeroTest + " ok");
        System.out.println();

        //test2
        numeroTest = 2;
        System.out.println("test " + numeroTest);
        try{
            boolean[] tableTestee = new boolean[26];
            tableTestee[0]=true;
            tableTestee[1]=true;
            tableTestee[8]=true;
            tableTestee[25]=true;
            LettresLues lettres = new LettresLues(tableTestee);
            System.out.println("Les lettres lues : "+lettres.toString());
            char lettre = 'A';
            System.out.println("lettre verifiee : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, lettres.lettreDejaLue(lettre));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test " + numeroTest + " ok");
        System.out.println();

        //test3
        numeroTest = 3;
        System.out.println("test " + numeroTest);
        try{
            boolean[] tableTestee = new boolean[26];
            tableTestee[0]=true;
            tableTestee[1]=true;
            tableTestee[8]=true;
            tableTestee[25]=true;
            LettresLues lettres = new LettresLues(tableTestee);
            System.out.println("Les lettres lues : "+lettres.toString());
            char lettre = 'Z';
            System.out.println("lettre verifiee : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, lettres.lettreDejaLue(lettre));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test " + numeroTest + " ok");
        System.out.println();

        //test4
        numeroTest = 4;
        System.out.println("test " + numeroTest);
        try{
            boolean[] tableTestee = new boolean[26];
            tableTestee[0]=true;
            tableTestee[1]=true;
            tableTestee[8]=true;
            tableTestee[25]=true;
            LettresLues lettres = new LettresLues(tableTestee);
            System.out.println("Les lettres lues : "+lettres.toString());
            char lettre = 'X';
            System.out.println("lettre verifiee : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, lettres.lettreDejaLue(lettre));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test " + numeroTest + " ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

}
