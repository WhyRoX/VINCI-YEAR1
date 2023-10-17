
public class Membre {
	private String nom;

	private String prenom;

    private double numeroTelephone;

	private Membre parrain;

	public Membre(String nom, String prenom, double numeroTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public double getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(double numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public boolean creerParrain(Membre parrain) {
		if (this.parrain != null || this == parrain) {
			return false;
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		this.parrain = parrain;
		return true;
	}

	@Override
	public String toString() {
		if (parrain != null) {
			return "Nom: " + nom + ", Prénom: " + prenom + ", Numéro de téléphone: " + numeroTelephone +
					", Parrain: " + parrain.getPrenom() + " " + parrain.getNom();
		} else {
			return "Nom: " + nom + ", Prénom: " + prenom + ", Numéro de téléphone: " + numeroTelephone +
					", Ce membre n'a pas de parrain.";
		}
	}
}
