import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int result = abc(a, b, c);
        System.out.println(result);
    }
    
    private static int abc(int a, int b, int c) {
        if (a == 0) {
            return (c * c) - b;
        } else if (b == 0) {
            return (c * c) - a;
        } else {
            return (int) Math.sqrt(a + b);
        }
    }
}
