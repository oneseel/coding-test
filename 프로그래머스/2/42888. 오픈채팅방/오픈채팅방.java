import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); // <아이디, 닉네임> 맵
        List<String> list = new ArrayList<>();

        for (String rec : record) {
            String[] temp = rec.split(" ");
            String command = temp[0];
            String uuid = temp[1];
            
            if (!command.equals("Leave")) {
                String nickname = temp[2];
                map.put(uuid, nickname);
            }
        }

        for (String rec : record) {
            String[] temp = rec.split(" ");
            String command = temp[0];
            String uuid = temp[1];
            
            if (command.equals("Enter")) {
                list.add(map.get(uuid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                list.add(map.get(uuid) + "님이 나갔습니다.");
            }
        }

        return list.toArray(new String[0]);
    }
}
