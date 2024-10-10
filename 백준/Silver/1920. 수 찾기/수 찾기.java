import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(A, B);
    }

    public static void solution(int[] A, int[] B) {
        Arrays.sort(A);

        for (int value : B) {
            System.out.println(binarySearch(value, A));
        }
    }

    public static int binarySearch(int value, int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] < value) {
                l = mid + 1;
            }
            else if (arr[mid] > value) {
                r = mid - 1;
            }
            else return 1;
        }
        return 0;
    }
}