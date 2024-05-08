package application;

public class QuickSort implements Sorting {
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length -1);
        return arr;
    } 

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public String blurb() {
        return "Quicksort is another divide-and-conquer algorithm that works by selecting a ‘pivot’ element from the list and partitioning the other elements into two groups, according to whether they are less than or greater than the pivot. The sub-lists are then sorted recursively. Widely regarded as the fastest sorting algorithm.";
    }
}
