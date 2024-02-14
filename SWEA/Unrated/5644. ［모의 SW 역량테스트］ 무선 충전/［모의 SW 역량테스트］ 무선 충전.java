import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    // 1. 사람 이동
    // 2. 배터리 가능 확인
    // 3. A =[ ] , B=[] 에 넣고 배터리 최대값 구하기
    static int M,A;
    static int[] moveA;
    static int[] moveB;
    static int[][] batteryInfo;
    static int[] dx= {0,-1,0,1,0};
    static int[] dy= {0,0,1,0,-1};
    static AP[] ap;
    static int[] aPos;
    static int[] bPos;
    static int[] aIdx;
    static int[] bIdx;
    static int answer;
    static ArrayList<AP> arrA;
    static ArrayList<AP> arrB;
    //static int[]
    //static int[] batteryIdx;

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int testCase=Integer.parseInt(bf.readLine());


        for(int test=1; test<testCase+1;test++)
        {


            st = new StringTokenizer(bf.readLine());
            M=Integer.parseInt(st.nextToken());
            A=Integer.parseInt(st.nextToken());

            moveA= new int[M+1];
            moveB= new int[M+1];
            moveA[0]=0;
            moveB[0]=0;
            batteryInfo=new int[A][4];
            aPos = new int[]{0,0};
            bPos = new int[]{9,9};
            answer=0;
            ap =new AP[A];
            st= new StringTokenizer(bf.readLine());
            for(int i=1;i<M+1;i++)
            {
                moveA[i]=Integer.parseInt(st.nextToken());
            }

            st= new StringTokenizer(bf.readLine());
            for(int i=1;i<M+1;i++)
            {
                moveB[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<A;i++)
            {
                st= new StringTokenizer(bf.readLine());

//                for(int j=0;j<4;j++)
//                {
//                    batteryInfo[i][j]=Integer.parseInt(st.nextToken());
//                }
//
//                int temp = batteryInfo[i][0]-1;
//
//                batteryInfo[i][0] = batteryInfo[i][1]-1;
//                batteryInfo[i][1]=temp;

                int y= Integer.parseInt(st.nextToken())-1;
                int x= Integer.parseInt(st.nextToken())-1;
                int C =Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                ap[i] = new AP(x,y,C,P);

            }



            for(int time=0;time<M+1;time++)
            {
//                System.out.println();
//                System.out.println();
//                System.out.println("time: "+time);
//

                arrA = new ArrayList<>();
                arrB= new ArrayList<>();
                move(time);
                isBoundary();
                charge();



            }
            System.out.println("#"+test+" "+answer);
        }

    }
    public static void isBoundary()
    {

        for(int i=0;i<A;i++)
        {


            if(Math.abs(ap[i].x-aPos[0]) + Math.abs(ap[i].y-aPos[1]) <=ap[i].C )
            {
                arrA.add(ap[i]);
            }
            if(Math.abs(ap[i].x-bPos[0]) + Math.abs(ap[i].y-bPos[1]) <=ap[i].C )
            {
                arrB.add(ap[i]);
            }

        }
    }
    public static void charge()
    {

        int maxNum=0;

      //  System.out.println(arrA);
      //  System.out.println(arrB);
       // System.out.println(answer);
        if(arrA.size()!=0 && arrB.size()!=0)
        {
            for(int x=0;x<arrA.size();x++)
            {
                for(int y=0;y<arrB.size();y++)
                {
                    if(arrA.get(x)==arrB.get(y))
                    {
                        maxNum=Math.max(maxNum,arrA.get(x).P);
                    }
                    else
                    {
                        maxNum=Math.max(maxNum,arrA.get(x).P+arrB.get(y).P);
                    }
                }
            }


        }
        else if(arrA.size()!=0 && arrB.size() == 0)
        {
            for(int x=0;x<arrA.size();x++)
            {
                maxNum=Math.max(maxNum,arrA.get(x).P);
            }
        }
        else if(arrA.size()==0 && arrB.size() != 0)
        {
            for(int x=0;x<arrB.size();x++)
            {
                maxNum=Math.max(maxNum,arrB.get(x).P);
            }

        }

        answer+=maxNum;
    }

    public static void move(int time)
    {

        int aD = moveA[time];
        int bD = moveB[time];

        //System.out.println(aD);
        aPos[0]+=dx[aD];
        aPos[1]+=dy[aD];

        bPos[0]+=dx[bD];
        bPos[1]+=dy[bD];
    }


    public static class AP
    {
        int x;
        int y;
        int C;
        int P;

        AP(int x,int y,int C,int P)
        {
            this.x=x;
            this.y=y;
            this.C=C;
            this.P=P;
    }

        @Override
        public String toString() {
            return "AP{" +
                    "P=" + P +
                    '}';
        }
    }
}

//    public static void charge()
//    {
//        Queue<Integer> tempA = new PriorityQueue<>(Collections.reverseOrder());
//        Queue<Integer> tempB = new PriorityQueue<>(Collections.reverseOrder());
//        for(int i=0;i<A;i++)
//        {
//            if(aIdx[i]==1)
//            {
//                tempA.add(batteryInfo[i][3]);
//
//            }
//
//            if(bIdx[i]==1)
//            {
//                tempB.add(batteryInfo[i][3]);
//
//            }
//
//        }
//        System.out.println(tempA+"    ");
//        System.out.print(tempB);
//        int ta=answer;
//        if(tempA.size()>=1 && tempB.size()>=1)
//        {
//
//
//            int a= tempA.poll();
//            int b= tempB.poll();
//
//            // max 값 같은데
//            if(a==b) {
//
//                answer+=a;
//
//                if(!tempA.isEmpty() && !tempB.isEmpty())
//                {
//                    int x= tempA.poll();
//                    int y= tempB.poll();
//                    if(x==y)
//                    {
//
//                        answer+=x;
//
//                    }
//                    else
//                    {
//                        answer+=Math.max(x,y);
//                    }
//
//                }
//                else if(!tempA.isEmpty() && tempB.isEmpty() )
//                {
//                    answer+=tempA.poll();
//                }
//                else if(tempA.isEmpty() && !tempB.isEmpty())
//                {
//                    answer+=tempB.poll();
//                }
//
//            }
//            if(a>b)
//            {
//                answer+=a+b;
//            }
//            else if(a<b)
//            {
//                answer+=a+b;
//            }
//        }
//        else if(!tempA.isEmpty() && tempB.isEmpty())
//        {
//            answer+=tempA.poll();
//        }
//        else if(tempA.isEmpty() && !tempB.isEmpty())
//        {
//            answer+=tempB.poll();
//        }
//
//
//        System.out.println();
//        System.out.println(answer-ta);
//
//    }