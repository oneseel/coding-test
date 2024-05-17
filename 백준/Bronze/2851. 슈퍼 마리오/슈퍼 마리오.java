import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mushroom = new int[10];
        int sum = 0;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
            sum += mushroom[i];
            if (sum == 100) {
                result = sum;
                break;
            } else if (sum > 100) {
                int max = sum; // 100과 가장 가까운 큰 수
                int min = sum - mushroom[i]; // 100과 가장 가까운 작은 수
                // max와 min 중 어느 값이 100에 가까운지 확인한다(같은 경우에는 큰 값으로 한다.)
                result = max - 100 <= 100 - min ? max : min;
                break;
            }
        }
        // 10개의 버섯을 모두 먹었을 때, 100에 도달하지 못한 경우
        if (sum < 100) {
            result = sum;
        }
        
        System.out.println(result);
    }
}
