/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Analyse {
    private PortfolioEtudiant portfolio;
    private String resultat;
    private String interviewer;
    private static final String RESULTAT_NC="Portfolio non complet";
    private static final String RESULTAT_A_INTERVIEWER="A interviewer";
    private static final String RESULTAT_INTERESSE="interessé";
    private static final String RESULTAT_NON_INTERESSE="Non interessé";

    public Analyse(PortfolioEtudiant portfolio, String interviewer) {
        this.portfolio = portfolio;
        this.interviewer = interviewer;
    }
    public void determinerCompletudePortfolio(){
        if(!portfolio.estComplet())
            this.resultat=RESULTAT_NC;
        else
            this.resultat= RESULTAT_A_INTERVIEWER;
    }
    public void terminerAnalyseAvecInternet(){
        if(!this.resultat.equals(RESULTAT_A_INTERVIEWER))
            throw new IllegalStateException("Impossible de terminer l’analyse si l’étudiant n’a pas été interviewé");
        else this.resultat=RESULTAT_INTERESSE;
    }
    public void terminerAnalyseSansInternet(){
        if(this.resultat.equals( RESULTAT_A_INTERVIEWER) || this.resultat.equals( RESULTAT_NC))
            this.resultat=RESULTAT_NON_INTERESSE;
        else throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "Analyse par " + interviewer + " du portfolio \n"+ portfolio+ "\nRésultat actuel de l'analyse : "+ resultat;
    }
}
