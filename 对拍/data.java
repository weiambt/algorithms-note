import java.util.Random;

public class data {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);
        int t;
        if (a > b) {
            t = a; a = b; b = t;
        }
        System.out.println(a + " " + b);
    }
}