/*
1
2  9
3  10  8
4  5   6  7 

n = 6
1
2 15
3 16 14
4 17 21 13
5 18 19 20  12
6  7  8  9  10  11

가로방향으로 변경하는 경우: matrix[r][c + 1];
왼대각으로 변경하는 경우: matrix[r - 1][c - 1];
아래방향으로 변경 하는 경우: matrix[r + 1][c]
*/

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int[][] matrix = new int[n][n];
        
        int r = -1;
        int c = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                
                // 아래방향
                if (i % 3 == 0) {
                    r++;
                }
                
                // 가로방향
                else if (i % 3 == 1) {
                    c++;
                }
                
                // 대각위로 방향 변경
                else if (i % 3 == 2) {
                    r--;
                    c--;
                }
                
                matrix[r][c] = num++;
            }
        }
        
        int k = 0;
        for (int i = 1 ; i <= n; i++) {
            k += i;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    list.add(matrix[i][j]);
                }
            }
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}