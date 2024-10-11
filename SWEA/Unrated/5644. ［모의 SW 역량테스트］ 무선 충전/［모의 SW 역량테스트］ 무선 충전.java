import java.util.*;



import java.io.*;

public class Solution {

	static int M;
	static int[][] board;
	static int A;
	static int[] comA,comB;

	static ArrayList<Ap> ap;
	static ArrayList<Integer> apA;
	static ArrayList<Integer> apB;
	static int answer;
	static class Ap{
		int num;
		int x;
		int y;
		int c;
		int p;
		
		public Ap(int num,int x, int y, int c, int p) {
			super();
			this.num=num;
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Ap [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
		
	}
	static int[] dx= {0,0,1,0,-1};
	static int[] dy= {0,-1,0,1,0};
	static int ax,ay,bx,by;
	static ArrayList<Integer> power;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		// a
		// 1 2
		// b
		// 1 2
		
		int testCase= Integer.parseInt(st.nextToken());
	
		for(int test=1;test<=testCase;test++)
		{
			st= new StringTokenizer(bf.readLine());
			
			M= Integer.parseInt(st.nextToken());
			A= Integer.parseInt(st.nextToken());
			
			ap = new ArrayList<>();
			comA= new int[M];
			comB= new int[M];
			
			
			st= new StringTokenizer(bf.readLine());
			for(int i=0;i<M;i++)
			{
				comA[i]= Integer.parseInt(st.nextToken());
				
			}
			st= new StringTokenizer(bf.readLine());
			for(int i=0;i<M;i++)
			{
				comB[i]= Integer.parseInt(st.nextToken());
				
			}
			
			ax=0;
			ay=0;
			bx=9;
			by=9;
			power = new ArrayList<>();
			answer=0;
			for(int i=0;i<A;i++)
			{
				st= new StringTokenizer(bf.readLine());	int x= Integer.parseInt(st.nextToken())-1;
				int y= Integer.parseInt(st.nextToken())-1;
			
		
				int c= Integer.parseInt(st.nextToken());
				int p= Integer.parseInt(st.nextToken());
				power.add(p);
				ap.add(new Ap(i,x,y,c,p));
			//	System.out.println(y+","+x);
	
				
			}
	
			for(int idx=0;idx<=M;idx++)
			{
				// check
				apA= new ArrayList<>();
				apB= new ArrayList<>();
				
				check(ax,ay,0);
				check(bx,by,1);
				
				int tempResult=0;
	
				if(apA.size()>=1 && apB.size()==0)
				{
					for(int a=0;a<apA.size();a++)
					{
						tempResult=Math.max(tempResult, power.get(apA.get(a)));
					}
				}
				else if(apA.size()==0 && apB.size()>=1)
				{
					for(int a=0;a<apB.size();a++)
					{
						tempResult=Math.max(tempResult, power.get(apB.get(a)));
					}
				}
				else {
					//System.out.println("@");
					for(int a=0;a<apA.size();a++)
					{
						for(int b=0;b<apB.size();b++)
						{
							if(apA.get(a)==apB.get(b))
							{
								tempResult=Math.max(tempResult, power.get(apA.get(a)));
							}
							else {
								tempResult=Math.max(tempResult, power.get(apA.get(a))+power.get(apB.get(b)));

							}
						}
					}
				}
				// 150 300 400
				// 250 200 500
				answer+=tempResult;
				//System.out.println("round "+idx);
				//System.out.println(apA);
				//System.out.println(apB);
				//System.out.println("power "+ tempResult);
				
				
				//System.out.println();
				if(idx==M)
				{
					break;
				}
				ax+=dx[comA[idx]];
				ay+=dy[comA[idx]];
				
				bx+=dx[comB[idx]];
				by+=dy[comB[idx]];
				
			}
			System.out.println("#"+(test)+" "+answer);
		}
		
	}
	public static void check(int x,int y,int idx)
	{
		//temp= new ArrayList<>();
		for(int i=0;i<A;i++)
		{
			Ap a = ap.get(i);
		//	System.out.println(a);
			//System.out.println("ap num: "+i+" "+"("+x+","+y+") "+(Math.abs(a.x-x)+Math.abs(a.y-y)));
			if((Math.abs(a.x-x)+Math.abs(a.y-y)) <= a.c )
			{
				if(idx==0) {
					apA.add(a.num);}
				else {
					apB.add(a.num);
				}
			}
		}
		
	}
}