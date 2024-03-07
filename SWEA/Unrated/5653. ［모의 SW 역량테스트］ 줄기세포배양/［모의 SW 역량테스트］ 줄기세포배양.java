import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;






public class Solution {
	
	static boolean[][] isVisited;
	static int[][] board;
	static PriorityQueue<Virus> virus;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int answer;
	public static class Virus implements Comparable<Virus>
	{
		int x;
		int y;
		int life;
		int originLife;
		public Virus(int x, int y, int life,int originLife) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.originLife=originLife;
		}
		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", life=" + life + ", originLife=" + originLife + "]";
		}
		@Override
		public int compareTo(Virus o) {
			
			return Integer.compare(o.originLife,this.originLife);
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<testCase+1;tc++)
		{
			st= new StringTokenizer(bf.readLine());
			int N= Integer.parseInt(st.nextToken());
			int M= Integer.parseInt(st.nextToken());
			int K= Integer.parseInt(st.nextToken());
			answer=0;
			
			virus = new PriorityQueue<>();//<>();
			isVisited=new boolean[351*4][351*4];
			board = new int[N+K*4][M+K*4];
			
			
			
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(bf.readLine());
				for(int j=0;j<M;j++)
				{
					int num = Integer.parseInt(st.nextToken());
					if(num!=0)
					{
						board[i+K][j+K]=num;
					
                        virus.add(new Virus(i+K,j+K,num+1,num));
                        isVisited[i+K][j+K]=true;
					}
				}
			}
			// K=5
			// 2초에 죽고 라이프 2
			
			for(int time=1;time<=K;time++)
			{	//System.out.println();
			//	System.out.println("time: "+ (time-1));
				
				int s= virus.size();
				
				ArrayList<Virus> tempVirus= new ArrayList<>();
				
				
				for(int a=0;a<s;a++)
				{
					tempVirus.add(virus.poll());
				//	System.out.println(tempVirus.get(a));
				}
				
			
				for(int i=0;i<s;i++)
				{
					
					Virus temp = tempVirus.get(i);
					
				
					// 라이프 -1;
					temp.life-=1;
					
					if(temp.life==0)
					{
		
						if(temp.originLife>= K-time+2)
						{
							answer++;
						//System.out.println(temp.originLife+ " "+(K-time+1 ));
						}
					////	System.out.println("answer: "+answer);
					//	System.out.println();
						for(int idx=0;idx<4;idx++)
						{
							int nx = temp.x+dx[idx];
							int ny= temp.y+dy[idx];
							if(isVisited[nx][ny]==false )
							{
								
								if(board[nx][ny]==0)
								{
									board[nx][ny]=temp.originLife;
									virus.add(new Virus(nx,ny,temp.originLife+1,temp.originLife));
									isVisited[nx][ny]=true;
								}
							
							}
						}
					}
					else if(temp.life>=1)
					{
						virus.add(temp);
						isVisited[temp.x][temp.y]=true;
					}
				}
				
				
				
			}
							
			//System.out.println("l "+ virus.size());
			
			int ss=virus.size();
			for(int i=0;i<ss;i++)
			{
			//	System.out.println(i);
				Virus v= virus.poll();
			//	System.out.println(v);
				if(v.life>=1)
				{
					answer++;
				}
		
			}
			
				System.out.println("#"+tc+" "+answer);
		
			
			

			
			
		}
		
		
		// life 3이면 , 1 2 3 비활성
			//            4 5 6 살아있고 7에 죽음 
	}
		
		/* 큐에 다넣음 
		 *  큐 사이즈만큼 하나씩 꺼냄, 라이프 -1; 
		 *  
		 * */
	public static void print(ArrayList<Virus> vv)
	{
		for(Virus v: vv)
		{
			System.out.println(v);
		}
	}

}