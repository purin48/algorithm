import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스만큼 반복
        for(int i=0; i<T; i++) {
            // 2-1. 국가 수(N) & 비행기 종류(M) 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 비행기 종류의 노선 반복
            for(int j=0; j<M; j++) {
                br.readLine().split(" ");
            }

            // 2-2. 그냥 N 개의 국가를 다니는 비행기 루트는 항상 N-1 인 규칙..!
            System.out.println(N-1);
        }
    }
}