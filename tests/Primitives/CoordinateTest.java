package Primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate coord1 = new Coordinate(0.0098);
    Coordinate coord2 = new Coordinate(0.001);
    @Test
    void getCoordinateTest() {
        double result = coord1.getCoordinate();
        assertEquals(0.00987,coord1.getCoordinate(),0.0009);
        System.out.println("result is " + result);
    }

     @Test
    void compareToTest() {
    }
}

//ok below i will put my standers commnets to start off a new class



//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

//********************Fields*****************//

// ***************** Constructors ********************** //

// ***************** Getters/Setters ********************** //

// ***************** Implementations   ******************** //

// ***************** Operations ******************** //

//}