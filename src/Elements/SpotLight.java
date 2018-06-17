package Elements;

import Primitives.Point3D;
import Primitives.Vector;
import java.awt.*;
//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpis
//what the class practically contains





public class SpotLight extends PointLight {

    // ******************* Fields **************************** //
    private Vector _direction;

    // ***************** Constructors ************************* //

    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector _direction) {
        super(color, position, kc, kl, kq);
        this._direction = _direction;
    }
    public SpotLight(Color color, Point3D position, Vector direction, //coool can have to functions (constructor's) with different orders of elements..
                     double kc, double kl, double kq) {

        super(color, position, kc, kl, kq);
        _direction = new Vector(direction);
        _direction.normalize();
    }

// ***************** Implementations ********************** //

// ***************** Operations *************************** //

    public Color getIntensity(Point3D point) {

        Color pointColor = super.getIntensity(point);

        Vector l = getL(point);
        l.normalize();

        double k = Math.abs(_direction.dotProduct(l));

        if (k > 1) k = 1; // doesn't allow light magnification

        return new Color((int)(pointColor.getRed()   * k),
                (int)(pointColor.getGreen() * k),
                (int)(pointColor.getBlue()  * k));
    }
}
