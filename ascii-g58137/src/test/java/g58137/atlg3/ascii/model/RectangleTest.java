package g58137.atlg3.ascii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    public void testIsInsideTrue(){
        Point p1 = new Point(0,0);
        Rectangle rectangle = new Rectangle(new Point(0,4),5,4,'r');
        boolean actual = rectangle.isInside(p1);
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @Test
    public void testIsInsideFalse(){
        Point p1 = new Point(0,5);
        Rectangle rectangle = new Rectangle(new Point(0,4),5,4,'r');
        boolean actual = rectangle.isInside(p1);
        boolean expected = false;
        assertEquals(expected,actual);
    }
    @Test
    public void testIsInsideInupperLeft(){
        Point p1 = new Point(0,4);
        Rectangle rectangle = new Rectangle(new Point(0,4),5,4,'r');
        boolean actual = rectangle.isInside(p1);
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void testIsInsideFalseNegatif(){
        Point p1 = new Point(-1,4);
        Rectangle rectangle = new Rectangle(new Point(0,4),5,4,'r');
        boolean actual = rectangle.isInside(p1);
        boolean expected = false;
        assertEquals(expected,actual);
    }
}