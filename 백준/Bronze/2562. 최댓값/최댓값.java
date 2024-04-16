import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int max = Integer.MIN_VALUE;
        int idx = 0;
        
        for (int i = 0; i < 9; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i + 1;
                }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}