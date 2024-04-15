import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dice = new int[3];
        int money = 0;
        
        for (int i = 0; i < 3; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        
        // 세 눈이 다를 경우
        if (dice[0] != dice[1] && dice[0] != dice[2] && dice[1] != dice[2]) {
            int max = Math.max(dice[0], Math.max(dice[1], dice[2]));
            money = max * 100;
        // 세 눈이 같은 경우
        } else if (dice[0] == dice[1] && dice[1] == dice[2]) {
            money = 10000 + dice[0] * 1000;
        // 두 눈이 같은 경우
        } else { 
            int temp = dice[0] == dice[1] ? dice[0] : (dice[0] == dice[2] ? dice[0] : dice[2]);
            money = 1000 + temp * 100;
        }
        System.out.println(money);
    }
}