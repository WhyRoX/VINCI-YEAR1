/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Serie extends ContenuVideo{
    private int nombreEpisodes;

    public Serie(String titre, String categorie, int nombreEpisodes) {
        super(titre, categorie);
        setNombreEpisodes(nombreEpisodes);
    }

    public void setNombreEpisodes(int nombreEpisodes) {
        if (nombreEpisodes <= 0) throw new IllegalArgumentException("Le nombre d'épisodes ne peut pas être négatif");
        this.nombreEpisodes = nombreEpisodes;
    }

    @Override
    public String toString() {
        return "Serie [" +super.toString() + ", nombre d'épisodes=" + nombreEpisodes+"]";
    }

}
