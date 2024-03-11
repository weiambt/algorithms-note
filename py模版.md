# 模版

### 二维前缀和

- python

```python
# 二维前缀和模板（）
class MatrixSum:
    def __init__(self, matrix: List[str]):
        n, m = len(matrix), len(matrix[0])
        s = [[0] * (m + 1) for _ in range(n + 1)]
        for i, row in enumerate(matrix):
            for j, x in enumerate(row):
                s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + (x == 'A')
        self.s = s

    # 返回左上角在 (i1,j1) 右下角在 (j2,j2) 的子矩阵元素和
    def query(self, i1: int, j1: int, i2: int, j2: int) -> int:
        return self.s[i2][j2] - self.s[i1-1][j2] - self.s[i2][j1-1] + self.s[i1-1][j1-1]
    

# 调用	
sum = MatrixSum(pizza)
sum.query(x,y,i-1,m):
```

- java

```
class MatrixSum {
    private final int[][] sum;

    public MatrixSum(String[] matrix) {
        int m = matrix.length, n = matrix[0].length();
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j)=='A'?1:0);
            }
        }
    }
    
    public int query(int i1, int j1, int i2, int j2) {
        return sum[i2][j2] - sum[i2][j1-1] - sum[i1-1][j2] + sum[i1-1][j1-1];
    }
}
```

### 并查集

```
class UnionFind:
    def __init__(self,n):
        fa = [i for i in range(n+1)]
        cnt = [1]*(n+1)
        self.fa = fa
        self.cnt = cnt
    def find(self,x):
        if self.fa[x]==x:
            return x
        self.fa[x] = self.find(self.fa[x])
        return self.fa[x]
    def union(self,a,b):
        a = self.find(a)
        b = self.find(b)
        if a==b: return 
        self.cnt[b] += self.cnt[a]
        self.fa[a] = b
        return 
```

### 快速幂

python自带快速幂

```
pow(a,b,mod)
```

