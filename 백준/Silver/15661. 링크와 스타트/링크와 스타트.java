import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int n;
    static int score = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, new ArrayList<>(), new ArrayList<>());
        System.out.println(score);
    }

    private static void go(int idx, List<Integer> start, List<Integer> link) {
        // todo 종료조건
        if (idx == n) {
            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < start.size()-1; i++) {
                for (int j = i+1; j < start.size(); j++) {
                    int A = start.get(i);
                    int B = start.get(j);
                    team1 += matrix[A][B];
                    team1 += matrix[B][A];
                }
            }

            for (int i = 0; i < link.size() - 1; i++) {
                for (int j = i+1; j < link.size(); j++) {
                    int C = link.get(i);
                    int D = link.get(j);
                    team2 += matrix[C][D];
                    team2 += matrix[D][C];
                }
            }

            if (Math.abs(team1-team2) < score) {
                score = Math.abs(team1-team2);
            }
            return;
        }

        start.add(idx);
        go(idx+1, start, link);
        start.remove(start.size()-1);

        link.add(idx);
        go(idx+1, start, link);
        link.remove(link.size()-1);
    }
}
