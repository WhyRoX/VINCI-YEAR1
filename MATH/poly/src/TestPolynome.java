import java.lang.reflect.Field;
import java.util.Scanner;

public class TestPolynome {
    private static Scanner scanner = new Scanner(System.in);
    static Class<Polynome> classe = Polynome.class;
    static Field coeff;

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("**************************************");
        System.out.println("Programme Test pour la classe Polynome");
        System.out.println("**************************************");
        int choix = 0;

        do {
            System.out.println("1 -> Tests de la méthode 'racineParBissectionNIterations(double a,double b , int n)'");
            System.out.println("2 -> Tests de base de la méthode 'racineParBissection(double a,double b , int décimales)'");
            System.out.println("3 -> Tests approfondis la méthode 'racineParBissection(double a,double b , int décimale)'");
            System.out.println("4 -> Tests de la méthode 'racineParNewtonNIterations(double a,double b , int n)'");
            System.out.println("5 -> Tests de base de la méthode 'racineParNewton(double a,double b , int décimales)'");
            System.out.println("6 -> Tests approfondis de la méthode 'racineParNewton(double a,double b , int décimales)'");
            System.out.println("Autre -> Quitter");
            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testRacineParBissectionNIterations();
                    break;
                case 2:
                    testRacineParBissection1();
                    break;
                case 3:
                    testRacineParBissection2();
                    break;
                case 4:
                    testRacineParNewtonNIterations();
                    break;
                case 5:
                    testNewton1();
                    break;
                case 6:
                    testNewton2();
                    break;
            }
            System.out.println();
        } while (choix >= 1 && choix <= 6);
    }

    private static void testRacineParBissectionNIterations() {
        int temps = 300;
        Polynome p = null;
        boolean testOK = true;
        p = new Polynome(4);
        p.setCoefficient(0, -16);
        double result;

        System.out.println("Test 1 :");
        System.out.println("========");
        try {
            result = p.racineParBissectionNIterations(-3, 3, 6);
            System.out.println("Approximation de la racine de x^4-16 sur l'intervalle [-3,3] (a = -3, b= 3) --> Bolzano pas vérifié --> Il fallait lancer une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Approximation de la racine de x^4-16 sur l'intervalle [-3,3] (a = -3, b= 3) --> Bolzano pas vérifié --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");

        try {
            result = p.racineParBissectionNIterations(1, 2, 4);
            if (result != 2) {
                System.out.println("Approximation de la racine de x^4-16 sur l'intervalle [1,2] (a = 1, b= 2) après 4 itérations --> Solution attendue : 2");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de x^4-16 sur l'intervalle [1,2] (a = 1, b= 2)--> Il ne fallait pas d'exception si la racine est une borne de l'intervalle");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        p = new Polynome(2);
        p.setCoefficient(0, -3);
        try {
            result = p.racineParBissectionNIterations(1, 2, 4);
            if (result != 1.71875) {
                System.out.println("Approximation de la racine de x²-3 sur l'intervalle [1,2] (a = 1, b= 2) après 4 itérations --> Solution attendue : 1.71875");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de x²-3 sur l'intervalle [1,2] (a = 1, b= 2)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        p = new Polynome(2);
        p.setCoefficient(0, 2);
        p.setCoefficient(1, -5);
        p.setCoefficient(2, 2);
        try {
            result = p.racineParBissectionNIterations(-0.75, 1.25, 8);
            if (result != 0.5) {
                System.out.println("Approximation de la racine de 2x²-5x+2 sur l'intervalle [-3/4,5/4] (a = -0.75, b= 1.26) après 8 itérations --> Solution attendue : 0.5");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x²-5x+2 sur l'intervalle [-3/4,5/4] (a = -0.75, b= 1.26)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        p = new Polynome(4);
        p.setCoefficient(0, 1);
        p.setCoefficient(1, -2);
        try {
            result = p.racineParBissectionNIterations(0.25, 0.75, 8);
            if (result != 0.5439453125) {
                System.out.println("Approximation de la racine de x^4-2x+1 sur l'intervalle [1/4,3/4] (a = 0.25, b= 0.75) après 8 itérations --> Solution attendue : 0.5439453125");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de x^4-2x+1 sur l'intervalle [1/4,3/4] (a = 0.25, b= 0.75)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        if (testOK) {
            System.out.println();
            System.out.println("Tous les tests de la méthode 'racineParBissectionNIterations' ont réussi");
        }
    }

    private static void testRacineParBissection1() {
        int temps = 300;
        Polynome p = null;
        boolean testOK = true;
        p = new Polynome(2);
        p.setCoefficient(0, -2);
        double result;

        System.out.println("Test 1 :");
        System.out.println("========");
        try {
            result = p.racineParBissection(1, 2, 2);
            if (Math.abs(result - 1.41796875) > 0.00000001) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2)--> Solution attendue : 1.41796875");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");

        try {
            result = p.racineParBissection(2, 1, 2);
            if (result != 1.41796875) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1)--> Solution attendue : 1.41796875");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        try {
            result = p.racineParBissection(1.4142, 1.4143, 2);
            if (result != 1.41425) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1.4142, b= 1.4143)--> Solution attendue : 1.41425");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1.4142, b= 1.4143)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        try {
            result = p.racineParBissection(1, 2, 5);
            if (result < 1.4142112731933594 - 1e-13 || result > 1.4142112731933594 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1, b = 2) --> Solution attendue = 1.4142112731933594");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1, b = 2)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        try {
            p.racineParBissection(3, 4, 3);
            System.out.println("Impossible de trouver la racine de 2 dans l'intervalle [3,4] --> Il fallait lancer une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 2 dans l'intervalle [3,4] --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 6 :");
        System.out.println("========");

        try {
            p.setCoefficient(0, -9);
            result = p.racineParBissection(1, 9, 3);
            if (result != 3) {
                System.out.println("Calcul de la racine de 9 sur l'intervalle [1,9] --> Solution attendue : 3");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Calcul de la racine de 9 sur l'intervalle [1,9] --> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        if (testOK) {
            System.out.println();
            System.out.println("Tous les tests de base de la méthode 'racineParBissection' ont réussi");
        }
    }

    private static void testRacineParBissection2() {
        int temps = 300;
        boolean testOK = true;
        Polynome p = new Polynome(2);
        p.setCoefficient(0, -2);

        System.out.println("Test 1 :");
        System.out.println("========");

        try {
            p.racineParBissection(1, 2, 20);
            System.out.println("Impossible de trouver la racine de 2 avec 20 décimales exactes --> Il fallait une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 2 avec 20 décimales exactes --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");

        p.setCoefficient(0, -10000000);
        try {
            double result = p.racineParBissection(1, 10000000, -1);
            if (Math.abs(result - 3162.430042743683) > 0.000000000001) {
                System.out.println("Calcul de la racine de 10000000 avec -1 décimale exacte --> Solution attendue = 3162.430042743683");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Il ne faut pas lancer d'exception si le nombre de décimales demandé est négatif");
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        try {
            p.racineParBissection(1, 10000000, 15);
            System.out.println("Impossible de trouver la racine de 10000000 avec 15 décimales exactes --> Il fallait une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 10000000 avec 15 décimales exactes --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        p.setCoefficient(0, -0.21545461E-20);
        try {
            double result = p.racineParBissection(0.21545461E-20, 1, 20);
            if (Math.abs(result - 4.641708844862331E-11) > 0.0000001E-11) {
                System.out.println("Calcul de la racine de 0.21545461E-20 avec 20 décimales exactes--> Solution attendue : 4.641708844862331E-11");
                System.out.println("solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("calcul de la racine de 0.21545461E-20 avec 20 décimales exactes --> il ne devrait pas y avoir d'exception");
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        p.setCoefficient(0, - 9);
        try {
            double result = p.racineParBissection(3, 5, 9);
            if (result != 3) {
                System.out.println("Calcul de la racine de 9 sur l'intervalle [3,5] --> Une des extrémités de l'intervale est la racine : il fallait renvoyer cette extrémité");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 9 sur l'intervalle [3,5]");
            System.out.println("Si une des extrémités est solution de l'équation, on ne doit pas lancer d'exception");
            testOK = false;
        }

        System.out.println("Test 6 :");
        System.out.println("========");

        try {
            double result = p.racineParBissection(1, 3, 9);
            if (result != 3) {
                System.out.println("Calcul de la racine de 9 sur l'intervalle [1,3] --> Une des extrémités de l'intervale est la racine : il fallait renvoyer cette extrémité");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 9 sur l'intervalle [-1,3]");
            System.out.println("Si une des extrémités est solution de l'équation, on ne doit pas lancer d'exception");
            testOK = false;
        }

        if (testOK) {
            System.out.println();
            System.out.println("Tous les tests approfondis de la méthode 'racineParBissection' ont réussi");
        }
    }

    private static void testRacineParNewtonNIterations() {
        int temps = 300;
        Polynome p = null;
        boolean testOK = true;
        p = new Polynome(4);
        p.setCoefficient(0, 1);
        p.setCoefficient(2, -3);
        p.setCoefficient(4, 2);
        double result;
        System.out.println("Test 1 :");
        System.out.println("========");
        try {
            result = p.racineParNewtonNIterations(-0.75, 0.75, 4);
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.75,0.75] (a = -0.75, b= 0.75) --> Bolzano pas vérifié --> Il fallait lancer une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.75,0.75] (a = -0.75, b= 0.75) --> Bolzano pas vérifié --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");
        try {
            result = p.racineParNewtonNIterations(-0.9, -0.6, 6);
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.9,-0.6] (a = -0.9, b= -0.6) --> La dérivée première n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.9,-0.6] (a = -0.9, b= -0.6) --> La dérivée première n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        try {
            result = p.racineParNewtonNIterations(-0.8, -0.25, 2);
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.8,-0.25] (a = -0.8, b= -0.25) --> La dérivée seconde n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.8,-0.25] (a = -0.8, b= -0.25) --> La dérivée seconde n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        try {
            result = p.racineParNewtonNIterations(0.5, 1, 4);
            if (result != 1) {
                System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [0.5,1] (a = 0.5, b= 1) après 4 itérations --> Solution attendue : 1");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [0.5,1] (a = 0.5, b= 1) --> Il ne fallait pas d'exception si la racine est une borne de l'intervalle");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        try {
            result = p.racineParNewtonNIterations(-0.8, -0.6, 3);
            if (result != -0.7071066475220704) {
                System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.8,-0.6] (a = -0.8, b= -0.6) après 3 itérations --> Solution attendue : -0.7071066475220704");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [-0.8,-0.6] (a = -0.8, b= -0.6)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 6 :");
        System.out.println("========");

        try {
            result = p.racineParNewtonNIterations(0.65, 0.75, 6);
            if (result != 0.7071067811865476) {
                System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [0.65,0.75] (a = 0.65, b= 0.75) après 3 itérations --> Solution attendue : -0.7071066475220704");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            System.out.println("Approximation de la racine de 2x^4-3x²+1 sur l'intervalle [0.65,0.75] (a = 0.65, b= 0.75)--> Il ne fallait pas d'exception");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        if (testOK) {
            System.out.println();
            System.out.println("Tous les tests de la méthode 'racineParNewtonNIterations' ont réussi");
        }

    }

    private static void testNewton1() {
        int temps = 300;
        boolean testOK = true;
        Polynome p = new Polynome(2);
        p.setCoefficient(0, -2);
        double result;

        System.out.println("Test 1 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 2, 2);
            if (result < 1.4166666666666667 - 1e-13 || result > 1.4166666666666667 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2)--> Solution attendue : 1.411764705882353");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2) -- > Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(2, 1, 2);
            if (result < 1.4166666666666667 - 1e-13 || result > 1.4166666666666667 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1)--> Solution attendue : 1.411764705882353");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1) -- > Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 2, 5);
            if (result < 1.4142156862745099 - 1e-13 || result > 1.4142156862745099 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1, b = 2) --> Solution attendue = 1.41421143847487");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1, b= 2) -- > Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 1.6, 5);
            if (result < 1.414213562962298 - 1e-13 || result > 1.414213562962298 + 1e-13) {
                System.out.println("Calcul de la racine de 2 (x^2-2) avec 5 décimales exactes (a = 1, b = 1.6) --> Solution attendue = 1.4142131306617165");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1, b= 1.6) -- > Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1.6, 1, 5);
            if (result < 1.414213562962298 - 1e-13 || result > 1.414213562962298 + 1e-13) {
                System.out.println("Calcul de la racine de 2 (x^2-2) avec 5 décimales exactes (a = 1.6, b = 1) --> Solution attendue = 1.4142131306617165");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 5 décimales exactes (a = 1.6, b= 1) -- > Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 6 :");
        System.out.println("========");

        try {
            p.racineParNewton(3, 4, 3);
            System.out.println("Impossible de trouver la racine de 2 dans l'intervalle [3,4] --> Il fallait une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 2 dans l'intervalle --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 7 :");
        System.out.println("========");

        p.setCoefficient(0, 2);
        p.setCoefficient(2, -1);

        try {
            result = p.racineParNewton(1, 2, 2);
            if (result < 1.4166666666666667 - 1e-13 || result > 1.4166666666666667 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2)--> Solution attendue : 1.411764705882353");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1, b= 2)--> Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 8 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(2, 1, 2);
            if (result < 1.4166666666666667 - 1e-13 || result > 1.4166666666666667 + 1e-13) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1)--> Solution attendue : 1.411764705882353");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 2, b= 1)--> Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 9 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 1.6, 5);
            if (result < 1.414213562962298 - 1e-13 || result > 1.414213562962298 + 1e-13) {
                System.out.println("Calcul de la racine de 2 (-x^2+2) avec 5 décimales exactes (a = 1, b = 1.6) --> Solution attendue = 1.4142131306617165");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            e.printStackTrace();
            System.out.println("Calcul de la racine de 2 (-x^2+2) avec 5 décimales exactes (a = 1, b = 1.6) --> Il ne fallait pas d'exception!");
            testOK = false;
        }

        System.out.println("Test 10 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1.6, 1, 5);
            if (result < 1.414213562962298 - 1e-13 || result > 1.414213562962298 + 1e-13) {
                System.out.println("Calcul de la racine de 2 (-x^2+2) avec 5 décimales exactes (a = 1.6, b = 1) --> Solution attendue = 1.4142131306617165");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            e.printStackTrace();
            System.out.println("Calcul de la racine de 2 (-x^2+2) avec 5 décimales exactes (a = 1.6, b = 1) --> Il ne fallait pas d'exception!");
            testOK = false;
        }

        if (testOK) {
            System.out.println() ;
            System.out.println("Tous les tests de base de la méthode 'racineParNewton' ont réussi");
        }
    }

    private static void testNewton2() {
        int temps = 300;
        Polynome p = new Polynome(2);
        p.setCoefficient(0, -2);
        boolean testOK = true;
        double result;

        System.out.println("Test 1 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1.4142, 1.4143, 2);
            if (result != 1.4143) {
                System.out.println("Calcul de la racine de 2 avec 2 décimales exactes (a = 1.4142, b= 1.4143)--> Solution attendue : a = 1.4143");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 2 sur l'intervalle [1.4142,1.4143] --> Il ne fallait pas d'exception");
            testOK = false;
        }

        System.out.println("Test 2 :");
        System.out.println("========");

        try {
            p.racineParNewton(1, 2, 20);
            System.out.println("Impossible de trouver la racine de 2 avec 20 décimales exactes --> Il fallait une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 2 avec 20 décimales exactes --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 3 :");
        System.out.println("========");

        try {
            p.racineParNewton(-0.5, 2, 0);
            System.out.println("La dérivée première n'a pas le même signe en a et en b : il devait y avoir une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException n) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("La dérivée première n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 4 :");
        System.out.println("========");

        p.setCoefficient(0, -10000000);
        try {
            result = p.racineParNewton(1, 10000, -1);
            if (Math.abs(result - 3162.277665175675) > 0.000000000001) {
                System.out.println("Calcul de la racine de 10000000 avec -1 décimale exacte --> Solution attendue = 3157.580696301692");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Il ne faut pas lancer d'exception si le nombre de décimales demandé est négatif");
            testOK = false;
        }

        System.out.println("Test 5 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 10000000, 15);
            System.out.println("Impossible de trouver la racine de 10000000 avec 15 décimales exactes --> Il fallait une NumeriqueException");
            System.out.println("solution renvoyée : " + result);
            testOK = false;
        } catch (NumeriqueException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Impossible de trouver la racine de 10000000 avec 15 décimales exactes --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 6 :");
        System.out.println("========");

        try {
            p.setCoefficient(0, -9);
            result = p.racineParNewton(3, 5, 9);
            if (result!=3) {
                System.out.println("Calcul de la racine de x²-9 avec 9 décimales exactes --> Solution attendue = 3");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("OK") ;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 9 sur l'intervalle [3,5]");
            System.out.println("Si une des extrémités est solution de l'équation, on ne doit pas lancer d'exception");
            testOK = false;
        }

        System.out.println("Test 7 :");
        System.out.println("========");

        try {
            result = p.racineParNewton(1, 3, 9);
            if (result!=3) {
                System.out.println("Calcul de la racine de x²-9 avec 9 décimales exactes --> Solution attendue = 3");
                System.out.println("Solution trouvée : " + result);
                testOK = false;
            } else {
                System.out.println("OK") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            System.out.println("Calcul de la racine de 9 sur l'intervalle [1,3]");
            System.out.println("Si une des extrémités est solution de l'équation, on ne doit pas lancer d'exception");
            testOK = false;
        }

        System.out.println("Test 8 :");
        System.out.println("========");

        try {
            p = new Polynome(3);
            p.setCoefficient(3, -2);
            p.setCoefficient(2, +3);
            p.setCoefficient(1, 1);
            p.setCoefficient(0, -1);
            p.racineParNewton(0, 1, 3);
            System.out.println("La dérivée seconde n'a pas le même signe en a et en b");
            System.out.println("--> Il devait y avoir une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException n) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("La dérivée seconde n'a pas le même signe en a et en b --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        System.out.println("Test 9 :");
        System.out.println("========");

        try {
            p = new Polynome(4);
            p.setCoefficient(4, 1);
            p.setCoefficient(3, -6);
            p.setCoefficient(2, 12);
            p.setCoefficient(1, -10);
            p.setCoefficient(0, 4);
            p.racineParNewton(0, 2.2, 6);
            System.out.println("Les approximations successives ne sont pas pas décroissantes en valeur absolue");
            System.out.println("--> Il devait y avoir une NumeriqueException");
            testOK = false;
        } catch (NumeriqueException n) {
            System.out.println("OK") ;
        } catch (Exception e) {
            System.out.println("Les approximations successives ne sont pas pas décroissantes en valeur absolue --> Il fallait lancer une NumeriqueException");
            System.out.println("Or exception lancée : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException ex) {
            }
            testOK = false;
        }

        if (testOK) {
            System.out.println();
            System.out.println("Tous les tests approfondis de la méthode 'racineParNewton' ont réussi");
        }

    }

}


	