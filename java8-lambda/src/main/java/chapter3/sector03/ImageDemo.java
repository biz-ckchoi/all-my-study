package chapter3.sector03;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.function.UnaryOperator;


@FunctionalInterface
interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}

public class ImageDemo extends Application {

    public static Image transform(Image in, UnaryOperator<Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
            }
        }

        return out;
    }

    public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }

        return out;
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        final String imageName = "file:java8-lambda/src/main/java/chapter3/sector03/queen-mary.png";
        Image image = new Image(imageName);
        Image brightenedImage = transform(image, Color::brighter);
        Image image2 = transform(image, (x, y, c) -> (x / 10) % 2 == (y / 10) % 2 ? Color.GRAY : c);

        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(brightenedImage), new ImageView(image2))));
        stage.show();
    }

}
