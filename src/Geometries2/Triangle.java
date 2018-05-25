package Geometries2;
import Primitives.Point3D;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

public class Triangle {
//********************Fields*****************//


    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;


// ***************** Constructors ********************** //

//why here Primitives.Point3D but in Plane just point3D
    //ok took one out see if this still works
    //gee should use a test here.....
    public Triangle(Point3D _p1, Primitives.Point3D _p2, Primitives.Point3D _p3) {//3 3D points
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }


// ***************** Getters/Setters ********************** //


    public Point3D get_p1() {
        return _p1;
    }

    public void set_p1(Point3D _p1) {
        this._p1 = _p1;
    }

    public Point3D get_p2() {
        return _p2;
    }

    public void set_p2(Point3D _p2) {
        this._p2 = _p2;
    }


    public Point3D get_p3() {
        return _p3;
    }

    public void set_p3(Point3D _p3) {
        this._p3 = _p3;
    }


// ***************** Implementations   ******************** //

// ***************** Operations *****************

}
