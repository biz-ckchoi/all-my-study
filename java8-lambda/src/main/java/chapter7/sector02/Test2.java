package chapter7.sector02;


import javafx.application.Application;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Test2 extends Application {

    private static ScriptEngineManager manager = new ScriptEngineManager();
    private static ScriptEngine engine = manager.getEngineByName("nashorn");


    public void start(Stage stage) {
        engine.put("stage", stage);
        try {
            engine.eval(Files.newBufferedReader(Paths.get("java8-lambda/src/main/java/chapter7/sector02/hellofx.js")));
            // Script code can access the object as stage
        } catch (IOException | ScriptException ex) {
            ex.printStackTrace();
        }
    }

}
