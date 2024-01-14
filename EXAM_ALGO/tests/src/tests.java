import java.util.NoSuchElementException;

/**
 * @author Coded by Enes Yumer
 * @Date 14-01-24
 */
public class tests {
    private static int[] table;
    private static int nbEntiers;
    public int[] troisPlusPetitsEntiers(){
        if (nbEntiers<3)
            throw new NoSuchElementException();
        int[] tableTemp = new int[table.length];
        for (int i = 0; i < nbEntiers; i++) {
            tableTemp[i]=table[i];
        }
        int[] table3PPetits = new int[3];
        int min;
        int index=0;
        for (int i = 0; i < 3; i++) {
            min=Integer.MAX_VALUE;
            for (int j = 0; j < nbEntiers; j++) {
                if (tableTemp[j] < min) {
                    min = tableTemp[j];
                    index=j;
                }
            }
            table3PPetits[i]=min;
            tableTemp[index]=Integer.MAX_VALUE;
        }
        return table3PPetits;
    }

    public static void main(String[] args) {
        for (int x = 1; x <= 9; x++) {
            if(x<=2)
                System.out.print('v');
            else
            if(x>=9)
                System.out.print('j');
            else
            if(x<=4)
                System.out.print('r');
            else
                System.out.print('b');
        }
        System.out.println();
        System.out.println();
        for (char c = 'A'; c <= 'C' ; c++) {
            for (int j = 1; j <= 4 ; j++) {
                System.out.print(j);
            }
            System.out.print(c);
        }
        System.out.println();
        System.out.println();




    }
}
