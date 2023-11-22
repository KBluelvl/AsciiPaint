package g58137.atlg3.ascii.model;

/**
 * Represents a shape in the plane.
 * @author Florian Essomba
 */
public interface Shape {

    /**
     * Allows you to move a shape
     * @param dx = value x.
     * @param dy = value y.
     */
    void move(double dx, double dy);

    /**
     * Return true if the given point is inside the form and false otherwise.
     * @param p = a given point.
     */
    boolean isInside(Point p);

    /**
     * Return the color.
     * @return the color.
     */
    char getColor();

    /**
     * Sets the color.
     */
    void setColor(char color);
}
