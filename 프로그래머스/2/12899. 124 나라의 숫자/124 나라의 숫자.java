class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            int temp = n % 3;
            n = n / 3 - (temp == 0 ? 1 : 0);
            answer = numbers[temp] + answer;
        }

        return answer;
    }
}
