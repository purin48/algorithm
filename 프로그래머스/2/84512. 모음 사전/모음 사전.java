import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static String VOWELS = "AEIOU";
    static List<String> dictionary = new ArrayList<>();

    // 모든 단어를 생성하는 함수
    private void generateWords(String currentWord) {
        // 사전의 단어 길이가 5 이상이 되면 종료
        if (currentWord.length() > 5) return;

        // 현재 단어를 사전에 추가
        dictionary.add(currentWord);

        // 각 모음에 대해 재귀 호출하여 단어를 생성
        for (int i = 0; i < VOWELS.length(); i++) {
            generateWords(currentWord + VOWELS.charAt(i));
        }
    }

    public int solution(String word) {
        // 사전 초기화 및 단어 생성 시작
        generateWords("");

        // 사전 리스트를 정렬
        Collections.sort(dictionary);

        // word의 위치를 찾고 1을 더해 반환
        return dictionary.indexOf(word);
    }
}
