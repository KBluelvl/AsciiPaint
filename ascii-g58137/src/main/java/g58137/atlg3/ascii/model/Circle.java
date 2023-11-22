package g58137.atlg3.ascii.model;

/**
 * Represents a circle in the plane.
 * @author Florian Essomba
 */
public class Circle extends ColoredShape {
    private Point center;
    private double radius;

    /**
     * Constructs a new Circle which initializes the center and radius attributes and the color.
     * @param center = the Point in the center of the Circle.
     * @param radius = the radius of the Circle.
     * @param color = the Color of the Circle.
     */
    public Circle(Point center, double radius, char color){
        super(color);
        if(radius < 0){
            throw new IllegalArgumentException("The radius can't be negative :"+radius);
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * Return true if the given point is inside the form and false otherwise.
     * @param p = a given point.
     */
    @Override
    public boolean isInside(Point p) {
        return p.distanceTo(center) < radius;
    }

    /**
     * Allows you to move a Circle.
     * @param dx = value x.
     * @param dy = value y.
     */
    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * Convert to string.
     * @return a string.
     */
    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
