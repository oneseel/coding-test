import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        
        ArrayList<Integer> list = new ArrayList<>();
        for (String a : arr) {
            for (String num : a.split(",")) {
                int n = Integer.parseInt(num);
                if (!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
