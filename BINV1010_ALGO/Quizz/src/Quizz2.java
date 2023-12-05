public class Quizz2 {

    public static FenetreQuizz fenetreQuizz;

    public static void main(String[] args){

        // creation des 2 equipes

        Candidat[] candidatsF = new Candidat[6];
        for (int i = 0; i < candidatsF.length; i++) {
            candidatsF[i] = new Candidat("F"+(i+1));
        }
        Candidat[] candidatsM = new Candidat[6];
        for (int i = 0; i < candidatsM.length; i++) {
            candidatsM[i] = new Candidat("M"+(i+1));
        }

        Equipe equipeF = new Equipe(1, candidatsF);
        Equipe equipeM = new Equipe(2, candidatsM);

        // creation du questionnaire

        Questionnaire questionnaire = chargerQuestions();

        // creation de la fenetre de depart

        fenetreQuizz = new FenetreQuizz("Quizz - Capitales des pays de l'union européenne");
        fenetreQuizz.afficherEquipe(equipeF);
        fenetreQuizz.afficherEquipe(equipeM);

        //TODO


    }
    public static Questionnaire chargerQuestions(){

        QuestionCM[] questions = new QuestionCM[5];
        questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
        questions[1]= new QuestionCM("Autriche","Vienne","Prague", "Vilnius",1);
        questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
        questions[3]= new QuestionCM("Bulgarie"	,"Sofia","Budapest","Bucarest",1);
        questions[4]= new QuestionCM("Italie","Nicosie","Riga","Rome",3);


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

}


