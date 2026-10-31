import java.util.Arrays;

public class task_1 {
    public static void main(String[] args) {
        int[] priorities = {5, 1, 3, 1, 5, 2, 4, 2, 2};
        System.out.println(Arrays.toString(priorities));
        countingSort(priorities);
        System.out.println(Arrays.toString(priorities));
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        int min = 1;
        int max = 5;
        int range = max - min + 1;
        int[] count = new int[range];

        for (int val : arr) {
            count[val - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i + min;
            }
        }
    }
}