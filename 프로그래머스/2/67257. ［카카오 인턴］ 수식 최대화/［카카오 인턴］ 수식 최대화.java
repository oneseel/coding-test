import java.util.*;

class Solution {
    public long solution(String expression) {
        List<String> list = new ArrayList<>();
        String[][] rank = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}};
    
        // 문자열 분리(숫자, 연산자)
        char[] temp = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char t : temp) {
            if (Character.isDigit(t)) {
                sb.append(t);
            } else {
                list.add(sb.toString());
                list.add(Character.toString(t));
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        
        long answer = 0;
        for (String[] r : rank) {
            List<String> copy = new ArrayList<>(list);
            for (String op : r) {
                int i = 0;
                while (i < copy.size()) {
                    if (copy.get(i).equals(op)) {
                        long a = Long.parseLong(copy.get(i-1));
                        long b = Long.parseLong(copy.get(i+1));
                        long result = 0;
                        switch (op) {
                            case "+":
                                result = a + b;
                                break;
                            case "-":
                                result = a - b;
                                break;
                            case "*":
                                result = a * b;
                                break;
                        }
                        
                        copy.set(i-1, String.valueOf(result));
                        copy.remove(i);
                        copy.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(copy.get(0))));
        }
        
        return answer;
    }
}
