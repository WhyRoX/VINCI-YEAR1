public class TestEgalite{
   	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	// les 3 nombres sont égaux
	private static boolean tousEgaux(int nombre1, int nombre2, int nombre3){
		return nombre1 == nombre2 && nombre1 == nombre3;	// A MODIFIER
	}

	// les 3 nombres sont tous différents
	private static boolean tousDifferents(int nombre1, int nombre2, int nombre3){
		return nombre1 != nombre2 && nombre1 != nombre3 && nombre2 != nombre3;	// A MODIFIER
	}

	// Au moins 2 nombres les mêmes
	private static boolean auMoinsUneEgalite(int nombre1, int nombre2, int nombre3){
		return false;
	}

	// Au plus 2 nombres les mêmes
	private static boolean auPlusUneEgalite(int nombre1, int nombre2, int nombre3){
		return false ;	// A MODIFIER
	}

	private static boolean uneSeuleEgalite(int nombre1, int nombre2, int nombre3){
		return false;  // A MODIFIER
	}


   	public static void main(String [] args){

	   	int choix;			
		do{
			System.out.println();
			System.out.println("1 -> Tester la méthode tousEgaux");
			System.out.println("2 -> Tester la méthode tousDifferents");
			System.out.println("3 -> Tester la méthode auMoinsUneEgalite");
			System.out.println("4 -> Tester la méthode auPlusUneEgalite");
			System.out.println("5 -> Tester la méthode uneSeuleEgalite");
			System.out.println("Entrez votre choix :");
			choix=scanner.nextInt();
			switch(choix){
				case 1: testTousEgaux(); break;
				case 2: testTousDifferents(); break;
				case 3: testAuMoinsUneEgalite(); break;
				case 4: testAuPlusUneEgalite(); break;
				case 5: testUneSeuleEgalite(); break;
				
			}	
		}while(choix >=1 && choix<=5);
	}


	private static void testTousEgaux(){
		if(!tousEgaux(1,1,1)){
			System.out.println("Attention test : 1 1 1 a échoué");
			return;
		}
		if(tousEgaux(1,1,2)){
			System.out.println("Attention test : 1 1 2 a échoué");
			return;
		}
		if(tousEgaux(1,2,2)){
			System.out.println("Attention test : 1 2 2 a échoué");
			return;
		}
		if(tousEgaux(1,2,1)){
			System.out.println("Attention test : 1 2 1 a échoué");
			return;
		}
		if(tousEgaux(1,2,3)){
			System.out.println("Attention test : 1 2 3 a échoué");
			return;
		}
		System.out.println("Tous les tests ont réussi!");

      	}

	private static void testTousDifferents(){
		if(tousDifferents(1,1,1)){
			System.out.println("Attention test : 1 1 1 a échoué");
			return;
		}
		if(tousDifferents(1,1,2)){
			System.out.println("Attention test : 1 1 2 a échoué");
			return;
		}
		if(tousDifferents(1,2,2)){
			System.out.println("Attention test : 1 2 2 a échoué");
			return;
		}
		if(tousDifferents(1,2,1)){
			System.out.println("Attention test : 1 2 1 a échoué");
			return;
		}
		if(!tousDifferents(1,2,3)){
			System.out.println("Attention test : 1 2 3 a échoué");
			return;
		}
		System.out.println("Tous les tests ont réussi!");

      	}
	
	private static void testAuMoinsUneEgalite(){
		if(! auMoinsUneEgalite(1,1,1)){
			System.out.println("Attention test : 1 1 1 a échoué");
			return;
		}
		if(! auMoinsUneEgalite(1,1,2)){
			System.out.println("Attention test : 1 1 2 a échoué");
			return;
		}
		if(! auMoinsUneEgalite(1,2,2)){
			System.out.println("Attention test : 1 2 2 a échoué");
			return;
		}
		if(! auMoinsUneEgalite(1,2,1)){
			System.out.println("Attention test : 1 2 1 a échoué");
			return;
		}
		if( auMoinsUneEgalite(1,2,3)){
			System.out.println("Attention test : 1 2 3 a échoué");
			return;
		}
		System.out.println("Tous les tests ont réussi!");

      	}

	private static void testAuPlusUneEgalite(){
		if(auPlusUneEgalite(1,1,1)){
			System.out.println("Attention test : 1 1 1 a échoué");
			return;
		}
		if(!auPlusUneEgalite(1,1,2)){
			System.out.println("Attention test : 1 1 2 a échoué");
			return;
		}
		if(!auPlusUneEgalite(1,2,2)){
			System.out.println("Attention test : 1 2 2 a échoué");
			return;
		}
		if(!auPlusUneEgalite(1,2,1)){
			System.out.println("Attention test : 1 2 1 a échoué");
			return;
		}
		if(!auPlusUneEgalite(1,2,3)){
			System.out.println("Attention test : 1 2 3 a échoué");
			return;
		}
		System.out.println("Tous les tests ont réussi!");

      	}
	
	private static void testUneSeuleEgalite(){
		if(uneSeuleEgalite(1,1,1)){
			System.out.println("Attention test : 1 1 1 a échoué");
			return;
		}
		if(! uneSeuleEgalite(1,1,2)){
			System.out.println("Attention test : 1 1 2 a échoué");
			return;
		}
		if(! uneSeuleEgalite(1,2,2)){
			System.out.println("Attention test : 1 2 2 a échoué");
			return;
		}
		if(! uneSeuleEgalite(1,2,1)){
			System.out.println("Attention test : 1 2 1 a échoué");
			return;
		}
		if(uneSeuleEgalite(1,2,3)){
			System.out.println("Attention test : 1 2 3 a échoué");
			return;
		}
		System.out.println("Tous les tests ont réussi!");

      	}
}