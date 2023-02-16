import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                if (sum - a - b == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);

                    for (int k = 2; k < arr.length; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}