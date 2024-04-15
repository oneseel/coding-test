import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken()); // 시
        int m = Integer.parseInt(st.nextToken()); // 분
        int c = Integer.parseInt(br.readLine()); // 요리시간
        
        int convertTime = (h * 60) + m + c;
        
        h = convertTime / 60 % 24;
        m = convertTime % 60;
        
        System.out.println(h + " " + m);
    }
}