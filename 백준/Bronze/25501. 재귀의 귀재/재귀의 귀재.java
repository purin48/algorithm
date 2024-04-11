import java.util.Scanner;

public class Main {
    static int cnt;
    public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
            cnt++;
            return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++) {
            cnt = 1;
            System.out.println(isPalindrome(sc.next()) + " " + cnt);
        }
    }
}