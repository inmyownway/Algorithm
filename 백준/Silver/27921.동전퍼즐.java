import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전퍼즐27921 {
    static int N1,M1,N2,M2;
    static int[][] arr1,int[][] arr2;
    public static void main(String[] args) throws IOException
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N1=Integer.parseInt(st.nextToken());
        M1=Integer.parseInt(st.nextToken());
        
        
        for(int i=0;i<N1;i++)
        {
            st= new StringTokenizer(bf.readLine());
            String str = bf.readLine();
            for(int j=0;j<M1;j++)
            {
                arr1[i][j]=str.charAt(j);
            }
        }
        

        
    }

}
