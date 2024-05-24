import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absCompare = Math.abs(o1) - Math.abs(o2);
            if (absCompare == 0) return o1 - o2;
            else return absCompare;
        });
                                                        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                 pq.offer(arr[i]);
            } else {
                if (pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}