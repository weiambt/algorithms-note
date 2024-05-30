
import java.util.Random;

public class data {
	static Random random = new Random();
	static int rd(int l,int r){
		return random.nextInt(r-l+1)+l;
	}
	public static void main(String[] args) {
		
		int n = rd(1,20);
		System.out.println(n);
		for(int i=1;i<=n-1;i++){
			int s = rd(0,1);
			System.out.print(s+" ");
		}
	}
}
