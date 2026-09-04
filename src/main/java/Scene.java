import java.util.ArrayList;
import java.util.List;

public class Scene {

    private List<Shape> shapes;

    public Scene() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public HitResult hit(Ray ray) {
        HitResult closestHit = null;

        for ( int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            HitResult hitResult = shape.hit(ray);

            if (hitResult != null) {
                if (closestHit == null || hitResult.distance() < closestHit.distance()) {
                    closestHit = hitResult;
                }
            }
        }

        return closestHit;
    }



}
