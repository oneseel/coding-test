import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름
                String clothes = st.nextToken(); // 의상 종류
                map.put(clothes, map.getOrDefault(clothes, 0) + 1);
            }

            int result = 1;
            for (int value : map.values()) {
                result *= (value + 1); // 의상을 안 입는 경우 때문에 1만큼 더 해서 곱해준다.
            }
            
            System.out.println(result - 1); // 아무것도 입지 않는 경우 때문에 1만큼 빼준다.
        }
    }
}
