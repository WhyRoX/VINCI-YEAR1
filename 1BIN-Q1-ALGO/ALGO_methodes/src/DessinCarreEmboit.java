public class DessinCarreEmboit {
    public static void main(String[] args) {
        Tortue t = new Tortue();
        t.accelerer();
        int pix = 150;
        for (int i = 0; i < 100; i++) {
            t.dessinerUnCarre(pix);
            pix -= 10;
        }
    }
}
