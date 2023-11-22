package g58137.atlg3.ascii.model;

import  java.lang.Math;

/**
 * Represents a point in the plane.
 * @author Florian Essomba
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructs a new Point which initializes his position x and y.
     * @param x = the position x.
     * @param y = the position y.
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new Point which takes a Point in parameter
     * and initializes his position x and y.
     * @param p = a given Point.
     */
    public Point(Point p){
        this(p.x, p.y);
    }

    /**
     * Allows you to move a Point.
     * @param dx = value x.
     * @param dy = value y.
     */
    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }

    /**
     * Returns the distance from this Point to another.
     * @param other = a given Point.
     * @return the distance from this Point to another.
     */
    public double distanceTo(Point other){
        return Math.sqrt(Math.pow(this.x - other.x, 2)
                + Math.pow(this.y - other.y, 2));
    }

    /**
     * Returns the X coordinate of this Point.
     * @return the X coordinate of this Point.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the Y coordinate of this Point.
     * @return the Y coordinate of this Point.
     */
    public double getY() {
        return y;
    }

    /**
     * Convert to string.
     * @return a string.
     */
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
