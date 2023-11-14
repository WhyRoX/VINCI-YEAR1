import java.util.Objects;

public class Livre {
	private String isbn;
	private String nom;
	private String prenom;
	private String titre;
	private int nbPages;
	private double prixConseille;
	private int anneeEdition ;

	public Livre(String isbn, String nom, String prenom, String titre,
			int nbPages, double prixConseille, int anneeEdition) {
		this(isbn,nom,titre,nbPages,prixConseille,anneeEdition);
		this.prenom = prenom;
	}
	
	public Livre(String isbn, String nom, String titre,
			int nbPages, double prixConseille, int anneeEdition) {
		this.isbn = isbn;
		this.nom = nom;
		this.titre = titre;
		this.nbPages = nbPages;
		this.setPrixConseille(prixConseille);
		this.anneeEdition = anneeEdition;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitre() {
		return titre;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getNbPages() {
		return nbPages;
	}

	public double getPrixConseille() {
		return prixConseille;
	}
	

	public int getAnneeEdition() {
		return anneeEdition;
	}

	public void setPrixConseille(double prixConseille)  {
		this.prixConseille = prixConseille;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Livre livre = (Livre) o;
		return nbPages == livre.nbPages && Double.compare(prixConseille, livre.prixConseille) == 0 && anneeEdition == livre.anneeEdition && Objects.equals(isbn, livre.isbn) && Objects.equals(nom, livre.nom) && Objects.equals(prenom, livre.prenom) && Objects.equals(titre, livre.titre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, nom, prenom, titre, nbPages, prixConseille, anneeEdition);
	}

	public String toString(){
		return titre +  " de " + nom + " " + prenom;
	}
	
}
