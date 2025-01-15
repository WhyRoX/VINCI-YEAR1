/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Film extends ContenuVideo{

    private int duree;
    private long recettes;

    public Film(String titre, String categorie, int duree, long recettes) {
        super(titre, categorie);
        setDuree(duree);
        setRecettes(recettes);
    }

    public Film(String titre, String categorie, int duree) {
        super(titre, categorie);
        setDuree(duree);
    }

    public void setDuree(int duree) {
        if (duree <= 0) throw new IllegalArgumentException("La durée ne peut pas être négatif");
        this.duree = duree;
    }

    public void setRecettes(long recettes) {
        if (recettes < 0) throw new IllegalArgumentException("Les recettes ne peuvent être négatif");
        this.recettes = recettes;
    }
    @Override
    public String toString() {
        return "Film [" + super.toString() +", duree=" + duree + ", recettes=" + recettes+"]";
    }
}
