import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        String reverseA = new StringBuilder(A).reverse().toString();
        String reverseB = new StringBuilder(B).reverse().toString();

        int a = Integer.parseInt(reverseA);
        int b = Integer.parseInt(reverseB);
        
        System.out.println(Math.max(a, b));
    }
}