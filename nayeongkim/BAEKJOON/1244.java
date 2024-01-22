import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void man(String[] strings, int n) {
        int cur = n;
        while(cur <strings.length){
            if(strings[cur].equals("1")){
                strings[cur] = "0";
            } else if (strings[cur].equals("0")) {
                strings[cur] = "1";
            }
            cur += n;
        }
    }

    public static void woman(String[] strings, int n) {
        int lt = n - 1;
        int rt = n + 1;
        if(strings[n].equals("0")) {
            strings[n] = "1";
        }else if(strings[n].equals("1")){
            strings[n] = "0";
        }
        while (1 <= lt && rt < strings.length) {
            if(strings[lt].equals(strings[rt])){
                if(strings[lt].equals("1")) {
                    strings[lt] = "0";
                    strings[rt] = "0";
                } else {
                    strings[lt] = "1";
                    strings[rt] = "1";
                }
                lt--;
                rt++;
            }
            else break;
        }

    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = new char[N+1];
        String[] strings = new String[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            strings[i] = st.nextToken();
        }
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                man(strings, Integer.parseInt(st.nextToken()));

            } else {
                woman(strings, Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.printf("%s ",strings[i]);
            if (i % 20 == 0) {
                System.out.println();
            }
        }

    }

}