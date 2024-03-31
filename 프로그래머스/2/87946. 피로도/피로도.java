class Solution {
    private int answer;
    private boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        check = new boolean[n + 1];
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    private void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (check[i] || dungeons[i][0] > k) {
                continue;
            }
            
            check[i] = true;
            dfs(depth + 1, k - dungeons[i][1], dungeons);
            check[i] = false;
        }
        
        answer = Math.max(answer, depth);
    }
}