/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import lab03.service.SimulationService;
import lab03.service.impl.SimulationServiceImpl;
import lab03.ui.controller.NewStage;
import lab03.ui.model.SimTable1;
import lab03.ui.model.particle;

/**
 *
 * @author Shaikh
 */
public class FXMLDocumentController implements Initializable {

    private SimulationService simulationService;
    private Canvas canvas;
    private double radius = 200;

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TableView<SimTable1> table_sim;
    @FXML
    private TableColumn<TableView, Integer> col_replication;
    @FXML
    private TableColumn<TableView, Integer> col_samplesize;
    @FXML
    private TableColumn<TableView, Double> col_hitcount;
    @FXML
    private TableColumn<TableView, Double> col_estimatedpi;
    @FXML
    private TableColumn<TableView, Double> col_variance;
    @FXML
    private TableColumn<TableView, Double> col_finalvariance;
    @FXML
    private TableColumn<TableView, Double> col_standarddeviation;
    @FXML
    private TableColumn<TableView, Double> col_cilb;
    @FXML
    private TableColumn<TableView, Double> col_ciub;
    @FXML
    private TextField txt_replicaiton;
    @FXML
    private TextField txt_streamsize;
    @FXML
    private Button visualize;

    @FXML
    public void handleVisualize(ActionEvent e) throws Exception {
        //  System.out.println("You clicked me!");
        System.out.println("sssaaaa");

        String sampleStreamSize = txt_streamsize.getText();
        String[] sampleStreamSizes = sampleStreamSize.split(",");
        Circle circle = createCircle();
        Map<Integer, List<particle>> sampleMap = new LinkedHashMap();
        for (String sampleSize : sampleStreamSizes) {
            Integer sample = Integer.valueOf(sampleSize);
            List<particle> particles = simulationService.getParticles(sample, radius, canvas);
            sampleMap.put(sample, particles);

        }

        List<SimTable1> simTable = simulationService.getTableData(circle, sampleMap);

        for (SimTable1 simTable1 : simTable) {
            int sample = simTable1.getSampleSize();
            List<particle> particles = simulationService.getParticles(sample, radius, canvas);
            // yeh bhae mjhe yeh bc smhj nahin aya :O change kardun ? comment karunga isey :P kr de
            Group root = new Group();
            circle = createCircle();
            Rectangle r = createRectangle();
            root.getChildren().add(r);
            root.getChildren().add(circle); //ye kr
            root.getChildren().addAll(particles);
//                new NewStage(root);
            new NewStage(root);
        }

        //Group root = new Group();
//        table_sim.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                int sample = newSelection.getSampleSize();
//                List<particle> particles = simulationService.getParticles(sample, radius, canvas);
//                // yeh bhae mjhe yeh bc smhj nahin aya :O change kardun ? comment karunga isey :P kr de
//                Group root = new Group();
//                
//                Rectangle r = createRectangle();
//                root.getChildren().add(r);
//                root.getChildren().add(circle);
//                root.getChildren().addAll(particles);
////                new NewStage(root);
//                new NewStage(root);
//            }
//        });
//        final String estimatedP = "PI";
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//
//        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
//        bc.setTitle("ssss");   // shi kro 
//        xAxis.setLabel("n");
//        yAxis.setLabel("X_bar(n)");
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("");
//        series1.getData().add(new XYChart.Data(estimatedP, 25601.34));
//        series1.getData().add(new XYChart.Data(estimatedP, 20148.82));
//        series1.getData().add(new XYChart.Data(estimatedP, 10000));
//        series1.getData().add(new XYChart.Data(estimatedP, 35407.15));
//        series1.getData().add(new XYChart.Data(estimatedP, 12000));
//
//        bc.getData().addAll(series1);
//
//        root.getChildren().addAll(bc);
//        new NewStage(root);
    }

    private void initialize() {
        canvas = new Canvas(640, 480);

    }

    private Rectangle createRectangle() {
        Rectangle r = new Rectangle();
        r.setTranslateX(canvas.getWidth() / 2 - radius);
        r.setTranslateY(canvas.getHeight() / 2 - radius);
        r.setWidth(radius * 2);
        r.setHeight(radius * 2);
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLUE);
        r.setStrokeWidth(4);
        return r;

    }

    private Circle createCircle() {

        Circle circle = new Circle();
        circle.centerXProperty().bind(canvas.widthProperty().divide(2));
        circle.centerYProperty().bind(canvas.heightProperty().divide(2));
        circle.setRadius(radius);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.YELLOW);
        circle.setStrokeWidth(4);
        return circle;

    }

    @FXML
    public void handleimulate(ActionEvent e) throws Exception {
        System.out.println("sss");

        String sampleStreamSize = txt_streamsize.getText();
        String[] sampleStreamSizes = sampleStreamSize.split(",");
        Circle circle = createCircle();
        Map<Integer, List<particle>> sampleMap = new LinkedHashMap();
        for (String sampleSize : sampleStreamSizes) {
            Integer sample = Integer.valueOf(sampleSize);
            List<particle> particles = simulationService.getParticles(sample, radius, canvas);
            sampleMap.put(sample, particles);

        }

        List<SimTable1> simTable = simulationService.getTableData(circle, sampleMap);
        if (!simTable.isEmpty()) {
            populateTable(simTable);
        }

    }

    private void populateTable(List<SimTable1> simTable) {
        ObservableList<SimTable1> tableData = FXCollections.observableArrayList(simTable);
        col_replication.setCellValueFactory(new PropertyValueFactory<TableView, Integer>("replication"));
        col_samplesize.setCellValueFactory(new PropertyValueFactory<TableView, Integer>("sampleSize"));
        col_hitcount.setCellValueFactory(new PropertyValueFactory<TableView, Double>("hitCount"));
        col_estimatedpi.setCellValueFactory(new PropertyValueFactory<TableView, Double>("estimatedPi"));
        col_variance.setCellValueFactory(new PropertyValueFactory<TableView, Double>("variance"));
        col_finalvariance.setCellValueFactory(new PropertyValueFactory<TableView, Double>("finalVariance"));
        col_standarddeviation.setCellValueFactory(new PropertyValueFactory<TableView, Double>("standardDeviation"));
        col_cilb.setCellValueFactory(new PropertyValueFactory<TableView, Double>("cilb"));
        col_ciub.setCellValueFactory(new PropertyValueFactory<TableView, Double>("ciub"));

        table_sim.setItems(tableData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        simulationService = new SimulationServiceImpl();
        canvas = new Canvas(640, 480);

    }

}
