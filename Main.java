/*
Sources: Bubble, Selection, Insertion, Merge, Quicksort Sorting Implementations and Blurbs https://medium.com/@AlexanderObregon/introduction-to-sorting-algorithms-in-java-a-beginners-guide-db522047effb
*/

import java.util.Arrays;
import application.BubbleSort;
import application.Generator;
import application.InsertionSort;
import application.MergeSort;
import application.QuickSort;
import application.SelectionSort;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    @SuppressWarnings("rawtypes")
    XYChart barchart;
    Label bubbleSortLabel;
    Button bubbleSortButton;
    Label selectionSortLabel;
    Button selectionSortButton;
    Label insertionSortLabel;
    Button insertionSortButton;
    Label mergeSortLabel;
    Button mergeSortButton;
    Label quickSortLabel;
    Button quickSortButton;
    Label timSortLabel;
    Button timSortButton;
    Label blurbLabel;
    Button resetButton;
    TextField textBox;
    int[] array;
    @SuppressWarnings("unchecked")
    @Override public void start(Stage stage) {
        int numberOfValues = 4096;
        array = Generator.initialize(numberOfValues);
        barchart = Generator.makeGraph(array);

        bubbleSortLabel = new Label("Unsorted...");
        bubbleSortButton = new Button("Bubble Sort my data!");
        bubbleSortButton.setPrefWidth(200);
        bubbleSortButton.setOnAction(event -> {
            int[] bubbleArray = Arrays.copyOf(array, array.length); 
            BubbleSort bubble = new BubbleSort();
            long startTime = System.currentTimeMillis();
            bubbleArray = bubble.sort(bubbleArray);
            long endTime = System.currentTimeMillis();
            bubbleSortLabel.setText(endTime - startTime + "ms");
            bubbleSortButton.setDisable(true);
            blurbLabel.setText(bubble.blurb());
        });
        
        selectionSortLabel = new Label("Unsorted...");
        selectionSortButton = new Button("Selection Sort my data!");
        selectionSortButton.setPrefWidth(200);
        selectionSortButton.setOnAction(event -> {
            int[] selectionArray = Arrays.copyOf(array, array.length); 
            SelectionSort selection = new SelectionSort();
            long startTime = System.currentTimeMillis();
            selectionArray = selection.sort(selectionArray);
            long endTime = System.currentTimeMillis();
            selectionSortLabel.setText(endTime - startTime + "ms");
            selectionSortButton.setDisable(true);
            blurbLabel.setText(selection.blurb());
        });
        
        insertionSortLabel = new Label("Unsorted...");
        insertionSortButton = new Button("Insertion Sort my data!");
        insertionSortButton.setPrefWidth(200);
        insertionSortButton.setOnAction(event -> {
            int[] insertionArray = Arrays.copyOf(array, array.length); 
            InsertionSort insertion = new InsertionSort();
            long startTime = System.currentTimeMillis();
            insertionArray = insertion.sort(insertionArray);
            long endTime = System.currentTimeMillis();
            insertionSortLabel.setText(endTime - startTime + "ms");
            insertionSortButton.setDisable(true);
            blurbLabel.setText(insertion.blurb());
        });

        mergeSortLabel = new Label("Unsorted...");
        mergeSortButton = new Button("Merge Sort my data!");
        mergeSortButton.setPrefWidth(200);
        mergeSortButton.setOnAction(event -> {
            int[] mergeArray = Arrays.copyOf(array, array.length); 
            MergeSort merge = new MergeSort();
            long startTime = System.currentTimeMillis();
            mergeArray = merge.sort(mergeArray);
            long endTime = System.currentTimeMillis();
            mergeSortLabel.setText(endTime - startTime + "ms");
            mergeSortButton.setDisable(true);
            blurbLabel.setText(merge.blurb());
        });
        
        quickSortLabel = new Label("Unsorted...");
        quickSortButton = new Button("Quick Sort my data!");
        quickSortButton.setPrefWidth(200);
        quickSortButton.setOnAction(event -> {
            int[] quickArray = Arrays.copyOf(array, array.length); 
            QuickSort quick = new QuickSort();
            long startTime = System.currentTimeMillis();
            quickArray = quick.sort(quickArray);
            long endTime = System.currentTimeMillis();
            quickSortLabel.setText(endTime - startTime + "ms");
            quickSortButton.setDisable(true);
            blurbLabel.setText(quick.blurb());
        });
        
        timSortLabel = new Label("Unsorted...");
        timSortButton = new Button("TIM! Sort my data!");
        timSortButton.setPrefWidth(200);
        timSortButton.setOnAction(event -> {
            int[] timArray = Arrays.copyOf(array, array.length); 
            long startTime = System.currentTimeMillis();
            Arrays.sort(timArray);
            long endTime = System.currentTimeMillis();
            timSortLabel.setText(endTime - startTime + "ms");
            timSortButton.setDisable(true);
            blurbLabel.setText("Timsort is a hybrid, stable sorting algorithm, derived from merge sort and insertion sort, designed to perform well on many kinds of real-world data. It was implemented by Tim Peters in 2002 for use in the Python programming language. It has also been adopted by Java for its Arrays.sort method. Timsort is widely regarded as the fastest stable sorting algorithm.\n\nStable Sorting Algorithm: An algorithm that preserves the order of equivalent values");
        });

        blurbLabel = new Label("Click a sort button to get more information about the sorting algorithm!\nRemember that measuring sorting algorithms' efficiency by time elapsed is generally unreliable, especially at low sample sizes. Take time ratios with a grain of salt");
        blurbLabel.setWrapText(true);
        blurbLabel.setMaxWidth(400);
        blurbLabel.setFont(new Font(18));

        resetButton = new Button("Reset the sorting sandbox");
        resetButton.setPrefWidth(200);
        resetButton.setOnAction(event -> {
            array = Generator.initialize(numberOfValues);
            bubbleSortButton.setDisable(false);
            selectionSortButton.setDisable(false);
            insertionSortButton.setDisable(false);
            mergeSortButton.setDisable(false);
            quickSortButton.setDisable(false);
            timSortButton.setDisable(false);
            bubbleSortLabel.setText("Unsorted...");
            selectionSortLabel.setText("Unsorted...");
            insertionSortLabel.setText("Unsorted...");
            mergeSortLabel.setText("Unsorted...");
            quickSortLabel.setText("Unsorted...");
            timSortLabel.setText("Unsorted...");
            blurbLabel.setText("Click a sort button to get more information about the sorting algorithm!");
            barchart.getData().clear();
            barchart.getData().addAll(Generator.updateGraph(array));
        });

        HBox bubbleBox = new HBox(20, bubbleSortButton, bubbleSortLabel);
        HBox selectionBox = new HBox(20, selectionSortButton, selectionSortLabel);
        HBox insertionBox = new HBox(20, insertionSortButton, insertionSortLabel);
        HBox mergeBox = new HBox(20, mergeSortButton, mergeSortLabel);
        HBox quickBox = new HBox(20, quickSortButton, quickSortLabel);
        HBox timBox = new HBox(20, timSortButton, timSortLabel);
        VBox sortBox = new VBox(20, bubbleBox, selectionBox, insertionBox, mergeBox, quickBox, timBox, resetButton);
        VBox.setMargin(bubbleBox, new Insets(0,0,0,10));
        VBox.setMargin(selectionBox, new Insets(0,0,0,10));
        VBox.setMargin(insertionBox, new Insets(0,0,0,10));
        VBox.setMargin(mergeBox, new Insets(0,0,0,10));
        VBox.setMargin(quickBox, new Insets(0,0,0,10));
        VBox.setMargin(timBox, new Insets(0,0,0,10));
        VBox.setMargin(resetButton, new Insets(0,0,0,10));
        HBox sortPlusInfoBox = new HBox(100, sortBox, blurbLabel);
        VBox vbox = new VBox(barchart, sortPlusInfoBox);
        Scene scene  = new Scene(vbox, 800,800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}