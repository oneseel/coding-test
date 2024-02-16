class Solution {
  public int solution(int n, int k) {
    int answer = 0;
    // n을 k진수로 바꾸기
    String result = Long.toString(n, k);
    String[] splitResult = result.split("0");

    for (String s : splitResult) {
      if (!s.isEmpty() && isPrime(Long.parseLong(s))) answer++;
    }

    return answer;
  }

  public boolean isPrime (long n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}