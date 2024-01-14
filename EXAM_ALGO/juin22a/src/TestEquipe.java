
public class TestEquipe {

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
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Equipe :");
		System.out.println("**************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode 'selectionnerCandidat()'");
			System.out.println("2 -> Tester la methode 'remettreEnJeu(Candidat candidat)'");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testerSelectionnerCandidat();
					break;
				case 2:
					testerRemettreEnJeu();
					break;
			}
		} while (choix >= 1 && choix <= 2);
		System.out.println("Fin des tests");
	}

	private static void testerSelectionnerCandidat() {
		//Test1
		System.out.println("Test1");
		System.out.println("Au depart, les 6 candidats en jeu sont : nom1 \tnom2 \tnom3 \tnom4 \tnom5 \tnom6");
		System.out.println("Le candidat a selectionner est nom1");
		System.out.println("Apres selection, Il reste 5 candidats en jeu : nom2 \tnom3 \tnom4 \tnom5 \tnom6");
		try{
			String[] candidats = new String[6];
			for (int i = 0; i < candidats.length; i++) {
				candidats[i] = "nom"+(i+1);
			}
			Equipe equipe = new Equipe(1, candidats);
			assertEquals("Test1 ko, candidat ko","nom1",equipe.selectionnerCandidat());
			assertEquals("Test1 ko, apres selection, le nombre de candidats est ko",5, equipe.getNombreCandidatsEnJeu());
			assertEquals("Test1 ko, apres selection, les candidats en jeu sont ko"," nom2 nom3 nom4 nom5 nom6", equipe.toString());
			System.out.println("Test1 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test1 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test2
		System.out.println("Test2");
		System.out.println("En cours de jeu, le nombre de candidats diminue ");
		System.out.println("Pour le test2, il reste 3 candidats en jeu : nom5 nom1 nom2 ");
		System.out.println("Le candidat a selectionner est nom5");
		System.out.println("Apres selection, Il reste 2 candidats en jeu : nom1 nom2");
		try{
			String[] candidats = new String[6];
			candidats[0] = "nom5";
			candidats[1] = "nom1";
			candidats[2] = "nom2";
			for (int i = 3; i < 6; i++) {
				candidats[i] = "nomBidon";
			}
			Equipe equipe = new Equipe(1, candidats,3);
			assertEquals("Test2 ko, candidat ko","nom5",equipe.selectionnerCandidat());
			assertEquals("Test2 ko, apres selection, le nombre de candidats est ko",2, equipe.getNombreCandidatsEnJeu());
			assertEquals("Test2 ko, apres selection, les candidats restants sont ko"," nom1 nom2", equipe.toString());
			System.out.println("Test2 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test2 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test3
		System.out.println("Test3");
		System.out.println("Il n'y a plus de candidat en jeu");
		System.out.println("On ne peut donc plus en selectionner");

		try{
			String[] candidats = new String[6];
			for (int i = 0; i < 6; i++) {
				candidats[i] = "nomBidon";
			}
			Equipe equipe = new Equipe(1, candidats,0);
			assertEquals("Test1 ko, candidat ko",null,equipe.selectionnerCandidat());
			assertEquals("Test3 ko, apres selection, le nombre de candidats est ko",0, equipe.getNombreCandidatsEnJeu());
			System.out.println("Test3 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test3 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testerRemettreEnJeu() {
		//Test3
		System.out.println("Test1");
		System.out.println("Au depart, les 6 candidats en jeu sont : nom1 \tnom2 \tnom3 \tnom4 \tnom5 \tnom6");
		System.out.println("Il est donc impossible de remettre en jeu un candidat !");
		try{
			String[] candidats = new String[6];
			for (int i = 0; i < candidats.length; i++) {
				candidats[i] = "nom"+(i+1);
			}
			Equipe equipe = new Equipe(1, candidats);
			assertEquals("Test1 ko, booleen renvoye est ko" ,false,equipe.remettreEnJeu("nom7") );
			assertEquals("Test1 ko, apres remise en jeu, le nombre de candidats est ko",6, equipe.getNombreCandidatsEnJeu());
			System.out.println("Test1 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test1 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test2
		System.out.println("Test2");
		System.out.println("En cours de jeu, le nombre de candidats diminue ");
		System.out.println("Pour le test2, il reste 3 candidats en jeu : nom5 \tnom1 \tnom2 ");
		System.out.println("On peut remettre le candidat nom4 en jeu !");
		System.out.println("Apres remise en jeu, Il y aura 4 candidats en jeu : nom5 \tnom1 \tnom2 \tnom4");
		try{
			String[] candidats = new String[6];
			candidats[0] = "nom5";
			candidats[1] = "nom1";
			candidats[2] = "nom2";
			for (int i = 3; i < 6; i++) {
				candidats[i] = "nomBidon";
			}
			Equipe equipe = new Equipe(1, candidats,3);
			assertEquals("Test2 ko, booleen renvoye est ko" ,true,equipe.remettreEnJeu("nom4") );
			assertEquals("Test2 ko, apres remise en jeu, le nombre de candidats est ko",4, equipe.getNombreCandidatsEnJeu());
			assertEquals("Test2 ko, apres remise en jeu, les candidats en jeu sont ko"," nom5 nom1 nom2 nom4", equipe.toString());
			System.out.println("Test2 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test2 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test3
		System.out.println("Test3");
		System.out.println("Il n'y a plus de candidat en jeu");
		System.out.println("On peut remettre le candidat nom2 en jeu !");
		System.out.println("Apres remise en jeu, Il y aura 1 candidat en jeu : nom2");
		try{
			String[] candidats = new String[6];
			for (int i = 0; i < 6; i++) {
				candidats[i] = "nomBidon";
			}
			Equipe equipe = new Equipe(1, candidats,0);
			assertEquals("Test3 ko, booleen renvoye est ko" ,true,equipe.remettreEnJeu("nom3") );
			assertEquals("Test3 ko, apres remise en jeu, le nombre de candidats est ko",1, equipe.getNombreCandidatsEnJeu());
			assertEquals("Test3 ko, apres remise en jeu, le candidat en jeu est ko"," nom3", equipe.toString());
			System.out.println("Test3 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test3 ko : il y a eu une exception non prevue");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();

	}

}
