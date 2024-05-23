import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] fileInfo = new String[files.length][3];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int numberStart = 0; // 숫자부분의 시작
            int numberEnd = 0; // 숫자부분의 끝
        
            // HEAD
            while (numberStart < file.length() && !Character.isDigit(file.charAt(numberStart))) {
                numberStart++;
            }
            fileInfo[i][0] = file.substring(0, numberStart);
            
            // NUMBER
            numberEnd = numberStart;
            while (numberEnd < file.length() && Character.isDigit(file.charAt(numberEnd))) {
                numberEnd++;
            }
            fileInfo[i][1] = file.substring(numberStart, numberEnd);
            
            // TAIL
            if (numberEnd < file.length()) {
                fileInfo[i][2] = file.substring(numberEnd);
            } else {
                fileInfo[i][2] = "";
            }
        }
        
        // 정렬
        Arrays.sort(fileInfo, (a, b) -> {
            int head = a[0].toLowerCase().compareTo(b[0].toLowerCase());
            if (head != 0) return head;
            
            int number = Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            return number;
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileInfo[i][0] + fileInfo[i][1] + fileInfo[i][2];
        }

        return answer;
    }
}