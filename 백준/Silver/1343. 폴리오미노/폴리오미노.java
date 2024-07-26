import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : board.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                // '.'를 만나기 전에 연속된 'X' 처리
                if (count % 2 != 0) {
                    System.out.println("-1");
                    return;
                } else {
                    sb.append("AAAA".repeat(count / 4));
                    sb.append("BB".repeat((count % 4) / 2));
                }
                sb.append(".");
                count = 0;
            }
        }

        // 보드가 'X'로 끝났을 때 마지막 처리
        if (count % 2 != 0) {
            System.out.println("-1");
            return;
        } else {
            sb.append("AAAA".repeat(count / 4));
            sb.append("BB".repeat((count % 4) / 2));
        }
        
        System.out.println(sb.toString());
    }
}
