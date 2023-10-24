import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
public class Commande {
	private ArrayList<Article> articles;
	private LocalDate date;
	
	public Commande(){
		date = LocalDate.now();
		articles = new ArrayList<Article>();
	}
	public void ajouter(Article article){
		articles.add(article);
	}
	public double calculerPrixTotal(){
		double prixTotal = 0;
		for(Article article : articles){
			prixTotal += article.calculerPrixTVAComprise();
		}
		return prixTotal;
	}

	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String infosCommande = date.format(formatter)+" \n";
		infosCommande += "Liste des articles : \n";
		for (Article article : articles) {
			infosCommande += article.toString() + "\n";
		}
		infosCommande += "Prix total : " + calculerPrixTotal() + "\n";
		return infosCommande;
	}
}
