import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cardArr = new int[N];

        // que 생성
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // N장 만큼 숫자 반복해서 카드배열 만들기
        for(int i=1; i<=N; i++) {
            deque.addLast(i);
        }

        // (버린 카드 + 마지막 카드) 출력할 answer 생성
        StringBuilder answer = new StringBuilder();

        // 2. 카드가 1장 남을때까지 반복
        while (deque.size() > 1) {
            // 2-1. 제일 위에 있는 카드 버리기(pollFirst)
            answer.append(deque.pollFirst() + " ");

            // 2-2. 그다음 제일 위에 있는 카드를 맨 뒤로 보내기(addLast)
            deque.addLast(deque.pollFirst());
        }
        // 2-3. 마지막 카드 answer 에 넣어주기
        answer.append(deque.peekFirst());
        
        // 3. 출력
        System.out.println(answer);
    }
}