public class TableEntiers {

    public int[] table;

    /**
     * verifie si tous les entiers contenus dans la table sont positifs (>0)
     * @return true si tous les entiers sont positifs, false sinon
     * Remplacer les ? par les bons mots clefs
     */
    public boolean tousPositifs(){
        int i = 0;
        boolean tousPositifs = true;
        while(i < table.length && tousPositifs) {
            if(table[i] <= 0 )
                tousPositifs = false;
            i++;
        }
        return tousPositifs;
    }
    public boolean contient(int entier){

       /*
       boolean trouve = false;
       int i = 0;
       while(i < table.length && !trouve){
           if(table[i]==entier){
               trouve = true;
           }
           i++;
       }
       return trouve;
       */

        /*
        for (int i = 0; i < table.length; i++) {
            if(table[i]==entier)
                return true;
        }
        return false;
        */

        int i = 0;
        while(i < table.length && table[i]!=entier){
            i++;
        }
        if(i== table.length)
            return false;
        return true;
    }

    public TableEntiers(int[] tableARecopier) {
        table = new int[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            table[i] = tableARecopier[i];
        }
    }

}