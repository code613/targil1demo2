package Elements;
import java.awt.Color;

//ben marcus 305568867
//summery of this class
//general explanation of the class.. what is it's perpis
//what the class practically contains




public abstract class Light {

    // ******************* Fields **************************** //


    protected Color _color;
    // ***************** Constructors ************************* //\

    public Light()              { _color = null;  }
    public Light (Color color)  { _color = color; }

    // ***************** Operations *************************** //

    public Color getIntensity() { return _color;  }

}
