import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] avg = new int[n];
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            avg[i] = score[i][0] + score[i][1];
        }
        
        int cnt = 1;
        while(cnt <= n) {
            int max = 0;
            for(int i = 0; i < n; i++) {
                if(max < avg[i]) {
                    max = avg[i];
                }
            }
            
            int a = 0;
            for (int i = 0; i < n; i++) {
                if(avg[i] == max) {
                    a++;
                    ans[i] = cnt;
                    avg[i] = -1;
                }
            }
            
            cnt += a;
        }
    
        return ans;
    }
}