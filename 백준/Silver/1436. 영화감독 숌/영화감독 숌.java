import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 0;
        while(true) {
            // 숫자에 "666" 포함 확인
            if(Integer.toString(num).contains("666")) {
                cnt += 1;
            }

            // 카운터가 N에 도달하면 출력
            if(cnt == N) {
                System.out.println(num);
                break;
            }

            // 브루트포스 : 1씩 증가시키기
            num += 1;
        }
    }
}