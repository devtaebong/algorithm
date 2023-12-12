import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        System.out.println(binarySearch(n));
    }

    public static long binarySearch(long n) {
        long res = 0;
        long l = 0;
        long r = n;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (Math.pow(mid, 2) >= n) {
                res = mid;
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return res;
    }
}
