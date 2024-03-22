class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean checkA = check(gcdA, arrayB);
        boolean checkB = check(gcdB, arrayA);
        
        if (checkA && checkB) {
            return Math.max(gcdA, gcdB);
        }
        
        if (checkA) return gcdA;
        if (checkB) return gcdB;
        
        return 0;
    }

    // 최대공약수(GCD)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    private boolean check(int gcd, int[] arr) {
        for (int num : arr) {
            if (num % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}