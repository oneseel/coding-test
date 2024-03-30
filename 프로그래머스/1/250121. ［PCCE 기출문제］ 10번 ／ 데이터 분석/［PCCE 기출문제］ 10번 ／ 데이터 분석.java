import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        for (int[] datum : data) {
            int code = datum[0];
            int date = datum[1];
            int maximum = datum[2];
            int remain = datum[3];
            
            // 조건에 맞는 값을 리스트에 넣기
            switch (ext) {
                case "code":
                    if (val_ext > code) list.add(datum);
                    break;
                case "date":
                    if (val_ext > date) list.add(datum);
                    break;
                case "maximum":
                    if (val_ext > maximum) list.add(datum);
                    break;
                case "remain":
                    if (val_ext > remain) list.add(datum);
                    break;
            }
        }
        
        // 리스트 정렬
        switch (sort_by) {
            case "code":
                list.sort((o1, o2) -> o1[0] - o2[0]);
                break;
            case "date":
                list.sort((o1, o2) -> o1[1] - o2[1]);
                break;
            case "maximum":
                list.sort((o1, o2) -> o1[2] - o2[2]);
                break;
            case "remain":
                list.sort((o1, o2) -> o1[3] - o2[3]);
                break;
        }
        
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
