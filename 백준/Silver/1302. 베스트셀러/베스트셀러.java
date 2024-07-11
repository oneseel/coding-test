import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > max) max = map.get(key);
        }
        
        TreeSet<String> set = new TreeSet<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                set.add(key);
            }
        }
        
        for (String s : set) {
            System.out.println(s);
            break;
        }
    }
}
