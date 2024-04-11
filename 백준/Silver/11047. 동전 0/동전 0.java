import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 목표 값
        
        List<Integer> coinList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K) { // K보다 작거나 같은 코인만 리스트에 넣어준다.
                coinList.add(coin);
            }
        }
        
        // 코인리스트를 내림차순으로 정렬
        coinList.sort((o1, o2) -> o2 - o1);
        
        int count = 0;
        
        for (int c : coinList) {
            count += K / c;
            K %= c;
            if (K == 0) {
                break;
            }
        }    
        
        System.out.println(count);
    }
}
