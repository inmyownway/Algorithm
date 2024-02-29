import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static class Stairs{
		int x;
		int y;
		int k;
		public Stairs(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
	}
	public static class Person{
		int x;
		int y;
		int d;
		int k;
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", d=" + d + ", k=" + k + "]";
		}
		public Person(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
		
	}	
	static int N;
	static Person[] person;
	static Stairs[] stairs;
	static int personNum;
	static int[][] board;
	static boolean[] isVisited;
	static int time;
	static int answer;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=testCase;tc++)
		{
			
		
	
			N=Integer.parseInt(bf.readLine());
			board = new int[N][N];
			personNum=0;

			stairs = new Stairs[2];
			answer= Integer.MAX_VALUE;
			time=0;
			
			int idx=0;
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++)
				{
					int temp= Integer.parseInt(st.nextToken());
				
					if(temp==1)
					{
						board[i][j]=1;
						personNum++;
					}
					else if(temp>=2)
					{	
						stairs[idx++]= new Stairs(i,j,temp);
					}
				}
			}
			
			person = new Person[personNum];
			isVisited= new boolean[personNum];

			idx=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(board[i][j]==1)
					{
						person[idx++]=new Person(i,j,0,0);
						
					}
				}
			}
			
			subset(0);
			
			
			System.out.println("#"+tc+" "+(answer+1));
		}

	}
	public static void subset(int depth)
	{
		if(depth==personNum)
		{
			// 팀 나누기 완성

			makeTeam(isVisited);
			return;
		}
		
		isVisited[depth]=true;
		subset(depth+1);
		isVisited[depth]=false;
		subset(depth+1);
	}
	public static void makeTeam(boolean[] v)
	{
			
		ArrayList<Person> team1= new ArrayList<>();
		ArrayList<Person> team2 = new ArrayList<>();

		for(int i=0;i<v.length;i++)
		{
			if(v[i])
				team1.add(person[i]);
			else
				team2.add(person[i]);
		}

	
		// 계단거리, 내려가는 거리 넣기
		
		for(int i=0;i<team1.size();i++)
		{
			Person temp= team1.get(i);
			
			temp.d= Math.abs(stairs[0].x- temp.x)+ Math.abs(stairs[0].y-temp.y);
			temp.k=stairs[0].k;
			
		}
		
		for(int i=0;i<team2.size();i++)
		{
			Person temp= team2.get(i);
			
			temp.d= Math.abs(stairs[1].x- temp.x)+ Math.abs(stairs[1].y-temp.y);
			temp.k=stairs[1].k;
			
		}
		

		// move 시작
		
		ArrayList<Person> s1= new ArrayList<>();
		ArrayList<Person> s2= new ArrayList<>();

		time=0;
		
		while(true)
		{
			time++;
			// 계단 진입
			
			for(int i=0;i<team1.size();i++)
			{
				if(team1.get(i).d>0)
				{
					team1.get(i).d-=1;
				}
			}
			for(int i=0;i<team2.size();i++)
			{
				if(team2.get(i).d>0)
				{
					team2.get(i).d-=1;
				}
			}
			
			// 현재 계단위 또는 타고있는 사람 내려주기 
			int limit1=0;
			int limit2=0;
			
			int cnt1=0;
			int cnt2=0;
			for(int i=0;i<s1.size();i++)
			{
				if(s1.get(i).k >0)
				{
					s1.get(i).k--;
					limit1++;
				}
					if(limit1==3)
					break;
	
				
			
			}
			
			for(int i=0;i<s2.size();i++)
			{
				if(s2.get(i).k >0)
				{
					s2.get(i).k--;
					limit2++;
				}
				
				if(limit2==3)
					break;
	
			
			}
			
			// 계단 도착한 사람 리스트에 넣어주기
			
			for(int i=0;i<team1.size();i++)
			{
				if(team1.get(i).d==0)
				{
				//	s1.add(team1.get(i));
					Person tt= team1.get(i);
					s1.add(new Person(tt.x,tt.y,tt.d,tt.k));
					team1.get(i).d=-1;
				}
			}
			for(int i=0;i<team2.size();i++)
			{
				if(team2.get(i).d==0)
				{
				//	s2.add(team2.get(i));
					Person tt= team2.get(i);
					s2.add(new Person(tt.x,tt.y,tt.d,tt.k));
					team2.get(i).d=-1;
				}
			}
			
		
			int scnt1=0;
			for(int i=0;i<s1.size();i++)
			{
				if(s1.get(i).k==0)
				{
					scnt1++;
				}
			}
			int scnt2=0;
			for(int i=0;i<s2.size();i++)
			{
				if(s2.get(i).k==0)
				{
					scnt2++;
				}
			}
			if(scnt1+scnt2==personNum)
			{
				//System.out.println("@");
				answer=Math.min(answer, time);
				break;
			}
			

		}
			
			
			
			
			
			
			
		}
		
		
		
		public static void print(ArrayList<Person> p)
		{
			for(int i=0;i<p.size();i++)
			{
				System.out.println(p.get(i));
			}
		}
	}