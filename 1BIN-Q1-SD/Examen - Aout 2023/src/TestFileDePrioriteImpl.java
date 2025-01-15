import java.util.Scanner;


public class TestFileDePrioriteImpl {

	private static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {

		System.out.println("*********************************");
		System.out.println("Programme Test FileDePrioriteImpl");
		System.out.println("*********************************");
		int choix = 0;

		do {
			System.out.println();
			System.out.println("1 ->  Tester la methode insere()");
			System.out.println("2 ->  Tester la methode max()");
			System.out.println("3 ->  Tester l'iterateur");

			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {

				case 1:
					testInsere();
					break;
				case 2:
					testMax();
					break;
				case 3:
					testIterateur();
					break;

				default:
					break;
			}
		} while (choix >= 1 && choix <= 3);
		System.out.println();
		System.out.println("Fin des tests");
	}

	private static FileDePriorite<PersonneAvecPriorite> enonce(){
		PersonneAvecPriorite lea = new PersonneAvecPriorite("lea",5);
		PersonneAvecPriorite anouk = new PersonneAvecPriorite("anouk",8);
		PersonneAvecPriorite zoe = new PersonneAvecPriorite("zoe",2);
		PersonneAvecPriorite sam = new PersonneAvecPriorite("sam",3);
		PersonneAvecPriorite hugo = new PersonneAvecPriorite("hugo",6);
		PersonneAvecPriorite tim = new PersonneAvecPriorite("tim",3);
		PersonneAvecPriorite marie = new PersonneAvecPriorite("marie",5);
		ComparateurPersonneAvecPriorite comparateur = new ComparateurPersonneAvecPriorite();
		return new FileDePrioriteImpl<PersonneAvecPriorite>(lea,anouk,zoe,sam,hugo,tim,marie,comparateur);
	}

	private static FileDePriorite<PersonneAvecPriorite> vide(){
		ComparateurPersonneAvecPriorite comparateur = new ComparateurPersonneAvecPriorite();
		return new FileDePrioriteImpl<PersonneAvecPriorite>(comparateur);
	}


	private static void testMax() {
		System.out.println();
		FileDePriorite<PersonneAvecPriorite> file;
		PersonneAvecPriorite pTrouve;
		System.out.println("Test max() avec la file de priorite de l'enonce");
		file = enonce();
		pTrouve = file.max();
		if(pTrouve==null){
			System.out.println("\nAttention, votre methode a renvoye null comme max");
			System.out.println("Revoyez votre methode !");
			return;
		}
		if(!pTrouve.prenom.equals("zoe")){
			System.out.println("\nAttention, votre methode a renvoye "+ pTrouve);
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.println("Le test avec la file de priorite de l'enonce a reussi !");
		System.out.println();
		System.out.println("Test max() avec une file de priorite vide");
		file = vide();
		pTrouve = file.max();
		if(pTrouve!=null){
			System.out.println("\nAttention, votre methode n'a pas renvoye null");
			System.out.println("Revoyez votre methode !");
			return;
		}

		System.out.println("Le test avec une file de priorite vide a reussi !");
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testInsere() {

		System.out.println();
		System.out.println("Test ajouter() en partant d'une file de priorite vide et en construisant la file de priorite de l'enonce");
		System.out.println("Les ajouts se feront selon l'ordre : lea anouk zoe sam hugo tim marie");
		PersonneAvecPriorite lea = new PersonneAvecPriorite("lea",5);
		PersonneAvecPriorite anouk = new PersonneAvecPriorite("anouk",2);
		PersonneAvecPriorite zoe = new PersonneAvecPriorite("zoe",12);
		PersonneAvecPriorite sam = new PersonneAvecPriorite("sam",7);
		PersonneAvecPriorite hugo = new PersonneAvecPriorite("hugo",5);
		PersonneAvecPriorite tim = new PersonneAvecPriorite("tim",9);
		PersonneAvecPriorite marie = new PersonneAvecPriorite("marie",7);
		FileDePriorite<PersonneAvecPriorite> file = vide();
		System.out.println();
		System.out.print("on insere lea");
		file.insere(lea);
		if(!file.toString().equals("[ lea (5) ]")){
			System.out.println("\nAttention, apres ajout de lea, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre : [ lea (5) ]");
			System.out.println("");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere anouk");
		file.insere(anouk);
		if(!file.toString().equals("[  [ anouk (2) ] lea (5) [ ]  ]")){
			System.out.println("\nAttention, apres ajout de anouk, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [ anouk (2) ] lea (5) [ ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere zoe");
		file.insere(zoe);
		if(!file.toString().equals("[  [ anouk (2) ] lea (5) [ zoe (12) ]  ]")){
			System.out.println("\nAttention, apres ajout de zoe, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [ anouk (2) ] lea (5) [ zoe (12) ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere sam");
		file.insere(sam);
		if(!file.toString().equals("[  [ anouk (2) ] lea (5) [  [ sam (7) ] zoe (12) [ ]  ]  ]")){
			System.out.println("\nAttention, apres ajout de sam, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [ anouk (2) ] lea (5) [  [ sam (7) ] zoe (12) [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere hugo");
		file.insere(hugo);
		if(!file.toString().equals("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [ sam (7) ] zoe (12) [ ]  ]  ]")){
			System.out.println("\nAttention, apres ajout de hugo, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [ sam (7) ] zoe (12) [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere tim");
		file.insere(tim);
		if(!file.toString().equals("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [  [ ] sam (7) [ tim (9) ]  ] zoe (12) [ ]  ]  ]")){
			System.out.println("\nAttention, apres ajout de tim, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [  [ ] sam (7) [ tim (9) ]  ] zoe (12) [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.print("on insere marie");
		file.insere(marie);
		if(!file.toString().equals("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [  [ marie (7) ] sam (7) [ tim (9) ]  ] zoe (12) [ ]  ]  ]")){
			System.out.println("\nAttention, apres ajout de marie, la file de priorite obtenue :");
			System.out.println(file.toString());
			System.out.println("Elle devrait etre :");
			System.out.println("[  [  [ ] anouk (2) [ hugo (5) ]  ] lea (5) [  [  [ marie (7) ] sam (7) [ tim (9) ]  ] zoe (12) [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");
			return;
		}
		System.out.print(" : ok");
		System.out.println();
		System.out.println();
		System.out.println("Tous les tests ont reussi !");

	}

	private static void testIterateur() {
		System.out.println();
		FileDePriorite<PersonneAvecPriorite> file;
		PersonneAvecPriorite pTrouve;
		System.out.println("Test iterator() avec la file de priorite de l'enonce");
		file = enonce();
		String[] attendu = {"zoe", "tim", "sam", "marie", "lea", "hugo", "anouk"};
		int i = 0;
		for (PersonneAvecPriorite p : file) {
			if(p==null){
				System.out.println("\nAttention, next() recu : null");
				System.out.println("next() attendu : "+attendu[i]);
				System.out.println("Revoyez la methode remplirFile() de la classe Iterateur !");
				return;
			}
			if(!p.prenom.equals(attendu[i])){
				System.out.println("\nAttention, next() recu "+p.prenom);
				System.out.println("           next() attendu : "+attendu[i]);
				System.out.println("Revoyez la methode remplirFile() de la classe Iterateur !");
				return;
			}
			System.out.print(" "+p.prenom);
			i++;
		}
		if(i!=7){
			System.out.println("\nAttention, l'iterateur n'a pas parcouru toute la file de priorite");
			System.out.println("Revoyez la methode remplirFile() de la classe Iterateur !");
			return;
		}
		System.out.println();
		System.out.println("Le test avec la file de priorite de l'enonce a reussi !");
		System.out.println();
		System.out.println();
		System.out.println("Test iterator() avec une file de priorite vide");
		file = vide();
		for (PersonneAvecPriorite p : file) {
			System.out.println(p);
			System.out.println("\nAttention, l'iterateur n'a rien a renvoyer");
			System.out.println("Revoyez la methode remplirFile() de la classe Iterateur !");
		    return;
		}
		System.out.println("Le test avec une file de priorite vide a reussi !");
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

}

	


