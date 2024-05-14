import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        List<String> list = new ArrayList<>();
        
        int idx = 0;
        while (list.size() < t * m) {
            String temp = Integer.toString(idx, n);
            String[] arr = temp.split("");
            for (String s : arr) {
                list.add(s.toUpperCase());
            }
            idx++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = p - 1; i < t * m; i += m) {
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}
