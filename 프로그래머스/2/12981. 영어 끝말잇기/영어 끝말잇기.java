import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        // 초기값 넣어주기
        set.add(words[0]);
        
        // words 만큼 반복
        for(int i=1; i<words.length; i++) {
            
            String prev = words[i-1];
            String current = words[i];
            
            if(set.contains(current) || prev.charAt(prev.length()-1) != current.charAt(0)) {
                int num = (i%n)+1;
                int cnt = (i/n)+1;
                return answer = new int[]{num, cnt};
            }
            
            // 끝말잇기 조건 성립되는 지 확인
            set.add(current);
            
        }
        
        return answer;
    }
}