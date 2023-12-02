import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (binarySearch(arr, str)) count++;
        }
        System.out.println(count);
    }

    public static boolean binarySearch(String[] arr, String str) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;
            // arr[mid] < x
            if (arr[mid].compareTo(str) < 0)  {
                l = mid + 1;
            }

            // arr[mid] > x
            else if (arr[mid].compareTo(str) > 0) {
                r = mid - 1;
            }

            else {
                return true;
            }
        }
        return false;
    }
}
