public class TableDEntiers {

    public int[] table;

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


    public TableDEntiers(int[] tableARecopier) {
        table = new int[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            table[i] = tableARecopier[i];
        }
    }

}
