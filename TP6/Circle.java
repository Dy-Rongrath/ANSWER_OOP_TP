public class Circle {
    private Point center;
    private Point p;

    public Circle(Point center, Point p) {
        this.center = center;
        this.p = p;
    }

    public double length() {
        return 2 * Math.PI * center.distance(p);
    }

    public double radius() {
        return center.distance(p);
    }

    public double surface() {
        return Math.PI * Math.pow(center.distance(p), 2);
    }
}
