package g58137.atlg3.ascii.model;

/**
 * Represents a square in the plane.
 * @author Florian Essomba
 */
public class Square extends Rectangle{
    /**
     * Constructs a new Square which initializes the upperLeft, side and color with its parent constructor.
     * @param upperLeft = the point on the top corner left of the rectangle.
     * @param side = the side of the square.
     * @param color = the color of the square.
     */
    public Square(Point upperLeft, double side, char color){
        super(upperLeft, side, side ,color);
    }

    /**
     * Convert to string.
     * @return a string.
     */
    @Override
    public String toString() {
        return "Square{upperLeft="+this.getUpperLeft()+", width="+this.getWidth()+", height="+this.getHeight()+"}";
    }

}
