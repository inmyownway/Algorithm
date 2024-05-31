#include <iostream>
using namespace std;

bool broken[10];
int check(int n)
{
    if(n==0)
    {
        if(broken[0]==true)
        {
        return 0;
        }
        else
        {
        return 1;
        }

    }
  int len = 0;
  while(n>0)
  {
     if(broken[n%10])
     {
         return 0;

     }

    len +=1;
     n/=10;
  }

   return len;
}
int main()
{
    int n;
    cin>>n;
    int m;
    cin>>m;
    for(int i=0;i<m;i++)
    {
        int in;
        cin>>in;
        broken[in]=true;

    }
    int ans = n - 100;
    if(ans<0)
    {
        ans= -ans;
    }

    for(int i=0;i<=1000000;i++)
    {
        int c =i;
        int len = check(c);
        if(len>0)
        {
            int press = c-n;
             
            if(press<0)
            {
                press = -press;
            }
            if(ans > press + len)
            {
                ans = press + len;
            }
        }
    
    
    }
        printf("%d\n",ans);
        return 0;
        



}
