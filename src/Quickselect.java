
public class Quickselect {

	
	
	private static int quickselect(int[] numbers, int k) {
		int left = 0;
		int right = numbers.length - 1;
		while (right >= left) {
			int pivotIndex = partition(numbers, left, right);
			if (k == pivotIndex)
				return numbers[pivotIndex];
			else if (k < pivotIndex)
				right = pivotIndex - 1;
			else
				left = pivotIndex + 1;
		}
		return Integer.MIN_VALUE;
	}

	private static void swwap(int[] numbers, int i, int j) {
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
				swwap(numbers, leftScan, rightScan);
			}
			// Ansonsten ist die Partition fertig
		}
		// Pivot-Element an die Nahtstelle bringen
		swwap(numbers, leftScan, right);
		return leftScan; // Index der Nahtstelle ausliefern
	}

	// 4 1 3 2 5 6 7
}
