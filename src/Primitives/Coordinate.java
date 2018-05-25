package Primitives;
//ok when thrue this class some Q's of it's end
//ben marcus 305568867
//ok summery of this class
//so this is the base primitive it takes a number and declares it as a point
//it has cunstructers can be compared to itself as well as added and subtracted
//
public class Coordinate implements Comparable<Coordinate>{//indeed how did we know to add this interface

    //********************Fields*****************//
    private double coordinate;//lower case c right class has to start with	a uppercase
    // note the field is private

    // ***************** Constructors ********************** //

    public Coordinate()             { coordinate = 0.0;           }//empty
    public Coordinate(double c)     { coordinate = c;             }//implement
    public Coordinate(Coordinate c) { coordinate = c.coordinate;  }//copy

    // ***************** Getters/Setters ********************** //

    //note these are public methods  (method is in the class function is out - i think)
    //wait no these are properties
    public double getCoordinate()                {	return coordinate;	          }
    public void setCoordinate(double c) { coordinate = c; }

    // ***************** Implementations   ******************** //
    @Override//this means implementing the Comparable Interface (as interface's are virtual classes)
    public int compareTo(Coordinate c) {//i guess this is the only function of the interface
        return Double.compare(coordinate, c.coordinate);
    }

    // ***************** Operations ******************** //

    //when doing changes of coordinates of a point use the following functions
    public void add (Coordinate c ){
        coordinate += c.coordinate;
    }

    public void subtract(Coordinate c) {
        coordinate -= c.coordinate;
    }

}
