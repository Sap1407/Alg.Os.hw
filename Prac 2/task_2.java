import java.util.Arrays;

public class task_2 {
    public static void main(String[] args) {
        int[] serials = {123456, 654321, 111111, 9000, 1000, 99};
        System.out.println(Arrays.toString(serials));
        radixSort(serials);
        System.out.println(Arrays.toString(serials));
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;
        int max = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
        }

        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(arr, place);
        }
    }

    private static void countingSortByDigit(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}