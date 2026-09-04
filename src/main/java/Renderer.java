import java.io.FileWriter;
import java.io.IOException;

public class Renderer {

    private int width;
    private int height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Scene scene, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("P3\n");
        writer.write(width + " " + height + "\n");
        writer.write("255\n");


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double screenX = (x - width / 2.0) / width;
                double screenY = (height / 2.0 - y) / height;

                Vector3D direction = new Vector3D(screenX, screenY, 1).normalize();

                Ray ray = new Ray(
                        new Vector3D(0, 0, 0),
                        direction
                );

                HitResult hitResult = scene.hit(ray);

                Color color;

                if (hitResult != null) {
                    color = new Color(255, 0, 0);
                } else {
                    color = new Color(0, 0, 0);
                }

                writer.write(
                            color.getRed() + " " +
                                color.getGreen() + " " +
                                color.getBlue() + "\n"
                );
            }
        }
        writer.close();
    }
}
