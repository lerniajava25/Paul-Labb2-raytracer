import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Scene scene = new Scene();

        scene.addShape(new Sphere(
                new Vector3D(-1, 0, 5),
                1
        ));

        scene.addShape(new Triangle(
                new Vector3D(0, -1, 6),
                new Vector3D(2, -1, 6),
                new Vector3D(1, 1, 6)
        ));

        Renderer renderer = new Renderer(200, 200);

        renderer.render(scene, "output.ppm");

        IO.println("Image created: output.ppm");
    }
}