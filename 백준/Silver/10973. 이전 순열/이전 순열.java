
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

        if(!prePermutation(arr)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static boolean prePermutation(int[] arr) {
        // 7 2 5 1 3 4 6
        // 7 2 4 1 3 5 6
        // 7 2 4 6 5 3 1

        int i = arr.length-1;
        while (i > 0 && arr[i-1] < arr[i]) {
            i--;
        }

        if (i == 0) return false;

        int j = arr.length-1;
        while (arr[i-1] < arr[j]) {
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
