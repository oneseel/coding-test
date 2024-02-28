import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        
        // int 배열을 String 배열로 바꾸기
        for(int i = 0; i < numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순으로 정렬
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (strArr[0].equals("0")) {
            return "0";
        }
        
        // 정렬된 배열의 값을 더해준다.
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}