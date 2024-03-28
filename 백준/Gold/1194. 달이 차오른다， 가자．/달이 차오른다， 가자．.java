import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static char[][] board;
	static int N, M;
	static int sx, sy;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int answer;
	static boolean[][][][][][][][] v= new boolean[50][50][2][2][2][2][2][2];

	public static class Person {
		int x;
		int y;
		int d;


		int[] keys;
		public Person() {}
		public Person(int x, int y, int d, int[] keys) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
	
			this.keys = keys;
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", d=" + d + ", keys=" + Arrays.toString(keys) + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		v= new boolean[50][50][2][2][2][2][2][2];

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);

				board[i][j] = c;

				if (c == '0') {
					sx = i;
					sy = j;
					board[i][j] = '.';
					v[i][j][0][0][0][0][0][0]=true;
				}

			}
		}

		bfs();
		if (answer == 0) {
			System.out.println(-1);
		} else {

			System.out.println(answer);
		}

	}

	private static void bfs() {

		Queue<Person> q =new LinkedList<>();
		
	
		int[] keys = new int[6];
		q.add(new Person(sx, sy, 0, keys));

		while (!q.isEmpty()) {

	
				Person cur = q.poll();
				//System.out.println(cur);
				
				
				if(board[cur.x][cur.y]=='1')
				{
					answer=cur.d;
					return;
				}
				
				
			
				for (int idx = 0; idx < 4; idx++) {

					int nx = cur.x + dx[idx];
					int ny = cur.y + dy[idx];


					int px=0;
					int py=0;
					int pd=0;
					int[] pKeys = new int[6];
			

				
					if(!isBoundary(nx, ny)) continue;
					
					if(v[nx][ny][cur.keys[0]][cur.keys[1]][cur.keys[2]][cur.keys[3]][cur.keys[4]][cur.keys[5]]) continue;
		
			
					if(board[nx][ny]=='.' || board[nx][ny]=='1')
					{
						
						px=nx;
						py=ny;
						pd=cur.d+1;
						v[nx][ny][cur.keys[0]][cur.keys[1]][cur.keys[2]][cur.keys[3]][cur.keys[4]][cur.keys[5]]=true;
						for (int a = 0; a < 6; a++) {
							pKeys[a] = cur.keys[a];
							
						}
						q.add(new Person(px,py,pd,pKeys));
					}
					else if(board[nx][ny]>='a' && board[nx][ny]<='f')
					{
						px=nx;
						py=ny;
						pd=cur.d+1;
						v[nx][ny][cur.keys[0]][cur.keys[1]][cur.keys[2]][cur.keys[3]][cur.keys[4]][cur.keys[5]]=true;
						for (int a = 0; a < 6; a++) {
							pKeys[a] = cur.keys[a];
						}
						pKeys[board[nx][ny]-'a']=1;
						//System.out.println(board[nx][ny]);
			
						q.add(new Person(px,py,pd,pKeys));

					}
					else if(board[nx][ny]>='A' && board[nx][ny]<='F')
						
					{
						if(cur.keys[board[nx][ny]-'A']==1)
						{
							px=nx;
							py=ny;
							pd=cur.d+1;
							v[nx][ny][cur.keys[0]][cur.keys[1]][cur.keys[2]][cur.keys[3]][cur.keys[4]][cur.keys[5]]=true;
							for (int a = 0; a < 6; a++) {
								pKeys[a] = cur.keys[a];
							}
							
							q.add(new Person(px,py,pd,pKeys));

						}
					
					}

			}
		}

	}

	public static boolean isBoundary(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}