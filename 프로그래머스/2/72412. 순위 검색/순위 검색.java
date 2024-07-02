import java.util.*;
 
class Solution {
    private Map<String, List<Integer>> map;
 
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, List<Integer>>();
 
        for (int i = 0; i < info.length; i++) {
            String[] arr = info[i].split(" ");
            check(arr, "", 0);
        }
 
        for (String key : map.keySet())
            Collections.sort(map.get(key));
 
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] arr = query[i].split(" ");
            answer[i] = map.containsKey(arr[0]) ? binarySearch(arr[0], Integer.parseInt(arr[1])) : 0;
        }
 
        return answer;
    }
 
    // 이분 탐색
    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }
 
    // 가능한 경우의 수
    private void check(String[] arr, String str, int count) {
        if (count == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        check(arr, str + "-", count + 1);
        check(arr, str + arr[count], count + 1);
    }
}