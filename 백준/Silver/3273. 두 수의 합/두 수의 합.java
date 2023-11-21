import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
    1. 아이디어
    - a[i] + a[j] < x => count++
    - bool[] -> 입력값 저장
    - for -> bool[x - a[i]] == true => count += 1

    2. 시간복잡도
    O(N)

    3. 자료구조
    - int -> count
    - bool[]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        int a[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        boolean[] check = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            check[a[i]] = true;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int pairValue = x - a[i];
            if (0 <= pairValue && pairValue <= 1000000) {
                if (check[pairValue]) {
                    count++;
                }
            }
        }

        System.out.println(count/2);
    }
}
