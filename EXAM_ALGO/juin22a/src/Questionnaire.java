
public class Questionnaire {
	
	private QuestionCM[] tableQuestions;
	private int nombreQuestionsRestantes;
	
	// A ne pas modifier, va servir pour les tests
	public Questionnaire(QuestionCM[] tableARecopier) {
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length==0)
			throw new IllegalArgumentException();
		this.tableQuestions = new QuestionCM[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			if(tableARecopier[i]==null)
				throw new IllegalArgumentException();
			this.tableQuestions[i]=tableARecopier[i];
		}
		this.nombreQuestionsRestantes = tableQuestions.length;
	}

	/**
	 * renvoie le nombre de questions restantes
	 * @return le nombre de questions restantes
	 */
	public int getNombreQuestionsRestantes() {
		return nombreQuestionsRestantes;
	}

	/**
	 * reinitialise le questionnaire
	 * toutes les questions sont remises en jeu
	 */
	public void reinitialiser(){
		this.nombreQuestionsRestantes = tableQuestions.length;
	}



	/**
	 * renvoie une question au hasard, parmi les questions restantes
	 * @return une question QuestionCM ou null s'il n'y a plus de question
	 */
	public QuestionCM fournirQuestion(){
		//TODO

		// Si votre methode ne fonctionne pas
		// Pour tester votre classe Buzz
		// Mettez votre code non fonctionnel en /* */ et prenez l'instruction :
		// return new QuestionCM("Belgique","Amsterdam","Bruxelles","Paris",2);
		//
		int id;
		id = nombreQuestionsRestantes;
		if (id == tableQuestions.length) {
			id = 0;
		}
		return tableQuestions[id+1];
	}

	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}

}
