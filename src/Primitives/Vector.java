package Primitives;

public class Vector implements Comparable<Vector> {
    private  Point3D _head;

    public Vector(Point3D _head) {
        this._head = _head;
    }

    public void set_head(Point3D _head) {
        this._head = _head;
    }
    public Point3D get_head() {
        return _head;
    }

    @Override
    public int compareTo(Vector other) {
        return (this._head.compareTo(other._head));
    }
}
