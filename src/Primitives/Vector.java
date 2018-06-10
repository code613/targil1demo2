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
    public Vector(int v,int v1,int v2) {
        _head = new Point3D(v,v1,v2);
    }
    public Vector(double v, double v1, double v2) {
        _head = new Point3D(v,v1,v2);
    }

    public Vector(Point3D center, Point3D p) {
        _head.setX(new Coordinate( p.getX().getCoordinate()-center.getX().getCoordinate()));
        _head.setY(new Coordinate( p.getY().getCoordinate()-center.getY().getCoordinate()));
        _head.setZ(new Coordinate( p.getZ().getCoordinate()-center.getZ().getCoordinate()));
        //vector AB is B mines A
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

    public void normalize(){//if i recall correctly what we want here is that all coordinates add up to one
        double whole = this._head.x.getCoordinate()+this.get_head().y.getCoordinate()+this.get_head().getZ().getCoordinate();
        this.get_head().setX(new Coordinate(this._head.x.getCoordinate()/whole));
        this.get_head().setY(new Coordinate(this.get_head().y.getCoordinate()/whole));
        this.get_head().setZ(new Coordinate(this.get_head().getZ().getCoordinate()/whole));
    }
    public double length(){
        double x = this.get_head().getX().getCoordinate();
        double y = this.get_head().getY().getCoordinate();
        double z = this.get_head().getZ().getCoordinate();

        return Math.sqrt(Math.pow(x, 2) +
                Math.pow(y, 2) +
                Math.pow(z, 2));}//oh i think need to find length from (0,0,0)
    //length of the vector
    public void scale (double v){
        this.get_head().setX(new Coordinate(this._head.getX().getCoordinate()*v));
        this.get_head().setY(new Coordinate(this.get_head().getY().getCoordinate()*v));
        this.get_head().setZ(new Coordinate(this.get_head().getZ().getCoordinate()*v));
    }

}
