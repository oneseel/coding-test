import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        // 우박수열 만들기
        List<Integer> list = new ArrayList<>();
        
        while (k != 1) {
            list.add(k);
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = (k * 3) + 1;
            }
        }
        list.add(1);
        
        // 각 넓이 구하기
        List<Double> areaList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            double area = ((double) list.get(i) + (double) list.get(i + 1)) / 2.0;
            areaList.add(area);
        }
        
        // 부분구간 정적분 값 구하기
        double[] answer = new double[ranges.length];
        int n = list.size() - 1;
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            int start = a;
            int end = n + b;
            
            if (start > end) {
                answer[i] = -1.0;
                continue;
            }
            
            double sum = 0;
            for (int j = start; j < end; j++) {
                sum += areaList.get(j);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}