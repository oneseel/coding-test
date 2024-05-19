import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = Integer.toString(n, 2);
        System.out.println((int) Math.pow(2, s.length() - 1));
    }
}