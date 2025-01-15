/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class TestSite {
    public static void main(String[] args) {
        //1
        try {
            ContenuVideo contenuVideo = new Film("Avengers: ENdgame","superhéros",181,279800000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //2
        Site superContent = new Site("www.supercontent.com");
        ContenuVideo endGame = new Film("Avengers: ENdgame","action",181,279800000);
        ContenuVideo bigbang = new Serie("The Big Bang Theory","comédie",279);
        ContenuVideo avengers = new Film("The Avengers","action",143);
        System.out.println(superContent);
        //3
        superContent.ajouter(endGame);
        superContent.ajouter(bigbang);
        superContent.ajouter(avengers);
        System.out.println(superContent);



    }
}
