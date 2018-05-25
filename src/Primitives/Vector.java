package Primitives;
//ben marcus 305568867
//class summery
//the Vector is really an implementation of a 3D point such that it redifines it to mean the head of the vector (from 0??)
//it has constructor's compareTo as well as a ToString and addition of 2 3D points

public class Vector implements Comparable<Vector> {

    //********************fields*****************//
    private  Point3D _head;

    // ***************** Constructors ********************** //

    public Vector(Point3D _head) {                         //from a 3D point
        this._head = _head;
    }

    // ***************** Getters/Setters ********************** //
    public void set_head(Point3D _head) {
        this._head = _head;
    }
    public Point3D get_head() {
        return _head;
    }
    // ***************** Implementations   ******************** //
    @Override
    public int compareTo(Vector other) {
        return (this._head.compareTo(other._head));
    }
}
