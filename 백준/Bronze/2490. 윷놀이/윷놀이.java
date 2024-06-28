import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 3; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    count++;
                }
            }
            System.out.println(check(count));
        }

    }
    private static String check(int count) {
        if (count == 0) return "D";
        else if (count == 1) return "C";
        else if (count == 2) return "B";
        else if (count == 3) return "A";
        return "E";
    }
}