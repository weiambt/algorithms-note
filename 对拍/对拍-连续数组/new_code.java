

import java.util.*;
import java.io.*;
import java.math.*;

public class new_code {
	static int INF = Integer.MAX_VALUE;
	static int mod = 1000000007 ;
	static int N = 20,M = 2*N;
	static int[] op = new int[N];
  static long[][] dp = new long[1<<N][N];
	static int n;
	static long ans;
	
  static void solve(){
    for(int i=0;i<n;i++){
      dp[1<<i][i] = 1;
    }
    for(int mask = 0;mask<(1<<n);mask++){
      int i = getCnt(mask);
      for(int last = 0;last<n;last++){
        if((mask>>last&1)==0 ) continue;
        for(int j = 0;j<n;j++){
          if((mask>>j&1)==0 || j==last) continue;
          int cha = last - j;
          if(op[i-1]==1 && cha!=1) continue;
          if(op[i-1]==0 && cha==1) continue;
          dp[mask][last] += dp[mask & ~(1<<last)][j];
        }
        if(mask == (1<<n)-1) ans += dp[mask][last];
      }
    }
  }
  static int getCnt(int mask){
    int res = 0;
    while(mask>0){
      res += 1;
      mask -= mask&-mask;
    }
    return res;
  }
	public static void main(String[] args) throws IOException {
		
		n = sc.nextInt();
		
		for(int i=1;i<=n-1;i++) 
			op[i] = sc.nextInt();
		
		solve();
		System.out.println(ans);
	}
	static Scanner sc = new Scanner(System.in);

}