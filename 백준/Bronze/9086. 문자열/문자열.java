import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            System.out.println(first + "" + last);
        }

    }
}