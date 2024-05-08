package application;

public class InsertionSort implements Sorting {
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String blurb() {
        return "Insertion Sort is a comparison-based algorithm that builds the sorted output one item at a time. It’s efficient for small data sets or data that is already partially sorted.";
    }
}