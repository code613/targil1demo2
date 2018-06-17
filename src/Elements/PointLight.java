package Elements;

import Primitives.Vector;
import Primitives.Point3D;
import java.awt.*;
//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpis
//what the class practically contains

public class PointLight extends Light {
    // ******************* Fields **************************** //

    Point3D _position;
    double _Kc, _Kl, _Kq;

    // ***************** Constructors ************************* //

    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq) {
        super(color);
        _Kc = kc;
        _Kl = kl;
        _Kq = kq;
        _position = new Point3D(position);

    }

    //@Override
    public Color getIntensity(Point3D point) {

        int r = _color.getRed();
        int g = _color.getGreen();
        int b = _color.getBlue();

        double d = _position.distance(point);

        double k = 1/(_Kc + _Kl*d + _Kq*Math.pow(d, 2));

        if (k > 1) k = 1;

        return new Color((int)(r * k),
                (int)(g * k),
                (int)(b * k));
    }

    //@Override
    public Vector getL(Point3D point) { return new Vector (_position, point); }

// ***************** Getters/Setters ********************** //

// ***************** Implementations ********************** //

// ***************** Operations *************************** //
}
