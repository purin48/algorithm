import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> maraMap = new HashMap<>();
        
        // hashmap 에 이름을 key, 동명이인 고려해서 카운트를 value 값으로
        for(String comp : completion) {
            if(maraMap.containsKey(comp)) {
                maraMap.replace(comp , (maraMap.get(comp)) + 1);
            } else {
                maraMap.put(comp, 1);
            }
        }
        
        // participant 에 해당하는 이름에 대한 카운트 -1 해주기(0값이 아닌 경우에만)
        // 만약 해당 조건이 충족되지 않는 경우 return
        for(String part : participant) {
            if(maraMap.containsKey(part) && maraMap.get(part) != 0) {
                maraMap.replace(part , (maraMap.get(part)) - 1);
            } else {
                answer = part;
            }
        }
        return answer;
    }
}