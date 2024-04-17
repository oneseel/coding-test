import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num % 42;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        System.out.println(set.size());
    }
}