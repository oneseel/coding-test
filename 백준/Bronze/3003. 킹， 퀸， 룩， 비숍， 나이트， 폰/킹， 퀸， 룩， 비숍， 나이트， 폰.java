import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] black = {1, 1, 2, 2, 2, 8}; // 킹, 퀸, 룩, 비숍, 나이트, 폰
        int[] white = new int[6];
        int[] answer = new int[6];
        
        for (int i = 0; i < 6; i++) {
            white[i] = Integer.parseInt(st.nextToken());
            answer[i] = black[i] - white[i];
            
            System.out.print(answer[i] + " ");
        }
    }
}