import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 과목 수
        int[] score = new int[N];
        int M = 0;
        double sum = 0;
        double avg;
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            M = Math.max(M, score[i]);
        }

        for (int i = 0; i < N; i++) {
            sum += (double) score[i] / M * 100;
        }
        avg = sum / N;

        System.out.println(avg);
    }
}
