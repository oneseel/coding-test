import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 대소문자 구별 안하기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        String[] str1Arr = convertStr(str1);
        String[] str2Arr = convertStr(str2);
        
        List<String> list1 = new ArrayList<>(Arrays.asList(str1Arr));
        List<String> list2 = new ArrayList<>(Arrays.asList(str2Arr));

        int union = 0; // 합집합
        int intersection = 0; // 교집합
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection++;
            }
        }
        
        union = list1.size() + list2.size();
        
        if (intersection == 0 && union == 0) return 65536;
        
        double result = (double) intersection / (double) union * 65536;
        
        return (int) result;
    }
    
    private static String[] convertStr(String str) {
        List<String> list = new ArrayList<>();
        String[] strArr = str.split(""); 
    
        for (int i = 0; i < str.length() - 1; i++) {
            if (!strArr[i].matches("[a-z]") || !strArr[i + 1].matches("[a-z]")) {
              continue;
            } else {
                String temp = strArr[i] + strArr[i + 1];
                list.add(temp);
            }
        }
    
        return list.toArray(new String[list.size()]);
    }

}