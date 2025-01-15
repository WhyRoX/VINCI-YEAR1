public class TestMotACompleter {

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
        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe MotACompleter :");
        System.out.println("*********************************************");
        do{
            System.out.println("1 -> Tester la methode 'estComplet()'");
            System.out.println("2 -> Tester la methode 'contientLettre()'");
            System.out.println("3 -> Tester la methode 'ajouterLettre()'");
            System.out.println("4 -> Tester la methode 'premiereLettreEstAjoutee()'");
            System.out.println("5 -> Tester la methode 'ajouterPremiereLettre()'");
            System.out.println("6 -> Tester la methode 'premiereLettreNonTrouvee()'");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testEstComplet();
                    break;
                case 2: testContientLettre();
                    break;
                case 3: testAjouterLettre();
                    break;
                case 4: testPremiereLettreEstAjoutee();
                    break;
                case 5: testAjouterPremiereLettre();
                    break;
                case 6: testPremiereLettreNonTrouvee();
                    break;
            }
        }while(choix >= 1 && choix <= 6);
        System.out.println("Merci pour votre visite.");
    }


    private static void testEstComplet() {
        System.out.println();
        System.out.println("estComplet");
        System.out.println("----------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.estComplet());
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
            MotACompleter mot = new MotACompleter("COLIBRI","COLIBR_");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = COLIBR_");
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.estComplet());
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
            MotACompleter mot = new MotACompleter("COLIBRI","_OLIBRI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = _OLIBRI");
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.estComplet());
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
            MotACompleter mot = new MotACompleter("COLIBRI","_______");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = _______");
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.estComplet());
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


        //test5
        numeroTest = 5;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","COLIBRI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = COLIBRI");
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, mot.estComplet());
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

    private static void testContientLettre() {
        System.out.println();
        System.out.println("contientLettre()");
        System.out.println("----------------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            char lettre = 'B';
            System.out.println("contient lettre : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, mot.contientLettre(lettre));
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
            MotACompleter mot = new MotACompleter("PENDU","P_____");
            System.out.println("motATrouver = PENDU");
            System.out.println("motACompleter = P____");
            char lettre = 'U';
            System.out.println("contient lettre : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, mot.contientLettre(lettre));
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
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            char lettre = 'C';
            System.out.println("contient lettre : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, mot.contientLettre(lettre));
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
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            char lettre = 'X';
            System.out.println("contient lettre : "+lettre);
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.contientLettre(lettre));
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

    private static void testAjouterLettre() {
        System.out.println();
        System.out.println("ajouterLettre()");
        System.out.println("---------------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            char lettre = 'B';
            System.out.println("ajout lettre : "+lettre);
            mot.ajouterLettre(lettre);
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout ","C_LIBRI",mot.motACompleter());
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
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            char lettre = 'X';
            System.out.println("ajout lettre : "+lettre);
            mot.ajouterLettre(lettre);
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout ","C_LI_RI",mot.motACompleter());
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
            MotACompleter mot = new MotACompleter("COLIBRI","C_L_BR_");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_L_BR_");
            char lettre = 'I';
            System.out.println("ajout lettre : "+lettre);
            mot.ajouterLettre(lettre);
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout ","C_LIBRI",mot.motACompleter());
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
            MotACompleter mot = new MotACompleter("COLIBRI","__LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = __LI_RI");
            char lettre = 'C';
            System.out.println("ajout lettre : "+lettre);
            mot.ajouterLettre(lettre);
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout ","C_LI_RI",mot.motACompleter());
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

        //test5
        numeroTest = 5;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("ABBA","____");
            System.out.println("motATrouver = ABBA");
            System.out.println("motACompleter = ____");
            char lettre = 'A';
            System.out.println("ajout lettre : "+lettre);
            mot.ajouterLettre(lettre);
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout ","A__A",mot.motACompleter());
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

    private static void testPremiereLettreEstAjoutee() {
        System.out.println();
        System.out.println("premiereLettreEstAjoutee()");
        System.out.println("--------------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            assertEquals("test " + numeroTest + " ko : booleen ko ", true, mot.premiereLettreEstAjoutee());
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
            MotACompleter mot = new MotACompleter("COLIBRI","__LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = __LI_RI");
            assertEquals("test " + numeroTest + " ko : booleen ko ", false, mot.premiereLettreEstAjoutee());
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

    private static void testAjouterPremiereLettre() {
        System.out.println();
        System.out.println("ajouterPremiereLettre()");
        System.out.println("-----------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","__LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = __LI_RI");
            mot.ajouterPremiereLettre();
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout 1ere lettre","C_LI_RI",mot.motACompleter());
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
            MotACompleter mot = new MotACompleter("COLIBRI","C_LI_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = C_LI_RI");
            mot.ajouterPremiereLettre();
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout 1ere lettre","C_LI_RI",mot.motACompleter());
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
            MotACompleter mot = new MotACompleter("ANANAS","_N_N__");
            System.out.println("motATrouver = ANANAS");
            System.out.println("motACompleter = _N_N__");
            mot.ajouterPremiereLettre();
            assertEquals("test " + numeroTest + " ko : mot a completer apres ajout 1ere lettre","ANANA_",mot.motACompleter());
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

    private static void testPremiereLettreNonTrouvee() {

        System.out.println();
        System.out.println("premiereLettreNonTrouvee()");
        System.out.println("--------------------------");
        //test1
        int numeroTest = 1;
        System.out.println("test " + numeroTest);
        try{
            MotACompleter mot = new MotACompleter("COLIBRI","CO_I_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = CO_I_RI");
            assertEquals("test " + numeroTest + " ko : lettre ko ", 'L', mot.premiereLettreNonTrouvee());
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
            MotACompleter mot = new MotACompleter("COLIBRI","_O_I_RI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = _O_I_RI");
            assertEquals("test " + numeroTest + " ko : lettre ko ", 'C', mot.premiereLettreNonTrouvee());
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
            MotACompleter mot = new MotACompleter("ANANAS","ANANA_");
            System.out.println("motATrouver = ANANAS");
            System.out.println("motACompleter = ANANA_");
            assertEquals("test " + numeroTest + " ko : lettre ko ", 'S', mot.premiereLettreNonTrouvee());
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
            MotACompleter mot = new MotACompleter("COLIBRI","COLIBRI");
            System.out.println("motATrouver = COLIBRI");
            System.out.println("motACompleter = COLIBRI");
            assertEquals("test " + numeroTest + " ko : lettre ko ", ' ', mot.premiereLettreNonTrouvee());
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
