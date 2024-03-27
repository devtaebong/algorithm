import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        System.out.println(Arrays.toString(arr));
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        String answer = min + " " + max;
        
        return answer;
    }
}