/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class SiteWeb extends Element{
    private String url;
    private String technologies;
    public static final int POINTS = 1;

    public SiteWeb(String titre, int points, String url, String technologies) {
        super(titre, POINTS);
        this.url = url;
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "SiteWeb{" +
                "url='" + url + '\'' +
                ", technologies='" + technologies + '\'' +
                '}';
    }
}
