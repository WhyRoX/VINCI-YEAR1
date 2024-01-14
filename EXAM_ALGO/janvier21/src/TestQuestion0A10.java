
public class TestQuestion0A10 {

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
		
		System.out.println("*********************************");
		System.out.println("Tests pour la classe Question0A10");
		System.out.println("*********************************");
		do{
			System.out.println("Menu");
			System.out.println("****");
		
			System.out.println("1 -> moyenne()");						
			System.out.println("2 -> contientReponses()");
			System.out.println("3 -> ajouterReponses()");
			System.out.println("4 -> tableFrequences()");	
			System.out.println("5 -> mediane()");
			System.out.print("\nEntrez votre choix : ");			
			
			choix=scanner.nextInt();
			
			switch(choix){	
			case 1: testerMoyenne();   
			break;	
			case 2: testerContientReponses();   
			break;			
			case 3: testerAjouterReponses();
			break;
			case 4: testerTableFrequences(); 
			break;		
			case 5: testerMediane(); 
			break;		


			}
		}while(choix >=1&&choix<=5);
		System.out.println("\nFin des tests");
	}

	private static void testerMoyenne() {
		System.out.println();
		System.out.println("moyenne()");
		System.out.println("---------");
		
		System.out.println("test 1 : reponses 3 4 7 1");
		try{
			int[] table1 = {3,4,7,1};
			Question0A10 q1 = new Question0A10("q",table1);
			assertEquals("test 1 ko ", 3.75 , q1.moyenne());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		
		
		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerContientReponses() {
		System.out.println();
		System.out.println("contientReponses()");		
		System.out.println("------------------");
		
		System.out.println("test 1 : table 0 1 2 3 4 5 6 7 8 9 10");
		try{
			int[] table1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			assertEquals("test 1 ko ", true , Question0A10.contientReponses(table1));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		
		System.out.println();
		System.out.println("test 2 : table 11 0 1 4 ");
		try{
			int[] table2 = {11, 0, 1, 4};
			assertEquals("test 2 ko ", false , Question0A10.contientReponses(table2));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		
		System.out.println();
		System.out.println("test 3 : table 1 0 4 -1");
		try{
			int[] table3 = {1, 0, 4, -1};
			assertEquals("test 3 ko ", false , Question0A10.contientReponses(table3));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");
		
		System.out.println();
		System.out.println("test 4 : table vide");
		try{
			int[] table4 = {};
			assertEquals("test 4 ko ", true , Question0A10.contientReponses(table4));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 4 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok");
		
		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
		
	}

	private static void testerAjouterReponses() {
		System.out.println();
		System.out.println();
		System.out.println("ajouterReponses()");
		System.out.println("-----------------");
		System.out.println("test 1 : reponses 1 2 3 4 - reponses supp 5 6 7");
		try{
			int[] table1 = {1,2,3,4};
			Question0A10 q1 = new Question0A10("q",table1);
			int[] tableSupp1 = {5,6,7};
			q1.ajouterReponses(tableSupp1);
			assertEquals("test 1 ko le nombre de reponses apres ajout est ko",7,q1.getNbReponses());
			assertEquals("test 1 ko contenu apres ajout est ko","q 1 2 3 4 5 6 7 ",q1.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		
		System.out.println();
		System.out.println("test 2 : aucune reponse - reponses supp 5 6 7");
		try{
			int[] table2 = {};
			Question0A10 q2 = new Question0A10("q",table2);
			int[] tableSupp2 = {5,6};
			q2.ajouterReponses(tableSupp2);
			assertEquals("test 2 ko le nombre de reponses apres ajout est ko",2,q2.getNbReponses());
			assertEquals("test 2 ko contenu apres ajout est ko","q 5 6 ",q2.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		
		System.out.println();
		System.out.println("test 3 : reponses 1 2 3 4 5 6 7 - reponses supp 1 2 3 4 5");
		try{
			int[] table3 = {1,2,3,4,5,6,7};
			Question0A10 q3 = new Question0A10("q",table3);
			int[] tableSupp3 = {1,2,3,4,5};
			q3.ajouterReponses(tableSupp3);
			assertEquals("test 3 ko le nombre de reponses apres ajout est ko",10,q3.getNbReponses());
			assertEquals("test 3 ko contenu apres ajout est ko","q 1 2 3 4 5 6 7 1 2 3 ",q3.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");
		
		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

	
	private static void testerTableFrequences() {
		System.out.println();
		System.out.println();
		System.out.println("tableFrequences()");
		System.out.println("-----------------");
		
		System.out.println("test 1 : reponses 1 3 9 3 8");
		try{
			int[] table1 = {1,3,9,3,8};
			Question0A10 q1 = new Question0A10("q1",table1);
			int[] fr1 = q1.tableFrequences();
			assertEquals("test 1 ko la dimension de la table renvoyee est ko (il y a 11 reponses possibles)",11,fr1.length);
			assertEquals("test 1 ko frequence 0 ko", 0, fr1[0]);
			assertEquals("test 1 ko frequence 1 ko", 1, fr1[1]);
			assertEquals("test 1 ko frequence 2 ko", 0, fr1[2]);
			assertEquals("test 1 ko frequence 3 ko", 2, fr1[3]);
			assertEquals("test 1 ko frequence 4 ko", 0, fr1[4]);
			assertEquals("test 1 ko frequence 5 ko", 0, fr1[5]);
			assertEquals("test 1 ko frequence 6 ko", 0, fr1[6]);
			assertEquals("test 1 ko frequence 7 ko", 0, fr1[7]);
			assertEquals("test 1 ko frequence 8 ko", 1, fr1[8]);
			assertEquals("test 1 ko frequence 9 ko", 1, fr1[9]);
			assertEquals("test 1 ko frequence 10 ko", 0, fr1[10]);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		System.out.println();
		
		
		System.out.println("test 2 : reponses 0 10 0 10 0 0");
		try{
			int[] table2 = {0,10,0,10,0,0};
			Question0A10 q2 = new Question0A10("q",table2);
			int[] fr2 = q2.tableFrequences();
			assertEquals("test 2 ko la dimension de la table renvoyee est ko (il y a 11 reponses possibles)",11,fr2.length);
			assertEquals("test 2 ko frequence 0 ko", 4, fr2[0]);
			assertEquals("test 2 ko frequence 1 ko", 0, fr2[1]);
			assertEquals("test 2 ko frequence 2 ko", 0, fr2[2]);
			assertEquals("test 2 ko frequence 3 ko", 0, fr2[3]);
			assertEquals("test 2 ko frequence 4 ko", 0, fr2[4]);
			assertEquals("test 2 ko frequence 5 ko", 0, fr2[5]);
			assertEquals("test 2 ko frequence 6 ko", 0, fr2[6]);
			assertEquals("test 2 ko frequence 7 ko", 0, fr2[7]);
			assertEquals("test 2 ko frequence 8 ko", 0, fr2[8]);
			assertEquals("test 2 ko frequence 9 ko", 0, fr2[9]);
			assertEquals("test 2 ko frequence 10 ko", 2, fr2[10]);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		
		System.out.println();
		System.out.println("test 3 : aucune reponse");
		try{
			int[] table3 = {};
			Question0A10 q1 = new Question0A10("q1",table3);
			int[] fr3 = q1.tableFrequences();
			assertEquals("test 3 ko la dimension de la table renvoyee est ko (il y a 11 reponses possibles)",11,fr3.length);
			assertEquals("test 3 ko frequence 0 ko", 0, fr3[0]);
			assertEquals("test 3 ko frequence 1 ko", 0, fr3[1]);
			assertEquals("test 3 ko frequence 2 ko", 0, fr3[2]);
			assertEquals("test 3 ko frequence 3 ko", 0, fr3[3]);
			assertEquals("test 3 ko frequence 4 ko", 0, fr3[4]);
			assertEquals("test 3 ko frequence 5 ko", 0, fr3[5]);
			assertEquals("test 3 ko frequence 6 ko", 0, fr3[6]);
			assertEquals("test 3 ko frequence 7 ko", 0, fr3[7]);
			assertEquals("test 3 ko frequence 8 ko", 0, fr3[8]);
			assertEquals("test 3 ko frequence 9 ko", 0, fr3[9]);
			assertEquals("test 3 ko frequence 10 ko", 0, fr3[10]);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");
		
		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
		
	}

	private static void testerMediane() {
		System.out.println();
		System.out.println();
		System.out.println("mediane()");
		System.out.println("---------");
		
		System.out.println("test 1 : reponses 1 2 3 4 5");
		try{
			int[] table1 = {1,2,3,4,5};
			Question0A10 q1 = new Question0A10("q1",table1);
			Question0A10 q1Copie = new Question0A10("q1",table1);
			assertEquals("test 1 ko",3,q1.mediane());
			assertEquals("test 1 ko tableReponses modifiee", q1Copie.toString(), q1.toString());
	
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		System.out.println();
		
		System.out.println("test 2 : reponses 2 4 5 1 3");
		try{
			int[] table2 = {2,4,5,1,3};
			Question0A10 q2 = new Question0A10("q2",table2);
		
			assertEquals("test 2 ko",3,q2.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		System.out.println();
		
		System.out.println("test 3 : reponses 2 8 9 1 9 7 4");
		try{
			int[] table3 = {2,8,9,1,9,7,4};
			Question0A10 q3 = new Question0A10("q3",table3);
		
			assertEquals("test 3 ko",7,q3.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");
		
		System.out.println();
		
		System.out.println("test 4 : reponses 9 ");
		try{
			int[] table4 = {9};
			Question0A10 q4 = new Question0A10("q4",table4);
		
			assertEquals("test 4 ko",9,q4.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 4 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok");
		
		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

	

}
