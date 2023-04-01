public class TestCircle {
    public static void main(String[] args) {
        Point center = new Point(0, 0);
        Point p = new Point(0, 5);
        Circle circle = new Circle(center, p);
        System.out.println("Length of the circle: " + circle.length());
        System.out.println("Radius of the circle: " + circle.radius());
        System.out.println("Surface of the circle: " + circle.surface());
    }
}
