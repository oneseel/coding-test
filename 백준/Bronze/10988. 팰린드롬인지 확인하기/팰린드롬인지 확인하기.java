import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String s = bf.readLine();
        
        if (isPalindrome(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        return s.equals(sb.append(s).reverse().toString());
    }
}
