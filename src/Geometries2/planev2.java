package Geometries2;
import java.util.List;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class planev2 extends Geometry{

    //********************Fields*****************//

    private Vector _normal;//this is normal to the plane
    private Point3D _Q;

    // ***************** Constructors ********************** //
    public planev2(){
        _normal = new Vector();
        _Q = new Point3D();
    }

    public planev2 (planev2 plane){                  //copy constructer
        _normal = plane.getNormal(null);
        _Q = plane.getQ();
    }

    public planev2 (Vector normal, Point3D q){
        _normal = new Vector(normal);
        _normal.normalize();
        _Q = new Point3D(q);
    }

    // ***************** Getters/Setters ********************** //


    @Override
    public Vector getNormal(Point3D point) { return _normal; }//so don't need new???
    public Point3D getQ()                  { return _Q;	 }

    public void setNormal(Vector normal) {	this._normal = new Vector(normal); }
    public void setQ(Point3D d)          { this._Q = new Point3D(d);           }

    // ***************** Operations ******************** //


   /* @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoint = new ArrayList<Point3D>(1);

        Point3D P0 = ray.getPOO();
        Point3D Q0 = this.getQ();
        Vector N = this.getNormal(null);
        Vector V = ray.getDirection();

        Vector v = new Vector (Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0){
            V.scale(t);
            P0.add(V);
            intersectionPoint.add(P0);
        }

        return intersectionPoint;*/

    }

}
