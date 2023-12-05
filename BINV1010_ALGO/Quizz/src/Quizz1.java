
public class Quizz1 {

	public static FenetreQuizz fenetreQuizz;
	
	public static void main(String[] args){
		
		// creation de  l'equipe
		
		Candidat[] candidats = new Candidat[6];
		for (int i = 0; i < candidats.length; i++) {
			candidats[i] = new Candidat("nom"+(i+1));
		}
		Equipe equipe = new Equipe(1, candidats);


		// creation du questionnaire
		
		Questionnaire questionnaire = chargerQuestions();


		// creation de la fenetre de depart
		
		fenetreQuizz = new FenetreQuizz("Quizz - Capitales des pays de l'union europeenne");
		fenetreQuizz.afficherEquipe(equipe);

		quizzLoop(equipe, questionnaire);

	}

	public static Questionnaire chargerQuestions(){

		QuestionCM[] questions = new QuestionCM[5];
		questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
		questions[1]= new QuestionCM("Autriche","Vienne","Prague", "Vilnius",1);
		questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
		questions[3]= new QuestionCM("Bulgarie"	,"Sofia","Budapest","Bucarest",1);
		questions[4]= new QuestionCM("Italie",	"Nicosie","Riga","Rome",3);
		

//		Croatie		Zagreb
//		Danemark	Copenhague
//		Espagne		Madrid
//		Estonie		Tallinn
//		Finlande	Helsinki
//		France		Paris
//		Grece		Athenes
//		Hongrie		Budapest
//		Irlande		Dublin
//		Italie		Rome
//		Lettonie	Riga
//		Lituanie	Vilnius
//		Luxembourg	Luxembourg
//		Malte		La Valette
//		Pays-Bas	Amsterdam
//		Pologne		Varsovie
//		Portugal	Lisbonne
//		Republiquetcheque	Prague
//		Roumanie	Bucarest
//		Royaume-Uni	Londres
//		Slovaquie	Bratislava
//		Slovenie	Ljubljana
//		Suede		Stockholm

		return new Questionnaire(questions);
		
	}
	public static void quizzLoop(Equipe equipe, Questionnaire questionnaire) {
		while (true) {
			QuestionCM question = questionnaire.fournirQuestion();
			fenetreQuizz.afficherQuestion(question);
			int choix = fenetreQuizz.cliquerChoix();

			if (choix == question.getNumeroChoixCorrect()) {
				fenetreQuizz.afficherPouceOK();
				passerAuSuivant(equipe);
			} else {
				fenetreQuizz.afficherPouceKO();
				traiterMauvaiseReponse(equipe);
			}
		}
	}
	private static void passerAuSuivant(Equipe equipe) {
		fenetreQuizz.cliquerSuivant();
		equipe.selectionnerCandidat();
		fenetreQuizz.afficherEquipe(equipe);
	}

	private static void traiterMauvaiseReponse(Equipe equipe) {
		if (equipe.getNombreCandidats() > 1) {
			// Si plus d'un candidat est encore en jeu, éliminer le candidat et afficher l'équipe
			equipe.selectionnerCandidat();
			fenetreQuizz.afficherEquipe(equipe);
			passerAuSuivant(equipe);
		} else {
			// S'il ne reste qu'un candidat, le jeu s'arrête
			fenetreQuizz.afficherInformation("Fin du jeu. Un seul candidat reste.");
			System.exit(0);
		}
	}

}
