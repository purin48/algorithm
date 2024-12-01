import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 최대공약수 계산
    static int gcd(int a, int b) {
        // 나머지 값이 0이 될때까지 반복
        while(b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수 계산 ( LMC = (a*b)/GCD )
    static int lcm(int a, int b, int gcd) {
        return (a*b) / gcd;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 최대공약수 계산
        int gcdV = gcd(A,B);

        // 최소공배수 계산
        int lcmV = lcm(A,B,gcdV);

        System.out.println(gcdV);
        System.out.println(lcmV);
    }
}