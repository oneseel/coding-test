import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            // 두 원의 중심 사이의 거리
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            
            // 두 원이 동일한 경우
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append('\n');
            }
            // 두 원의 중심이 같고 반지름이 다른 경우 (접하지 않음)
            else if(x1 == x2 && y1 == y2 && r1 != r2) {
                sb.append(0).append('\n');
            }
            // 두 원이 외접하거나 내접하는 경우
            else if(distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                sb.append(1).append('\n');
            }
            // 두 원이 서로 다른 두 점에서 만나는 경우
            else if(distance < r1 + r2 && distance > Math.abs(r1 - r2)) {
                sb.append(2).append('\n');
            }
            // 그 외의 경우 (접하지 않음)
            else {
                sb.append(0).append('\n');
            }
        }
        
        System.out.println(sb);
    }
}
