import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 오타 수정: StrintTokenizer -> StringTokenizer
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numberMap = new HashMap<>();
        
        // 맵에 포켓몬 이름과 번호를 저장
        for (int i = 0 ; i < n; i++) {
            String name = br.readLine();
            nameMap.put(name, i + 1);
            numberMap.put(i + 1, name);
        }
        
        // 문제(번호 => 이름, 이름 => 번호)
        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            if (Character.isDigit(quiz.charAt(0))) {
                int num = Integer.parseInt(quiz);
                System.out.println(numberMap.get(num));
            } else {
                System.out.println(nameMap.get(quiz));
            }
        }
    }
}
