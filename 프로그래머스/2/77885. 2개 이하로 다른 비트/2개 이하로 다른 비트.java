class Solution {
  public long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      // 짝수
      if (numbers[i] % 2 == 0) {
        answer[i] = numbers[i] + 1;
        // 홀수
      } else {
        String s = Long.toString(numbers[i], 2);
        // 비트에 0이 있는지를 확인(0이 없다면 -1을 반환한다)
        int lastNum = s.lastIndexOf("0");
        // 0이 있는 경우
        if (lastNum != -1) {
          s = s.substring(0, lastNum) + "10" + s.substring(lastNum + 2, s.length());
          answer[i] = Long.parseLong(s, 2);
          // 전부 1인 경우
        } else {
          s = "10" + s.substring(1, s.length());
          answer[i] = Long.parseLong(s, 2);
        }
      }
    }

        return answer;
}
}