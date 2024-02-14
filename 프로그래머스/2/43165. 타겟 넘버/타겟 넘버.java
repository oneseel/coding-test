class Solution {

  static int answer;

  public int solution(int[] numbers, int target) {
    answer = 0;
    dfs(numbers, target, numbers[0], 0);
    dfs(numbers, target, -numbers[0], 0);
    return answer;
  }

  private static void dfs(int[] numbers, int target, int sum, int idx) {
      if (idx == numbers.length - 1) {
        if (sum == target) {
          answer++;
        }
        return;
      }

    dfs(numbers, target, sum + numbers[idx + 1], idx + 1);
    dfs(numbers, target, sum - numbers[idx + 1], idx + 1);
  }
}