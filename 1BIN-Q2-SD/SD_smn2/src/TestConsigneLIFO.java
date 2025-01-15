public class TestConsigneLIFO{

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

		ConsigneLIFO consigne = new ConsigneLIFO(3);

		System.out.println("Les tests se font avec une consigne comportant 3 casiers");
		System.out.println();

		try {
			System.out.println("test 1 : au depart les 3 casiers sont libres");
			assertEquals("test 1 ko : reste 1 casier de libre ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 1 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		System.out.println();


		// test2 - test3 - test4
		// attribution de 3 casiers avec mdp "mdp"
		// les numeros attribues sont 0, 1 et 2 dans n'importe quel ordre
		// L'ordre des numeros depend du constructeur

		boolean[] occupations = new boolean[3];
		int numero = -1;
		System.out.println("test 2 : attribution d'un premier casier avec le mot de passe 'mdp'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp"));
		} catch (Exception e) {
			System.out.println("test 2 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		// Le constructeur a-t-il bien rempli la pile?
		if (numero != 0 && numero != 1 && numero != 2) {
			System.out.println("test 2 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("Au depart, tous ces casiers sont libres.");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero " + numero);
			System.out.println("Le constructeur a-t-il bien rempli l'arrayList?");
			System.exit(0);
		}
		try {
			assertEquals("test 2 ko : apres attribution d'un premier casier, reste 1 casier de libre ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 2 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		occupations[numero] = true;
		System.out.println("test 2 ok : numero casier attribue --> " + numero);
		System.out.println();


		System.out.println("test3 : attribution d'un deuxieme casier avec le mot de passe 'mdp'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp"));
		} catch (Exception e) {
			System.out.println("test3 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		// Le constructeur a-t-il bien rempli la pile?
		if (numero != 0 && numero != 1 && numero != 2) {
			System.out.println("test 3 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero " + numero);
			System.out.println("Le constructeur a-t-il bien rempli l'arrayList?");
			System.exit(0);
		}
		if (occupations[numero]) {
			System.out.println("test 3 ko : ");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero " + numero);
			System.out.println("Attention, ce numero correspond a un casier occupe");
			System.exit(0);
		}
		try {
			assertEquals("test 3 ko : apres 2 attributions, reste 1 casier de libre ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 3 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		occupations[numero] = true;
		System.out.println("test 3 ok : numero casier attribue --> " + numero);
		System.out.println();


		System.out.println("test 4 : attribution d'un troisieme casier avec le mot de passe 'mdp'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp"));
		} catch (Exception e) {
			System.out.println("test 4 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		// Le constructeur a-t-il bien rempli la pile?
		if (numero != 0 && numero != 1 && numero != 2) {
			System.out.println("test 4 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero " + numero);
			System.out.println("Le constructeur a-t-il bien rempli l'arrayList?");
			System.exit(0);
		}
		if (occupations[numero]) {
			System.out.println("test 4 ko");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero " + numero);
			System.out.println("Attention, ce numero correspond a un casier deja occupe");
			System.exit(0);
		}
		try {
			assertEquals("test 4 ko : apres attribution de 3 casiers, reste 1 casier de libre ko", false, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 4 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok : numero casier attribue --> " + numero);
		System.out.println();


		System.out.println("test5 : attribution d'un casier alors que tous les casiers sont occupes");
		try {
			assertEquals("test 5 ko, numero renvoye ko", -1, consigne.attribuerCasierLibre("mdp"));
		} catch (Exception e) {
			System.out.println("test 5 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 5 ok");
		System.out.println();


		// test6 - test7 - test8
		// liberation des 3 casiers occupes avec bon mot de passe
		// D'abord le 2, puis le 0, puis le 1
		// Apres ces 3 liberations , la pile : base 2 0 1 sommet

		System.out.println("test 6 : liberation casier numero 2 avec le bon mot de passe");
		try {
			assertEquals("test 6 ko : booleen renvoye ko", true, consigne.libererCasier(2, String.valueOf("mdp")));
		} catch (Exception e) {
			System.out.println("test 6 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			assertEquals("test 6 ko : apres liberation d'un casier, reste un casier de libre ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 6 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 6 ok");
		System.out.println();


		System.out.println("test 7 : liberation casier numero 0 avec le bon mot de passe");
		try {
			assertEquals("test 7 ko : booleen renvoye ko ", true, consigne.libererCasier(0, "mdp"));
		} catch (Exception e) {
			System.out.println("test 7 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 7 ok");
		System.out.println();


		System.out.println("test 8 : liberation casier numero 1 avec le bon mot de passe");
		try {
			assertEquals("test 8 ko : booleen renvoye ko", true, consigne.libererCasier(1, "mdp"));
		} catch (Exception e) {
			System.out.println("test 8 ko: il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 8 ok");
		System.out.println();


		System.out.println("Tous les casiers sont a nouveau libre");
		System.out.println();
		System.out.println("test 9 : liberation du casier 2 avec le mot de passe (prealablement utilise) 'mdp'");
		try {
			if(consigne.libererCasier(2, String.valueOf("mdp"))) {
				System.out.println("test 9 ko : on ne peut liberer un casier qui est libre : booleen renvoye ko");
				System.out.println("Avez-vous reinitialiser le mot de passe, lors de la liberation");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("test 9 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 9 ok");
		System.out.println();


		// tous les casiers sont libres
		// la pile : base 2 0 1 sommet
		// test10 - test11 - test12
		// attribution de 3 casiers
		// on verifie si les attributions des 3 casiers suivent l'ordre 1 puis 0 puis 2

		System.out.println("test 10 : attribution casier avec le mot de passe 'mdp1'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp1"));
			if (numero != 1) {
				System.out.println("test 10 ko : numero attendu = 1, numero recu : "+numero);
				System.out.println("Avez-vous toujours bien rempli la pile et uniquement dans le cas ou la liberation est effective?");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("test 10 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			assertEquals("test 10 ko : apres cette attribution, il reste 2 casiers de libre : reste casier libre ? booleen renvoye ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 10 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 10 ok : numero casier attribue --> " + numero);
		System.out.println();

		System.out.println("test 11 : attribution casier avec le mot de passe 'mdp0'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp0"));
			if (numero != 0) {
				System.out.println("test 11 ko : numero attendu = 0, numero recu : "+numero);
				System.out.println("Avez-vous toujours bien rempli la pile et uniquement dans le cas ou la liberation est effective?");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("test 11 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			assertEquals("test 11 ko : apres cette attribution, il reste 1 casier de libre : reste casier libre ? booleen renvoye ko", true, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 11 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 11 ok : numero casier attribue --> " + numero);
		System.out.println();

		System.out.println("test 12 : attribution casier avec le mot de passe 'mdp2'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdp2"));
			if (numero != 2) {
				System.out.println("test 12 ko : numero attendu = 2, numero recu : "+numero);
				System.out.println("Avez-vous toujours bien rempli la pile et uniquement dans le cas ou la liberation est effective?");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("test 12 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			assertEquals("test 12 ko : apres cette attribution, il ne reste plus de casier de libre : reste casier libre ? booleen renvoye ko", false, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 12 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 12 ok : numero casier attribue --> " + numero);
		System.out.println();

		System.out.println("test 13 : attribution d'un casier alors que tous les casiers sont occupes");
		try {
			assertEquals("test 13 ko : numero casier renvoye ko", -1, consigne.attribuerCasierLibre("mdp"));
		} catch (Exception e) {
			System.out.println("test 13 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 13 ok");
		System.out.println();

		System.out.println("test 14 : liberation casier 1 avec le bon mot de passe 'mdp1'");
		try {
			assertEquals("test 14 ko : booleen renvoye ko ", true, consigne.libererCasier(1, "mdp1"));
		} catch (Exception e) {
			System.out.println("test 14 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 14 ok");
		System.out.println();


		System.out.println("test 15 : liberation casier 0 avec un mauvais mot de passe 'mdpX'");
		try {
			assertEquals("test 15 ko : booleen renvoye ko ", false, consigne.libererCasier(1, String.valueOf("mdpX")));
		} catch (Exception e) {
			System.out.println("test 15 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 15 ko");
		System.out.println();
		System.out.println();

		System.out.println("A ce stade, les casiers 0 (mdp0) et 2 (mdp2) sont occupes");
		System.out.println();

		System.out.println("test 16 : attribution casier avec le mot de passe 'mdpnv1'");
		try {
			numero = consigne.attribuerCasierLibre(String.valueOf("mdpnv1"));
			if (numero != 1) {
				System.out.println("test 16 ko : numero attendu = 1, numero recu : "+numero);
				System.out.println("Avez-vous toujours bien rempli la pile et uniquement dans le cas ou la liberation est effective?");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("test 16 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			assertEquals("test 16 ko : apres cette attribution, il ne reste plus de casier de libre : reste casier libre ? booleen renvoye ko", false, consigne.resteUnCasierLibre());
		} catch (Exception e) {
			System.out.println("test 16 ko : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 16 ok : numero casier attribue --> " + numero);
		System.out.println();

		//Cas d'exception

		// Il n'existe pas de casier -1
		System.out.println("test 17 : liberation casier avec un numero inexistant (-1)");
		try {
			consigne.libererCasier(-1, String.valueOf("mdp"));
			System.out.println("test 17 ko : il fallait lancer une IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 17 ok");
		}
		catch (Exception e) {
			System.out.println("test 17 ko : il y a eu une exception non prevue");
			System.out.println("(il fallait lancer une IllegalArgumentException)");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		// Il n'existe pas de casier 3
		System.out.println("test 18 : liberation casier avec un numero inexistant (3)");
		try {
			consigne.libererCasier(3, String.valueOf("mdp"));
			System.out.println("test 18 ko : il fallait lancer une IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 18 ok");
		}
		catch (Exception e) {
			System.out.println("(test 18 ko : il fallait lancer une IllegalArgumentException)");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		// Le mot de passe ne peut etre null
		System.out.println("test 19 : liberation casier 1 - mot de passe = null");
		try {
			consigne.libererCasier(1, null);
			System.out.println("test 19 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 19 ok");
		} catch (Exception e) {
			System.out.println("test 19 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();


		// Le mot de passe ne peut etre une chaine vide
		System.out.println("test 20 : liberation casier 0 - mot de passe = chaine vide");
		try {
			consigne.libererCasier(0, String.valueOf(""));
			System.out.println("test 20 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 20 ok");
		} catch (Exception e) {
			System.out.println("test 20 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();


		// Le mot de passe ne peut etre null
		System.out.println("test 21 : attribution casier - mot de passe = null");
		try {
			consigne.attribuerCasierLibre(null);
			System.out.println("test 21 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 21 ok");
		} catch (Exception e) {
			System.out.println("test 21 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		// Le mot de passe ne peut etre une chaine vide
		System.out.println("test 22 : attribution casier - mot de passe = chaine vide");
		try {
			consigne.attribuerCasierLibre(String.valueOf(""));
			System.out.println("test 22 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 22 ok");
		} catch (Exception e) {
			System.out.println("test 22 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();

		// Le nombre de casiers doit etre > 0
		System.out.println("test 22 : creation d'une consigne de gare avec 0 casier");
		try {
			consigne = new ConsigneLIFO(0);
			System.out.println("test 22 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 22 ok");
		} catch (Exception e) {
			System.out.println("test 22 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		// Le nombre de casiers doit etre > 0
		System.out.println("test 23 : creation d'une consigne de gare avec -1 casiers");
		try {
			consigne = new ConsigneLIFO(-1);
			System.out.println("test 23 ko : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			System.out.println("test 23 ok");
		} catch (Exception e) {
			System.out.println("test 23 ko : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();


		System.out.println("Tous les tests ont reussi");
	}
	
}

