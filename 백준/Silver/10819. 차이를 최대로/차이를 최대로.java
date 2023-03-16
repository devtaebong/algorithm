import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        Arrays.sort(arr);

        int max = 0;
        do {
            int sum = 0;
            for (int i = 0; i < arr.length-1; i++) {
                sum += Math.abs(arr[i]-arr[i+1]);
            }
            if (max < sum) {
                max = sum;
            }
        } while (nextPermutation(arr));

        System.out.println(max);
    }


    private static boolean nextPermutation(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }

        if (i == 0) return false;

        int j = arr.length-1;
        while (arr[i-1] >= arr[j]) {
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

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
