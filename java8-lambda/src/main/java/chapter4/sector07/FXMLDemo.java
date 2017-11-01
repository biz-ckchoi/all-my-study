package chapter4.sector07;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class FXMLDemo extends Application {

    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dialog.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

}
