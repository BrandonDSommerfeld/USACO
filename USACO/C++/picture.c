/*
ID: bdsomme1
LANG: C++
TASK: picture
*/



#include<bits/stdc++.h>
#define ll long long
#define ull unsigned long long
#define inf 2147483647
#define mp make_pair
#define pii pair<int,int>
#define pb push_back
#define r1 rt<<1
#define r2 rt<<1|1
#define ld long double
using namespace std;

inline int read(){
	int x=0,f=1;char c=getchar();
	while(c<'0'||c>'9'){if(c=='-')f=-1;c=getchar();}
	while(c>='0'&&c<='9') x=(x<<1)+(x<<3)+(c^48),c=getchar();
	return x*f;
}

const int N=10005,M=30000;
struct node{
	int x1,x2,y,k;
	bool operator < (const node &b) const{
		if(y!=b.y) return y<b.y;
		else return k>b.k;
	}
}a[N];

struct seg{
	int l,r,len,num,sum,lc,rc;
}st[M<<2];

inline void pushup(int rt){
	if(st[rt].sum>0){
		st[rt].len=st[rt].r-st[rt].l+1;
		st[rt].lc=st[rt].rc=1;
		st[rt].num=1;
	}
	else if(st[rt].l==st[rt].r){
		st[rt].len=st[rt].num=st[rt].lc=st[rt].rc=0;
	}
	else{
		st[rt].len=st[r1].len+st[r2].len;
		st[rt].lc=st[r1].lc;st[rt].rc=st[r2].rc;
		st[rt].num=st[r1].num+st[r2].num-(st[r1].rc&st[r2].lc);
	}
}

inline void build(int l,int r,int rt){
	st[rt].l=l;st[rt].r=r;st[rt].len=st[rt].num=st[rt].sum=st[rt].lc=st[rt].rc=0;
	if(l==r) return;
	int m=(l+r)>>1;
	build(l,m,r1);
	build(m+1,r,r2);
}

inline void update(int l,int r,int c,int rt){
	if(st[rt].l>r||l>st[rt].r) return;
	if(l<=st[rt].l&&st[rt].r<=r){
		st[rt].sum+=c;
		pushup(rt);
		return;
	}
	update(l,r,c,r1);
	update(l,r,c,r2);
	pushup(rt);
}

int main()
{
	freopen("picture.in","r",stdin);
	freopen("picture.out","w",stdout);
	int n=read(),m=0,mx=-inf,mn=inf;
	for(int i=1;i<=n;++i){
		int x1=read(),y1=read(),x2=read(),y2=read();
		mx=max(mx,max(x1,x2));
        mn=min(mn,min(x1,x2));
		a[++m].x1=x1,a[m].x2=x2,a[m].y=y1,a[m].k=1;
		a[++m].x1=x1,a[m].x2=x2,a[m].y=y2,a[m].k=-1;
	}
	sort(a+1,a+m+1);
	build(mn,mx-1,1);
	int ans=0,last=0;
	for(int i=1;i<=m;++i){
		update(a[i].x1,a[i].x2-1,a[i].k,1);
		//橫線
		ans+=abs(st[1].len-last);
		//豎線 
		ans+=(a[i+1].y-a[i].y)*2*st[1].num;
		last=st[1].len;
	}
	printf("%d\n",ans);
	return 0;
}



