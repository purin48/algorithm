import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];

        // 입력 숫자들을 쪼개서 각 숫자 카운트
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            int num = c - '0';
            count[num]++;
        }

        // 6과 9는 같은 숫자로 취급 (합쳐서 처리)
        int sixNine = count[6] + count[9];
        count[6] = (sixNine + 1) / 2; // 올림
        count[9] = 0; // 9는 더 이상 필요 없음

        // 가장 많이 필요한 숫자가 세트의 개수
        int max = 0;
        for (int i = 0; i < 9; i++) { // 0~8까지 (9는 이미 처리됨)
            if (count[i] > max) {
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
