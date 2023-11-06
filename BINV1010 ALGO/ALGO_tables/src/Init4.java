public class Init4 {

    public static void main(String[] args) {

        int[] t = new int[4];

        t[0] = 1;

        for (int i = 1; i < t.length; i++) {

            t[i] = t[i - 1] + 2;

        }

        System.out.println(t[3]);
    }
}
