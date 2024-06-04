import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 가중치 오름차순
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        // 현재 노드의 부모를 자기자신으로 함
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int cost = 0; // 최소비용
        
        for (int i = 0; i < costs.length; i++) {
            // 두 섬의 부모노드가 같은지를 확인(같다면 사이클이기 때문에 다를 경우만 계산)
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                cost += costs[i][2];
                // 두 섬이 연결되었기 때문에 부모노드를 하나로 합친다.
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return cost;
    }
    
    // 부모노드를 찾는 메서드
    private int find (int[] parent, int i) {
        if (parent[i] == i) return i;
        return find(parent, parent[i]);
    }
    
    // 부모노드를 합치는 메서드
    private void union (int[] parent, int a, int b) {
        int aParent = find (parent, a);
        int bParent = find (parent, b);
        
        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }
}