import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] triangle = new int[3];
        
        for (int i = 0; i < 3; i++) {
            triangle[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬을 이용해 값이 작은 순으로 정렬
        Arrays.sort(triangle);
        
        // 삼각형의 변 중에서 가장 작은 두 변은 다른 변의 길이보다 크다.
        int a = triangle[0];
        int b = triangle[1];
        int c = triangle[2];
        
        // c의 길이가 두 변의 길이의 합보다 크거나 같다면 줄여줘야 한다.
        if (a + b <= c) {
            c = a + b - 1; 
        }
        
        System.out.println(a + b + c);

    }
}