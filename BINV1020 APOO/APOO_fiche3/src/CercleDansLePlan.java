
public class CercleDansLePlan {
	private double rayon;
	private Point centre;
	
	public CercleDansLePlan(double rayon, Point centre) {
		this.rayon = rayon;
		this.centre = centre;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) { this.centre = centre; }
	
	public String toString() {
		return "Cercle de rayon : " + rayon + " de centre " + centre;
	}
	// Ajoutez dans la classe CercleDansLePlan deux constructeurs. Le premier prend en
	//paramètre uniquement le centre et crée un cercle de rayon 1 ayant ce centre. Le deuxième
	//ne prend rien en paramètre et crée un cercle de rayon 1 centré au point (0,0). Il faut que ces
	//constructeurs invoquent un autre constructeur.

}
