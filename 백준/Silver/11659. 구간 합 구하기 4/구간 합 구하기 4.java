import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] number = new int[N]; // 입력된 배열
        int[] prefixSum = new int[N]; // 부분합을 저장할 배열
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            if (i == 0) prefixSum[i] = number[i]; // 첫 번째 원소는 그대로 할당
            else prefixSum[i] = prefixSum[i - 1] + number[i]; // 이전까지의 합에 현재 값을 더함
        }
        
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int sum;
            
            // 시작 인덱스가 1인 경우, j까지의 합은 prefixSum[j - 1]과 같다
            if (i == 1) sum = prefixSum[j - 1]; 
            // 그렇지 않은 경우, i부터 j까지의 합은 prefixSum[j - 1]에서 prefixSum[i - 2]를 뺀 값과 같다
            else sum = prefixSum[j - 1] - prefixSum[i - 2]; 
            
            System.out.println(sum);
        }
    }
}
