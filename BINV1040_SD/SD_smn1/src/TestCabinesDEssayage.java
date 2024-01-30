
public class TestCabinesDEssayage {

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu       la valeur qu'on s'attendait a recevoir
     * @param recu          la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        System.out.println("Les tests suivent un scenario.");
        System.out.println("Le magasin compte 3 cabines d'essayage. Elles sont toutes libres au depart");
        CabinesDEssayage c = new CabinesDEssayage(3);
        int numero1 = -1, numero2 = -1, numero3 = -1, numero4 = -1;

        System.out.println("test 1 : toutes les cabines sont libres");
        try {
            assertEquals("test 1 ko : nombre cabines libres ko", 3, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 1 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 2 : premiere attribution");
        System.out.println("le numero de cabine attribue doit etre 1, 2 ou 3");
        try {
            numero1 = c.attribuerCabineLibre();
            System.out.println("le numero de cabine attribue est " + numero1);
            boolean test2 = numero1 >= 1 && numero1 <= 3;
            if (!test2) {
                System.out.println("test 2 ko : numero attribue ko");
                System.exit(0);
            }
            assertEquals("test 2 ko : apres 1 attribution : nombre cabines libres ko", 2, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 2 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 3 : deuxieme attribution");
        System.out.println("le numero de cabine attribue doit etre 1, 2 ou 3, mais pas le numero de cabine attribue a l'etape precedente");
        try {
            numero2 = c.attribuerCabineLibre();
            System.out.println("le numero de cabine attribue est " + numero2);
            boolean test3 = numero2 >= 1 && numero2 <= 3 && numero2 != numero1;
            if (!test3) {
                System.out.println("test 3 ko : numero attribue ko");
                System.exit(0);
            }
            assertEquals("test 3 ko : apres 2 attributions : nombre cabines libres ko", 1, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 3 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 4 : troisieme attribution");
        System.out.println("le numero de cabine attribue doit etre 1, 2 ou 3, mais pas le numero d'une cabine deja attribuee");
        try {
            numero3 = c.attribuerCabineLibre();
            System.out.println("le numero de cabine attribue est " + numero3);
            boolean test4 = numero3 >= 1 && numero3 <= 3 && numero3 != numero1 && numero3 != numero2;
            if (!test4) {
                System.out.println("test 4 ko : numero attribue ko");
                System.exit(0);
            }
            assertEquals("test 4 ko : apres 3 attributions : nombre cabines libres ko", 0, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 4 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 5 : 3 cabines sont occupees, 4eme attribution : impossible!!!");
        try {
            assertEquals("test 5 ko : plus de cabine libre", -1, c.attribuerCabineLibre());
            assertEquals("test 5 ko : nombre cabines libres ko", 0, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 5 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 6 : Avant cette etape, toutes les cabines sont occupees, on libere la cabine 1");
        System.out.println("le numero de cabine existe, la liberation doit reussir");
        try {
            c.libererCabine(1);
            assertEquals("test 6 ko : la cabine 1 a ete liberee : nombre cabines libres ko", 1, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 6 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 7 : A l'etape predente, on a libere la cabine 1");
        System.out.println("on essaye de la liberer a nouveau");
        try {
            c.libererCabine(1);
            System.out.println("test 7 ko : il fallait une exception de type IllegalStateException");
            System.exit(0);
        } catch (IllegalStateException e) {
            assertEquals("test 7 ko : nombre cabines libres ko", 1, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 7 ko : il fallait une exception de type IllegalStateException");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 8 : nouvelle attribution");
        System.out.println("la cabine 1 est la seule cabine libre");
        System.out.println("cette cabine peut etre reattribuee si elle a bien ete liberee");
        System.out.println("en cas de test ko, pensez a verifier la methode d'attribution et la methode de liberation !");

        try {
            assertEquals("test 8 ko : numero de cabine attribuee ko", 1, c.attribuerCabineLibre());
            assertEquals("test 8 ko : apres cette attribution, nombre cabines libres ko", 0, c.nombreCabinesLibres());
        } catch (Exception e) {
            System.out.println("test 8 ko : il ne fallait pas d'exception");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 9 : liberation de la cabine numero 0");
        try {
            c.libererCabine(0);
            System.out.println("test 9 ko : pas de cabine numero 0 : il fallait une exception de type IllegalArgumentException");
            System.exit(0);
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("test 9 ko : il fallait une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test 10 : liberation de la cabine numero 4");
        try {
            c.libererCabine(4);
            System.out.println("test 10 ko : pas de cabine numero 4 : il fallait une exception de type IllegalArgumentException");
            System.exit(0);
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("test 10 ko : il fallait une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");

    }

}
