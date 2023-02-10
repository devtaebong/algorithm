import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // System.setIn(new FileInputStream("src/BOJ/input.txt"));
        Scanner sc = new Scanner(System.in);

        int n;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n) {
        int result = 1 % n;

        for (int i = 1; i < n+1; i++) {
            /*
            1 % 7 = 1
            11 % 7 = (1 * 10 + 1) % 7 = (1 % 7 * 10 + 1) % 7 = 4
            111 % 7 = (11 * 10 + 1) % 7 = (4 * 10 + 1) % 7 = 6
             */
            if (result % n == 0) {
                return i;
            }
            result = (result * 10 +1) % n;
        }
        return n;
    }
}