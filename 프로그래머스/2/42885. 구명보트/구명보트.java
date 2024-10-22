import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 가볍 + 무겁 짝지어서 보트에 태우기
        int light = 0;                 // 가벼운 사람 idx(앞에서부터)
        int heavy = people.length - 1; // 무거운 사람 idx(뒤에서부터)
        int boat = 0;                  // 보트 개수
        
        while(light <= heavy) {
            // (가장 가벼운 사람 + 가장 무거운 사람) 의 합이 limit 보다 작거나 같으면
            if(people[light] + people[heavy] <= limit) {
                // 가벼운 사람도 태움(가벼운 사람 태웠으니까 light값 +1)
                light += 1;
            }
            
            // 무거운 사람은 일단 태우기
            heavy -= 1;
            boat += 1;
        }
        
        return boat;
    }
}