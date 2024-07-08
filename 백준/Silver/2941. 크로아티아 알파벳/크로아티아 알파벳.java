import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String result = convert(s);

        System.out.println(result.length());

    }
    
    private static String convert(String s) {
        return s.replaceAll("c=", "A")
                .replaceAll("c-", "B")
                .replaceAll("dz=", "C")
                .replaceAll("d-", "D")   
                .replaceAll("lj", "E")   
                .replaceAll("nj", "F")   
                .replaceAll("s=", "G")   
                .replaceAll("z=", "H");        
    }
}