package Geometries2;

import java.awt.Color;
import java.util.List;

//import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
public interface Geometry {

   /* private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);*/

    public abstract List<Point3D> FindIntersections (Ray ray);
    //i am not "closed" exactly how the intersection thing works and what it does..
    public abstract Vector getNormal(Point3D point);

   /* public double   getShininess() { return _nShininess; }
    public Material getMaterial()  { return _material;   }
    public Color getEmmission()    { return _emmission;  }

    public void setShininess(double n)          { _nShininess = n;             }
    public void setMaterial(Material _material) { this._material = _material;  }
    public void setEmmission(Color emmission)   { this._emmission = emmission; }

    public void setKs(double ks) { _material.setKs(ks); }
    public void setKd(double kd) { _material.setKd(kd); }
    public void setKr(double Kr) { _material.setKr(Kr); }
    public void setKt(double Kt) { _material.setKt(Kt); }*/

}
