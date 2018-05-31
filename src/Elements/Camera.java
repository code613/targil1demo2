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

//example for constructor (up ,to) then can build the 3rd from the normal of the 2
public class Camera {
    //********************Fields*****************//
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    private Vector _vRight;

    // ***************** Constructors ********************** //

    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        this._P0 = new Point3D(P0);
        this._vUp = new Vector(vUp);
        this._vTo = new Vector(vTo);

        this._vRight =_vUp.crossProduct(_vTo);
        this._vUp= _vTo.crossProduct(_vRight);

        _vUp.normalize();
        _vRight.normalize();
        _vTo.normalize();
    }

    public Camera() {
        this._P0 =new Point3D(0,0,10);

        this._vUp = new Vector(1.0,0.0,0.0);
        this._vTo = new Vector(0,0,-1.0);

        _vRight = _vUp.crossProduct(_vTo);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = _vTo;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public void set_vRight(Vector _vRight) {
        this._vRight = _vRight;
    }

    // ***************** Implementations   ******************** //


    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny,
                                         double x, double y, double
                          screenDistance, double
                          screenWidth, double
                          screenHeight){
        
    }
    }

//summery of this class
//general explanation of the class.. what is it's perpes
//what the class practically contains



