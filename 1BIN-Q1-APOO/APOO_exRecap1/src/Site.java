import java.util.ArrayList;

/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Site {
    private String url;
    private ArrayList<ContenuVideo> contenusVideos = new ArrayList<>();

    public Site(String url) {
        if (url == null)
            throw new IllegalArgumentException("Url ne peut être null");
        if (url.equals(""))
            throw new IllegalArgumentException("Chaîne vide non autorisée comme URL");
        this.url = url;
    }

    public boolean ajouter(ContenuVideo contenuVideo) {
        if (contenuVideo == null) throw new IllegalArgumentException("Le contenu video ne peut être nul");
        if (contenusVideos.contains(contenuVideo)) return false;
        return contenusVideos.add(contenuVideo);
    }
    public boolean effacer(ContenuVideo contenuVideo) {
        if (contenuVideo == null) throw new IllegalArgumentException("Le contenu video ne peut être nul");
        return contenusVideos.remove(contenuVideo);
    }


    @Override
    public String toString() {
        String infos = "Site[url=" +url +"]\n Liste de contenus vidéos";
        if (contenusVideos.isEmpty()) return infos += "\n  Aucun contenu vidéo";
        else {
            for (ContenuVideo contenusVideo : contenusVideos) {
                return infos += contenusVideo;
            }
        }
        return infos;
    }
}
