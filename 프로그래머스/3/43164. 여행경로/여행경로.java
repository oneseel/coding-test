import java.util.*;

class Solution {
    private static boolean[] visited; // 경로 방문 배열
    private static List<String> answer;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        // 티켓 정보를 정렬 (사전순으로 경로를 반환하기 위해)
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", "ICN", tickets, 0);
        
        return answer.get(0).split(" ");
    }
    
    private void dfs(String current, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            answer.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}