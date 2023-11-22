package g58137.atlg3.ascii.model;

/**
 * Represents a rectangle in the plane.
 * @author Florian Essomba
 */
public class Rectangle extends ColoredShape{
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructs a new Rectangle which initializes the upperLeft, width, height and color attributes.
     * @param upperLeft = the point on the top corner left of the rectangle.
     * @param width = the width of the rectangle.
     * @param height = the height of the rectangle.
     * @param color = the color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, char color){
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Return true if the given point is inside the form and false otherwise.
     * @param p = a given point.
     */
    @Override
    public boolean isInside(Point p) {
        double x1 = upperLeft.getX();
        double y1 = upperLeft.getY();
        // downRight
        double x2 = x1 + width;
        double y2 = y1 - height;

        return p.getX() >= x1 && p.getX() <= x2 &&
                p.getY() <= y1 && p.getY() >= y2;
    }

    /**
     * Allows you to move a Rectangle.
     * @param dx = value x.
     * @param dy = value y.
     */
    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    /**
     * return the upperLeft.
     * @return the upperLeft.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * return width.
     * @return width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * return height.
     * @return height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Convert to string.
     * @return a string.
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "upperLeft=" + upperLeft +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
