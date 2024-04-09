class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int l = 0;
        int r = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] <= r) {
                continue;
            }
            
            l = section[i];
            r = l + m - 1;
            answer++;
        }
        
        return answer;
    }
}