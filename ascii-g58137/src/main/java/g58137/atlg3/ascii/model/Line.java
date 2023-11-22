package g58137.atlg3.ascii.model;

/**
 * Represents a line in the plane.
 * @author Florian Essomba
 */
public class Line extends ColoredShape{
    private Point pointA;
    private Point pointB;

    /**
     * Constructs a new Line which initializes the point A and B.
     * @param pointA the point A of the Line.
     * @param pointB the point B of the Line.
     * @param color the color of the Line.
     */
    public Line(Point pointA,Point pointB,char color){
        super(color);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    /**
     * Constructs a new Line which initializes the point A and B with given position.
     * @param x1 the position x of the point A.
     * @param y1 the position y of the point A.
     * @param x2 the position x of the point B.
     * @param y2 the position y of the point B.
     * @param color the color of the Line.
     */
    public Line(double x1,double y1,double x2,double y2,char color){
        super(color);
        this.pointA = new Point(x1,y1);
        this.pointB = new Point(x2,y2);
    }

    /**
     Allows you to move a Line.
     * @param dx = value x.
     * @param dy = value y.
     */
    @Override
    public void move(double dx, double dy) {
        this.pointA.move(dx,dy);
        this.pointB.move(dx,dy);
    }

    /**
     * Return true if the given point is inside the form and false otherwise.
     * @param p = a given point.
     */
    @Override
    public boolean isInside(Point p) {
        double m =  (pointB.getY() - pointA.getY())/(pointB.getX()-pointA.getX());
        return p.getY()  == m*(p.getX()-pointA.getX()) + pointA.getY();
    }

    /**
     * Convert to string.
     * @return a string.
     */
    @Override
    public String toString() {
        return "Line{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
