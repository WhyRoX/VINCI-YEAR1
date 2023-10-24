public class LigneDeCommande {
    private Article article;
    private int quantite;

    public LigneDeCommande(Article article) {
        this.article = article;
        this.quantite = 0;
    }

    public LigneDeCommande(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double calculerPrixTotal(){
        return article.calculerPrixTVAComprise()*quantite;
    }
    public String toString(){
        return quantite + " x " + article.toString();
    }
}
