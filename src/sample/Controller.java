package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private CategoryAxis x;

    @FXML
    private CategoryAxis y;

    @FXML
    LineChart<String, Number> lineChart;

    XYChart.Series algorithmOne = new XYChart.Series();
    XYChart.Series algorithmTwo = new XYChart.Series();



    public static void experimentalAnalysis1(int n, int trials, XYChart.Series series) {
        series.setName("Algorithm 1");
        System.out.println("<----------- Prefix Average 1 ----------->");
        for (int i = 0; i<trials; i++) {
            long startTime = System.currentTimeMillis();
            PrefixAverage.prefixAverage1(PrefixAverage.inputSize(n));
            long endTime = System.currentTimeMillis();
            long elapsed = endTime-startTime;
            System.out.println("Array with "+n+ " items took "+elapsed+" milliseconds");
            series.getData().add(new XYChart.Data<>(""+n, elapsed));
            n*=2;
        }
    }

    public static void experimentalAnalysis2(int n, int trials, XYChart.Series series) {
        series.setName("Algorithm 2");
        System.out.println("<----------- Prefix Average 2 ----------->");
        for (int i = 0; i<trials; i++) {
            long startTime = System.currentTimeMillis();
            PrefixAverage.prefixAverage2(PrefixAverage.inputSize(n));
            long endTime = System.currentTimeMillis();
            long elapsed = endTime-startTime;
            System.out.println("Array with "+n+ " items took "+elapsed+" milliseconds");
            series.getData().add(new XYChart.Data<>(""+n, elapsed));
            n*=2;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        experimentalAnalysis1(1000, 5, algorithmOne);
        experimentalAnalysis2(1000, 5, algorithmTwo);

        lineChart.getData().addAll(algorithmOne);
        lineChart.getData().addAll(algorithmTwo);

    }


//        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
//        series.getData().add(new XYChart.Data<>("Jan", 200));
//        series.getData().add(new XYChart.Data<>("Feb", 275));
//        series.getData().add(new XYChart.Data<>("Mar", 120));
//        series.getData().add(new XYChart.Data<>("Apr", 310));
//
//        lineChart.getData().add(series);




}



