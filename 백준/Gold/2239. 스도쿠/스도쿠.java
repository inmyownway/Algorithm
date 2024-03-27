import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int N=9;
	static int answer;
	static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			
			board = new int[9][9];
			
			for(int i=0;i<N;i++)
			{
				String s= bf.readLine();
				for(int j=0;j<N;j++)
				{
					int num = s.charAt(j)-'0';
					if(num==0)
						list.add(new int[] {i,j});
					
					board[i][j]=num;
					}
				}
			
			dfs(0);
	}

	public static void dfs(int depth)
	//https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-2239-%EC%8A%A4%EB%8F%84%EC%BF%A0-Java%EC%9E%90%EB%B0%94
	{
		//System.out.println(depth);
		if(list.size()==depth)
			
			
		{	
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		

		}
		
		int i = list.get(depth)[0];
		int j = list.get(depth)[1];
		
		
	
				
					boolean[] check = new boolean[10];
					
					
					
		
					
					// 가로 체크
					for(int idx=0;idx<9;idx++)
					{
						if(board[i][idx]!=0)
						{
							check[board[i][idx]]=true;
						}
					}
					
					// 세로 체크
					for(int idx=0;idx<9;idx++)
					{
						if(board[idx][j]!=0)
						{
							check[board[idx][j]]=true;
						}
					}
					
					// 3*3 체크
					int tx=0;
					int ty=0;
					if( 0 <= i && i<3)
					{
						tx=0;
					}
					else if( i>=3 && i<6)
					{
						tx=3;
					}
					else if( i>=6 && i<9)
					{
						tx=6;
					}	
					
					if( 0 <= j&& j<3)
					{
						ty=0;
					}
					else if( j>=3 && j<6)
					{
						ty=3;
					}
					else if( j>=6 && j<9)
					{
						ty=6;
					}	
					
					for(int a=tx;a<tx+3;a++)
					{
						for(int b=ty;b<ty+3;b++)
						{
							if(board[a][b]!=0)
							{
								check[board[a][b]]=true;
							}
						}
					}
					
					for(int d=1;d<=9;d++)
					{
						if(!check[d])
						{
							board[i][j]=d;
							dfs(depth+1);
							board[i][j]=0;
						}
					}
					
				
		
	}
}