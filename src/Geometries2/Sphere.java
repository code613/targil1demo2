package Geometries2;
import Primitives.Point3D;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

public class Sphere extends RadialGeometry {


    //********************Fields*****************//
    private Point3D _center;

// ***************** Constructors ********************** //

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }
// ***************** Getters/Setters ********************** //



    public Point3D get_center() {
        return _center;
    }

    public void set_center(Point3D _center) {
        this._center = _center;
    }


// ***************** Implementations   ******************** //

// ***************** Operations ******************** //
}