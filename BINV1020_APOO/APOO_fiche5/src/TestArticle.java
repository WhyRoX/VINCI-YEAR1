public class TestArticle {
    public static void main(String[] args) {
        try {
            Article article1 = new Article("REF123", "Nom1", "Description1", 50.0, 10.0);
            System.out.println("Article créé : " + article1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'article : " + e.getMessage());
        }

        try {
            Article article2 = new Article("", "Nom2", "Description2", 30.0);
            System.out.println("Article créé : " + article2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'article : " + e.getMessage());
        }

        try {
            Article article3 = new Article("REF456", "Nom3", "Description3", -10.0);
            System.out.println("Article créé : " + article3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'article : " + e.getMessage());
        }

        try {
            Article article4 = new Article("REF789", "Nom4", "Description4", 40.0, 120.0);
            System.out.println("Article créé : " + article4);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création de l'article : " + e.getMessage());
        }
    }
}
