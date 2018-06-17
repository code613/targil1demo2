package Elements;
//ben marcus 305568867
//need to vectors
//one for where direction is too
//other 2 are to find place in
//one other one is too say what direction is up in the camara

//it's main function buids a ray (will be used many times) that has a direction that will
//go thrue the veiw plane and return the coler it hits
//it will start from the center and then from the function it will move to any place in the veiw plane
//eventually in rendering it will biuld all of the pixels
//but for now we need a function that is able to build a picsel not just the center picsel

//so builds a ray that goes thrue a pixel

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.Map;

//example for constructor (up ,to) then can build the 3rd from the normal of the 2


//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains

//ok deleted what did and took from eliezer .. what he had was more and better..

public class Camera {
    // *****************Fields***************************** //

    // Eye point of the camera
    private Point3D _P0;//current location
    private Vector _vUp;//  -> twist down and up
    private Vector _vTo;//  -> facing

    // Should be calculated as the cross product if vUp and vTo
    private Vector _vRight;//  ->   twist sideways

    // ***************** Constructors ********************** //

    public Camera(){

        _P0 = new Point3D(0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);

        _vRight = _vUp.crossProduct(_vTo);
    }

    public Camera (Camera camera){
        _P0     = camera.getP0();
        _vUp    = camera.get_vUp();
        _vTo    = camera.get_vTo();
        _vRight = camera.get_vRight();
    }

    public Camera (Point3D P0, Vector vUp, Vector vTo){

        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);

        _vRight = _vUp.crossProduct(_vTo);
        _vUp = _vTo.crossProduct(_vRight);

        _vUp.normalize();
        _vTo.normalize();
        _vRight.normalize();

    }

    public Camera (Map<String, String> attributes){

        String[] P0params = attributes
                .get("P0").split("\\s+");

        _P0 = new Point3D(Double.valueOf(P0params[0]),
                Double.valueOf(P0params[1]),
                Double.valueOf(P0params[2]));

        String[] vToParam = attributes
                .get("vTo").split("\\s+");
        _vTo = new Vector(Double.valueOf(vToParam[0]),
                Double.valueOf(vToParam[1]),
                Double.valueOf(vToParam[2]));

        String[] vUpParam =  attributes
                .get("vUp").split("\\s+");
        _vUp = new Vector(Double.valueOf(vUpParam[0]),
                Double.valueOf(vUpParam[1]),
                Double.valueOf(vUpParam[2]));

        _vRight = _vUp.crossProduct(_vTo);
        _vUp = _vTo.crossProduct(_vRight);

        _vUp.normalize();
        _vTo.normalize();
        _vRight.normalize();

    }

    // ***************** Getters/Setters ********************** //

    public Vector get_vUp()         { return new Vector(_vUp);     }
    public Vector get_vTo()         { return new Vector(_vTo); 	   }
    public Point3D getP0()          { return new Point3D(_P0);     }
    public Vector get_vRight()      { return new Vector(_vRight);  }

    public void set_vUp(Vector vUp) { this._vUp = new Vector(vUp); }
    public void set_vTo(Vector vTo) { this._vTo = new Vector(vTo); }
    public void setP0(Point3D P0)   { this._P0  = new Point3D(P0); }


    // ***************** Administration ********************** //

    public String toString(){
        return "Vto: "   + _vTo + "\n" +
                "Vup: "   + _vUp + "\n" +
                "Vright:" + _vRight + ".";
    }

    // ***************** Operations ******************** //

    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
                                         double screenDist, double screenWidth,
                                         double screenHeight){

        // Calculating the image center
        Vector vToward = new Vector(_vTo);
        vToward.scale(screenDist);

        Point3D Pc = new Point3D(_P0);
        Pc.add(vToward);

        // Calculating x-y ratios
        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        Vector vRight = new Vector(_vRight);
        Vector vUp = new Vector(_vUp);

        vRight.scale(((x - (Nx/2.0)) * Rx + 0.5 * Rx));
        vUp.   scale(((y - (Ny/2.0)) * Ry + 0.5 * Ry));

        vRight.subtract(vUp);

        Pc.add(vRight);

        Point3D P = new Point3D(Pc);

        // constructing ray between P0 and the intersection point
        Vector ray = new Vector(_P0, P);
        ray.normalize();

        // returning the constructed ray
        return new Ray(P, ray);

    }

}
