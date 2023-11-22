package g58137.atlg3.ascii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void testDistanceToIsTrueX(){
        Point p1 = new Point(10,0);
        Point p2 = new Point(0,0);
        double expected = 10;
        double actual = p1.distanceTo(p2);
        assertEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsTrueY(){
        Point p1 = new Point(0,5);
        Point p2 = new Point(0,0);
        double expected = 5;
        double actual = p1.distanceTo(p2);
        assertEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsTrueXY(){
        Point p1 = new Point(21,8);
        Point p2 = new Point(21,1);
        double expected = 7;
        double actual = p1.distanceTo(p2);
        assertEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsFalseY(){
        Point p1 = new Point(0,8);
        Point p2 = new Point(0,0);
        double expected = 7;
        double actual = p1.distanceTo(p2);
        assertNotEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsFalseX(){
        Point p1 = new Point(0,8);
        Point p2 = new Point(14,8);
        double expected = 15;
        double actual = p1.distanceTo(p2);
        assertNotEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsFalseXY(){
        Point p1 = new Point(0,8);
        Point p2 = new Point(1,0);
        double expected = 7;
        double actual = p1.distanceTo(p2);
        assertNotEquals(expected,actual);
    }

    @Test
    public void testDistanceToIsZero(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        double expected = 0;
        double actual = p1.distanceTo(p2);
        assertEquals(expected,actual);
    }
}