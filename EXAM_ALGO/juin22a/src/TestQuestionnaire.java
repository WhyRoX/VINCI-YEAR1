
public class TestQuestionnaire {

	
	public static void main(String[] args) {
		System.out.println("Le questionnaire compte 5 questions");
		System.out.println("Ce programme affiche les questions tirees au hasard");
		System.out.println("Verifiez que les 5 premieres questions sont bien differentes");
		Questionnaire questionnaire = chargerQuestions();
		for (int i = 0; i < 5; i++) {
			System.out.println(questionnaire.fournirQuestion().getQuestion());
		}
		System.out.println("Reinitialisation du questionnaire");
		questionnaire.reinitialiser();
		System.out.println("Verifiez que les questions apparaissent dans un ordre different que la premiere fois");
		for (int i = 0; i < 5; i++) {
			System.out.println(questionnaire.fournirQuestion().getQuestion());
		}
		System.out.println("Reinitialisation du questionnaire");
		questionnaire.reinitialiser();
		System.out.println("Verifiez que les questions apparaissent bien dans un ordre different que les 2 premieres fois");
		for (int i = 0; i < 5; i++) {
			System.out.println(questionnaire.fournirQuestion().getQuestion());
		}

	}
	public static Questionnaire chargerQuestions(){
		QuestionCM[] questions = new QuestionCM[5];
		questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
		questions[1]= new QuestionCM("France","Paris","Prague", "Vilnius",1);
		questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
		questions[3]= new QuestionCM("Espagne"	,"Madrid","Budapest","Bucarest",1);
		questions[4]= new QuestionCM("Italie","Nicosie","Riga","Rome",3);
		return new Questionnaire(questions);
	}
}
