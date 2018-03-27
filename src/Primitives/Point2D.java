package Primitives;

public class Point2D {//implements Comparable<Point2D> {
    //Fields
    //ok forgot publicly inherited - protected will stay protected in the inherited class as well (c++)
    //but a private field can't be accessed from the son class - so that was use of protected private yet public for inheritance
    protected Coordinate x;
    protected Coordinate y;

    // ***************** Constructors ********************** //
    public Point2D () {                                    //empty
        x = new Coordinate();//why do we need new??
        y = new Coordinate();
    }
    public Point2D(Coordinate xIn, Coordinate yIn) {          //implement
        x = new Coordinate(xIn);
        y = new Coordinate(yIn);
    }
}
