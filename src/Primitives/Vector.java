package Primitives;
//ben marcus 305568867
//class summery
//the Vector is really an implementation of a 3D point such that it redifines it to mean the head of the vector (from 0??)
//it has constructor's compareTo as well as a ToString and addition of 2 3D points

public class Vector implements Comparable<Vector> {

    //********************fields*****************//
    private  Point3D _head;

    // ***************** Constructors ********************** //

    public Vector() {//do i really need an empty constructor for cross Product???
    }

    public Vector(Point3D _head) {                         //from a 3D point
        this._head = _head;
    }
    public Vector(Vector _head) {                         //from a Vector
        this._head = _head.get_head();
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
    // ***************** Operations ******************** //

    public void add(Vector v) {
        get_head().x=new Coordinate(get_head().x.getCoordinate()+v.get_head().x.getCoordinate());
        get_head().y=new Coordinate(get_head().y.getCoordinate()+v.get_head().y.getCoordinate());
        get_head().setZ(new Coordinate(get_head().getZ().getCoordinate()+v.get_head().getZ().getCoordinate()));
    }

    public void subtract(Vector v) {//this Vector mines the Vector V
        get_head().x=new Coordinate(get_head().x.getCoordinate()-v.get_head().x.getCoordinate());
        get_head().y=new Coordinate(get_head().y.getCoordinate()-v.get_head().y.getCoordinate());
        get_head().setZ(new Coordinate(get_head().getZ().getCoordinate()-v.get_head().getZ().getCoordinate()));
    }

    public Vector crossProduct (Vector v){
        /*
        1=  u2v3 − u3v2
        2=  u3v1 − u1v3
        3=  u1v2 − u2v1*/
        Vector r = new Vector();
        r.get_head().setX(new Coordinate(this.get_head().y.getCoordinate()*v.get_head().getZ().getCoordinate()-
                this.get_head().getZ().getCoordinate()*v.get_head().y.getCoordinate()));
        r.get_head().y=new Coordinate(this.get_head().getZ().getCoordinate()*v.get_head().x.getCoordinate()-
                this.get_head().x.getCoordinate()*v.get_head().getZ().getCoordinate());
        r.get_head().setZ(new Coordinate(this.get_head().x.getCoordinate()*v.get_head().y.getCoordinate()-
                this.get_head().y.getCoordinate()*v.get_head().x.getCoordinate()));
        return r;//i hope this works..
    }

    public double dotProduct (Vector v){
        return  this.get_head().x.getCoordinate()*v.get_head().x.getCoordinate()+
                this.get_head().y.getCoordinate()*v.get_head().y.getCoordinate()+
                this.get_head().getZ().getCoordinate()*v.get_head().getZ().getCoordinate();
    }

    public void normalize(){}
    //public double length(){}


}
