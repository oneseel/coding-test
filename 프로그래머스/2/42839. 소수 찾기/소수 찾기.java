import java.util.*;

class Solution {
    static Set<String> set;
    static String[] arr;
    static boolean[] visit;
    
    public int solution(String numbers) {
        arr = numbers.split("");
        visit = new boolean[arr.length];
        set = new HashSet<>();
        
        makeNumber("", 0);
        
        Set<Integer> numSet = new HashSet<>();
        for (String number : set) {
            if(!number.equals(""))
                numSet.add(Integer.parseInt(number));
        }
        
        int answer = 0;
        for (int number : numSet) {
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
        
    // 만들 수 있는 숫자
    public void makeNumber (String number, int depth) {
        if (!number.equals("")) {
            set.add(number);
        }
        
        if (depth == arr.length) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                makeNumber(number + arr[i], depth + 1);
                visit[i] = false;
            }
        }
    }
    
    // 소수인지 확인
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    } 
}