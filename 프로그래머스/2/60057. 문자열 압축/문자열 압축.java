import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            String prev = "";
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j += i) {
                String curr = s.substring(j, Math.min(j + i, n));
                if (prev.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = curr;
                    count = 1;
                }
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            min = Math.min(min, sb.length());
        }

        return min;
    }
}
