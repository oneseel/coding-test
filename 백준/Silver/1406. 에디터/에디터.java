import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        
        for (char c : br.readLine().toCharArray()) {
            leftStack.push(c);
        }

        int m = Integer.parseInt(br.readLine()); // 명령어의 개수

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L': // 커서를 왼쪽으로 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D': // 커서를 오른쪽으로 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B': // 커서 왼쪽의 문자 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P': // 커서 위치에 문자 삽입
                    char c = command.charAt(2);
                    leftStack.push(c);
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
    }
}
