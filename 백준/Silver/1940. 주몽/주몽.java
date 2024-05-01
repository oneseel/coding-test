import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int s = 0, e = n - 1, count = 0;
        
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum < m) {
                s++;
            } else if (sum > m) {
                e--;
            } else {
                count++;
                s++;
                e--;
            }
        }
        
        System.out.println(count);
    }
}
