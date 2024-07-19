import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력
        String n = br.readLine();
        
        // 2. 자릿수를 배열로 변환, 해당 값을 Integer값으로 변환.
        String[] numbers = n.split("");
        Integer[] answer = new Integer[n.length()];
        
        for (int i = 0; i < n.length(); i++) {
            answer[i] = Integer.parseInt(numbers[i]);    
        }
        
        // 3. 내림차순 정렬
        Arrays.sort(answer, (o1, o2) -> o2 - o1);
        
        // 4. 출력
        StringBuilder sb = new StringBuilder();
        
        for (Integer i : answer) {
            sb.append(i + "");
        }
        
        System.out.println(sb.toString());
    }
}