import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        
        int c = b % 10; // 일의 자리 값
        int d = (b / 10) % 10; // 십의 자리 값
        int e = b / 100; // 백의 자리 값

        System.out.println(a * c);
        System.out.println(a * d);
        System.out.println(a * e);
        System.out.println(a * b);
    }
}