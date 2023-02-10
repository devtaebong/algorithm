class Solution {
    public int solution(String before, String after) {
        
        int beforeResult = 0;
        for(int i = 0; i < before.length(); i++) {
            int beforeNum = before.charAt(i) - 0;
            beforeResult += beforeNum;
        }
        
        int afterResult = 0;
        for(int i = 0; i < after.length(); i++) {
            int afterNum = after.charAt(i) - 0;
            afterResult += afterNum;
        }
        
        if (beforeResult == afterResult) {
            return 1;
        }
        return 0;
    }
}