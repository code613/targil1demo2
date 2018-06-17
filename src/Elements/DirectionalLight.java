package Elements;

import Primitives.Vector;
import Primitives.Point3D;
import java.awt.*;
//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpis
//what the class practically contains

// ******************* Fields ***************************** //

// ***************** Constructors ************************* //

// ***************** Getters/Setters ********************** //

// ***************** Implementations ********************** //

// ***************** Operations *************************** //
public class DirectionalLight extends Light {
    private Vector _direction;

    public DirectionalLight(Color color, Vector direction){
        super (color);
        _direction = new Vector(direction);
    }

    public Color  getIntensity(Point3D point)   { return getIntensity();         }
    public Vector getDirection()                { return new Vector(_direction); }
    public Vector getL(Point3D point)           { return getDirection();         }

    public void setDirection(Vector _direction) { this._direction = _direction;	 }

}
