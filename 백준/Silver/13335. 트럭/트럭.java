import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, W, L 각각 입력값 넣어주기
        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int W = Integer.parseInt(inputArr[1]);
        int L = Integer.parseInt(inputArr[2]);
        String[] truckArr = br.readLine().split(" ");

        // 2. N개의 트럭 큐 생성
        ArrayDeque<Integer> truckQue = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            truckQue.addLast(Integer.parseInt(truckArr[i]));
        }

        // 3. 다리 큐 생성(0으로 초기화 = 아무것도 안올라간 상태)
        ArrayDeque<Integer> bridgeQue = new ArrayDeque<>();
        for (int i=0; i<W; i++) {
            bridgeQue.addLast(0);
        }

        // 누적된 최단시간
        int time = 0;
        // 다리에 올라간 트럭 총 무게
        int weight = 0;

        // 4. bridgeQue에 아무것도 없을때까지 반복
        while(!bridgeQue.isEmpty()) {
            time += 1; // 1씩 시간이 흐름
            weight -= bridgeQue.pollFirst(); // 다리에서 벗어난 트럭의 무게를 뺌

            // 4-1.만약 대기중인 트럭이 남아있고 & 다리 누적 무게 <= L
            if(!truckQue.isEmpty() && weight + truckQue.peekFirst() <= L) {
                // 4-1-1. 트럭을 다리에 올리기
                int nextTruck = truckQue.pollFirst(); // 트럭큐에서 다음 트럭 제거
                weight += nextTruck; // 다리 누적 무게 증가
                bridgeQue.addLast(nextTruck); // 다리큐에 다음 트럭 올리기
            }

            // 4-2. 만약 다리 누적 무게 >= L
            else {
                bridgeQue.addLast(0);
            }

            // 4-3. while문 종료(모든 요소가 0일때 종료)
            if(bridgeQue.stream().allMatch(x -> x==0)) {
                break;
            }
        }
        System.out.println(time);
    }
}