import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;
        
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        
        System.out.println(sum);
    }
}