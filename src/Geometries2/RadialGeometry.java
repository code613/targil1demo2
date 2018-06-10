package Geometries2;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

import Primitives.Point3D;
import Primitives.Vector;

public abstract class RadialGeometry implements Geometry{

    //********************Fields*****************//
    protected double _radius;


    @Override
    public abstract Vector getNormal(Point3D p);


// ***************** Constructors ********************** //

    //intresting in order to inherit (maybe just when building it..) need defoult constructer..
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

// ***************** Getters/Setters ********************** //

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

// ***************** Implementations   ******************** //

// ***************** Operations ******************** //
}