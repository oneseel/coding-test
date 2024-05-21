import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int max = 0; // 접두사의 최대 길이
        String s = "";
        String t = "";

        for (int i = 0; i < n; i++) {
            String current = words[i]; // 현재 단어
            for (int j = i + 1; j < n; j++) {
                String next = words[j]; // 다음 단어
                int temp = getPrefixLength(current, next);

                if (temp > max) {
                    max = temp;
                    s = current;
                    t = next;
                }
            }
        }

        System.out.println(s);
        System.out.println(t);

    }

    // 접두사의 길이를 구하는 메서드
    private static int getPrefixLength(String current, String next) {
        int length = Math.min(current.length(), next.length());

        for (int i = 0; i < length; i++) {
            if (current.charAt(i) != next.charAt(i)) {
                return i;
            }
        }

        return length;
    }
}
