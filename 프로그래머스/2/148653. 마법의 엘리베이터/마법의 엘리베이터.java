class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int temp = storey % 10;
            storey = storey / 10;

            if (temp > 5) {
                answer = answer + (10 - temp);
                storey++;
            } else if (temp == 5) {
                if (storey % 10 >= 5) {
                    answer = answer + (10 - temp);
                    storey++;
                } else {
                    answer = answer + temp;
                }
            }
            else {
                answer = answer + temp;
            }

        }
        return answer;
    }
}