import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        
        // 1. 알파벳 사전 추가
        for(int i=0; i<26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        // 2. 문자열 잘라서 dictionary에 있는지 확인하기 / 없으면 추가하기
        List<Integer> output = new ArrayList<>(); // 색인번호 배열
        String w = ""; // 가장 긴 문자열
        
        for(char c : msg.toCharArray()) {
            // 새로운 글자
            String wc = w + c;
            
            // 2-1. dictionary에 wc가 있는 경우
            if(dictionary.containsKey(wc)) {
                w = wc;
            } else {
                // 2-2. dictionary에 wc가 없는 경우
                
                // 색인번호 출력
                output.add(dictionary.get(w));
                
                // 새로운 글자 등록
                dictionary.put(wc, dictionary.size() + 1);
                
                // w를 c로 초기화 => 다음단계로
                w = String.valueOf(c);
            }
            
        }
        
        // 3. 처리되지 X 글자
        if (!w.isEmpty()) {
            output.add(dictionary.get(w));
        }
        
        int[] answer = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            answer[i] = output.get(i);
        }
        return answer;
    }
}