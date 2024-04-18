class Solution {
    static int[] answer = {-1};
    static int[] ryan;
    static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        bt(info, 1, n);
        return answer;
    }

    private void bt(int[] apeach, int count, int arrows) {
        if (count == arrows + 1) {
            int apeachScore = 0;
            int ryanScore = 0;
            for (int i = 0; i <= 10; i++) {
                if (apeach[i] != 0 || ryan[i] != 0) {
                    if (apeach[i] < ryan[i]) ryanScore += 10 - i;
                    else apeachScore += 10 - i;
                }
            }
            if (ryanScore > apeachScore && ryanScore - apeachScore >= maxDiff) {
                answer = ryan.clone();
                maxDiff = ryanScore - apeachScore;
            }
            return;
        }
        for (int j = 0; j <= 10 && ryan[j] <= apeach[j]; j++) {
            ryan[j]++;
            bt(apeach, count + 1, arrows);
            ryan[j]--;
        }
    }
}
