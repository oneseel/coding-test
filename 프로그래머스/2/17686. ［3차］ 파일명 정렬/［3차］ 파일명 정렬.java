import java.util.*;

class Solution {
    public String[] solution(String[] files) {
    String[][] filesInfo = new String[files.length][3];

    for (int i = 0; i < files.length; i++) {
        String file = files[i];
        int numberStart = 0;
        int numberEnd = 0;

        // HEAD
        while (numberStart < file.length() && !Character.isDigit(file.charAt(numberStart))) {
            numberStart++;
        }
        filesInfo[i][0] = file.substring(0, numberStart);

        // NUMBER
        numberEnd = numberStart;
        while (numberEnd < file.length() && Character.isDigit(file.charAt(numberEnd))) {
            numberEnd++;
        }
        filesInfo[i][1] = file.substring(numberStart, numberEnd);

        // TAIL
        if (numberEnd < file.length()) {
            filesInfo[i][2] = file.substring(numberEnd);
        } else {
            filesInfo[i][2] = "";
        }
    }

    // 정렬
    Arrays.sort(filesInfo, (a, b) -> {
        int head = a[0].toLowerCase().compareTo(b[0].toLowerCase());
        if (head != 0) return head;

        int number = Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
        return number;
    });

    String[] answer = new String[files.length];
    for (int i = 0; i < files.length; i++) {
        answer[i] = filesInfo[i][0] + filesInfo[i][1] + filesInfo[i][2];
    }

    return answer;
    }
}