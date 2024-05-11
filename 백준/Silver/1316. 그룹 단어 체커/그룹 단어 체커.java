import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (check(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    private static boolean check(String s) {
        String[] arr = s.split("");
        String prev = "";
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(prev)) {
                continue;
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                prev = arr[i];
            }
        }
        
        for (int i : map.values()) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }
}