package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    LineChart<String, Number> lineChart;

    XYChart.Series<String, Number> algorithmOne = new XYChart.Series<>();
    XYChart.Series<String, Number> algorithmTwo = new XYChart.Series<>();


    public static void experimentalAnalysis1(int n, int trials, XYChart.Series<String, Number> series) {
        series.setName("Algorithm 1");
        System.out.println("<----------- Prefix Average 1 ----------->");
        for (int i = 0; i<trials; i++) {
            long startTime = System.currentTimeMillis();
            CustomMethods.prefixAverage1(CustomMethods.inputSize(n));
            long endTime = System.currentTimeMillis();
            long elapsed = endTime-startTime;
            System.out.println("Array with "+n+ " items took "+elapsed+" milliseconds");
            series.getData().add(new XYChart.Data<>(""+n, elapsed));
            n*=2;
        }
    }

    public static void experimentalAnalysis2(int n, int trials, XYChart.Series<String, Number> series) {
        series.setName("Algorithm 2");
        System.out.println("<----------- Prefix Average 2 ----------->");
        for (int i = 0; i<trials; i++) {
            long startTime = System.currentTimeMillis();
            CustomMethods.prefixAverage2(CustomMethods.inputSize(n));
            long endTime = System.currentTimeMillis();
            long elapsed = endTime-startTime;
            System.out.println("Array with "+n+ " items took "+elapsed+" milliseconds");
            series.getData().add(new XYChart.Data<>(""+n, elapsed));
            n*=2;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        experimentalAnalysis1(1000, 7, algorithmOne);
        experimentalAnalysis2(1000, 10, algorithmTwo);

        lineChart.getData().addAll(algorithmOne);
        lineChart.getData().addAll(algorithmTwo);

    }
}



