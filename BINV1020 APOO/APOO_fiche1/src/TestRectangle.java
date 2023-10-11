public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 =  new Rectangle(5, 3);
        Rectangle rectangle2 = new Rectangle(10,6);
        Rectangle rectangle3 = new Rectangle(8,2);
        System.out.println("Aire du rectangle 1 : " + rectangle1.calculerAire() + "cm2");
        System.out.println("Perimetre du rectangle 2 : " + rectangle2.calculerPerimetre() + "cm");
        System.out.println(rectangle3);
    }
}
