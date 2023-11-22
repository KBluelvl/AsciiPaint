package g58137.atlg3.ascii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testIsInsideFalse() {
        Point p1 = new Point(4,3);
        Line line = new Line(2,2,2,4,'t');
        boolean actual = line.isInside(p1);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    void testIsInsideTrue() {
        Point p1 = new Point(4,2);
        Line line = new Line(2,2,20,2,'l');
        boolean actual = line.isInside(p1);
        boolean expected = true;
        assertEquals(expected,actual);
    }
}