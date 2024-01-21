import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_{


    public static String totalCircle(String str1, String str2){
        for (int i = 0; i <str1.length(); i++) {
            if ("ADOPQR".indexOf(str1.charAt(i))!= -1 && "ADOPQR".indexOf(str2.charAt(i))!= -1) {
                continue;
            } else if ("B".indexOf(str1.charAt(i))!= -1 && "B".indexOf(str2.charAt(i))!= -1) {
                continue;
            } else if("CEFGHIJKLMNSTUVWXYZ".indexOf(str1.charAt(i))!= -1 && "CEFGHIJKLMNSTUVWXYZ".indexOf(str2.charAt(i))!= -1) {
                continue;
            } else return "DIFF";
        }
        return "SAME";
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc =0; tc < T; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                String result;
                if(s1.length() != s2.length()){
                    result = "DIFF";
                } else {
                    result = totalCircle(s1, s2);
                }
            System.out.printf("#%d %s\n",tc + 1,result);
        }

    }
}
