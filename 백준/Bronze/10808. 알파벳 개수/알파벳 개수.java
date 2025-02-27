import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 카운트
        int[] alphabet = new int[26];
        for (int i=0; i<26; i++) {
            alphabet[i] = 0;
        }

        // 단어 char 배열로 만들기
        char[] wordArr = br.readLine().toCharArray();

        // char 아스키코드 - 97(소문자 a) 를 idx
        for (char word : wordArr) {
            int idx = (int)word - 97;
            alphabet[idx]++;
        }

        // 출력
        for (int i=0; i<26; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}