package application;

import java.util.Random;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Generator {
    public static int[] initialize(int length) {
        int[] array = new int[length];    
        for(int i = 0; i < length; i++) {
            array[i] = i;
        }
        
        Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int swapIndex = rand.nextInt(length);
			int temp = array[swapIndex];
			array[swapIndex] = array[i];
			array[i] = temp;
		}
        return array;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static XYChart makeGraph(int[] array) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> barchart = new BarChart<String,Number>(xAxis,yAxis);
        barchart.setBarGap(0);
        barchart.setCategoryGap(0);
        barchart.getXAxis().setTickLabelsVisible(false);
        barchart.getXAxis().setOpacity(0);
        barchart.getYAxis().setTickLabelsVisible(false);
        barchart.getYAxis().setOpacity(0);
        barchart.setLegendVisible(false);
        XYChart.Series series = new XYChart.Series();
        for(int i = 0; i < array.length; i++) {
            series.getData().add(new XYChart.Data(Integer.toString(i), array[i]));
        }  
        barchart.getData().addAll(series);
        return barchart;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static XYChart.Series updateGraph(int[] array) {
        XYChart.Series series = new XYChart.Series();
        for(int i = 0; i < array.length; i++) {
            series.getData().add(new XYChart.Data(Integer.toString(i), array[i]));
        } 
        return series;
    }
}
