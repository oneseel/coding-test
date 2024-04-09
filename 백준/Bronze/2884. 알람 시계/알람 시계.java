import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if (M < 45) { 
            if (H == 0) { 
                H = 23;
            } else {
                H--;
            }
            M = M + 15;
        } else {
            M = M - 45;
        }
        System.out.println(H + " " + M);
    }
}