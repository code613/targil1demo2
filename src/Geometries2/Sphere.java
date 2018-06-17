package Geometries2;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

public class Sphere extends RadialGeometry {


    //********************Fields*****************//
    private Point3D _center;
    //also have radius in

// ***************** Constructors ********************** //

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }
    public Sphere(){
        super(0.0);
        _center = new Point3D();
    }

    public Sphere (Sphere sphere){
        super(sphere._radius);
        _center = sphere.getCenter();
    }

    /*public Sphere(double radius, Point3D center){
        super(radius);
        _center = new Point3D(center);
    }*/

    public Sphere(Map<String, String> attributes){
       // this();
        //super();

        String[] centerPoints = attributes
                .get("center" ).split("\\s+");

        _center = new Point3D(Double.valueOf(centerPoints[0]),
                Double.valueOf(centerPoints[1]),
                Double.valueOf(centerPoints[2]));

        _radius = Double.valueOf(attributes.get("radius"));
    }

// ***************** Getters/Setters ********************** //


    public Point3D get_center() {
        return _center;
    }

    public void set_center(Point3D _center) {
        this._center = _center;
    }

//    @Override
//    public List<Point3D> FindIntersections(Ray ray) {
//        return null;
//    }

    @Override
    public Vector getNormal(Point3D p) {
        Vector v1 = new Vector(_center, p);
        v1.normalize();
        return v1;
    }


    // ***************** Implementations   ******************** //
    //this function is returing all intersection points between the sphere and this ray
    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoints = new ArrayList<Point3D>(2);

        Vector L = new Vector(ray.get_PointOfOrigin(), _center);
        double tm = L.dotProduct(ray.get_direction());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));

        if (d > _radius)
            return intersectionPoints;

        double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0) {
            Vector V = ray.get_direction();
            V.scale(t1);
            Point3D P1 = ray.get_PointOfOrigin();
            P1.add(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0) {
            Vector V = ray.getDirection();
            V.scale(t2);
            Point3D P2 = ray.getPOO();
            P2.add(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;

    }

    public List<Point3D> findIntersections(Ray myRay) {

        List<Point3D> intersectionPoints = new ArrayList<Point3D>();

        Vector u = new Vector(myRay.get_PointOfOrigin(), _center);
        double tm = u.dotProduct(myRay.get_direction());
        double d = Math.sqrt(Math.pow(u.length(), 2) - Math.pow(tm, 2));

        // if there is no intersections
        if (d > _radius)
            return intersectionPoints;
        // if there is one intersection
        if (new Coordinate(d).equals(new Coordinate(_radius))) {

            Point3D interPoint = Point3D.add(myRay.get_PointOfOrigin(), myRay.get_direction().multiplyByScalar(tm));
            if (myRay.isOnRay(interPoint))
                intersectionPoints.add(interPoint);
        }

        // if there are two intersections
        else if (d < _radius) {
            double th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(d, 2));

            double t1 = tm + th;
            double t2 = tm - th;

            if (t1 >= 0) {
                Point3D interPoint = Point3D.add(myRay.getPoint(), myRay.get_direction().multiplyByScalar(t2).getVector());
                if (myRay.isOnRay(interPoint))
                    intersectionPoints.add(interPoint);
            }
            if (t2 >= 0) {
                Point3D interPoint = Point3D.add(myRay.getPoint(), myRay.get_direction().multiplyByScalar(t1).getVector());
                if (myRay.isOnRay(interPoint))
                    intersectionPoints.add(interPoint);
            }

        }
        return ;
    }
// ***************** Operations ******************** //


}