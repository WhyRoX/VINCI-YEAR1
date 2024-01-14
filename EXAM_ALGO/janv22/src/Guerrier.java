import java.util.Objects;

public class Guerrier {
	
	private int numero;
	private int pointsDeVie; // >= 0
	
	public Guerrier(int numero, int pointsDeVie) {
		if(numero<1||pointsDeVie<0)
			throw new IllegalArgumentException();
		this.numero = numero;
		this.pointsDeVie = pointsDeVie;
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString() {
		return "G" + numero + " ("+ pointsDeVie + "pts)";
	}

	public int getNumero() {
		return numero;
	}

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	/**
	 * retire des points de vie
	 * le nombre de points de vie est mis a 0 si le guerrier est mort
	 * @param pointsDeViePerdus le nombre de points de vie a retirer
	 * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
	 */
	public void retirerPointsDeVie(int pointsDeViePerdus){
		if(pointsDeViePerdus<0)
			throw new IllegalArgumentException();
		pointsDeVie = this.pointsDeVie-pointsDeViePerdus;
		if(pointsDeVie < 0)
			pointsDeVie = 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Guerrier guerrier = (Guerrier) o;
		return numero == guerrier.numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
}
