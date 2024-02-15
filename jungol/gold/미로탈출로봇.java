package s0215;

import java.awt.image.BufferedImage;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class 미로탈출로봇 {

//	static int X,Y;
//	static int startX,startY,endX,endY;
//	static int[][] board;
//	static boolean[][] visited;
//	static int[] dx= {0,0,-1,1};
//	static int[] dy = {1,-1,0,0};
	
	static int[][] map;
	static int scol,srow,ecol,erow;
	static int rowN,colN;
	static int[] dr= {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int minNum=Integer.MAX_VALUE;
	static int[][] v1;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st=new StringTokenizer(bf.readLine());

		colN=Integer.parseInt(st.nextToken());
		rowN=Integer.parseInt(st.nextToken());
		
		
		st= new StringTokenizer(bf.readLine());
		
		scol=Integer.parseInt(st.nextToken())-1;
		srow=Integer.parseInt(st.nextToken())-1;
		ecol=Integer.parseInt(st.nextToken())-1;
		erow=Integer.parseInt(st.nextToken())-1;
		

		map= new int[rowN][colN];
		v1= new int[rowN][colN];
	
		
		
		for(int i=0;i<rowN;i++)
		{
			String line= bf.readLine();
			for(int j=0;j<colN;j++)
			{
				map[i][j]=line.charAt(j)-'0';
				
				v1[i][j]=Integer.MAX_VALUE;
			}
		}
	
		
		
		
		
		//bfs();
		
		map[srow][scol]=1;
		dfs(srow,scol,1);
		System.out.println(minNum);
		
	}
	public static void dfs(int r,int c,int count)
	{
		if(r == erow && c== ecol)
		{
			
			
			minNum=Math.min(minNum, count-1);
			
			return;
		}
		
		int nr;
		int nc;
		
		//v1[r][c]=1;
		
		for(int i=0;i<4;i++)
		{
			nr= r+dr[i];
			nc= c+dc[i];
			
			if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc]==0 && count+1 < v1[nr][nc])
			{
				
				
				
				v1[nr][nc]=count+1;
				
				map[nr][nc]=count+1;
				
				dfs(nr,nc,count+1); 
			
				map[nr][nc] = 0;
		
			
			}
			
		}
		return;
	}
		
		
public static void f(int[][] x)
{
	for(int i=0;i<x.length;i++)
	{
		for(int j=0;j<x.length;j++)
		{
			x[i][j]=0;
		}
	}
}
		

	
	
	public static void bfs()
	{
		//System.out.println(1);
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		map[srow][scol]= 1; // 방문표시
		
		queue.offer(new int[] {srow,scol});
		
		
		int r,c,nr,nc,count;
		int[] temp;
		
		top:
		while(!queue.isEmpty())
		{
			temp=queue.poll();
			
			r=temp[0];
			c=temp[1];
			count=map[r][c];
			for(int i=0;i<4;i++)
			{
				nr= r+dr[i];
				nc= c+dc[i];
				
				if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc]==0)
				{
					
					map[nr][nc]=count+1;
			
					
					if(nr == erow && nc== ecol)
					{
						
						break top;
					}
					else
					{
								queue.offer(new int[] {nr,nc});
					}
				}
			}
			
			
		}
		
		
		System.out.println(map[erow][ecol]-1);
	}
}
