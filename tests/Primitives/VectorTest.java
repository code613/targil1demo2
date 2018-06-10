package Primitives;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    //TO DO
    @Test
    void compareToTest() {
    }

    @Test
    public void testCrossProduct(){

        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5,7,0.5);
        Vector v3 = v1.crossProduct(v2);

        //assertEquals("", 0, v3.dotProduct(v2), 1e-10);
        //assertEquals("", 0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);
        v3.add(v4);
        assertEquals(v3.length(), 1e-10);

    }
    @Test
    void crossProductTest() {
        Vector v1 = new Vector(1,0,0);
        Vector v2 =new Vector(0,0,1);
        Vector v3 =new Vector(0,-1,0);
        assertEquals(v1.crossProduct(v2),v3);
    }

    @Test
    void dotProduct() {
        Vector v1 = new Vector(3,0,0);
        Vector v2 =new Vector(5,0,1);
        Vector v3 =new Vector(0,-1,0);
        assertEquals(v1.dotProduct(v2),15);
    }

    @Test
    void set_head() {
    }

    @Test
    void get_head() {
    }

    @Test
    void add() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.add(v2);
        assertTrue(v1.compareTo(new Vector(0.0,0.0,0.0)) == 0);
    }

    @Test
    void subtract() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.subtract(v2);
        assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);

        v2.subtract(v1);
        assertTrue(v2.compareTo(new Vector(-3.0,-3.0,-3.0)) == 0);
    }
}