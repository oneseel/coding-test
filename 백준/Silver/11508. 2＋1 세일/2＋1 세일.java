import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(integerArr, Comparator.reverseOrder());

        int sum = 0;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            temp++;
            if (temp < 3) {
                sum += integerArr[i];
            } else {
                temp = 0;
            }
        }

        System.out.println(sum);
    }
}
