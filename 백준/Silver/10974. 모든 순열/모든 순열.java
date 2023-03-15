
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        while (nextPermutation(arr)) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation(int[] arr) {
        // 1 3 5 4 2
        // 1 4 5 3 2
        // 1 4 2 3 5

        int i = arr.length-1;
        while (i > 0 && arr[i-1] > arr[i]) {
            i--;
        }

        if (i == 0) return false;

        int j = arr.length-1;
        while (arr[i-1] > arr[j]) {
            j--;
        }

        // 1 4 5 3 2
        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        // 1 4 2 3 5
        j = arr.length-1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
