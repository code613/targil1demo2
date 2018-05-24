package Primitives;

public class Point2D implements Comparable<Point2D> {
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
    public Point2D(Point2D point2D){                     //copy
        x = point2D.getX();//doesn't need new here becouse in the get/set there is a new
        y = point2D.getY();
    }
    // ***************** Getters/Setters ********************** //

    //properties
    public Coordinate getX() { return new Coordinate(x); }
    public Coordinate getY() { return new Coordinate(y); }

    public void setX(Coordinate _x) { x = new Coordinate(x);	}
    public void setY(Coordinate _y) { y = new Coordinate(y);	}

    // ***************** Administration  ******************** //
    @Override
    public int compareTo(Point2D p2D) {
        //check only if  equal (0) or not equal (1)
        if (this.x.compareTo(p2D.x) == 0 && this.y.compareTo(p2D.y) == 0)
            return 0; //both coordinates area equal
        return 1; // not equal
    }
    // ***************** Operations ******************** //
    //ok don't need add or subtract just to string
    @Override
    public String toString(){
        return "("+ x.getCoordinate()//does matter if I use getCoordinate() or toString() (besides that this is a string and other a double?
        + "," + y.getCoordinate() + ")";
    }
}
