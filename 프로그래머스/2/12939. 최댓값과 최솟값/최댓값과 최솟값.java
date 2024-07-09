import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }
        
        String answer = min + ""  + " " + max;
        
        return answer;
    }
}