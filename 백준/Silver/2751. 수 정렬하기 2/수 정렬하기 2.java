import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 정렬
        Collections.sort(list);

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}