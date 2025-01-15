public class Init3 {

    public static void main(String[] args) {

        int[] t = new int[4];

        for (int i = 1; i < t.length; i++) {

            t[i] = (i - 1) + 2;

        }

        System.out.println(t[3]);
    }
}
