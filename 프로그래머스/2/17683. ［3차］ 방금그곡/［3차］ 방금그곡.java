import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = replaceSharp(m); // #변환
        int max = 0; // 최대 재생 시간
        String answer = "(None)";
        
        for (String musicinfo : musicinfos) {
            String[] part = musicinfo.split(",");
            String start = part[0]; // 시작시간
            String end = part[1]; // 끝시간
            String title = part[2]; // 제목
            String score = replaceSharp(part[3]); // 악보
            
            int playTime = timeConvert(end) - timeConvert(start); // 재생 시간
           
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < playTime; i++) {
                sb.append(score.charAt(i % score.length()));
            }
            
            if (sb.toString().contains(m)) {
                if (playTime > max) {
                    max = playTime;
                    answer = title;
                }
            }     
        }
        
        return answer;
    }
    
    private int timeConvert (String time) {
        String[] times = time.split(":");
        
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    private String replaceSharp (String m) {
        return m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("E#", "e")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }       
}