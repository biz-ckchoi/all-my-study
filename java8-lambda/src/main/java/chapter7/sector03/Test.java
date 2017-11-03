package chapter7.sector03;


import javafx.application.Application;
import javafx.stage.Stage;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Test extends Application {

    private static ScriptEngineManager manager = new ScriptEngineManager();
    private static ScriptEngine engine = manager.getEngineByName("nashorn");

    public void start(Stage stage) {
        Bindings scope = engine.createBindings();
        scope.put("stage", stage);
        try {
            engine.eval(Files.newBufferedReader(Paths.get("java8-lambda/src/main/java/chapter7/sector03/hellofx.js")), scope);
            // Script code can access the object as stage
        } catch (IOException | ScriptException ex) {
            ex.printStackTrace();
        }
    }

}
