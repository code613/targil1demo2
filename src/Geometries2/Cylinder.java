package Geometries2;
import Primitives.Point3D;
import Primitives.Vector;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains
public class Cylinder extends RadialGeometry {


//********************Fields*****************//
//access the point
    private Point3D _accessPoint;
    private Vector _accessDirection;
// ***************** Constructors ********************** //

    public Cylinder(double _radius, Point3D _accessPoint, Vector _accessDirection) {
        super(_radius);//super super cool
        this._accessPoint = _accessPoint;
        this._accessDirection = _accessDirection;
    }


// ***************** Getters/Setters ********************** //

    public Point3D get_accessPoint() {
        return _accessPoint;
    }

    public void set_accessPoint(Point3D _accessPoint) {
        this._accessPoint = _accessPoint;
    }

    public Vector get_accessDirection() {
        return _accessDirection;
    }

    public void set_accessDirection(Vector _accessDirection) {
        this._accessDirection = _accessDirection;
    }


// ***************** Implementations   ******************** //

// ***************** Operations *****************
}