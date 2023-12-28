import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[] arr;
    static int[] res;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String readLine = br.readLine();
            if (readLine.equals("0")) break;
            int[] input = Arrays.stream(readLine.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = input[0];
            arr = new int[n];
            check = new boolean[n];

            for (int i = 1; i < n + 1; i++) {
                arr[i - 1] = input[i];
            }

            solve(0 ,0);
            System.out.println();
        }
    }

    public static void solve(int index, int count) {
        if (count == 6) {
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = index; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                solve(i + 1, count + 1);
                check[i] = false;
            }
        }
    }
}
