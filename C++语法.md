# 细节、API

### string加char类型的值时一次只能加1个

```
char a,b;

string s;

s += (a+b);//报错

s += a;//正确

s += b;//正确
```



### string的insert函数

```
vector<int> nums；
nums.insert(nums.begin(),值);//第一个位置插入
```



# char转string

string str = 'a';

不能夹在string中，比如string a =  str +'a';//报错



### C++ queue 的 push 和 emplace 有哪些区别？

- `push()` 先产生一个副本，然后将该副本移动到容器中；

- `emplace()`直接在容器尾构造，实质上是传递构造函数的参数，直接在内存上构造对象，省去移动的过程。



### unique函数

> stl中有两个重排容器算法：sort，unique

```
unique(V.begin(),V.end())
```

将V重新排序，使得V中所有出现过的元素放到前边，其他重复的元素放到后面，返回第一个重复位置的迭代器

例子，V= [1,2,2,3,3]，unique后，V= [1,2,3,2,3],返回值直线第四个元素

- 扩展：离散化

  一般unique函数是配合erase使用的，一般在离散化的时候使用，例子如下

  ```
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end()); 
  //v中元素既有序又无重复
  ```

  