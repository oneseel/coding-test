import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        boolean b = true;
        
        for (int i = 0 ; i < n; i++) {
            int temp = arr[i];
            if (temp >= idx) {
                while (temp >= idx) {
                    stack.push(idx++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int top = stack.pop();
                if (top > temp) {
                    System.out.println("NO");
                    b = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        
        if (b) System.out.print(sb.toString());
    }
}