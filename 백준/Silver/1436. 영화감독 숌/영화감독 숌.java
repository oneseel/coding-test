import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int idx = 1;

        while(count != n) {
            String temp = Integer.toString(idx);
            if (temp.contains("666")) {
                count++;
            }
            idx++;
        }

        System.out.println(idx - 1);
    }
}