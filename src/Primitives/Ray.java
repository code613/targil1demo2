package Primitives;
//ben marcus 305568867
//class summery
//the Ray is really an implementation of a vector from 3D point
//it has constructor's compareTo as well as a ToString and addition of 2 3D points

public class Ray implements Comparable<Ray> {

    //********************Fields*****************//
    private Point3D _PointOfOrigin;

    private Vector _direction;
    // ***************** Constructors ********************** //

    public Ray(Vector _direction,Point3D _PointOfOrigin) {      //gets a direction and a orgin of type vector and 3D point
        this._direction = _direction;
        this._PointOfOrigin = _PointOfOrigin;
    }
    // ***************** Getters/Setters ********************** //
    public Point3D get_PointOfOrigin() {
        return _PointOfOrigin;
    }

    public void set_PointOfOrigin(Point3D _PointOfOrigin) {
        this._PointOfOrigin = _PointOfOrigin;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public int compareTo(Ray other) {
        if(this._direction.compareTo(other._direction) == 0)
        return  this._PointOfOrigin.compareTo(other._PointOfOrigin);
        else
            return 1;
    }
    // ***************** Implementations   ******************** //

    // ***************** Operations ******************** //
}
