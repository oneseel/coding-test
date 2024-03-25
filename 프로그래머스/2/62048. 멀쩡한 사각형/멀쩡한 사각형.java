class Solution {
    public long solution(int w, int h) {
        
        // 전체 격자의 개수
        long square = (long) w * (long) h;
        
        // 잘린 사각형의 개수
        long count = w + h - gcd(w, h);
        
        return square - count;
    }
    
    // 최대공약수
    private static long gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}