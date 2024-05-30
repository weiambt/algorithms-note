import java.util.Scanner;

public class new_code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println((a + b) * (b - a + 1) / 2);
        
    }
}