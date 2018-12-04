import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    public static void sort(int[] ints){
        sort(ints, 0, ints.length - 1);
    }

    private static void sort(int[] numbers, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(numbers, left, right);

            sort(numbers, left, pivotIndex - 1);
            sort(numbers, pivotIndex +1 , right);

        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int partition(int[] numbers, int left, int right) {
        int leftScan = left; // Links auf das erste Element
        int rightScan = right; // Rechts auf das letzte Element
        int pivot = numbers[right]; // Wahl des Pivot-Elements

        while (leftScan < rightScan) {
            while (leftScan < rightScan && numbers[leftScan] < pivot) {
                leftScan++; // eins weiter nach rechts
            }
            while (leftScan < rightScan && numbers[rightScan] >= pivot) {
                rightScan--; // eins weiter nach links
            }
            if (leftScan < rightScan) { // Falls leftScan und rightScan sich noch
                // nicht kreuzen, dann Elemente tauschen
                swap(numbers, leftScan, rightScan);
            }
            // Ansonsten ist die Partition fertig
        }
        // Pivot-Element an die Nahtstelle bringen
        swap(numbers, leftScan, right);
        return leftScan; // Index der Nahtstelle ausliefern
    }

    public static void main(String[] args) {
        int[] arr = new Random().ints(2000, 0, 100).toArray();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        sort(arr);
        Arrays.sort(arr2);
        System.out.println(Arrays.equals(arr, arr2));

    }

}
