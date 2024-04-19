import java.io.*;
import java.util.*;

class Main {
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (isNice(arr, n)) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }

    private static boolean isNice(int[] arr, int n) {
        int idx = 1;
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == idx) {
                result[idx - 1] = arr[i];
                idx++;
                
                while (!stack.isEmpty() && stack.peek() == idx) {
                    result[idx - 1] = stack.pop();
                    idx++;
                }
            } else {
                stack.push(arr[i]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (result[i] != i + 1) {
                return false;
            }
        }
        return true;
    }
}
