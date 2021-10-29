import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThirdLargest {
    List<Integer> list;

    public ThirdLargest() {
        this.list = new ArrayList<Integer>();
    }

    public int[] GenerateNumbers(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(99999/*random number range*/);
        }
        return arr;
    }

    public int thirdLargestByThreeLoops(int[] arr) {
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[firstIdx]) {
                firstIdx = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != firstIdx && arr[i] > arr[secondIdx]) {
                secondIdx = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != firstIdx && i != secondIdx && arr[i] > arr[thirdIdx]) {
                thirdIdx = i;
            }
        }

        return arr[thirdIdx];
    }

    public static void main(String[] args) {
        long start;
        long finish;
        ThirdLargest thirdLargest = new ThirdLargest();

        for (int i = 1000; i <= 10000; i += 1000) {
            int[] arr = thirdLargest.GenerateNumbers(i);

            start = System.nanoTime();
            thirdLargest.thirdLargestByThreeLoops(arr);
            finish = System.nanoTime();
            System.out.println(i + "," + (finish - start));
        }
    }
}
