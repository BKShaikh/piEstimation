/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.awt.ScrollPane;
import java.net.URL;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import static sun.plugin.javascript.navig.JSType.URL;

/**
 *
 * @author Shaikh
 */
public class Lab03 extends Application {

    private double N = 10000; //total number of throws and trials
    private Integer hitCounts = 0;
    private Integer missCounts = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }

//    private ScrollPane getRootUsingPath() throws Exception {
//        String file = "src/main/resources/Text.fxml";
//        Path dest = Paths.get(file);
//        URL url = dest.toUri().toURL();
//        ScrollPane page = FXMLLoader.load(url);
//        return page;
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
