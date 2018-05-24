package Primitives;

//why doesn't need "implements Comparable<Point3D>" ??????
public class Point3D extends Point2D  {
    //feilds
    private Coordinate z;

    // ***************** Constructors ********************** //
    //how do you know which constructor are needed?
    public Point3D() {
        z = new Coordinate();
    }

    public Point3D(Coordinate xIn, Coordinate yIn, Coordinate z) {
        super(xIn, yIn);
        // why this is generated automatically and not with new??
        // this.z = z;
        this.z = new Coordinate(z);//maybe this really is extra? and Coordinate in constructor is enugh?
    }
    public Point3D(double x, double y, double z){
        super(new Coordinate(x), new Coordinate(y));
        this.z = new Coordinate(z);
    }


    public int compareTo(Point3D p3D) {
        if (z.compareTo(p3D.z) != 0) {
            return 1;
        }
        return (((Point2D) this).compareTo(((Point2D) p3D)));
    }

    public Point3D(Point2D point2D, Coordinate z) {

        super(point2D);
        this.z = z;
    }


    public void add(Vector v) {
        x=new Coordinate(x.getCoordinate()+v.get_head().x.getCoordinate());
        y=new Coordinate(y.getCoordinate()+v.get_head().y.getCoordinate());
        z=new Coordinate(z.getCoordinate()+v.get_head().z.getCoordinate());
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result.substring(0,result.length()-1) + "," +z.getCoordinate() +")";
    }
}
