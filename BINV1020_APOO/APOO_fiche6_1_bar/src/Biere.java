public class Biere extends BoissonsAlcoolisees{

    private boolean sousPression;

    public Biere(String nom, double prix, double contenance, double degreAlcool, boolean sousPression) {
        super(nom, prix, contenance, degreAlcool);
        this.sousPression = sousPression;
    }

    public boolean isSousPression() {
        return sousPression;
    }

    @Override
    public String toString() {
        return "Biere{" +
                "sousPression=" + sousPression +
                '}';
    }
}
