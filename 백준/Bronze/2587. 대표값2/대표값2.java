import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];
        int sum = 0;
        int mid = 0;
        
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }
        
        Arrays.sort(numbers);
        int avg = sum / 5;
        int m = numbers[2];
        
        System.out.println(avg);
        System.out.println(m);
    }
}