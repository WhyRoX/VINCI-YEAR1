import java.util.Arrays;

public class StatistiquesTemperatures {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		
		chargerTemperatures();
		System.out.println(temperatures.toString());
		
		System.out.println("*****************************");
		System.out.println("Temperatures : statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");	
			System.out.println("2 -> calculer la moyenne");
			System.out.println("3 -> calculer la temperature minimale");
			System.out.println("4 -> calculer la temperature maximale");
			System.out.println("5 -> calculer le nombre de jours de gel");
			System.out.println("6 -> afficher les jours de gel");
			System.out.println("7 -> afficher les jours de temperature minimale");
			System.out.println();
			System.out.print("Entrez votre choix : ");	
			choix=scanner.nextInt();
			switch(choix){	
			case 1: afficherTout();   
			break;
			case 2: afficherMoyenne();   
			break;
			case 3: afficherTemperatureMin();
			break;
			case 4: afficherTemperatureMax();
			break;
			case 5: afficherNombreJoursDeGel();
			break;
			case 6: afficherJoursDeGel();
			break;
			case 7: afficherJoursTempMin();
			break;
			}
		}while(choix >=1 && choix<=6);
	}
	
	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		System.out.println("La moyenne des temperatures est : " + temperatures.moyenne());
	}
	private static void	afficherTemperatureMin(){
		System.out.println("La temperature minimale est : " + temperatures.temperatureMin());
	}
	private static void	afficherTemperatureMax(){
		System.out.println("La temperature maximale est : " + temperatures.temperatureMax());
	}
	private static void afficherNombreJoursDeGel(){
		System.out.println("Le nombre de jours de gel est : " + temperatures.nombreJoursDeGel());
	}
	private static void afficherJoursDeGel(){
		System.out.println("Les jours de gel sont : " + Arrays.toString(temperatures.joursDeGel()));
	}
	private static void	afficherJoursTempMin(){
		afficherTable(temperatures.joursMin());
	}


	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
