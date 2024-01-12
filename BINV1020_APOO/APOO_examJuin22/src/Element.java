/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public abstract class Element {
    private String titre;
    private int idDansPortfolio;
    private int points;

    public Element(String titre, int points) {
        this.titre = titre;
        this.points = points;
    }

    public boolean attribuerIdDansPortfolio(int id) {
        if (this.idDansPortfolio==0) {
            this.idDansPortfolio = id;
            return true;
        }
        return false;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Element{" +
                "titre='" + titre + '\'' +
                ", idDansPortfolio=" + idDansPortfolio +
                ", points=" + points +
                '}';
    }
}
