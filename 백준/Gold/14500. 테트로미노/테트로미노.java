import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // N x M 인 종이 위에 테트로미노를 하나 놓고 쓰여있는 수들의 합을 최대로 하는 프로그램
        // 테트로미노 회전이나 대칭 가능
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = x;
            }
        }

        int answer = solution(board);
        System.out.println(answer);
    }

    private static int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                /*
                ㅁㅁㅁㅁ
                 */
                if (j+3 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁ
                ㅁ
                ㅁ
                ㅁ
                 */
                if (i+3 < board.length) {
                    int temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁ
                ㅁㅁ
                 */
                if (i+1 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁ
                ㅁ
                ㅁㅁ
                 */
                if ((i+2 < board.length) && (j+1 < board[i].length)) {
                    int temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                    ㅁ
                ㅁㅁㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁ
                  ㅁ
                  ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁㅁ
                ㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i][j] + board[i+1][j] + board[i][j+1] + board[i][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                  ㅁ
                  ㅁ
                ㅁㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i+2][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁㅁ
                    ㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁ
                ㅁ
                ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁ
                ㅁㅁㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁ
                ㅁㅁ
                  ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                  ㅁㅁ
                ㅁㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i+1][j] + board[i+1][j+1] + board[i][j+1] + board[i][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                  ㅁ
                ㅁㅁ
                ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j+1] + board[i+1][j+1] + board[i+1][j] + board[i+2][j];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁ
                  ㅁㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁ
                ㅁㅁ
                ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                ㅁㅁㅁ
                  ㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                  ㅁ
                ㅁㅁ
                  ㅁ
                 */
                if (i+2 < board.length && j+1 < board[i].length) {
                    int temp = board[i+1][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
                    if (temp > answer) {
                        answer = temp;
                    }
                }

                /*
                  ㅁ
                ㅁㅁㅁ
                 */
                if (i+1 < board.length && j+2 < board[i].length) {
                    int temp = board[i+1][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
                    if (temp > answer) {
                        answer = temp;
                    }
                }
            }
        }

        return answer;
    }
}
