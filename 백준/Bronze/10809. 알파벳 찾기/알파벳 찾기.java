import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String s = br.readLine();
        int[] count = new int[26];
        Arrays.fill(count, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int index = currentChar - 'a';
            if (count[index] == -1) {
                count[index] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
