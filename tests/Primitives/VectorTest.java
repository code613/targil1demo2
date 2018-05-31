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
}