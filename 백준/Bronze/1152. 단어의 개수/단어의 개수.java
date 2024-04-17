import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            String[] arr = s.split(" ");
            System.out.println(arr.length);
        }
    }
}
