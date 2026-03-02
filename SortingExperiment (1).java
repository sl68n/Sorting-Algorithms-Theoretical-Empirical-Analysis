import java.util.*;

public class SortingExperiment {

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};

        for (int n : sizes) {
            System.out.println("\n========= Testing N = " + n + " =========");

            for (String type : new String[]{"Random", "Partially Sorted", "Nearly Sorted"}) {
                System.out.println(">> " + type);

                long insertionAvg = 0, mergeAvg = 0, quickAvg = 0;

                for (int run = 0; run < 5; run++) {
                    int[] original = generateArray(n);
                    int[] data = switch (type) {
                        case "Partially Sorted" -> generatePartiallySortedArray(original.clone());
                        case "Nearly Sorted" -> generateNearlySortedArray(original.clone());
                        default -> shuffleArray(original.clone());
                    };

                    int[] arr1 = data.clone();
                    int[] arr2 = data.clone();
                    int[] arr3 = data.clone();

                    insertionAvg += timeInsertionSort(arr1);
                    mergeAvg += timeMergeSort(arr2);
                    quickAvg += timeQuickSort(arr3);
                }

                System.out.println("Insertion Sort Avg: " + insertionAvg / 5 + " ns");
                System.out.println("Merge Sort Avg: " + mergeAvg / 5 + " ns");
                System.out.println("Quick Sort Avg: " + quickAvg / 5 + " ns");
                System.out.println();
            }
        }
    }




//Array Generators
    public static int[] generateArray(int n) {
        Random rand = new Random();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = rand.nextInt(999) + 1;
        }
        return A;
    }

    public static int[] shuffleArray(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int a : A) list.add(a);
        Collections.shuffle(list);
        for (int i = 0; i < A.length; i++) A[i] = list.get(i);
        return A;
    }

    public static int[] generatePartiallySortedArray(int[] A) {
        Arrays.sort(A, 0, A.length / 2);
        Arrays.sort(A, A.length / 2, A.length);
        return A;
    }

    public static int[] generateNearlySortedArray(int[] A) {
        Arrays.sort(A);
        Random rand = new Random();
        int swapCount = (int) (A.length * 0.05);
        for (int i = 0; i < swapCount; i++) {
            int x = rand.nextInt(A.length);
            int y = rand.nextInt(A.length);
            int temp = A[x];
            A[x] = A[y];
            A[y] = temp;
        }
        return A;
    }



//Calculating time
    public static long timeInsertionSort(int[] A) {
        long start = System.nanoTime();
        insertionSort(A);
        return System.nanoTime() - start;
    }

    public static long timeMergeSort(int[] A) {
        long start = System.nanoTime();
        mergeSort(A, 0, A.length - 1);
        return System.nanoTime() - start;
    }

    public static long timeQuickSort(int[] A) {
        long start = System.nanoTime();
        quickSort(A, 0, A.length - 1);
        return System.nanoTime() - start;
    }



//Insertion Sort
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }




//Merge Sort
    public static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    public static void merge(int[] A, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = A[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            A[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
    }




//Quick Sort with Random Pivot
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivotIndex = new Random().nextInt(high - low + 1) + low;
            int pivotValue = A[pivotIndex];
            swap(A, pivotIndex, high);
            int partitionIndex = partition(A, low, high, pivotValue);
            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] A, int low, int high, int pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, high);
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
