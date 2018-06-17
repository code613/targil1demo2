package Renderer;
//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains


import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.LightSource;
import Geometries2.FlatGeometry;
import Geometries2.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

public class Render {
    // ******************* Fields **************************** //
    private Scene _scene;
    private ImageWriter _imageWriter;

    private final int RECURSION_LEVEL = 3;//what is this??

// ***************** Constructors ************************* //


    public Render(ImageWriter imageWriter, Scene scene){
        _imageWriter = new ImageWriter(imageWriter);
        _scene = new Scene (scene);
    }
// ***************** Getters/Setters ********************** //

// ***************** Implementations ********************** //

// ***************** Operations *************************** //

    /*
    ok these are the (main functions that are doing operations in this class

    public void renderImage(){}
    public void printGrid(int interval){}
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {}
    private Map<Geometry, Point3D> getClosestPoint(}
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {}

    */

    public void renderImage(){

        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++){
                    //for each point (i, j) in the view plane..
                Ray ray = _scene.getCamera().constructRayThroughPixel(
                        _imageWriter.getNx(), _imageWriter.getNy(), j, i,
                        _scene.getScreenDistance(),
                        _imageWriter.getWidth(), _imageWriter.getHeight());

                Entry<Geometry, Point3D> entry = findClosesntIntersection(ray);

                if (entry == null){
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                } else {
                    _imageWriter.writePixel(j, i, calcColor(entry.getKey(), entry.getValue(), ray));
                }
            }
        }
    }

    public void printGrid(int interval){

        int height = _imageWriter.getHeight();
        int width = _imageWriter.getWidth();

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){

                if (i % interval == 0 || j % interval == 0)
                    _imageWriter.writePixel(j, i, 255, 255, 255);

            }
        }
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray ray){
        return calcColor(geometry, point, ray, 0);
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {


        if (level == RECURSION_LEVEL){
            return new Color(0, 0, 0);
        }

        Color ambientLight = _scene.getAmbientLight().getIntensity();
        Color emissionLight = geometry.getEmmission();

        Color inherentColors = addColors(ambientLight, emissionLight);

        Iterator<LightSource> lights = _scene.getLightsIterator();

        Color lightReflected = new Color(0, 0, 0);

        while (lights.hasNext()){

            LightSource light = lights.next();

            if (!occluded(light, point, geometry)){

                Color lightIntensity = light.getIntensity(point);


                Color lightDiffuse = calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point),
                        light.getL(point),
                        lightIntensity);


                Color lightSpecular = calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, _scene.getCamera().getP0()),
                        geometry.getNormal(point),
                        light.getL(point),
                        geometry.getShininess(),
                        lightIntensity);

                lightReflected = addColors(lightDiffuse, lightSpecular);
            }
        }

        Color I0 = addColors(inherentColors, lightReflected);


        //**// Recursive calls

        // Recursive call for a reflected ray
        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
        Entry<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
        Color reflected = new Color(0, 0, 0);
        if (reflectedEntry != null){
            reflected = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
            double kr = geometry.getMaterial().getKr();
            reflected = new Color ((int)(reflected.getRed() * kr), (int)(reflected.getGreen() * kr),(int)(reflected.getBlue() * kr));
        }

        // Recursive call for a refracted ray
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
        Entry<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
        Color refracted = new Color(0, 0, 0);
        if (refractedEntry != null){
            refracted = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
            double kt = geometry.getMaterial().getKt();
            refracted = new Color ((int)(refracted.getRed() * kt), (int)(refracted.getGreen() * kt),(int)(refracted.getBlue() * kt));
        }


        //**// End of recursive calls

        Color envColors = addColors(reflected, refracted);

        Color finalColor = addColors(envColors, I0);

        return finalColor;
    }

    private Map<Geometry, Point3D> getClosestPoint(
            Map<Geometry, List<Point3D>> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getP0();
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();


        for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet()){
            for (Point3D point : entry.getValue()){
                double pointDistance = P0.distance(point);
                if (pointDistance < distance){
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance = pointDistance;
                }
            }
        }

        return minDistancePoint;

    }

   /* this is from Elisha..
   private List<Point3D> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = scene.getGeometriesIterator();
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        while (geometries.hasNext())
            Geometry geometry = geometries.next()
        List<Point3D> geometryIntersectionPoints =
                geometry.findIntersections(ray)
        add geometryIntersectionPoints to intersectionPoints
        return intersectionPoints;
    }*/
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries =  _scene.getGeometriesIterator();

        Map<Geometry, List<Point3D>> intersectionPoints = new
                HashMap<Geometry, List<Point3D>>();

        while (geometries.hasNext()){
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);

            if (!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }
}
