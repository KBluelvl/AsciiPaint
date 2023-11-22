package g58137.atlg3.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a drawing in the plane.
 * @author Florian Essomba
 */
public class Drawing {
    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Constructs a new Drawing which initializes his width and height
     * at a predefined value.
     */
    public Drawing(){
        this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    /**
     * Constructs a new Drawing which initializes his width and height.
     * @param width = the width of the Drawing.
     * @param height = the height of the Drawing.
     */
    public Drawing(int width, int height){
        this.width = width;
        this.height = height;
        shapes = new ArrayList<>();
    }

    /**
     * Add a Shape to the Shapes attribute.
     * @param shape = a given Shape.
     */
    void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * Add a shape at a given position.
     * @param shape
     * @param index
     */
    void addShapeAt(Shape shape, int index){
        shapes.add(index-1, shape);
    }

    /**
     * return the shape who is at a given point if there is none return null.
     * @param p = a given point.
     * @return the shape who is at a given point if there is none return null.
     */
    public Shape getShapeAt(Point p) {
        for (int i = shapes.size() - 1; i >= 0; i--) { // LIFO, take the last in first
            if (shapes.get(i).isInside(p)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    /**
     * remove a shape.
     * @param shape a given shape.
     */
    void remove(Shape shape){
        shapes.remove(shape);
    }

    /**
     * Return the shape of a given index.
     * @param index a given index.
     * @return
     */
    public Shape getShapeAt(int index){
        return shapes.get(index-1);
    } // pq -1 ?
    /**
     * return the height.
     * @return the height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * return the width.
     * @return the width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * return the shapes(list of shape).
     * @return shapes.
     */
    public List<Shape> getShapes() {
        return shapes;
    } // bof.
}
