class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int time = bandage[0]; // 기술의 시전시간
        int heal = bandage[1]; // 1초당 회복량
        int addHeal = bandage[2]; // 추가 회복량
        
        int currentTime = 0; // 현재시간
        int currentHealth = health; // 현재체력
        int success = 0; // 연속성공
        int i = 0;
        
        while (currentTime <= attacks[attacks.length - 1][0]) {
            
            // 붕대감기
            if (currentTime < attacks[i][0]) {
                if (health > currentHealth) {
                    currentTime++;
                    currentHealth += heal;
                    if (currentHealth > health) {
                        currentHealth = health;
                    }
                    success++;
                    // 연속성공
                    if (success == time) {
                        currentHealth += addHeal;
                        if (currentHealth > health) {
                        currentHealth = health;
                    }
                        success = 0;
                    }
                } else {
                    currentTime++;
                }
            
            // 공격을 받는 경우
            } else if (currentTime == attacks[i][0]) {
                currentHealth -= attacks[i][1];
                if (currentHealth <= 0) {
                    return -1;
                }
                i++;
                currentTime++;
                success = 0;
            }
        }
        
        return currentHealth;
    }
}