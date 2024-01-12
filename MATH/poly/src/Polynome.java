public class Polynome {

    private static final int MAX_ETAPE = 1000;
    private double[] coefficients; // Coefficients du polynôme
    private int degre; // Degré du polynôme

    // Crée le polynôme x^degre
    // Lance une IllegalArgumentException si degre est négatif
    public Polynome(int degre) throws IllegalArgumentException {
        if (degre < 0) throw new IllegalArgumentException("Le degré du polynôme doit être positif");
        this.degre = degre;
        this.coefficients = new double[degre + 1];
        for (int i = 0; i < degre; i++) {
            this.coefficients[i] = 0;
        }
        this.coefficients[this.degre] = 1;
    }

    // Crée le polynôme nul
    public Polynome() {
        this.degre = 0;
        this.coefficients = new double[1];
        this.coefficients[0] = 0;
    }

    // Assigne la valeur coefficient au coefficient de degré degre du polynome
    // Lance une IllegalArgumentException si degre est négatif ou supérieur au degré du polynôme
    // Lance une IllegalArgumentException si on tente de changer le degré du polynôme
    public void setCoefficient(int degre, double coefficient) throws IllegalArgumentException {
        if (degre < 0 || degre > this.degre) throw new IllegalArgumentException("degré invalide");
        if (degre == this.degre && coefficient == 0 && this.degre != 0) {
            throw new IllegalArgumentException("Le coefficient de degré dominant ne peut pas être nul");
        }
        this.coefficients[degre] = coefficient;
    }

    // Renvoie la valeur du polynôme évalué en x
    public double evalueEn(double x) {
        double result = this.coefficients[this.degre];
        for (int i = this.degre - 1; i >= 0; i--) {
            result = result * x + this.coefficients[i];
        }
        return result;
    }

    // Renvoie la valeur du degré dominant du polynôme
    public int getDegre() {
        return degre;
    }

    // Renvoie le polynôme dérivé de this
    public Polynome polynomeDerive() {
        try {
            Polynome p = new Polynome(this.degre - 1);
            for (int i = 0; i < this.degre; i++) {
                p.coefficients[i] = (i + 1) * this.coefficients[i + 1];
            }
            return p;
        } catch (IllegalArgumentException e) {
            return new Polynome();
        }
    }

    // renvoie une description du polynôme courant, sous forme de chaine de caractères
    public String toString() {
        if (degre == 0)
            return "" + this.coefficients[0];
        String result = "" + this.coefficients[degre] + " x^" + degre;
        for (int i = degre - 1; i > 0; i--) {
            if (this.coefficients[i] < 0) {
                result += " - " + Math.abs(this.coefficients[i])  ;
                if (i!=1) {
                    result += " x^" + i;
                } else {
                    result += " x" ;
                }
            } else if (this.coefficients[i] > 0) {
                result += " + " + this.coefficients[i] ;
                if (i!=1) {
                    result += " x^" + i;
                } else {
                    result += " x" ;
                }
            }
        }
        if (this.coefficients[0] < 0) {
            result += " - " + Math.abs(this.coefficients[0]);
        } else if (this.coefficients[0] > 0) {
            result += " + " + this.coefficients[0];
        }

        return result;
    }

    // Renvoie une approximation de la racine contenue dans l'intervalle [a ; b] ou [b ; a],
    // obtenue par n intération de la méthode de la bissection
    // Lance une NumeriqueException si la présence d'une racine n'est pas garantie
    public double racineParBissectionNIterations(double a, double b, int n) throws NumeriqueException {
        // TO DO
        //1) Permutation des valeurs de a et b
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        double aEvalue = evalueEn(a);
        double bEvalue = evalueEn(b);
        //2) Vérification qu'une des bornes n'est pas la racine

        if(aEvalue == 0){
            System.out.println("A est déjà une racine");
            return a;
        }
        if(bEvalue == 0){
            System.out.println("B est déjà une racine");
            return b;
        }

        //3) Vérification de Bolzano
        if(aEvalue * bEvalue < 0){
            System.out.println("Bolzano : Il y a au moins une racine");
        }else {
            System.out.println("Bolzano : Pas vérifié");
            throw new NumeriqueException();
        }
        System.out.println(evalueEn(a));

        //4) Approximation initiale
        double moitie =(a + b)/2;
        double moitieEvalue = evalueEn(moitie);
        //5) Itération
        for (int i = 0; i < n; i++) {
            //a) Vérification que l'approximation n'est pas la racine
            if(moitieEvalue == 0){
                return moitie;
            }
            //b) Mise à jour de l'intervalle [a, b]
            if(aEvalue*moitieEvalue>0){
                a = moitie;
                aEvalue = evalueEn(a);
            }else {
                b = moitie;
            }
            //c) Calcul de la nouvelle approximation
            moitie = (a + b)/2;
            moitieEvalue = evalueEn(moitie);
        }
        //6) Renvoie de l'approximation obtenu
        return moitie;
    }

    // Renvoie une approximation à minimum d décimales exactes de la racine contenue dans
    // l'intervalle [a ; b] ou [b ; a], obtenue par la méthode de la bissection
    // Lance une NumeriqueException en cas de problème
    public double racineParBissection(double a, double b, int d) throws NumeriqueException{
        if (this.evalueEn(a)==0) return a ;  // si les racines sont en a et en b !
        if (this.evalueEn(b)==0) return b ;
        if((this.evalueEn(a)*this.evalueEn(b)) >= 0) throw new NumeriqueException("m�thode inefficace ! "); // m�thode de bolzano
        if (a>b) {   // inverser a et b si b est plus grand que a
            double inverseur = a;
            a=b;
            b=inverseur;
        }
        double milieu = (a+b)/2 ;
        double precision = (1/2.0)*Math.pow(10,-d);
        for (int i = 0; i<MAX_ETAPE; i++) {
            // a et b modifiables
            if (this.evalueEn(milieu)==0) return milieu ;
            if(((b-a)/2) < precision) {
                return milieu;
            }
            if((evalueEn(a)*evalueEn(milieu) <0)) { //sont de signe contraire
                b = milieu;
            } else {
                a = milieu;
            }
            milieu = (a+b)/2;
        }
        throw new NumeriqueException("m�thode inefficace ! ");
    }

    // Renvoie une approximation de la racine contenue dans l'intervalle [a ; b] ou [b ; a],
    // obtenue après n itération de la méthode de Newton
    // Lance une NumeriqueException si la présence d'une et une seule racine n'est pas garantie
    public double racineParNewtonNIterations(double a, double b, int n) throws NumeriqueException {
        // TO DO
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }

        double fA = evalueEn(a);
        double fB = evalueEn(b);
        if (fA == 0) {
            return a;
        }
        if (fB == 0) {
            return b;
        }

        if (fA * fB >= 0) {
            throw new NumeriqueException();
        }

        // 3) Vérification des hypothèses supplémentaires (f' et f'' de même signe en a et b)
        Polynome derive = polynomeDerive();
        Polynome deriveDeDerive = derive.polynomeDerive();
        // ou deriveSeconde
        double fPrimeA = derive.evalueEn(a);
        double fPrimeB = derive.evalueEn(b);
        double fPrimePrimeA = deriveDeDerive.evalueEn(a);
        double fPrimePrimeB = deriveDeDerive.evalueEn(b);

        if (fPrimeA * fPrimeB <= 0) throw new NumeriqueException();
        if (fPrimePrimeA * fPrimePrimeB <= 0) throw new NumeriqueException();

        double racine;
        //4) Approximation initiale
        if (fA * fPrimePrimeA > 0) {
            racine = a;
        } else {
            racine = b;
        }

        //5) Itération
        for (int i = 1; i <= n; i++) {
            //a) Calcul de la nouvelle approximation
            racine = racine - evalueEn(racine) / derive.evalueEn(racine);
            //b) Vérification que la nouvelle approximation n'est pas la racine
            if (evalueEn(racine) == 0) return racine;
        }
        //6) Renvoie de la racine
        return racine;
    }

    // Renvoie une approximation à minimum d décimales exactes de la racine contenue dans
    // l'intervalle [a ; b] ou [b ; a], obtenue par la méthode de Newton
    // Lance une NumeriqueException en cas de problème
    public double racineParNewton(double a,double b, int decimales)
            throws NumeriqueException{

        double x = 0, fx;
        double fa = this.evalueEn(a);
        double fb = this.evalueEn(b);

        if(fa==0)
            return a;
        if(fb==0)
            return b;
        Polynome derivee = this.polynomeDerive();
        Polynome deriveeSeconde = derivee.polynomeDerive();
        double borneDerivee;
        if(evalueEn(a)*deriveeSeconde.evalueEn(a)>0) {
            borneDerivee = derivee.evalueEn(b);
        }else{
            borneDerivee = derivee.evalueEn(a);
        }

        for (int etape = 0; etape < MAX_ETAPE; etape++) {
            fx = evalueEn(x);
            if(fx == 0)
                return x;
            if((int)
                    Math.floor(Math.log10(0.5/Math.abs(fx/borneDerivee)))<decimales)
                return x;
        }
        throw new NumeriqueException("La méthode a échoué");
    }

}