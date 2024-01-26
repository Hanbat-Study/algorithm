import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[4];
        for(int i = 0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if (p1 <x2 || p2 < x1 || q1 < y2||q2<y1)  {
                arr[i] = "d";
            } else if ((p1 == x2 && q1 == y2)|| (p1 == x2 && q2 == y1)||(p2 == x1 && q2 == y1)||(p2 == x1 && q1 == y2)) {
                arr[i] = "c";
            } else if ((p1 == x2)||(q1 == y2 ) || (q2 == y1) || (p2 == x1 )) {
                arr[i] = "b";
            }
            else {
                arr[i] = "a";
            }
        }
        for(String s : arr) {
            System.out.println(s);
        }
    }
}