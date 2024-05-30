import java.util.Random;

public class data {
	static int rd(int l,int r){
		Random random = new Random();
		return random.nextInt(r-l+1)+l;
	}
    public static void main(String[] args) {
        
        int n = rd(2,100);
		int m = rd(0,100);
		System.out.println(n + " " + m);
		//HashMap<Integer,Integer> mp 
		for(int i=2;i<=n;i++){
			int y = rd(1,i-1);
			System.out.println(i + " " + y);
		}
        for(int i=1;i<=m;i++){
			int a = rd(1,n);
			int b = rd(1,n);
			System.out.println(a + " " + b);
		}
    }
}