import java.util.Objects;

/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public abstract class ContenuVideo {
    private int id;
    private String titre;
    private String categorie;
    private static int idSuivant = 1;
    public static final String[] CATEGORIES_POSSIBLES = {"action", "science-fiction", "drame",
            "comédie", "horreur", "thriller", "documentaire", "animation"};

    public ContenuVideo(String titre, String categorie) {
        setTitre(titre);
        setCategorie(categorie);
        this.id = idSuivant++;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        if (titre == null) throw new IllegalArgumentException("Titre ne peut pas être nul");
        if (titre.isEmpty()) throw new IllegalArgumentException("Titre ne peut pas être vide");
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        if (categorie == null) throw new IllegalArgumentException("Catégorie null non autorisée");
        for (String categoriePossible : CATEGORIES_POSSIBLES) {
            if (categoriePossible.equals(categorie)){
                this.categorie = categorie;
                return;
            }
        }
        throw new IllegalArgumentException("catégorie inexistante");
    }

    @Override
    public String toString() {
        return "id=" + id +", titre=" + titre + ",catégorie=" + categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContenuVideo that = (ContenuVideo) o;
        return id == that.id && Objects.equals(titre, that.titre) && Objects.equals(categorie, that.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, categorie);
    }
}
