import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] check = new boolean[MAX + 1]; // 에라토스테네스의 체
        List<Integer> prime = new ArrayList<>(); // 소수를 저장하는 배열
        check[0] = check[1] = true;

        for (int i = 2; i*i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }
            prime.add(i);

            for(int j = i+i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {

            if (n == 0) {
                break;
            }

            for (int i = 0; i < prime.size(); i++) {
                int p = prime.get(i);

                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n - p));
                    break;
                }
            }
            n = Integer.parseInt(br.readLine());
        }
    }
}