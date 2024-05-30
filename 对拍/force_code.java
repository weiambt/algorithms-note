import java.util.Scanner;

public class force_code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int res = 0;
        for (int i = a; i <= b; ++i) res += i;
        System.out.println(res);
        in.close();
    }
}