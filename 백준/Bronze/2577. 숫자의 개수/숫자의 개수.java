import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3개 곱 total
        int total = 1;
        for(int i=0; i<3; i++) {
            total *= Integer.parseInt(br.readLine());
        }
        char[] totalSt = Integer.toString(total).toCharArray();

        // 0 ~ 9 숫자 카운트
        int[] numArr = new int[10];
        for (int i=0; i<10; i++) {
            numArr[i] = 0;
        }

        // Character.getNumericValue() :: char -> int 로 바꾸기
        for(char chNum : totalSt) {
            int idx = Character.getNumericValue(chNum);
            numArr[idx]++;
        }

        for(int i=0; i<10; i++) {
            System.out.println(numArr[i]);
        }
    }
}