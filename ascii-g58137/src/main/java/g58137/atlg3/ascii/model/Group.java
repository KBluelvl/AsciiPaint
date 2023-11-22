package g58137.atlg3.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Group in the plane.
 * @author Florian Essomba
 */
public class Group extends ColoredShape{
    private List<Shape> shapes;
    private List<Integer> indexes;

    /**
     * Constructs a new Group which initializes the list of shape and the color.
     * @param shapes list of Shape.
     * @param color the color of the Group.
     */
    public Group(List<Integer> indexes,List<Shape> shapes,char color){
        super(color);
        this.shapes = shapes;
        this.indexes = indexes;
    }

    /**
     * Allows you to move a Group.
     * @param dx = value x.
     * @param dy = value y.
     */
    @Override
    public void move(double dx, double dy) {
        for(Shape shape:shapes){
            shape.move(dx,dy);
        }
    }

    /**
     * Return true if the given point is inside the group and false otherwise.
     * @param p a given point.
     * @return true if the given point is inside the group and false otherwise.
     */
    @Override
    public boolean isInside(Point p) {
        for(Shape shape:shapes){
            if(shape.isInside(p)){
                return true;
            }
        }
        return false;
    }

    /**
     * return shapes(list of Shape).
     * @return a list of shape.
     */
    public List<Shape> getShapes() {
        List<Shape> copy_shapes = new ArrayList(shapes);
        return copy_shapes;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    @Override
    public String toString() {
        return "Group{" +
                "shapes=" + shapes +
                '}';
    }
}
