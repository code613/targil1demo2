package Elements;

import java.awt.*;
import java.util.Map;
//ben marcus 305568867
//summery of this class


/*      An ambient light source represents a fixed-intensity and fixed-color
		light source that affects all objects in the scene equally

		Upon rendering, all objects in the scene are brightened with the
        specified intensity and color
*/
public class AmbientLight extends Light {
    //********************Fields*****************//
    //i don't understand this field
    //it is either coler or intensity i think
    private final double _Ka = 0.1;

    // ***************** Constructors ********************** //

    public AmbientLight() {
        super(new Color(255, 255, 255));
    }

    public AmbientLight(AmbientLight aLight){
        super(aLight._color);
    }

    public AmbientLight(int r, int g, int b) {
        super(new Color(r, g, b));
    }

    public AmbientLight(Map<String, String> attributes){
        String[] ambientLightColors = attributes
                .get("color" ).split("\\s+");
        _color = new Color((int)(255 * Double.valueOf(ambientLightColors[0])),
                (int)(255 * Double.valueOf(ambientLightColors[1])),
                (int)(255 * Double.valueOf(ambientLightColors[2])));
    }

    // ***************** Getters/Setters ********************** //

    public Color getColor()             { return _color;  }
    public void  setColor(Color color)  { _color = color; }
    public double getKa()				{ return _Ka;     }

    // ***************** Implementations   ******************** //
    @Override
    public Color getIntensity() {
        return new Color((int)(_color.getRed()   * _Ka),
                (int)(_color.getGreen() * _Ka),
                (int)(_color.getBlue()  * _Ka));
    }

  /*  public AmbientLight(Color color) {
        super(color);
    }*/



    // ***************** Operations *************************** //
    ///the folowing are just extra stuff... kinda
    /*@Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }*/
}
