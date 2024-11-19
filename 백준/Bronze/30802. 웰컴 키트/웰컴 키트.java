import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] sizeArr = new int[input.length];
        for (int i=0; i< input.length; i++) {
            sizeArr[i] = Integer.parseInt(input[i]);
        }

        String[] input2 = br.readLine().split(" ");
        int T = Integer.parseInt(input2[0]);
        int P = Integer.parseInt(input2[1]);

        // T, P 묶음씩 구매해야함
        // T는 티셔츠 묶음별로 주문, 남아도 O
        int Tcnt = 0;
        for(int i=0; i<sizeArr.length; i++) {
            // 1. 만약 신청개수 % 묶음 == 0 이면 몫이 답
            if(sizeArr[i] % T == 0) {
                Tcnt += sizeArr[i] / T;
            }
            // 2. 만약 신청개수 % 묶음 != 0 이면 몫 + 1
            else {
                Tcnt += (sizeArr[i] / T) + 1;
            }
        }

        // P도 묶음별로 주문하되, 남으면 X (남는 건 개별주문)
        int PTotalcnt = N / P;
        int Pcnt = N % P;
        
        System.out.println(Tcnt);
        System.out.println(PTotalcnt + " " + Pcnt);
    }
}