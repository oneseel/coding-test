import java.util.ArrayList;
import java.util.List;

class Solution {

  public int[] solution(int[] answers) {
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    
    int[] supoja1Pattern = {1, 2, 3, 4, 5};
    int[] supoja2Pattern = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] supoja3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    // 각 수포자가 맞춘 개수 계산
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == supoja1Pattern[i % supoja1Pattern.length]) count1++;
      if (answers[i] == supoja2Pattern[i % supoja2Pattern.length]) count2++;
      if (answers[i] == supoja3Pattern[i % supoja3Pattern.length]) count3++;
    }

    int maxCount = Math.max(count1, Math.max(count2, count3));
      
    List<Integer> result = new ArrayList<>();

    if (maxCount == count1) result.add(1);
    if (maxCount == count2) result.add(2);
    if (maxCount == count3) result.add(3);

    return result.stream().mapToInt(i -> i).toArray();
  }
}
