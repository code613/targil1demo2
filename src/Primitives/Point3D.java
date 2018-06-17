package Primitives;
//ben marcus 305568867
//class summery
//this is a 3 dimensional point inheriting from 2D point as well as using another Coordinate
//it has constructor's compareTo as well as a ToString and addition of 2 3D points

//in theory here i built my 3D world
//as now i have created a 0,0,0 point or rather its possibility

//why doesn't need "implements Comparable<Point3D>" ??????
public class Point3D extends Point2D{// implements Comparable<Point3D> no doesn't need it because got it from Point2D (I think)


    //********************fields*****************//
    private Coordinate z;

    // ***************** Constructors ********************** //
    //how do you know which constructor are needed?
    public Point3D() {
        z = new Coordinate();                                   //why no super A nothing to put in (??)
    }

    public Point3D(Coordinate xIn, Coordinate yIn, Coordinate z) {//constructor of 3 coordinates
        super(xIn, yIn);
        // why this is generated automatically and not with new??
        // this.z = z;
        this.z = new Coordinate(z);//maybe this really is extra? and Coordinate in constructor is enugh?
    }
    public Point3D(double x, double y, double z){            //of 3 numbers
        super(new Coordinate(x), new Coordinate(y));
        this.z = new Coordinate(z);
    }

    public Point3D(Point2D point2D, Coordinate z) {          //2D point and a number

        super(point2D);
        this.z = z;
    }
    public Point3D(Point3D point3D){                         //copy constructor
        super(point3D.getX(), point3D.getY());
        this.z = point3D.getZ();
    }
    // ***************** Getters/Setters ********************** //
    //why is this importent again?
    public Coordinate getZ() {
        return z;
    }

    public void setZ(Coordinate z) {
        this.z = z;
    }
    // ***************** Implementations   ******************** //
    public int compareTo(Point3D p3D) {
        if (z.compareTo(p3D.z) != 0) {//recall compareTo returns a number and '0' if they are the same
            return 1;
        }
        return (((Point2D) this).compareTo(((Point2D) p3D)));
    }
    //i added (in the other project..)
    public boolean compareTo2(Point3D point3D) {

        if (((Point2D)this).compareTo((Point2D)point3D) == 0) {
            if (this.z.compareTo(point3D.z) == 0) {
                return true;
            }
        }
        return false;
    }

    // ***************** Operations ******************** //


    public void add(Point3D v) {
        x=new Coordinate(x.getCoordinate()+v.x.getCoordinate());
        y=new Coordinate(y.getCoordinate()+v.y.getCoordinate());
        z=new Coordinate(z.getCoordinate()+v.z.getCoordinate());
    }

    public void subtract(Point3D v) {
        x=new Coordinate(x.getCoordinate()-v.x.getCoordinate());
        y=new Coordinate(y.getCoordinate()-v.y.getCoordinate());
        z=new Coordinate(z.getCoordinate()-v.z.getCoordinate());
    }
    //here did mines a vecter abouve did mines a 3DPoint
    public void add(Vector v) {
        x=new Coordinate(x.getCoordinate()+v.get_head().x.getCoordinate());
        y=new Coordinate(y.getCoordinate()+v.get_head().y.getCoordinate());
        z=new Coordinate(z.getCoordinate()+v.get_head().z.getCoordinate());
    }

    public void subtract(Vector v) {//this Coordinate mines the Vector V
        x=new Coordinate(x.getCoordinate()-v.get_head().x.getCoordinate());
        y=new Coordinate(y.getCoordinate()-v.get_head().y.getCoordinate());
        z=new Coordinate(z.getCoordinate()-v.get_head().z.getCoordinate());
    }
    public double distance(Point3D point){
        return Math.sqrt(Math.pow(getX().getCoordinate() - point.getX().getCoordinate(), 2) +
                Math.pow(getY().getCoordinate() - point.getY().getCoordinate(), 2) +
                Math.pow(getZ().getCoordinate() - point.getZ().getCoordinate(), 2));
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result.substring(0,result.length()-1) + "," +z.getCoordinate() +")";
    }
}
