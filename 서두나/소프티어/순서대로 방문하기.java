import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int r;
        int c;
        int next;
        Node(int r, int c, int next){
            this.r=r;
            this.c=c;
            this.next=next;
        }
    }

    static int[] drs = {0,0,1,-1}; // 동서남북
    static int[] dcs = {1,-1,0,0};

    static int n;
    static int m;
    static int[][] map;
    static int ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int k=2;
        int startR=0;
        int startC=0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1]=k++;
            if(map[r-1][c-1]==2){
                startR=r-1;
                startC=c-1;
            }
        }

        ans = 0;

        map[startR][startC]=-1;
        recursive(3,startR,startC);
        System.out.println(ans);
    }

    static void recursive(int d, int r, int c){

        if(d==m+2){
            ans++;
            return;
        }

        for(int i=0;i<4;i++){
            int nr = drs[i]+r;
            int nc =dcs[i]+c;
            if(0<=nr&& nr<n&& 0<=nc&& nc<n){
                if(map[nr][nc]==0){
                    map[nr][nc]=-1;
                    recursive(d,nr,nc);
                    map[nr][nc]=0;
                }

                else if(map[nr][nc]==d){
                    map[nr][nc]=-1;
                    recursive(d+1,nr,nc);
                    map[nr][nc]=d;
                }
            }
        }

        
    }
}
