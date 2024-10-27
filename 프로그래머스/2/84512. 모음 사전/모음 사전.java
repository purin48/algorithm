public class Solution {
    public int solution(String word) {
        // 1. 각 자리에서 사용되는 알파벳의 배열 정의
        String vowels = "AEIOU";

        // 2. 각 자리의 가중치(해당 자리의 문자가 바뀔 때마다 이동하는 인덱스 수)
        int[] weights = {781, 156, 31, 6, 1};

        int index = 0; // 3. 최종 인덱스를 저장할 변수 선언

        // 4. 단어의 각 문자별로 해당 문자의 위치를 계산
        for (int i = 0; i < word.length(); i++) {
            // 5. 현재 문자의 인덱스를 모음 배열에서 찾음
            int charIndex = vowels.indexOf(word.charAt(i));

            // 6. 각 자리에 해당하는 가중치를 곱하여 인덱스 증가
            // 현재 자리의 문자가 바뀔 때마다 이동하는 수(가중치)만큼 곱해주고, 1을 더해줘서 현재 위치를 포함
            index += charIndex * weights[i] + 1; 
        }

        return index; // 7. 최종 계산된 인덱스를 반환
    }
}
