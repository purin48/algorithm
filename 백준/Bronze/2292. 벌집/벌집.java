import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1 -> ... -> N번의 방까지 가는 depth 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 6각형 최대값이 6의 배수씩 증가
        int max = 1;
        int multi = 0;
        int cnt = 1;
        while(N>max) {
            multi += 1;
            cnt += 1;
            max = max + (6 * multi);
        }
        System.out.println(cnt);
    }
}