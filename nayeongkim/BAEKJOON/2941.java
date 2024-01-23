import java.io.*;
class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alpabets = new String[] { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String s = br.readLine();
        for(String alpabet : alpabets) {
            if(s.contains(alpabet)) {
                s = s.replace(alpabet, "a");
            }
        }

        System.out.println(s.length());
    }
}