package Primitives;

public class Point3D extends Point2D  {//why doesn't need "implements Comparable<Point3D>" ??????
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

    public Point3D(Point2D point2D, Coordinate z) {

        super(point2D);
        this.z = z;
    }



}
