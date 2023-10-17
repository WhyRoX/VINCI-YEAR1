public class Dessins {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		int choix;
		do{
			afficherMenu();
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: carre();
					break;
				case 2: triangleVersion1();
					break;
				case 3: triangleVersion2();
					break;
				case 4: triangleVersion3();
					break;
				case 5: pyramide();
					break;

				// A COMPLETER
			}
			System.out.println();
		}
		while(choix>=1 && choix<=7);
	}

	private static void afficherMenu(){
		System.out.println("*********");
		System.out.println("Dessins :");
		System.out.println("*********");
		System.out.println("1 -> carre");
		System.out.println("2 -> triangle version 1");
		System.out.println("3 -> triangle version 2");
		System.out.println("4 -> triangle version 3");
		System.out.println("5 -> pyramide");
		System.out.println("6 -> losange");
		System.out.println("autre -> quitter");
	}

	private static void carre() {
		System.out.print("\nEntrez n : ");
		int n=scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}

	private static void triangleVersion1() {
		System.out.print("\nEntrez n : ");
		int n=scanner.nextInt();
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}

	private static void triangleVersion2() {
		System.out.print("\nEntrez n : ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	private static void triangleVersion3() {
		System.out.print("\nEntrez n : ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - i; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	private static void pyramide() {
		System.out.print("\nEntrez n : ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}





}
