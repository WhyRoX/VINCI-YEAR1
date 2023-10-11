public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point point = new Point(3.5, 4.2);
        System.out.println("Coordonnées du point : " + point);

        // Modif des cos
        point.setX(2.0);
        point.setY(5.7);
        System.out.println("Nouvelles coordonnées du point : " + point);
    }
}
