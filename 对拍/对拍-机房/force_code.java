
import java.util.*;
import java.io.*;
import java.math.*;

public class force_code {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,LOG = 30, M = 2*N;
	static int[][] f = new int[N][LOG];
    //dep记录高度，d记录每个点的度，dist记录向下节点的权值和
    static int[] dep = new int[N],d = new int[N],dist = new int[N];
	static int n,m;
	static long ans;

    static boolean dfs(int u,int fa,int fina){
        if(u==fina) return true;
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(j==fa) continue;
            if (dfs(j,u,fina)){
                ans += d[j];
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
        init();
		for(int i=1;i<=n-1;i++) {
            int a = sc.nextInt();
		    int b = sc.nextInt();
			add(a,b,0);
            add(b,a,0);
            d[a] += 1;
            d[b] += 1;
		}
        

        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ans = d[a];
            dfs(a,-1,b);
            System.out.println(ans);
        }
	}

    static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c ;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init(){
		Arrays.fill(h,-1);
	}

}
class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//	PrintWriter out = new PrintWriter(System.out);
//	out.flush();
	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	String getLine() throws IOException {
		return r.readLine();
	}
}
