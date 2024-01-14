import java.util.Arrays;
import java.util.Scanner;

public class JeuGuerrier {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de guerriers : ");
		int nombreGuerriers = scanner.nextInt();
		System.out.print("Entrez le nombre de points de vie de chaque guerrier : ");
		int pointsDeVieGuerrier = scanner.nextInt();
		EquipeGuerriers equipe = new EquipeGuerriers(nombreGuerriers, pointsDeVieGuerrier);
		System.out.print("Entrez le nombre de points de vie du dragon : ");
		int pointsDeVieDragon = scanner.nextInt();
		
		int attaque;
		int next;
		int vieRestant;

		System.out.println();

		while (pointsDeVieDragon > 0 && equipe.nombreGuerriersEnVie() > 0) {
			System.out.println("Voici les guerriers en vie : ");
			System.out.println(Arrays.toString(equipe.tableGuerriersEnVie()));

			next = equipe.donnerNumeroProchainGuerrier();

			System.out.println("Le guerrier " + equipe.donnerNumeroProchainGuerrier() + " est selectionne pour le combat");
			System.out.println("Le guerrier frappe le dragon");

			attaque = lancerDe();
			pointsDeVieDragon -= attaque;
			System.out.println("Le dragon vient de perdre " + attaque +  " point(s) de vie");
			if (pointsDeVieDragon <= 0){
				break;
			}
			System.out.println("Il lui reste" + pointsDeVieDragon +  "point(s) de vie");
			System.out.println("Le dragon riposte");

			attaque = lancerDe();
			vieRestant = equipe.recevoirDegats(attaque);
			System.out.println("Le guerrier" + next +  "vient de perdre " + attaque + "point(s) de vie");
			if (vieRestant > 0){
				System.out.println("Il lui reste" + vieRestant + "point(s) de vie");
			}
			else System.out.println("Le guerrier " + next + "est mort");
		}
		if (pointsDeVieDragon<=0){
			System.out.println("Le dragon est mort");
			System.out.println("Toutes nos pensees vont au(x) guerrier(s) mort(s) :"+ Arrays.toString(equipe.tableGuerriersMorts()));
		}
		else {
			System.out.println("Tous les guerriers sont morts");
			System.out.println("Toutes nos pensees vont au(x) guerrier(s) mort(s) :"+ Arrays.toString(equipe.tableGuerriersMorts()));
		}
		/*
		System.out.println("Voici les guerriers en vie :");
		System.out.println("Voici les guerriers morts :");
		System.out.println("Le guerrier est selectionne pour le combat");
		System.out.println("Le guerrier frappe le dragon");
		System.out.println("Le dragon riposte");
		System.out.println("Le guerrier vient de perdre point(s) de vie");
		System.out.println("Le dragon vient de perdre point(s) de vie");
		System.out.println("Il lui reste point(s) de vie");
		System.out.println("Le guerrier est mort");
		System.out.println("Le dragon est mort");
		System.out.println("Tous les guerriers sont morts");
		System.out.println("Toutes nos pensees vont au(x) guerrier(s) mort(s) :");
		*/
	}

	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}

	public static void afficherTableGuerriers(Guerrier[] table){
		if(table==null)
			System.out.println("null");
		else
			for (int i = 0; i < table.length; i++) {
				System.out.println(table[i]);
			}
	}
}
