public class Cercle {
    double rayon;
    Cercle(double nouveauRayon){
        rayon = nouveauRayon;
    }
    double calculerAire(){
        return rayon * rayon * Math.PI;
    }
    public String toString(){
        return "cercle de rayon " + rayon;
    }
}
