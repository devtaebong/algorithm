import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // 입력
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ".";
            }
        }

        boolean[][] passHorizontal = new boolean[n][n]; // 가로
        boolean[][] passVertical = new boolean[n][n]; // 세로

        int x = 0;
        int y = 0;
        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);
            if (command == 'R') {
                if (y+1 < n) {
                    passHorizontal[x][y] = true;
                    passHorizontal[x][y+1] = true;
                    y++;
                }
            } else if (command == 'D') {
                if (x+1 < n) {
                    passVertical[x][y] = true;
                    passVertical[x+1][y] = true;
                    x++;
                }
            } else if (command == 'L') {
                if (y-1 >= 0) {
                    passHorizontal[x][y] = true;
                    passHorizontal[x][y-1] = true;
                    y--;
                }
            } else if (command == 'U') {
                if (x-1 >= 0) {
                    passVertical[x][y] = true;
                    passVertical[x-1][y] = true;
                    x--;
                }
            }
        }

        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (passVertical[i][j] && passHorizontal[i][j]) {
                    ans += "+";
                } else if (passVertical[i][j] && !passHorizontal[i][j]) {
                    ans += "|";
                } else if (passHorizontal[i][j] && !passVertical[i][j]) {
                    ans += "-";
                } else {
                    ans += ".";
                }
            }
            ans += "\n";
        }
        System.out.println(ans);
    }
}
