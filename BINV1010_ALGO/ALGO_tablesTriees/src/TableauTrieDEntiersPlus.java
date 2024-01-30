public class TableauTrieDEntiersPlus {

    private int [] t;  // table d'entiers triee par ordre croissant
    private int nombreEntiers;  // nombre d'entiers dans t
    private static final int TAILLE = 10;

    public TableauTrieDEntiersPlus(){
        t = new int[TAILLE];
        nombreEntiers = 0;
    }

    public int getNombreEntiers(){
        return nombreEntiers;
    }


    /**
     * methode qui recherche l'indice correspondant a une occurrence
     * de l'entier passe en parametre
     * si l�entier se trouve plusieurs fois, l�indice correspond a une
     * occurrence quelconque (pas necessairement la premiere)
     * @param entier l'entier recherche
     * @return indice correspondant a entier, -1 s'il n'est pas dans la table
     */
    private int trouverIndiceDicho(int entier){

        int low = 0;
        int high = nombreEntiers-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (t[mid] == entier) return mid;
            if (t[mid] > entier) high = mid-1;
            else low = mid+1;
        }
        return -1;

        //recherche dichotomique cout O(logN)

        // Pour tester cette methode, testez la methode contient() qui l'utilise

        // Si cela ne va pas, refaites la demo su site
        // https://www.infoforall.fr/art/algo/animation-de-la-recherche-dichotomique/
        // et/ou refaites le test moovin recherche dichotomique

    }



    /**
     * methode qui verifie si la table contient l'entier passe en parametre
     * @param entier l'entier recherche
     * @return boolean true si l'entier est present dans la table, false sinon
     */
    public boolean contient(int entier){
        return trouverIndiceDicho(entier)!=-1;
    }


    /**
     * methode qui supprime toutes les occurrences d'un entier
     * @param entier l'entier a supprimer
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerToutesLesOccurrences(int entier){

        int nbrSuppr;
        int nbrASuppr = 0;
        for(int i=0; i<nombreEntiers; i++) {
            if(t[i] == entier) {
                nbrASuppr++;
            }else {
                t[i-nbrASuppr] = t[i];
            }
        }
        nombreEntiers = nombreEntiers - nbrASuppr;
        nbrSuppr = nbrASuppr;
        return nbrSuppr;


        // cout O(N)

        // Si votre methode appelle la methode supprimerUneOccurrence()
        // ou si votre methode contient une instruction du style :
        // t[i-1] = t[i];
        // ou
        // t[i] = t[i+1];

        // Votre methode est en O(Ncarre) !

        // Voici 2 pistes differentes :

        // Piste 1 :
        // Reprenez la solution de la methode supprimerToutesLesOccurrences() de la classe TableauNonTrieDENtiersPlus
        // Une solution en O(N) et une video d'explications se trouvent dans le dossier solutions de la semaine tableau non trie
        // Rendez cette solution plus performante.
        // La table est triee !
        // Ex :
        // 1 1 2 3 3 3 3 7 9 9 11
        // la table a obtenir apres suppression de tous les 3 :
        // 1 1 2 7 9 9 11
        // Il est inutile de recopiez les entiers 1 1 2 sur eux-memes
        // Des qu'on depasse l'entier, il faut replacer d'office tous ceux qui suivent dans la table.
        // Le test qui se trouve dans la boucle for est donc inutile des qu'on a depasse l'entier.


        // Piste 2 :
        // Votre methode pourrait contenir une instruction du style :
        // t[i-nombreSuppressions] = t[i];
        // nombreSuppressions correspond au nombre d'occurrences de l'entier a supprimer
        // Ex :
        // 1 1 2 3 3 3 3 7 9 9 11
        // la table a obtenir apres suppression de tous les 3 :
        // 1 1 2 7 9 9 11
        // Au moment de traiter l'entier 7, on a denombre 4 x 3
        // --> l'entier 7 devra etre deplace de 4 cases avant lui

        // En fait : tous les entiers qui suivent 3 doivent etre deplaces de 4 cases avant

        // 3 phases :
        // passer tous les entiers < entier a supprimer
        // denombrer le nombre de l'occurrence de l'entier a supprimer
        // decaler tous les entiers qui suivent l'entier a supprimer

        // En java ces 3 phases peuvent s'ecrire avec 3 boucles for successives et des "break"
        // int i = 0;
        // for( ; i < nombreEntiers; i++)
        //    break;
        // for( ; i < nombreEntiers; i++)
        //    break;
        // for( ; i < nombreEntiers; i++)

    }


    /**
     * methode qui supprime tous les ex-aequos
     * (en cas d'ex-aequo, un seul entier est conserve)
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerTousLesExAequos(){

        int nombreExSupp;
        int nombreExASupp = 0;
        for(int i=1; i<nombreEntiers; i++) {
            if(t[i] == t[i-1]) {
                nombreExASupp++;
            }else {
                t[i-nombreExASupp] = t[i];
            }
        }
        nombreExSupp = nombreExASupp;
        nombreEntiers = nombreEntiers - nombreExASupp;
        return nombreExSupp;

        // cout O(N)

        // Si votre methode appelle la methode supprimerUneOccurrence()
        // ou si votre methode contient une instruction du style :
        // t[i-1] = t[i];
        // (ou t[i] = t[i+1];)
        // Votre methode est en O(Ncarre) !

        // Piste 1:
        // Reprenez la methode supprimerToutesLesOccurrences() de la classe TableauNonTrieDEntiersV2
        // on "replace" un entier s'il est different du precedent !


        // Piste 2:
        // Votre methode pourrait contenir une instruction du style :
        // t[i-nombreSuppressions] = t[i];
        // nombreSuppressions correspond au nombre d'ex-aequos rencontres avant de "traiter" t[i]
        // on "decale" un entier s'il est different du precedent !
        // Ex :
        // 1 1 1 3 3 3 3 4 7 9 9 11
        // la table a obtenir
        // 1 3 4 7 9 11
        // Au moment de traiter le premier entier 3, on a deja rencontre 2 entiers a supprimer (2 x 1)  --> l'entier 3 devra etre ramene de 2 cases avant
        // Au moment de traiter l'entier 4, on a deja rencontre 5 entiers a supprimer ( 2 x 1 et 3 x 3) --> l'entier 4 devra etre ramene de 5 cases avant
        // ...


    }

    /**
     * supprime tous les entiers compris entre borneInf et borneSup (bornes comprises)
     * precondition (a ne pas verifier) : borneInf <= borneSup
     * @param borneInf l'entier le plus petit a supprimer
     * @param borneSup l'entier le plus grand a supprimer
     * @return le nombre de suppressions effectuees
     */
    public int supprimerEntre(int borneInf, int borneSup) {

        int nbrSuppr;
        int nbrASuppr = 0;
        for(int i=0; i<nombreEntiers; i++) {
            if(t[i] >= borneInf && t[i] <= borneSup) {
                nbrASuppr++;
            }else {
                t[i-nbrASuppr] = t[i];
            }
        }
        nombreEntiers = nombreEntiers - nbrASuppr;
        nbrSuppr = nbrASuppr;
        return nbrSuppr;
    }

    public String toString(){
        if(nombreEntiers ==0)
            return "[]";
        String aRenvoyer = "["+ t[0];
        for (int i = 1; i < nombreEntiers; i++)
            aRenvoyer = aRenvoyer + ", " + this.t[i];
        return aRenvoyer+"]";
    }

    // A NE PAS MODIFIER !
    // VA SERVIR POUR LES TESTS
    public TableauTrieDEntiersPlus(int[] tableARecopier){
        if (tableARecopier.length>TAILLE)
            throw new IllegalArgumentException();
        this.nombreEntiers = tableARecopier.length;
        t = new int[TAILLE];
        if(tableARecopier.length!=0)
            t[0] = tableARecopier[0];
        for (int i = 1; i< nombreEntiers; i++){
            if(tableARecopier[i]<tableARecopier[i-1]){
                throw new IllegalArgumentException();
            }
            t[i] = tableARecopier[i];
        }
    }

}
