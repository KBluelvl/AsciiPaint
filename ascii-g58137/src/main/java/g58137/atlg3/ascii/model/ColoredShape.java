package g58137.atlg3.ascii.model;

/**
 * Represents a colored shape in the plane.
 *
 * @author Florian Essomba
 */
public abstract class ColoredShape implements Shape{
    private char color;

    /**
     * Constructs a new ColoredShape which initializes his color.
     * @param color = a given color.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Return the color.
     * @return the color.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * Sets the color.
     * @param color = a given color.
     */
    @Override
    public void setColor(char color) {
        this.color = color;
    }

}
