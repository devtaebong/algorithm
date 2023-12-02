import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(input[i]);
            boolean result = isExist(arr, x);

            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    // 집합에 x라는 값이 있는지?
    public static boolean isExist(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            }
            else if (arr[mid] > x) {
                r = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
