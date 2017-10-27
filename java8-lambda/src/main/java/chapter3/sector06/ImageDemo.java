package chapter3.sector06;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;


class LatenImage {
    private Image in;
    private List<UnaryOperator<Color>> pendingOperations;

    public static LatenImage from(Image in) {
        LatenImage result = new LatenImage();
        result.in = in;
        result.pendingOperations = new ArrayList<>();
        return result;
    }

    LatenImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations) {
                    c = f.apply(c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }

        return out;
    }
}

public class ImageDemo extends Application {

    public void start(Stage stage) {
        Image image = new Image("file:java8-lambda/src/main/java/chapter3/sector06/eiffel-tower.jpg");
        Image finalImage = LatenImage.from(image).transform(Color::brighter).transform(Color::grayscale).toImage();
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(finalImage))));
        stage.show();
    }

}
