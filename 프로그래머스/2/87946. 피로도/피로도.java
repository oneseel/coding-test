class Solution {
  public int solution(int k, int[][] dungeons) {
    int answer = 0;
    boolean[] visited = new boolean[dungeons.length];
    answer = dfs(0, k, dungeons, visited);
    return answer;
  }

  public int dfs(int count, int k, int[][] dungeons, boolean[] visited) {
    int max = count; // 방문할 경우의 수 중 최대값
    for (int i = 0; i < dungeons.length; i++) {
      // 방문했거나 최소필요피로도가 k보다 클 경우 continue
      if (visited[i] || k < dungeons[i][0]) continue;
      visited[i] = true;
      int temp = dfs(count + 1, k - dungeons[i][1], dungeons, visited);
      max = Math.max(max, temp);
      visited[i] = false;
    }
    return max;
  }
}