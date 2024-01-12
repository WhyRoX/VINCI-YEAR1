import java.util.ArrayList;

/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class PortfolioEtudiant {
    private String emailEtudiant;
    private ArrayList<Element> elements = new ArrayList<>();
    private int nombreOperationDAjout = 0;

    public PortfolioEtudiant(String emailEtudiant) {
        if (emailEtudiant == null || emailEtudiant.isEmpty()) throw new IllegalArgumentException("pAs bgood");
        this.emailEtudiant = emailEtudiant;
    }
    public boolean ajouter(Element element) {
        if (!elements.contains(element)) {
            ++nombreOperationDAjout;
            element.attribuerIdDansPortfolio(nombreOperationDAjout);
            elements.add(element);
            return true;
        }
        return false;
    }
    public boolean supprimer(Element element) {
        return elements.remove(element);
    }
    public boolean estComplet(){
        int points=0;
        for (Element el : elements) {
            points+=el.getPoints();
        }

        return points>=3;
    }
    public int fournirNbrElements(){
        return elements.size();
    }
    @Override
    public String toString() {
        return "PortfolioEtudiant{" +
                "emailEtudiant='" + emailEtudiant + '\'' +
                ", elements=" + elements +
                ", nombreOperationDAjout=" + nombreOperationDAjout +
                '}';
    }
}
