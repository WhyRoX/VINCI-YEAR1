public class DuelGuerriers {

	public static void main(String[] args) {

		int pointsDeVieCogneDur = lancerDe();
		System.out.println("CogneDur a "+pointsDeVieCogneDur+" points de vie");

		// A COMPLETER


	}


	public static int lancerDe(){
		return (int)((Math.random() * 6) + 1);
	}
}
