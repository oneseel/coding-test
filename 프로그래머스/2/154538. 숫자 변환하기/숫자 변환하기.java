import java.util.*;

class Solution {
  public int solution(int x, int y, int n) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visit = new HashSet<>();
    queue.add(x);
    visit.add(x);
      
    if (x == y) return 0;

    while (!queue.isEmpty()) {
      answer++;
      int width = queue.size();
      for (int i = 0; i < width; i++) {
        int temp = queue.poll();

        int[] nextSteps = {temp + n, temp * 2, temp * 3};
        for (int nextStep : nextSteps) {
          if (!visit.contains(nextStep)) {
            if (nextStep == y) {
              return answer;
            } else if (nextStep < y) {
              queue.add(nextStep);
              visit.add(nextStep);
            }
          }
        }
      }
    }
    return -1;
  }
}