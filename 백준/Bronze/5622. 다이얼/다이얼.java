import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0; // 걸린 시간
        
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (c == 'A' || c == 'B' || c == 'C') {
                sum += 3;
            } else if (c == 'D' || c == 'E' || c == 'F') {
                sum += 4;
            } else if (c == 'G' || c == 'H' || c == 'I') {
                sum += 5;
            } else if (c == 'J' || c == 'K' || c == 'L') {
                sum += 6;
            } else if (c == 'M' || c == 'N' || c == 'O') {
                sum += 7;
            } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                sum += 8;   
            } else if (c == 'T' || c == 'U' || c == 'V') {
                sum += 9;  
            } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                sum += 10;
            } 
        }
        System.out.println(sum);
    }
}