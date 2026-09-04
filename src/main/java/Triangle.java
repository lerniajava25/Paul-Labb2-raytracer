public class Triangle implements Shape {

    private Vector3D v0;
    private Vector3D v1;
    private Vector3D v2;

    public Triangle(Vector3D v0, Vector3D v1, Vector3D v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vector3D getV0() {
        return v0;
    }

    public Vector3D getV1() {
        return v1;
    }

    public Vector3D getV2() {
        return v2;
    }

    @Override
    public HitResult hit(Ray ray) {
        Vector3D edge1 = v1.subtract(v0);
        Vector3D edge2 = v2.subtract(v0);

        Vector3D directionCrossEdge2 = ray.getDirection().cross(edge2);
        double determinant = edge1.dot(directionCrossEdge2);

        double epsilon = 0.0000001;

        if (Math.abs(determinant) < epsilon) {
            return null;
        }

        double inverse = 1.0 / determinant;

        Vector3D fromVertexToRay = ray.getOrigin().subtract(v0);

        double u = fromVertexToRay.dot(directionCrossEdge2) * inverse;

        if (u < 0 || u > 1) {
            return null;
        }

        Vector3D originCrossEdge1 = fromVertexToRay.cross(edge1);

        double v = ray.getDirection().dot(originCrossEdge1) * inverse;

        if (v < 0 || u + v > 1) {
            return null;
        }

        double distance = edge2.dot(originCrossEdge1) * inverse;

        if (distance < epsilon) {
            return null;
        }

        Vector3D hitPoint = ray.at(distance);

        return new HitResult(distance, hitPoint);

    }
}

