public class LettresLues {

    private boolean[] tableLettresLues;

    //table de 26 booleens, un booleen pour chaque lettre de l’alphabet.
    //Si le booleen est true, la lettre a deja ete lue, false sinon.
    //
    //Exemple
    //A	 B	 C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
    //F	 F	 F	F	T	F	F	F	T	F	F	F	F	T	F	F	F	T	F	F	F	F	F	F	F	F
    //Les lettres deja lues  E I N R
    //
    //code unicode de ‘A' --> 65, code unicode de ‘B’ --> 66, …)

    public LettresLues() {
        this.tableLettresLues = new boolean[26];
    }

    public LettresLues(boolean[] tableLettresLues){
        this.tableLettresLues= tableLettresLues;
    }




    /**
     * ajoute la lettre comme lettre lue
     * precondition (a ne pas verifier) : la lettre est une lettre majuscule de l'alphabet
     * @param lettre la lettre a ajouter
     */
    public void ajouterLettreLue(char lettre){
       tableLettresLues[lettre-'A'] = true;
    }


    /**
     * verifie si la lettre fait partie des lettres lues
     * precondition (a ne pas verifier) : la lettre est une lettre majuscule de l'alphabet
     * @param lettre la lettre verifiee
     * @return true si la lettre fait partie des lettres lues, false sinon
     */
    public boolean lettreDejaLue(char lettre){
        //pour une eventuelle amelioration
        return tableLettresLues[lettre-'A'];
    }

    /**
     * renvoie une chaine de caracteres avec les lettres lues
     * chaque lettre est separee par un espace
     * @return le mot a completer pour affichage
     */
    public String toString(){
        String aAfficher = "";
        boolean premier = true;
        for (int i = 0; i < tableLettresLues.length; i++) {
            if(tableLettresLues[i]){
                if(premier){
                    aAfficher += (char)(i+65);
                    premier = false;
                }
                else
                    aAfficher += " "+(char)(i+65);
            }
        }
        return aAfficher;
    }

}
