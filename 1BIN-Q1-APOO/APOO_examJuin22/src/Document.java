/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Document extends Element{
    private String contenu;
    public static final int POINTS = 1;

    public Document(String titre, int points, String contenu) {
        super(titre, POINTS);
        setContenu(contenu);
    }

    public Document(String titre) {
        super(titre, POINTS);
    }

    public void setContenu(String contenu) {
        if (contenu == null || contenu.isEmpty())
            throw new IllegalArgumentException("Contenu invalide");
        this.contenu = contenu;
    }
}
