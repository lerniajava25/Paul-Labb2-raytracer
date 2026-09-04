    public class Sphere implements Shape {
        private Vector3D center;
        private double radius;

        public Sphere(Vector3D center, double radius) {
            this.center = center;
            this.radius = radius;
        }

        public Vector3D getCenter() {
            return center;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public HitResult hit(Ray ray) {
            Vector3D oc = ray.getOrigin().subtract(center);

            double a = ray.getDirection().dot(ray.getDirection());
            double b = 2.0 * oc.dot(ray.getDirection());
            double c = oc.dot(oc) - radius * radius;

            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                return null;
            }

            double sqrtDiscriminant = Math.sqrt(discriminant);

            double t1 = (-b - sqrtDiscriminant) / (2 * a);
            double t2 = (-b + sqrtDiscriminant) / (2 * a);

            double t;

            if (t1 >= 0) {
                t = t1;
            } else if (t2 >= 0) {
                t = t2;
            } else {
                return null;
            }

            Vector3D point = ray.at(t);
            return new HitResult(t, point);
        }
    }

