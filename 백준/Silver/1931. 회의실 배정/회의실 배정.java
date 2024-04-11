import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 회의 개수
        int[][] meetings = new int[N][2];
        
        for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
		}
        
        // 종료시간을 기준으로 정렬(같다면 시작시간 기준으로 정렬)
        Arrays.sort(meetings, (o1, o2) -> 
            (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]
        );
        
        int count = 0;
        int prev = 0;
        
        for(int i = 0; i < N; i++) {
			// 이전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 업데이트 
			if(prev <= meetings[i][0]) {
				prev = meetings[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
 
}