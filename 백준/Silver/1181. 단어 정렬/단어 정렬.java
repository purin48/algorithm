import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        // 정렬: 길이 오름차순 -> 길이가 같으면 사전순
        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b); // 길이가 같으면 사전순
            }
            return a.length() - b.length(); // 길이 오름차순
        });

        // 중복 제거 및 출력 최적화
        StringBuilder sb = new StringBuilder();
        String prev = "";
        for (String str : arr) {
            // 이전 값과 다를 때만 추가
            if (!str.equals(prev)) {
                sb.append(str).append("\n");
                prev = str;
            }
        }
        System.out.print(sb);
    }
}