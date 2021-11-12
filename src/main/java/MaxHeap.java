import java.util.Arrays;

public class MaxHeap {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int topDown(int[] arr) {
        int totalComparison = 0;
        for (int i = 2; i < arr.length - 1; i++) {
            totalComparison += topBuild(arr, i);
        }
        return totalComparison;
    }

    public int topBuild(int[] arr, int index) {
        int parent = index / 2;
        if (parent < 1) return 0;
        int comparison = 1;

        if (arr[parent] < arr[index]) {
            swap(arr, index, parent);

            return comparison + topBuild(arr, parent);
        }
        return comparison;
    }

    public int bottomUp(int[] arr) {
        int totalComparison = 0;
        for (int i = arr.length / 2; i > 0; i--) {
            totalComparison += bottomBuild(arr, i, arr.length - 1);
        }
        return totalComparison;
    }

    public int bottomBuild(int[] arr, int index, int range) {
        int targetChild = 2 * index;
        if (targetChild > range) return 0;
        int comparison = 1;
        int nextChild = 2 * index + 1;

        if (nextChild <= range) {
            comparison++;
            // Find maximum valued child
            if (arr[targetChild] < arr[nextChild])
                targetChild = nextChild;
        }

        if (arr[targetChild] > arr[index]) {
            swap(arr, index, targetChild);

            return comparison + bottomBuild(arr, targetChild, range);
        }
        return comparison;
    }

    public int heapSort(int[] arr) {
        int totalComparison = 0;
        for (int i = arr.length - 1; i > 1; i--) {
            swap(arr, 1, i);
            totalComparison += bottomBuild(arr, 1, i - 1);
        }
        return totalComparison;
    }

    public static void main(String[] args) {
        // Index starts 1, so assume it has empty item in zero index. So I added -99 at zero
        int[] dataset1 = {-99, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataset2 = {-99, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataset3 = {-99, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataset4 = {-99, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        int[] dataset1_top = {-99, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataset2_top = {-99, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataset3_top = {-99, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataset4_top = {-99, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};

        MaxHeap maxHeap = new MaxHeap();

        System.out.println("Dataset 1: " + Arrays.toString(dataset1));
        System.out.println("Dataset 2: " + Arrays.toString(dataset2));
        System.out.println("Dataset 3: " + Arrays.toString(dataset3));
        System.out.println("Dataset 4: " + Arrays.toString(dataset4));

        System.out.println("\nTop Down Heap Build:");
        System.out.println("comparisons:" + maxHeap.topDown(dataset1_top));
        System.out.println("after topDown: " + Arrays.toString(dataset1_top));
        System.out.println("comparisons:" + maxHeap.topDown(dataset2_top));
        System.out.println("after topDown: " + Arrays.toString(dataset2_top));
        System.out.println("comparisons:" + maxHeap.topDown(dataset3_top));
        System.out.println("after topDown: " + Arrays.toString(dataset3_top));
        System.out.println("comparisons:" + maxHeap.topDown(dataset4_top));
        System.out.println("after topDown: " + Arrays.toString(dataset4_top));

        System.out.println("\nBottom Up Heap Build:");
        System.out.println("comparisons: " + maxHeap.bottomUp(dataset1));
        System.out.println("after bottomUp: " + Arrays.toString(dataset1));
        System.out.println("comparisons: " + maxHeap.bottomUp(dataset2));
        System.out.println("after bottomUp: " + Arrays.toString(dataset2));
        System.out.println("comparisons: " + maxHeap.bottomUp(dataset3));
        System.out.println("after bottomUp: " + Arrays.toString(dataset3));
        System.out.println("comparisons: " + maxHeap.bottomUp(dataset4));
        System.out.println("after bottomUp: " + Arrays.toString(dataset4));

        System.out.println("\nHeap Sort:");
        System.out.println("comparisons: " + maxHeap.heapSort(dataset1));
        System.out.println("after heapSort: " + Arrays.toString(dataset1));
        System.out.println("comparisons: " + maxHeap.heapSort(dataset2));
        System.out.println("after heapSort: " + Arrays.toString(dataset2));
        System.out.println("comparisons: " + maxHeap.heapSort(dataset3));
        System.out.println("after heapSort: " + Arrays.toString(dataset3));
        System.out.println("comparisons: " + maxHeap.heapSort(dataset4));
        System.out.println("after heapSort: " + Arrays.toString(dataset4));
    }
}