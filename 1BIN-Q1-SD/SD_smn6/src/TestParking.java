import java.util.Arrays;

public class TestParking {

	public static void main(String[] args) {

		System.out.println("*************************************");
		System.out.println("Programme Test pour la classe Parking");
		System.out.println("*************************************");

		Parking e = new Parking();
		Voiture p1AAA000 = new Voiture("1AAA000","pA");
		Voiture p1BBB000 = new Voiture("1BBB000","pB");
		Voiture p1CCC000 = new Voiture("1CCC000","pC");
		Voiture p1AAA999 = new Voiture("1AAA999","pA");

		System.out.println("Test 1 : ajout des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println("Ajout 1AAA000");
		if(!e.ajouterVoiture(p1AAA000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA000");
			return;
		}
		System.out.println(e.toString());
		if(!e.toString().equals("[1AAA000(pA)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA000(pA)]");
			return;
		}
		System.out.println("Ajout 1BBB000");
		if(!e.ajouterVoiture(p1BBB000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1BBB000");
			return;
		}
		System.out.println(e.toString());
		if(!e.toString().equals("[1AAA000(pA), 1BBB000(pB)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA000(pA), 1BBB000(pB)]");
			return;
		}
		System.out.println("Ajout 1AAA999");
		if(!e.ajouterVoiture(p1AAA999)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA999");
			return;
		}
		System.out.println(e.toString());
		if(!e.toString().equals("[1AAA999(pA), 1AAA000(pA), 1BBB000(pB)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1AAA000(pA), 1BBB000(pB)]");
			return;
		}
		System.out.println("Ajout 1CCC000");
		if(!e.ajouterVoiture(p1CCC000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1CCC000");
			return;
		}
		System.out.println(e.toString());
		if(!e.toString().equals("[1AAA999(pA), 1CCC000(pC), 1AAA000(pA), 1BBB000(pB)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1CCC000(pC), 1AAA000(pA), 1BBB000(pB)]");
			return;
		}
		System.out.println("Test 1 ok");
		System.out.println();

		System.out.println("Test 2 : verification de l'autorisation des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println(e.toString());
		System.out.println("Verification 1AAA000");
		if(! e.voitureAutorisee(new Voiture("1AAA000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA000 est non autorisee !");
			return;
		}
		System.out.println("Verification 1BBB000");
		if(! e.voitureAutorisee(new Voiture("1BBB000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1BBB000 est non autorisee !");
			return;
		}
		System.out.println("Verification 1CCC000");
		if(! e.voitureAutorisee(new Voiture("1CCC000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1CCC000 est non autorisee !");
			return;
		}
		System.out.println("Verification 1AAA999");
		if(! e.voitureAutorisee(new Voiture("1AAA999",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA999 est non autorisee !");
			return;
		}

		System.out.println("Test 2 ok");
		System.out.println();


		System.out.println("Test 3 : verification de la non autorisation de la voiture 1DDD000");
		System.out.println(e.toString());
		System.out.println("Verification 1DDD000");
		if(e.voitureAutorisee(new Voiture("1DDD000",""))){
			System.out.println("Attention, voiture 1DDD000 est non autorisee !");
			return;
		}
		System.out.println("Test 3 ok");
		System.out.println();


		System.out.println("Test 4 : table triee avec les plaques autorisees");
		System.out.println(e.toString());
		System.out.println("Table attendue : [1AAA000, 1AAA999, 1BBB000, 1CCC000]");
		String[]tableRecue = e.tableTrieePlaques();
		if(tableRecue==null){
			System.out.println("Attention la table est null");
			return;
		}
		if(Arrays.toString(tableRecue).equals("[1AAA999, 1CCC000, 1AAA000, 1BBB000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention la table est non triee");
			return;
		}
		if(!Arrays.toString(tableRecue).equals("[1AAA000, 1AAA999, 1BBB000, 1CCC000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention le contenu de la table est ko");
			return;
		}
		System.out.println("Test 4 ok");
		System.out.println();

		System.out.println("Test 5 : suppression de la voiture 1CCC000");
		System.out.println(e.toString());
		if(!e.retirerVoiture(new Voiture("1CCC000",""))){
			System.out.println("la voiture est presente dans l'ensembleVoitures, mais votre methode annonce ne pas l'avoir retiree");
			return;
		}
		System.out.println(e.toString());
		if(!e.toString().equals("[1AAA999(pA), 1AAA000(pA), 1BBB000(pB)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1AAA000(pA), 1BBB000(pB)]");
			return;
		}

		if(e.voitureAutorisee(new Voiture("1CCC000",""))){
			System.out.println("Attention, apres suppression, la voiture 1CCC000 est toujours autorisee !");
			return;
		}
		System.out.println("Test 5 ok");
		System.out.println();


		System.out.println("Test 6 : nouvelle suppression de la voiture 1CCC000 qui vient d'etre supprimee lors du test 5");
		System.out.println("VOUS DEVEZ COMPLETER CE TEST!");
		System.out.println();

		System.out.println("Test 7 : ajout de la voiture 1AAA000 (qui y est deja!)");
		System.out.println("VOUS DEVEZ COMPLETER CE TEST!");
		
	}

}