public class BoissonsAlcoolisees extends Boisson {

    private double degreAlcool;

    public BoissonsAlcoolisees(String nom, double prix, double contenance, double degreAlcool) {
        super(nom, prix, contenance);
        this.degreAlcool = degreAlcool;
    }

    public double getDegreAlcool() {
        return degreAlcool;
    }

    @Override
    public String toString() {
        return "BoissonsAlcoolisees{" +
                "degreAlcool=" + degreAlcool +
                '}';
    }
}
