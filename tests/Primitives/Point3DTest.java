package Primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    Point3D pt = new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(1.0));
    Vector v = new Vector(new Point3D(0.0,2,4));

    @Test
    void compareToTest() {
        assertTrue(true);//this test should show true
        //it means assert the following is true and then inside we put true (it has nothing to do with the code..)
    }
    @Test
    void addVectorPointTest()
    {
        pt.add(v);
        System.out.println(pt.toString());
    }
}