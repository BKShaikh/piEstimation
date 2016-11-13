/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.ui.controller;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sahar
 */
public class NewStage {

    public NewStage(Group root) {
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");
        subStage.sizeToScene();
        Scene scene = new Scene(root, 640, 640);
        subStage.setScene(scene);
        subStage.show();

    }

}
