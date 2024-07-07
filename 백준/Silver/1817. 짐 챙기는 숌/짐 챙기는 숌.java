import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int box = 1; // 박스의 수
        int weight = 0; // 현재 박스의 무게
        
        for (int i = 0 ; i < n; i++){
            weight += arr[i];
            if (weight > m){
                box++;
                weight = arr[i];
            }
        }

        System.out.println(box);
        
    }
}